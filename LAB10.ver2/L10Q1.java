package graph;

import java.util.*;

public class L10Q1 {

    public static void main(String[] args) {

        Graph<String, Integer> graph = new Graph<>();
        String[] v = {"A", "B", "C", "D", "E", "F", "G"};
        for (String i : v) {
            graph.addVertex(i);
        }

        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "D", 1);
        graph.addEdge("B", "E", 1);
        graph.addEdge("A", "C", 1);
        graph.addEdge("C", "F", 1);
        graph.addEdge("E", "G", 1);

        System.out.println("Creating a graph with 7 vertices and 6 edges");
        for (String x : v) {
            System.out.println(x + " --> ");
            ArrayList<String> y = graph.getNeighbours(x);
            int i = 0;
            while (i < y.size()) {
                System.out.print("  -> " + y.get(i) + " : " + graph.getEdgeWeight(x, y.get(i)));
                i++;
            }
            System.out.println("");
        }

        ArrayList<String> list = graph.getAllVertexObjects();

        ArrayList<ArrayList<String>> pathAG = new ArrayList<>();
        ArrayList<String> visited = new ArrayList<>();
        graph.findPaths("A", "G", visited, pathAG);

        System.out.println("The path from A to G");

        if (!pathAG.isEmpty()) {
            for (ArrayList<String> path : pathAG) {
                for (String vertex : path) {
                    System.out.print(vertex + " -> ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No path from A to G found.");
        }
    }
}
