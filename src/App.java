public class App {
    public static void main(String[] args) throws Exception {
        int[][] graph = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                        {10, 0, 8, 1, 0, 0, 0, 11, 0},
                        {0, 8, 0, 7, 5, 4, 0, 0, 2},
                        {0, 0, 7, 0, 9, 14, 0, 0, 0},
                        {0, 0, 0, 9, 0, 10, 0, 2, 0},
                        {0, 3, 4, 0, 10, 0, 2, 0, 0},
                        {1, 0, 0, 14, 0, 2, 0, 1, 6},
                        {8, 11, 0, 8, 0, 1, 1, 0, 7},
                        {0, 0, 2, 8, 0, 0, 6, 7, 0} };
        Dijkstra dijkstra = new Dijkstra();
        printSolution(dijkstra.dijkstra(graph, 5), 5);

        BellmanFord bellman = new BellmanFord();
        printSolution(bellman.bellmanFord(graph, 5), 5);

    }

    private static void printSolution(int[] dist, int source)
    {
        System.out.println("Distancia del vertice desde el vertice " + Integer.toString(source)+"\n");
        for (int i = 0; i < dist.length; i++)
        {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}
