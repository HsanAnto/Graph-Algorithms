package MST;

import java.util.Arrays;

public class PrimsAlgorithm 
{
    private int V; 
    private int parent[]; 
    private int key[]; 
    private boolean mstSet[]; 
    private int graph[][]; 

    public PrimsAlgorithm(int graph[][]) 
    {
        this.V = graph.length;
        this.parent = new int[V];
        this.key = new int[V];
        this.mstSet = new boolean[V];
        this.graph = graph;
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);
    }

    public int[][] getMST() 
    {
        int[][] mst = new int[V][V];

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) 
        {
            int u = minKey();
            mstSet[u] = true;

            for (int v = 0; v < V; v++) 
            {
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) 
                {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        for (int i = 1; i < V; i++) 
        {
            mst[parent[i]][i] = graph[i][parent[i]];
            mst[i][parent[i]] = graph[i][parent[i]];
        }

        return mst;
    }

    private int minKey() {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
        {
            if (mstSet[v] == false && key[v] < min) 
            {
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }
    
}
