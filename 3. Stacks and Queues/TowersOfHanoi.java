import java.util.Scanner;
import java.util.Stack;

class Stack1 {
	Stack<Integer> stack;
	Stack1() {
		stack = new Stack<Integer>();
	}
}
class TowersOfHanoi {
static Stack1[] a = new Stack1[3];
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of disks");
		int n = s.nextInt();
		for(int i=0;i<3;i++)
			a[i] = new Stack1();
		for(int i=n;i>0;i--)
			a[0].stack.push(i);
		Transfer(n,0,1,2);
	}
	public static void Transfer(int n, int s, int b, int d) {
		if(n>0) {
			Transfer(n-1,s,d,b);
			TransferTop(s,d);
			Transfer(n-1,b,s,d);
		}
	}
	public static void TransferTop(int s, int d) {
		int temp = a[s].stack.pop();
		System.out.println("Transfer disk"+temp+" from tower"+(s+1)+" to tower"+(d+1));
		a[d].stack.add(temp);
	}
}