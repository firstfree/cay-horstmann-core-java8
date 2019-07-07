package ch10.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CH10P24 {

  public static void main(String[] args) {
    CompletableFuture.supplyAsync(() -> getUrl())
        .thenApply(url -> readPage(url))
        .thenApply(content -> getLink(content))
        .handle((content, e) -> {
          if (e != null) {
            e.printStackTrace();
            return Collections.emptyList();
          }

          return content;
        })
        .thenAccept(links -> links.stream().forEach(System.out::println));

    ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
  }

  public static List<String> getLink(String content) {
    List<String> links = new ArrayList<>();

    Pattern pattern = Pattern.compile("(?i)href=\"(https://.*?)\"");
    Matcher matcher = pattern.matcher(content);

    while (matcher.find()) {
      links.add(matcher.group(1));
    }

    return links;
  }

  public static String readPage(URL url) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
      return reader.lines().collect(Collectors.joining());
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  public static URL getUrl() {
    try (Scanner in = new Scanner(System.in)) {
      return new URL(in.nextLine());
    } catch (MalformedURLException e) {
      throw new RuntimeException();
    }
  }
}
