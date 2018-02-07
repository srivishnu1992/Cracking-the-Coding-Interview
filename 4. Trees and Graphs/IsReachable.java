import java.util.Scanner;
import java.util.ArrayList;
class IsReachable {
	public static int s;
	public static int[][] isReachable;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes");
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		System.out.println("Enter Adjacency matrix");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j] = sc.nextInt();
		isReachable = new int[n][n];
		for(s=0;s<n;s++) {
			boolean[] visited = new boolean[n];
			visited[s] = true;
			isReachable[s][s] = 1;
			DFS(a,n,s,visited,isReachable);
		}
		System.out.println("Reachability Matrix");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				System.out.print(isReachable[i][j]+" ");
			System.out.println();
		}
	}
	public static void DFS(int[][] a, int n, int i, boolean[] visited, int[][] isReachable) {
		for(int j=0;j<n;j++) {
			if(a[i][j] == 1 && visited[j] == false) {
				visited[j] = true;
				isReachable[s][j] = 1;
				DFS(a,n,j,visited,isReachable);
			}
		}
	}
}