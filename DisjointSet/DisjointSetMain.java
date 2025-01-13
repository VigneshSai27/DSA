package DisjointSet;

import java.util.Arrays;

public class DisjointSetMain {
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {3, 4}, {2, 3}};
        DisjointSet ds = new DisjointSet(5); // 0 - based index. SO, 4+1
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            ds.union(u, v);
        }
    }
}

class DisjointSet {
    private int noOfVertices;
    int[] parent;
    int[] size;

    public DisjointSet(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        parent = new int[noOfVertices];
        size = new int[noOfVertices];
        for (int i = 1; i < noOfVertices; i++) {
            parent[i] = i;
        }
        Arrays.fill(size, 1);
    }

    public int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(x);
    }

    public void union(int u, int v) {
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if (size[parent_u] >= size[parent_v]) {
            parent[parent_v] = parent_u;
            size[parent_u] += size[parent_v];
        } else {
            parent[parent_u] = parent_v;
            size[parent_v] += size[parent_u];
        }
    }
}