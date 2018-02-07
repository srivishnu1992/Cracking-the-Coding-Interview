class clockwise {
	public static void main(String args[]) {
		int[][] a = new int[4][4];
		int count=1;
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				a[i][j] = count++;
		printMatrix(a);
		clockwisePrint(a);
	}
	public static void clockwisePrint(int[][] a) {
		int dir=0;
		int left = 0,up=0;
		int down = 3, right = 3;
		while(left<=right && up<=down) {
			if(dir==0) {
				for(int i=left;i<=right;i++)
					System.out.print(a[up][i]+" ");
				up++;
			}
			else if(dir==1) {
				for(int i=up;i<=down;i++)
					System.out.print(a[i][right]+" ");
				right--;	
			}
			else if(dir==2) {
				for(int i=right;i>=left;i--)
					System.out.print(a[down][i]+" ");
				down--;
			}
			else if(dir==3) {
			for(int i=down;i>=up;i--)
					System.out.print(a[i][left]+" ");
				left++;
			}
			dir = (dir+1)%4;
		}
	}
	public static void printMatrix(int[][] a) {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++)
				System.out.print(a[i][j]+" ");
			System.out.println();
		}
	} 
}