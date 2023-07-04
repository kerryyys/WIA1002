package graph;

import java.util.*;

public class L10Q2 {

    static Graph<String, Double> graph = new Graph();

    public static void main(String[] args) {

        String[] vertex = {"A", "B", "C", "D", "E", "F", "G", "H"};

        for (String i : vertex) {
            graph.addVertex(i);
        }

        graph.addEdge("A", "B", 0.4);
        graph.addEdge("B", "C", 0.1);
        graph.addEdge("C", "F", 0.3);
        graph.addEdge("F", "H", 0.4);
        graph.addEdge("A", "B", 0.4);
        graph.addEdge("E", "H", 0.5);
        graph.addEdge("G", "H", 0.8);
        graph.addEdge("B", "D", 0.2);
        graph.addEdge("A", "C", 0.7);
        graph.addEdge("A", "G", 0.8);

        System.out.println("Creating a graph with 8 vertices and 10 edges");
        for (String x : vertex) {
            System.out.println(x + " --> ");
            ArrayList<String> y = graph.getNeighbours(x);
            int i = 0;
            while (i < y.size()) {
                System.out.print("  -> " + y.get(i) + " : " + graph.getEdgeWeight(x, y.get(i)));
                i++;
            }
            System.out.println("");
        }

        ArrayList<String> currentPath = new ArrayList<>();
        ArrayList<ArrayList<String>> paths = new ArrayList<>();
        graph.findPaths("A", "H", currentPath, paths);

        System.out.println("The shortest path from A - H by cost");
        sortPathsByDistance(paths);
        ArrayList<String> shorts = paths.get(0);
        int x = 0;
        while (x < shorts.size()) {
            System.out.print(shorts.get(x) + " -> ");
            x++;
        }
        System.out.println("");

        System.out.println("The shortest path from A-H by distance");
        ArrayList<String> min = paths.get(0);
        for (int a = 1; a < paths.size(); a++) {
            if (min.size() > paths.get(a).size()) {
                min = paths.get(a);
            }
        }
        int b = 0;
        while (b < min.size()) {
            System.out.print(min.get(b) + " -> ");
            b++;
        }
    }

    public static double calculateDistance(List<String> path) {
        double distance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String currentVertex = path.get(i);
            String nextVertex = path.get(i + 1);
            double edgeWeight = graph.getEdgeWeight(currentVertex, nextVertex);

            distance += edgeWeight;
        }
        return distance;
    }

    private static void sortPathsByDistance(ArrayList<ArrayList<String>> paths) {
        paths.sort(Comparator.comparingDouble(L10Q2::calculateDistance));
    }
}
