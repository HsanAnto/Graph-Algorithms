import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    

    public int shortestPathBFS(int[][] graph, int source, int aim)
    {
        int V = graph.length;
        int[] distance = new int[V];
        boolean[] visited = new boolean[V];
        Queue<Integer> queue= new LinkedList<>();
        visited[source] = true;
        distance[source] = 0;
        queue.add(source);

        while(!queue.isEmpty())
        {
            int vertex = queue.poll();
            if (vertex == aim) return distance[aim];
            for(int i=0; i<V; i++)
            {
                if (graph[vertex][i] > 1 && !visited[i]) 
                {
                    visited[i] = true;
                    distance[i] = distance[vertex] + 1;
                    queue.add(i);
                }
            }
        }

        return -1;
    }
}
