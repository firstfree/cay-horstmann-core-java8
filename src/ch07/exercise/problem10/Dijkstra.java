package ch07.exercise.problem10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import ch06.sec06.Arrays;

public class Dijkstra {
	public static Map<String, Neighbor> run(Map<String, List<Neighbor>> graph, String startNodeName) {
		Neighbor startNode = new Neighbor(startNodeName, 0);
		Queue<Neighbor> unvisitedNodes = new PriorityQueue<>((f, s) -> Integer.compare(f.getDistance(), s.getDistance()));
		unvisitedNodes.add(startNode);
		
		Map<String, Neighbor> distanceNodes = new HashMap<>();
		distanceNodes.put(startNodeName, startNode);
		
		for (String nodeName : graph.keySet()) {
			if (!nodeName.equals(startNodeName)) {
				Neighbor neighbor = new Neighbor(nodeName, Integer.MAX_VALUE);
				unvisitedNodes.add(neighbor);
				distanceNodes.put(nodeName, neighbor);
			}
		}
		
		while (!unvisitedNodes.isEmpty()) {
			unvisitedNodes.add(unvisitedNodes.remove());
			Neighbor node = unvisitedNodes.poll();
			
			List<Neighbor> neighbors = graph.get(node.getName());
			for (Neighbor neighbor : neighbors) {
				int distance = node.getDistance() + neighbor.getDistance();
				Neighbor distanceNode = distanceNodes.get(neighbor.getName());
				
				if (distance < distanceNode.getDistance()) {
					distanceNode.setDistance(distance);
				}
			}
		}
		
		return distanceNodes;
	}
	
	public static void main(String[] args) {
		Map<String, List<Neighbor>> graph = new HashMap<>();
		graph.put("A", new ArrayList<>(Arrays.asList(new Neighbor("B", 10), new Neighbor("C", 30), new Neighbor("D", 15))));
		graph.put("B", new ArrayList<>(Arrays.asList(new Neighbor("E", 20))));
		graph.put("C", new ArrayList<>(Arrays.asList(new Neighbor("F", 5))));
		graph.put("D", new ArrayList<>(Arrays.asList(new Neighbor("C", 5), new Neighbor("F", 20))));
		graph.put("E", new ArrayList<>(Arrays.asList(new Neighbor("F", 20))));
		graph.put("F", new ArrayList<>(Arrays.asList(new Neighbor("D", 20))));
		
		System.out.println(run(graph, "A"));
	}
}
