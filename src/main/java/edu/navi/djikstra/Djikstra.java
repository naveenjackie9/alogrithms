package edu.navi.djikstra;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Djikstra {
    public Map<String, Map<String, Integer>> vertice = new HashMap<>();
    public List<String> visitedList = null;

    public Djikstra(char[] vertices) {
        visitedList = new ArrayList<>();
        for(int i = 0; i< vertices.length; i++) {
            this.vertice.put(String.valueOf(vertices[i]), new HashMap<>());
        }
    }

    public void addDirectedEdge(String source, String destination, int length) {
        this.vertice.get(source).put(destination, length);
    }

    public void findMinimumDistance(String origin, String destination) {

        Map<String, Integer> minimumDistance = new HashMap<>();
        for(Map.Entry<String, Map<String, Integer>> entry: this.vertice.entrySet()) {
            if(!entry.getKey().equalsIgnoreCase(origin)) {
                minimumDistance.put(entry.getKey(), Integer.MAX_VALUE);
            }
        }

        while(true) {
            visitedList.add(origin);
            System.out.println("VISITED NODE " + origin);
            Map<String, Integer> adjacentNodes = vertice.get(origin);
            updateMinimumDistance(minimumDistance, adjacentNodes, origin);
            String nextNode = unvisitedNodeWithMinimumDistance(minimumDistance);
            if (nextNode.equalsIgnoreCase(destination)) {
                System.out.println("MINIMUM DISTANCE TO DESTINATION " + minimumDistance.get(destination));
                break;
            }
            origin = nextNode;
        }
    }

    public void updateMinimumDistance(Map<String, Integer> minimumDistance,
                                      Map<String, Integer> adjacentNodes,
                                      String origin) {

        int totalDistance = 0;
        for(Map.Entry<String, Integer> entry: adjacentNodes.entrySet()) {
            if(this.visitedList.contains(origin) && minimumDistance.containsKey(origin)){
                totalDistance = minimumDistance.get(origin);
            }
            totalDistance += entry.getValue();
            if(minimumDistance.get(entry.getKey()) > totalDistance) {
                minimumDistance.put(entry.getKey(), totalDistance);
            }
        }
    }

    public String unvisitedNodeWithMinimumDistance(Map<String, Integer> minimumDistance) {
        int min = -1;
        String minimumNode = null;
        for(Map.Entry<String, Integer> entry: minimumDistance.entrySet()) {
            if (min == -1) {
                if(!this.visitedList.contains(entry.getKey())) {
                    min = entry.getValue();
                    minimumNode = entry.getKey();
                }
            } else if(entry.getValue() < min) {
                if(!this.visitedList.contains(entry.getKey())) {
                    min = entry.getValue();
                    minimumNode = entry.getKey();
                }
            }
        }
        this.visitedList.add(minimumNode);
        return minimumNode;
    }
}
