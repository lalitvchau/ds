package ds.graph;

import ds.pq.Heap;
import ds.queue.Queue;
import ds.stack.Stack;

public class Graph {
    boolean isDirectedGraph;
    boolean[][] adjMatrix;
    int totalVertices, totalEdges = 0;

    public Graph(int totalVertices, boolean isDirectedGraph) {
        this.isDirectedGraph = isDirectedGraph;
        this.totalVertices = totalVertices;
        this.totalEdges = 0;
        this.adjMatrix = new boolean[totalVertices][totalVertices];
    }

    private boolean isValidEdge(int vertex1, int vertex2) {
        if (vertex1 >= 0 && vertex1 < totalVertices && vertex2 >= 0 && vertex2 < totalVertices) {
            return true;
        } else {
            throw new IllegalArgumentException("Both Vertices mus be valid");
        }
    }

    public boolean addEdge(int vertex1, int vertex2) {
        isValidEdge(vertex1, vertex2);
        if (!adjMatrix[vertex1][vertex2]) {
            totalEdges++;
            adjMatrix[vertex1][vertex2] = true;
            if (!isDirectedGraph) {
                adjMatrix[vertex2][vertex1] = true;
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
                    if (adjMatrix[nextNode][i] && !visited[i]) {
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
                    if (adjMatrix[nextNode][i] && !visited[i]) {
                        queue.enqueue(i);
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8, false);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 7);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 7);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);

        graph.dfs();
        graph.bfs();
    }
}
