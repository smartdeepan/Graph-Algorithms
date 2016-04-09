public class Kosarajusalgo {
	// No. of vertices

	static int V = 5;

	// Adjacency List
	static int Graph[][] = new int[V + 1][V + 1];
	static int Graphrev[][] = new int[V + 1][V + 1];

	static int top = -1;

	static boolean printed[] = new boolean[V + 1];

	static int verticescopy[][] = new int[V][2];
	static int totalNoOfEdges = 0;

	static void addEdge(int v, int w) {

		v++;
		w++;

		verticescopy[totalNoOfEdges][0] = v;
		verticescopy[totalNoOfEdges][1] = w;

		totalNoOfEdges++;

		Graph[v][0] = Graph[v][0] + 1;
		Graph[v][Graph[v][0]] = w;

	}

	static void printStronglyConnectedComponentss() {

		int stack[] = new int[V];

		dfs(stack);

		invertGraph();

		while (top != -1) {
			// pop
			int popedele = stack[top--];

			dfsutilprint(popedele);
			System.out.println();
		}
	}

	private static void dfsutilprint(int popedele) {

		if (!printed[popedele]) {

			System.out.print(popedele);
			printed[popedele] = true;

			for (int i = 1; i <= Graphrev[popedele][0]; i++) {

				if (Graphrev[popedele][i] > 0
						&& !printed[Graphrev[popedele][i]]) {
					dfsutilprint(Graphrev[popedele][i]);

				}
			}
		}

	}

	private static void invertGraph() {

		for (int i = 0; i < totalNoOfEdges; i++) {

			Graphrev[verticescopy[i][1]][0]++;

			Graphrev[verticescopy[i][1]][Graphrev[verticescopy[i][1]][0]] = verticescopy[i][0];

		}

	}

	private static void dfs(int[] stacks) {

		boolean visited[] = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {

			if (!visited[i]) {
				dfsutil(visited, i, stacks);
			}

		}

	}

	private static void dfsutil(boolean[] visited, int source, int[] stacks) {

		visited[source] = true;

		// process neighbours

		for (int i = 1; i <= Graph[source][0]; i++) {

			if (Graph[source][i] != 0 && !visited[Graph[source][i]]) {

				dfsutil(visited, Graph[source][i], stacks);
			}
		}

		stacks[++top] = source;

	}

	
	public static void main(String args[]) {
		
		addEdge(1, 0);
		addEdge(0, 2);
		addEdge(2, 1);
		addEdge(0, 3);
		addEdge(3, 4);

		System.out.println("Following are strongly connected components "
				+ "in given graph ");
		printStronglyConnectedComponentss();
	}
}
