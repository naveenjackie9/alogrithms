package edu.navi.bfs;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphBFS {
    public int v;
    public LinkedList<Integer> edges[];

    public GraphBFS(int v) {
        this.v = v;
        edges = new LinkedList[v];
        for(int i = 0; i< v ; i++) {
            edges[i] = new LinkedList<>();
        }
    }

    public void addEdge(int origin, int destination) {
        edges[origin].add(destination);
    }

    public void bfs(int v) {
        LinkedList<Integer> queues = new LinkedList<>();
        boolean visited[] = new boolean[this.v];
        LinkedList<Integer> adjacentNode = edges[v];
        visited[v] = true;
        queues.add(v);
        while(!queues.isEmpty()) {
            Integer head = queues.poll();
            System.out.println("VISITED vertex " + head);
            LinkedList<Integer> adjacent = edges[head];
            Iterator<Integer> queueIterator = adjacent.iterator();

            while (queueIterator.hasNext()) {
                Integer next = queueIterator.next();
                if (!visited[next]) {
                    queues.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
