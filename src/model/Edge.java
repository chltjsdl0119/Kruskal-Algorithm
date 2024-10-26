package model;

public class Edge implements Comparable<Edge> {
    private int src;
    private int dest;
    private int weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Edge를 가중치에 따라 정렬할 수 있도록 Comparable 인터페이스 구현
    @Override
    public int compareTo(Edge e) {
        return Integer.compare(this.weight, e.weight);
    }

    // getter
    public int getSrc() {
        return src;
    }

    public int getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }
}
