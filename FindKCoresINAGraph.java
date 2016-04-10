public class FindKCoresINAGraph {
	// No. of vertices

	static int V = 9;
	static int Graph[][] = new int[V + 1][V + 1];


	static int k = 3;

	static void addEdge(int v, int w) {

		v++;
		w++;

		Graph[v][0] = Graph[v][0] + 1;
		Graph[w][0] = Graph[w][0] + 1;

		Graph[v][w] = 1;
		Graph[w][v] = 1;

	}

	private static void dfsutilprint(int popedele, boolean[] visited) {

		visited[popedele] = true;

		int adjcount = Graph[popedele][0];

		if (adjcount < k) {
			for (int l = 1; l <= V; l++) {
				if (Graph[popedele][l] == 1) {

					Graph[l][0]--;

					Graph[l][popedele] = 0;

					Graph[popedele][l] = 0;
					dfsutilprint(l, visited);
				}

			}
			Graph[popedele][0] = 0;

		}

	}

	// Driver method
	public static void main(String args[]) {

		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(1, 5);
		addEdge(2, 3);
		addEdge(2, 4);
		addEdge(2, 5);
		addEdge(2, 6);
		addEdge(3, 4);
		addEdge(3, 6);
		addEdge(3, 7);
		addEdge(4, 6);
		addEdge(4, 7);
		addEdge(5, 6);
		addEdge(5, 8);
		addEdge(6, 7);
		addEdge(6, 8);

		System.out.println("k - cores ");
		dfsutil();

		for (int i = 0; i <= V; i++) {

			if (Graph[i][0] >= k) {
				System.out.print("[" + (i - 1) + "]" + "\t");

				for (int j = 0; j <= V; j++) {

					if (Graph[i][j] == 1 && Graph[i][0] >= k) {
						System.out.print((j - 1) + "\t \t");
					}
				}
				System.out.println();
			}

		}

	}

	private static void dfsutil() {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {

			if (!visited[i]) {
				dfsutilprint(i, visited);
			}

		}

	}
}
