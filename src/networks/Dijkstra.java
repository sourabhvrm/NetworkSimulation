/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networks;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author saurabh
 */
public class Dijkstra {

    long[][] adjacencyMatrix;
    long dist[];
    int size;
    int parent[];
    Stack<Integer> path;

    public Dijkstra(int size) {
        this.size = size;
        dist = new long[this.size];
        parent = new int[this.size];
        adjacencyMatrix = new long[size][size];
        path = new Stack<>();
        for (int i = 0; i < size; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = Integer.MIN_VALUE;
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0;
                } else {
                    adjacencyMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void makeadjacencyMatrix(ArrayList<Node> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.get(i).connectedNodes.size(); j++) {
                adjacencyMatrix[i][nodes.get(i).connectedNodes.get(j).n.getIP().getLastoct()] = nodes.get(i).connectedNodes.get(j).avgdelay;
            }
        }
    }

    public void printAdjMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(adjacencyMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public Stack findShortestPath(int source, int dest) {
        boolean[] visited = new boolean[size];
        int nextNode = 0;
        dist[source] = 0;
        for (int c = 0; c < size; c++) {
            long min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                if (min > dist[i] && !visited[i]) {
                    min = dist[i];
                    nextNode = i;
                }
            }
            visited[nextNode] = true;
            for (int i = 0; i < size; i++) {
                if (!visited[i] && adjacencyMatrix[nextNode][i] != Integer.MAX_VALUE) {
                    if (min + adjacencyMatrix[nextNode][i] < dist[i]) {
                        dist[i] = min + adjacencyMatrix[nextNode][i];
                        parent[i] = nextNode;
                    }
                }
            }
        }
        path.push(dest);
        int j = dest;
        while (j != source) {
            j = parent[j];
            path.push(j);
        }
        path.pop();
        return path;
    }
    
    public int getCost(int dest){
        return (int) dist[dest];
    }
}
