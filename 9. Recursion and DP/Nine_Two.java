import java.util.Scanner;
class Nine_Two {
	public static void main(String args[]) {
		System.out.println("Enter X and Y coordinates");
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		int[][] a = new int[x][y];
		for(int i=1;i<y;i++)
			a[0][i] = 1;
		for(int i=1;i<x;i++)
			a[i][0] = 1;
		for(int i=1;i<x;i++)
			for(int j=1;j<y;j++)
				a[i][j] = a[i][j-1]+a[i-1][j];
		System.out.println("No. of ways = "+a[x-1][y-1]);
	}
}