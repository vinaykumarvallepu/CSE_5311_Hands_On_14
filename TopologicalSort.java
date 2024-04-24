import java.util.*;

class TopologicalSort {
    private int V;
    private LinkedList<Integer> adj[];

    TopologicalSort(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<Integer>(); 
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        stack.push(new Integer(v));
    }

    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String args[]) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(3, 2);
        g.addEdge(5, 0);
        g.addEdge(1, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Topological Sort order:");
        g.topologicalSort();
    }
}

// OUTPUT
// Topological Sort order:
// 5 4 2 3 1 0 

