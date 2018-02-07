import java.util.Scanner;
class Five_Two {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a value between 0 and 1");
		double n = s.nextDouble();
		String str = "0.";
		while(str.length()<34 && n!=0) {
			n = n*2;
			if(n>1) {
				str += 1;
				n = n - Math.floor(n);
			}
			else {
				str += 0;
			}
		}
		if(n==0)
			System.out.println("Binary Value is "+str);
		else
			System.out.println("Error");
	}
}