import java.util.*;

class KruskalAlgorithm {
    class Edge implements Comparable<Edge> {
        char src, dest;
        int weight;

        Edge(char src, char dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    List<Edge> edges;

    KruskalAlgorithm() {
        edges = new ArrayList<>();
    }

    void addEdge(char src, char dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    void KruskalMST() {
        Collections.sort(edges);

        Set<Character> visited = new HashSet<>();
        int totalWeight = 0;

        System.out.println("Kruskal Algo Edges in Minimum Spanning Tree:");
        for (Edge edge : edges) {
            if (!visited.contains(edge.src) || !visited.contains(edge.dest)) {
                System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
                totalWeight += edge.weight;
                visited.add(edge.src);
                visited.add(edge.dest);
            }
        }

        System.out.println("Total Weight of Tree: " + totalWeight);
    }

    public static void main(String[] args) {
        KruskalAlgorithm g = new KruskalAlgorithm();

        g.addEdge('M', 'N', 9);
        g.addEdge('M', 'O', 5);
        g.addEdge('N', 'O', 3);
        g.addEdge('N', 'P', 2);
        g.addEdge('O', 'P', 1);
        g.addEdge('O', 'Q', 7);
        g.addEdge('P', 'Q', 6);
        g.addEdge('P', 'R', 8);
        g.addEdge('Q', 'R', 9);

        g.KruskalMST();
    }
}

// OUTPUT
// Kruskal Algo Edges in Minimum Spanning Tree:
// O - P : 1
// N - P : 2
// M - O : 5
// P - Q : 6
// P - R : 8
// Total Weight of Tree: 22
