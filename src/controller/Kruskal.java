package controller;

import model.Edge;
import model.Graph;

import java.util.ArrayList;
import java.util.List;

public class Kruskal {
    private int[] parent;  // 각 노드의 부모 노드를 저장
    private int[] rank;    // 랭크(트리의 깊이)를 저장하여 최적화

    // 초기화: 각 노드의 부모를 자기 자신으로 설정하고, 랭크를 0으로 초기화
    public void initSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // find 메소드 - 경로 압축을 사용하여 루트 노드를 찾음
    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // 경로 압축
        }
        return parent[node];
    }

    // union 메소드 - 가중치(rank) 기반으로 두 트리를 병합
    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) { // 서로 다른 집합에 있을 경우에만 병합
            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV; // U의 트리가 V의 트리에 속하게 함
            } else if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU; // V의 트리가 U의 트리에 속하게 함
            } else {
                parent[rootV] = rootU; // 랭크가 같다면 U를 루트로 하고, 랭크 증가
                rank[rootU]++;
            }
        }
    }

    // Kruskal 알고리즘을 수행하여 최소 신장 트리(MST)를 반환
    public List<Edge> kruskalMST(Graph graph) {
        List<Edge> mst = new ArrayList<>();  // MST에 포함될 간선 리스트
        List<Edge> edges = graph.getEdges(); // 모든 간선 정보 불러오기

        // 자바의 List 클래스의 sort() 메소드를 사용하여 가중치 기준으로 간선 정렬
        edges.sort(Edge::compareTo);

        for (Edge edge : edges) {
            // 두 노드가 다른 집합에 있으면 MST에 추가하고 union 수행
            if (find(edge.getSrc()) != find(edge.getDest())) {
                union(edge.getSrc(), edge.getDest());
                mst.add(edge);
            }
        }
        return mst;
    }
}