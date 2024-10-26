package model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int[][] adjMatrix; // 인접행렬로 그래프의 노드 연결 정보를 저장
    private List<Edge> edges;  // 그래프의 간선(Edge) 리스트

    public Graph(int size) {
        adjMatrix = new int[size][size];
        edges = new ArrayList<>();
    }

    // 인접행렬 초기화 메소드
    public void initializeGraph() {
        /* 예시

        // adjMatrix[시작 노드][끝 노드] = 가중치;
        adjMatrix[0][1] = 4;
        adjMatrix[0][2] = 2;
        adjMatrix[1][2] = 5;
        adjMatrix[1][3] = 10;
        adjMatrix[2][3] = 3;
        adjMatrix[3][4] = 7;

        // 비방향 그래프이므로 반대 방향도 설정
        adjMatrix[1][0] = 4;
        adjMatrix[2][0] = 2;
        adjMatrix[2][1] = 5;
        adjMatrix[3][1] = 10;
        adjMatrix[3][2] = 3;
        adjMatrix[4][3] = 7;

         */
    }

    // 간선 리스트 반환 메소드
    public List<Edge> getEdges() {
        edges.clear(); // 기존 리스트 초기화
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = i + 1; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] != 0) {
                    edges.add(new Edge(i, j, adjMatrix[i][j])); // 가중치가 있는 간선만 추가
                }
            }
        }
        return edges;
    }
}