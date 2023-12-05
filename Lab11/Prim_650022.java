import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim {
	public int [][] graph;
	private PriorityQueue<PrimEdge> pq;

	public Prim(int [][] graph) {
		this.graph = graph;
		pq = new PriorityQueue<>(Comparator.comparing(PrimEdge::getWeight));
	}
	public int[][] getMST() {
		int [][] ret = new int[graph.length][graph.length];
		boolean [] visited = new boolean[graph.length];

		for (int i = 0; i < graph[0].length; i++) {
			if (graph[0][i] == 0)
				continue;
			pq.add(new PrimEdge(0, i, graph[0][i]));
		}
		visited[0] = true;
		
		while (!pq.isEmpty()) {
			PrimEdge pe = pq.poll();
			int u = pe.getU();
			int v = pe.getV();
			int w = pe.getWeight();

			if (visited[v])
				continue;
			visited[v] = true;

			ret[u][v] = w;
			
			for (int i = 0; i < graph[v].length; i++) {
				if (graph[v][i] == 0)
					continue;
				if (!visited[i])
					pq.add(new PrimEdge(v, i, graph[v][i]));
			}
		}
		return ret;
	}
	public int[][] getMST(int source) {
		int [][] ret = new int[graph.length][graph.length];
		boolean [] visited = new boolean[graph.length];

		for (int i = 0; i < graph[source].length; i++) {
			if (graph[source][i] == 0)
				continue;
			pq.add(new PrimEdge(source, i, graph[source][i]));
		}
		visited[source] = true;
		
		while (!pq.isEmpty()) {
			PrimEdge pe = pq.poll();
			int u = pe.getU();
			int v = pe.getV();
			int w = pe.getWeight();

			if (visited[v])
				continue;
			visited[v] = true;

			ret[u][v] = w;
			
			for (int i = 0; i < graph[v].length; i++) {
				if (graph[v][i] == 0)
					continue;
				if (!visited[i])
					pq.add(new PrimEdge(v, i, graph[v][i]));
			}
		}
		return ret;
	}
	public static void showTreeAdjacency(int [][] mst) {
		for (int [] row : mst)
			System.out.println(Arrays.toString(row));
	}
}
