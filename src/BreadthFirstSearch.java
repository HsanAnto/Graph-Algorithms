import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    

    public List<Integer> bfsShortestPath(int[][] graph, int source, int dest) 
    {
        int V = graph.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        
        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) 
        {
            int current = queue.poll();
            if (current == dest) 
            {
                break;
            }

            for (int neighbor = 0; neighbor < V; neighbor++) 
            {
                if (graph[current][neighbor] > 1 && !visited[neighbor]) 
                {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.offer(neighbor);
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int i = dest; i != -1; i = parent[i]) 
        {
            path.add(i);
        }
        Collections.reverse(path);

        return path;
    }
}
