package Lab10;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim {
    public int[][] graph;
    private boolean[] isTravel;
    private PriorityQueue<PrimEdge> pq;

    Prim(int[][] input){
        graph = input;
        isTravel = new boolean[graph.length];
        Arrays.fill(isTravel, false);
        pq = new PriorityQueue<>(100, Comparator.comparing(PrimEdge::getWeight));
    }

    public int[][] getMST() {
        Arrays.fill(isTravel, false);
        int allNode = graph.length;
        int current = 0;
        isTravel[current] = true;
        int[][] MST = new int[graph.length][graph[0].length];
        for(int i=0;i<allNode-1;i++){
            for(int j=0;j<graph[current].length;j++){
                if (graph[current][j] != 0){ //สามารถเดินไปหากันได้
                    PrimEdge n = new PrimEdge(current, j, graph[current][j]);
                    pq.add(n);
					//System.out.println(pq.poll());
                }
            }
            while(true){
                if(!isTravel[pq.peek().getV()]){
                    PrimEdge q = pq.poll();
                    MST[q.getU()][q.getV()] = q.getWeight();
                    isTravel[q.getV()] = true;
                    current = q.getV();
                    break;
                }
                pq.poll();
            }
        }
        return MST;
    }

    public int[][] getMST(int source) {
        Arrays.fill(isTravel, false);
        int allNode = graph.length;
        int current = source;
        isTravel[current] = true;
        int[][] MST = new int[graph.length][graph[0].length];
        for(int i=0;i<allNode-1;i++){
            for(int j=0;j<graph[current].length;j++){
                if (graph[current][j] != 0){
                    PrimEdge n = new PrimEdge(current, j, graph[current][j]);
                    pq.add(n);
                }
            }
            while(true){
                if(!isTravel[pq.peek().getV()]){
                    PrimEdge q = pq.poll();
                    MST[q.getU()][q.getV()] = q.getWeight();
                    isTravel[q.getV()] = true;
                    current = q.getV();
                    break;
                }
                pq.poll();
            }
        }
        return MST;
    }

    public static void showTreeAdjacency(int[][] mst){
        for(int[] row : mst)
            System.out.println(Arrays.toString(row));
    }
	public static void main(String[] args) {
		// Sample adjacency matrix
		int[][] graph = {
			{0, 9, 75, 0, 0},
			{9, 0, 95, 19, 42},
			{75, 95, 0, 51, 66},
			{0, 19, 51, 0, 31},
			{0, 42, 66, 31, 0}
		};
	
		// Initialize Prim's algorithm with the matrix
		Prim prim = new Prim(graph);
	
		// Get MST
		int[][] mst = prim.getMST();
	
		// Display MST
		System.out.println("Minimum Spanning Tree:");
		showTreeAdjacency(mst);
	}
}
