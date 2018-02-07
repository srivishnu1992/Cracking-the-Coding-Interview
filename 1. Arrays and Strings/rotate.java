class rotate {
	public static void main(String args[]) {
		int n = 4;
		int[][] a = new int[n][n];
		int count=1;
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				a[i][j] = count++;
		int[][] b = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				b[i][j] = a[n-j-1][i];
		printMatrix(a);
		System.out.println();
		printMatrix(b);
	}
	public static void printMatrix(int[][] a) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
	} 
}