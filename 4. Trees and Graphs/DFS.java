import java.util.Scanner;
class DFS {
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
			DFS(a,n,i,visited);
			System.out.println("\n");
		}
	}
	public static void DFS(int[][] a, int n, int s, boolean[] visited) {
		if(visited[s] == false) {
			visited[s] = true;
			System.out.print(" "+(s+1));
			for(int i=0;i<n;i++) {
				if(a[s][i] == 1)
					DFS(a,n,i,visited);
			}
		}
	}
}