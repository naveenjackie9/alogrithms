package edu.navi.dfs;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphDFS {
    public int v;
    public LinkedList<Integer> vertices[];
    private boolean visited[];

    public GraphDFS(int v) {
        vertices = new LinkedList[v];
        visited = new boolean[v];
        this.v = v;
        for(int i = 0 ; i < v ; i++) {
            vertices[i] = new LinkedList<>();
            visited[i] = false;
        }
    }

    public void addEdge(int origin, int destination) {
        vertices[origin].add(destination);
    }

    public void dfs(int index) {
        visited[index] = true;
        System.out.println("VISITING VERTICE "+ index );
        Iterator<Integer> verticeIterator = this.vertices[index].iterator();
            while(verticeIterator.hasNext()) {
                int next = verticeIterator.next();
                if(!visited[next]){
                    this.dfs(next);
                }

        }

    }
}
