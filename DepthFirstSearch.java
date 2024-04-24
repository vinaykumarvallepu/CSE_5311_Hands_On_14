import java.util.*;

class DepthFirstSearch {
    private int V;
    private LinkedList<Integer> adj[];

    DepthFirstSearch(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String args[]) {
        DepthFirstSearch g = new DepthFirstSearch(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.println("Depth First Traversal:");
        g.DFS(0);
    }
}

// OUTPUT
// Depth First Traversal:
// 0 1 3 4 2 5 6 
