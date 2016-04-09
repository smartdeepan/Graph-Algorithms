public class FordFulkerson {
	static final int V = 6;

	public static void main(String[] args) throws java.lang.Exception {

		int graph[][] = new int[][] { { 0, 16, 13, 0, 0, 0 },
				{ 0, 0, 10, 12, 0, 0 }, { 0, 4, 0, 0, 14, 0 },
				{ 0, 0, 9, 0, 0, 20 }, { 0, 0, 0, 7, 0, 4 },
				{ 0, 0, 0, 0, 0, 0 } };

		myFordFulkerson(graph, 0, 5);

	}

	private static void myFordFulkerson(int[][] graph, int s, int t) {

		int parent[] = new int[V];

		int maxFlow = 0;

		int rGraph[][] = new int[V][V];
		rGraph = graph.clone();

		while (bfs(rGraph, s, t, parent)) {

			int minvalue = Integer.MAX_VALUE;
			for (int v = t; v != s; v = parent[v]) {

				int u = parent[v];
				minvalue = min(minvalue, rGraph[u][v]);
			}

			for (int v = t; v != s; v = parent[v]) {
				int u = parent[v];
				rGraph[v][u] += minvalue;
				rGraph[u][v] -= minvalue;

			}

			maxFlow += minvalue;
		}

		System.out.println("maxflow is -- " + maxFlow);

	}

	private static int min(int j, int i) {

		return (i < j) ? i : j;
	}

	private static boolean bfs(int[][] graph, int s, int t, int[] parent) {

		boolean visited[] = new boolean[V];

		int queue[] = new int[V * V];
		int start = 0, end = 0;

		queue[end++] = s;
		visited[s] = true;
		parent[s] = -1;
		while (start <= end) {
			int popedele = queue[start++];

			for (int v = 0; v < graph[popedele].length; v++) {
				if (graph[popedele][v] > 0 && !visited[v]) {

					parent[v] = popedele;
					queue[end++] = v;
					visited[v] = true;

				}
			}

		}

		return (visited[t]);
	}
}
