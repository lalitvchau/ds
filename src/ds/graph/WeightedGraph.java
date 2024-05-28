package ds.graph;

import ds.pq.Heap;
import ds.queue.Queue;
import ds.stack.Stack;

import java.util.Arrays;

public class WeightedGraph {
    boolean isDirectedGraph;
    int[][] adjMatrix;
    int totalVertices, totalEdges = 0;

    public WeightedGraph(int totalVertices, boolean isDirectedGraph) {
        this.isDirectedGraph = isDirectedGraph;
        this.totalVertices = totalVertices;
        this.totalEdges = 0;
        this.adjMatrix = new int[totalVertices][totalVertices];
    }

    private boolean isValidEdge(int vertex1, int vertex2) {
        if (vertex1 >= 0 && vertex1 < totalVertices && vertex2 >= 0 && vertex2 < totalVertices) {
            return true;
        } else {
            throw new IllegalArgumentException("Both Vertices mus be valid");
        }
    }

    public boolean addEdge(int vertex1, int vertex2, int weight) {
        isValidEdge(vertex1, vertex2);
        if (adjMatrix[vertex1][vertex2] == 0) {
            totalEdges++;
            adjMatrix[vertex1][vertex2] = weight;
            if (!isDirectedGraph) {
                adjMatrix[vertex2][vertex1] = weight;
            }
            return true;
        } else {
            return false;
        }
    }

    public void dfs() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[totalVertices];
        stack.push(0);
        System.out.println("DFS = ");
        while (!stack.isEmpty()) {
            int nextNode = stack.pop();
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                System.out.printf("(%d) ", nextNode);
                for (int i = 0; i < totalVertices; i++) {
                    if (adjMatrix[nextNode][i] > 0 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
        System.out.println();
    }

    public void bfs() {
        Queue<Integer> queue = new Queue<>();
        boolean[] visited = new boolean[totalVertices];
        queue.enqueue(0);
        System.out.println("BFS = ");
        while (!queue.isEmpty()) {
            int nextNode = queue.dequeue();
            if (!visited[nextNode]) {
                visited[nextNode] = true;
                System.out.printf("(%d) ", nextNode);
                for (int i = 0; i < totalVertices; i++) {
                    if (adjMatrix[nextNode][i] > 0 && !visited[i]) {
                        queue.enqueue(i);
                    }
                }
            }
        }
        System.out.println();
    }

    public void dijkstra(int source) {
        Heap heap = new Heap(totalVertices);
        int[] distance = new int[totalVertices];
        int[] path = new int[totalVertices];
        boolean[] visited = new boolean[totalVertices];
        heap.insert(new Heap.Node(source, 0));
        while (heap.isNotEmpty()) {
            int nextNode = heap.delete().getKey();
            visited[nextNode] = true;
            for (int i = 0; i < totalVertices; i++) {
                if (!visited[i] && adjMatrix[nextNode][i] > 0) {
                    int weight = distance[nextNode];
                    int newWeight = weight + adjMatrix[nextNode][i];
                    if (newWeight < distance[i]) {
                        distance[i] = newWeight;
                        path[i] = nextNode;
                    } else if (distance[i] == 0) {
                        distance[i] = adjMatrix[nextNode][i] + weight;
                        path[i] = nextNode;
                    }
                    heap.insert(new Heap.Node(i, adjMatrix[nextNode][i]));
                }
            }
        }

        System.out.println("Shortest PATH");
        System.out.println("Node\t| Distance\t| PATH");
        System.out.println("------------------------------");
        for (int i = 0; i < totalVertices; i++) {
            System.out.printf("%-4d\t| %-8d\t| %d\n", i, distance[i], path[i]);
        }
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(5, true);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 4, 4);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 4, 4);

        graph.dfs();
        graph.bfs();
        graph.dijkstra(0);
    }
}
