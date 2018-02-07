import java.util.Scanner;
class Nine_One {
	public static void main(String args[]) {
		System.out.println("Enter number of steps");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n+1];
		a[0] = 1;
		a[1] = 1;
		a[2] = 2;
		for(int i=3;i<=n;i++)
			a[i] = a[i-1]+a[i-2]+a[i-3];
		System.out.println("Total Steps = "+a[n]);
	}
}