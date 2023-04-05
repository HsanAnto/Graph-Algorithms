import java.util.Arrays;

public class DijkstraAlgorithm 
{
    public int[] Dijkstra(int[][] graph, int source)
    {
        int V = graph.length; // number of vertices in the graph

        int [] distances = new int[V]; //array where the distances from the origin to each vertex are save
        Arrays.fill(distances, Integer.MAX_VALUE); // initialize all the distances as infinite
        distances[0] = 0; //the distance from the source to itself is 0

        boolean[] visited = new boolean[V]; //array to mark the vertices already processed
        Arrays.fill(visited, false); // initialize all the vertices as false

        for(int i = 0; i < V-1; i++)
        {
            // look for the vertex with the shortest distance from the source
            // in the first iteration, the actualVertex will always be the source
            int minDistance = Integer.MAX_VALUE;
            int actualVertex = -1;
            for(int j = 0; j < V; j++)
            {
                if(!visited[j] && distances[j] < minDistance)
                {
                    minDistance = distances[j];
                    actualVertex = j;
                }
            }

            visited[actualVertex] = true; //mark that vertex as visited

            //update the distance of the adjacent vertices of the actual vertex
            for(int j = 0; j < V; j++)
            {
                int distance = graph[actualVertex][j]; //get the distance from the actualVertex to the vertex that is being analized(j)
                if(!visited[j] && distance > 0 && distances[actualVertex] != Integer.MAX_VALUE) //if the vertex has not been visited and an arc between the actualVertex and j exist
                {
                    int newDistance = distances[actualVertex] + distance; // calculate the new possible distance
                    if(newDistance < distances[j]) //if the newDistance is < than the actual distance
                    {
                        distances[j] = newDistance; //update the distance
                    }
                }
            }
        }
        return distances;
    }


    
}
