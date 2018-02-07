import java.util.Scanner;
class Nine_Nine {
	public static void main(String args[]) {
		System.out.println("Enter number of queens");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] a = new int[n][n];
		if(nQueens(a,0,n) == false) {
			System.out.println("No Solution");
			return;
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				System.out.print(a[i][j]+" ");
			System.out.println("\n");
		}

	}
	public static boolean nQueens(int[][] a, int col, int n) {
		if(col>=n)
			return true;
		for(int row=0;row<n;row++) {
			if(isFeasible(a,row,col,n)) {
				a[row][col] = 1;
				if(nQueens(a,col+1,n) == false)
					a[row][col] = 0;
				else
					return true;
			}
		}
		return false;
	}
	public static boolean isFeasible(int[][] a , int row, int col, int n) {
		for(int i=0;i<n;i++) {
			if(a[row][i] == 1)
				return false;
			if(a[i][col] == 1)
				return false;
		}
		for(int i=row,j=col;i>=0 && i<n && j>=0 && j<n;i++,j++)
			if(a[i][j] == 1)
				return false;
		for(int i=row,j=col;i>=0 && i<n && j>=0 && j<n;i++,j--)
			if(a[i][j] == 1)
				return false;
		for(int i=row,j=col;i>=0 && i<n && j>=0 && j<n;i--,j++)
			if(a[i][j] == 1)
				return false;
		for(int i=row,j=col;i>=0 && i<n && j>=0 && j<n;i--,j--)
			if(a[i][j] == 1)
				return false;
		return true;
	}
}