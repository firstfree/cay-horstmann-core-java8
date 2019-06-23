package ch10.sec08;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

public class WebReader {

  public static final Logger log = Logger.getLogger("com.ch10.sec08");

  public static void main(String[] args)
      throws MalformedURLException, ExecutionException, InterruptedException {

    CompletableFuture<String> contents = readPage(new URL("http://horstmann.com"));
    CompletableFuture<Integer> contentLength = contents.thenApply(content -> {
      log.info(Thread.currentThread().getName());
      return content.length();
    });

    System.out.println(contentLength.get());
  }

  public static CompletableFuture<String> readPage(URL url) {
    return CompletableFuture.supplyAsync(() -> {
      log.info(Thread.currentThread().getName());

      StringBuffer sb = new StringBuffer();

      try (Scanner in = new Scanner(url.openStream())) {
        while (in.hasNextLine()) {
          sb.append(in.nextLine() + "\n");
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

      return sb.toString();
    });
  }
}
