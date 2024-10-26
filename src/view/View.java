package view;

import model.Edge;

import java.util.List;

public class View {

    // MST 결과와 총 가중치를 화면에 출력
    public void displayMST(List<Edge> mst) {
        System.out.println("Minimum Spanning Tree:");
        int totalWeight = 0;

        for (Edge edge : mst) {
            System.out.println(edge.getSrc() + " -- " + edge.getDest() + " == " + edge.getWeight());
            totalWeight += edge.getWeight();
        }

        System.out.println("Total Weight of MST: " + totalWeight);
    }
}