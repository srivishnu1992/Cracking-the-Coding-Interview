import java.util.Scanner;
class Nine_Eight {
	public static void main(String args[]) {
		System.out.println("Enter amount");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] denoms = {100,50,25,10,5,1};
		int[][] values = new int[n+1][denoms.length];
		int res = myfunction(n,denoms,0,values);
		System.out.println("Number of ways are "+res);
	}
	public static int myfunction(int n, int[] denoms, int index, int[][] values) {
		if(n == 0)
			return 1;	
		if(index >= denoms.length)
			return 0;
		if(values[n][index] > 0)
			return values[n][index];
		int denom = denoms[index];
		int ways = 0;
		for(int i=0;i*denom<=n;i++) {
			int remAmount = n - (i*denom);
			ways += myfunction(remAmount, denoms, index+1, values);
		}
		values[n][index] = ways;
		return ways;
	}
}