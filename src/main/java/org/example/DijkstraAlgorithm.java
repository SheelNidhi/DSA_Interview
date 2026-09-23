package org.example;

import java.util.*;

public class DijkstraAlgorithm {

    // Class to represent a weighted edge to a neighbor
    static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    // Class to track current shortest distance to a node in the PriorityQueue
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        // Overriding compareTo to make the PriorityQueue behave as a Min-Heap
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int[] dijkstra(List<List<Edge>> graph, int source, int V) {
        // Line 1: Initialize the distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Line 2: Create a Min-Heap (PriorityQueue) to hold our Nodes
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        // Line 3: Add the source node to start the exploration
        minHeap.add(new Node(source, 0));

        // Line 4: Keep looping while there are unvisited/unprocessed paths
        while (!minHeap.isEmpty()) {
            // Line 5: Extract the node with the absolute smallest distance
            Node current = minHeap.poll();
            int u = current.vertex;
            int currentDist = current.distance;

            // Line 6: Staleness check (Optimization)
            if (currentDist > dist[u]) continue;

            // Line 7: Loop through all neighboring edges of the current vertex
            for (Edge edge : graph.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                // Line 8: Relaxation Step
                if (dist[u] + weight < dist[v]) {
                    // Line 9: Update to the shorter distance found
                    dist[v] = dist[u] + weight;
                    // Line 10: Push the updated node to the min-heap
                    minHeap.add(new Node(v, dist[v]));
                }
            }
        }
        // Line 11: Return the final array containing shortest paths
        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Graph Initialization: node -> (target, weight)
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(4, 3));

        int[] distances = dijkstra(graph, 0, V);
        System.out.println("Shortest distances from source 0: " + Arrays.toString(distances));
        // Output: [0, 3, 1, 4, 7]
    }
}