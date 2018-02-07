import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class BFS {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of  nodes");
		int n = s.nextInt();
		System.out.println("Enter Adjacency Matrix");
		int[][] a = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j] = s.nextInt();
		for(int i=0;i<n;i++) {
			System.out.println("Source : "+(i+1));
			System.out.print("Traversal :");
			boolean[] visited = new boolean[n];
			visited[i] = true;
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(i);
			BFS(a,n,visited,queue);
			System.out.println("\n");
		}
	}
	public static void BFS(int[][] a, int n, boolean[] visited, Queue<Integer> queue) {
		while(!queue.isEmpty()) {
			int s = queue.remove();
			System.out.print(" "+(s+1));
			for(int i=0;i<n;i++)
				if(a[s][i] == 1 && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
		}
	}
}