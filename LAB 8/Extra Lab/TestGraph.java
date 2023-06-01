import java.util.*;

public class TestGraph {
    private static RoutingGraph<String, Double, Double> graph = new RoutingGraph<>();

    public static void main(String[] args) {
        String[] array = {"A","B","C","D","E","F","G"};
        for (String elem: array)
            graph.addVertex(elem);

        System.out.println("THe number of vertices in MyCityGraph: "+graph.getSize());
        System.out.println("List all vertices: ");

        for (int i=0; i<graph.getSize(); i++){
            System.out.print(i+": "+graph.getVertex(i)+"\t");
        }
        System.out.println("\n");

        // add edges
        graph.addUndirectedEdge("A","B",1.0,7.0);
        graph.addDirectedEdge("A","C",1.0,10.1);
        graph.addUndirectedEdge("B","C",1.0,5.5);
        graph.addDirectedEdge("B","E",1.25,3.2);
        graph.addDirectedEdge("C","D",1.25,8.3);
        graph.addDirectedEdge("D","G",1.5,4.9);
        graph.addDirectedEdge("E","F",1.5,4.0);
        graph.addUndirectedEdge("E","G",1.5,6.0);
        graph.addDirectedEdge("E","D",1.25,2.9);
        graph.addDirectedEdge("F","G",1.2,2.3);

        System.out.println("Has edge from B to A?\t"+graph.hasEdge("B","A"));
        System.out.println("Has edge from A to D?\t"+graph.hasEdge("A","D"));
        System.out.println();

        System.out.println("Find all neighbours of B : "+graph.getNeighbours("B").toString());
        System.out.println();

        System.out.println("Print all edges : ");
        graph.printEdges();
        System.out.println();

        List<List<String>> paths = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();
        currentPath.add("A"); // Start from Point A
        findPossiblePaths("A", "G", currentPath, paths);

        // Print the five possible paths
        List<List<String>> possiblePaths = new ArrayList<>();
        System.out.println("Five possible paths from A to G:");
        for (int i=0; i<Math.min(5, paths.size()); i++) {
            possiblePaths.add(paths.get(i));
            System.out.println(possiblePaths.get(i));
        }
        System.out.println();

        // Print distance and duration for every path
        for (int i=0; i<possiblePaths.size(); i++){
            System.out.print("Path "+(i+1)+": "+paths.get(i));
            System.out.println();
            System.out.printf("Distance= %.2f km, Duration= %.2f min",
                    calculateDistance(paths.get(i)), calculateDuration(paths.get(i)));
            System.out.println();
        }
        System.out.println();

        int n = paths.size();
        List<Integer> indices1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices1.add(i);
        }
        // Sort paths by distance (ascending) using bubble sort
        sortDistance(possiblePaths,indices1);

        // Print paths after bubble sort
        System.out.println("After Bubble Sort:");
        for (int i = 0; i < possiblePaths.size(); i++) {
            double distance = calculateDistance(possiblePaths.get(i));
            System.out.printf("Path %d (%.2f km)\n", indices1.get(i), distance);
        }
        System.out.println();

        List<Integer> indices2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices2.add(i);
        }
        // Sort paths by duration (descending) using insertion sort
        sortDuration(possiblePaths, indices2);

        // Print paths after insertion sort
        System.out.println("After Insertion Sort:");
        for (int i = 0; i < possiblePaths.size(); i++) {
            double duration = calculateDuration(possiblePaths.get(i));
            System.out.printf("Path %d (%.2f min)\n", indices2.get(i), duration);
        }
    }

    // find possible paths using depth first search
    public static void findPossiblePaths(String currentVertex, String targetVertex,
                                         List<String> currentPath, List<List<String>> paths){
        if (currentVertex.equals(targetVertex)) {
            // Found a path from A to G
            paths.add(new ArrayList<>(currentPath));
            return;
        }

        List<String> neighbors = graph.getNeighbours(currentVertex);
        for (String neighbor : neighbors) {
            if (!currentPath.contains(neighbor)) {
                currentPath.add(neighbor);
                findPossiblePaths(neighbor, targetVertex, currentPath, paths);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    public static double calculateDistance(List<String> path){
        double distance = 0;
        for (int i=0; i<path.size()-1; i++){
            String currentVertex = path.get(i);
            String nextVertex = path.get(i+1);
            Edge<String,Double,Double> currentEdge = graph.getEdge(currentVertex,nextVertex);
            if (currentEdge!=null)
                distance += currentEdge.distance;
        }
        return distance;
    }

    public static double calculateDuration(List<String> path){
        double duration = 0;
        for (int i=0; i<path.size()-1; i++){
            String currentVertex = path.get(i);
            String nextVertex = path.get(i+1);
            Edge<String,Double,Double> currentEdge = graph.getEdge(currentVertex,nextVertex);
            if (currentEdge!=null)
                duration += currentEdge.distance*currentEdge.speed;
        }
        return duration;
    }

    private static void sortDistance(List<List<String>> paths, List<Integer> indices){
        int n = paths.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                double distance1 = calculateDistance(paths.get(j));
                double distance2 = calculateDistance(paths.get(j + 1));
                if (distance1 > distance2) {
                    List<String> temp = paths.get(j);
                    paths.set(j, paths.get(j + 1));
                    paths.set(j + 1, temp);

                    Integer temp1 = indices.get(i);
                    indices.set(j, indices.get(j+1));
                    indices.set(j+1, temp1);
                }
            }
        }
    }

    private static void sortDuration(List<List<String>> paths, List<Integer> indices) {
        int n = paths.size();
        for (int i = 1; i < n; i++) {
            List<String> key = paths.get(i);
            double keyDuration = calculateDuration(key);
            int j = i - 1;
            while (j >= 0 && calculateDuration(paths.get(j)) < keyDuration) {
                paths.set(j + 1, paths.get(j));
                j--;
            }
            paths.set(j + 1, key);
        }

        // Update path numbers based on sorted duration order
        for (int i = 0; i < n; i++) {
            int index = indices.get(i);
            paths.get(i).add(0, "Path " + (index + 1));
        }
    }
}
    