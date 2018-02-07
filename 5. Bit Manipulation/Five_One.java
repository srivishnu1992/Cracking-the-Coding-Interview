import java.util.Scanner;
class Five_One {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the numbers N and M");
		int n = s.nextInt();
		int m = s.nextInt();
		System.out.println("Enter the bit positions i and j");
		int i = s.nextInt();
		int j = s.nextInt();
		System.out.println("N : "+binary(n));
		System.out.println("M : "+binary(m));
		int temp = (1 << (j-i+1))-1;
		temp = ~(temp << i);
		n = n & temp;
		m = m << i;
		n = n|m;
		System.out.println("Result : "+binary(n));
	}
	public static String binary(int n) {
		int temp = n;
		String str = "";
		while(n>0) {
			str = n%2+str;
			n = n/2;
		}
		return str;
	}
}