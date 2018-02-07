import java.util.Scanner;
import java.util.Stack;

class Stack2{
	Stack<Integer> stack;
	Stack2() {
		stack = new Stack<Integer>();
	}
}

class FourTowers {
static Stack2[] a;
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of disks");
		int n = s.nextInt();
		a = new Stack2[4];
		for(int i=0;i<4;i++)
			a[i] = new Stack2();
		for(int i=n;i>0;i--)
			a[0].stack.push(i);
		Transfer(n,0,1,2,3);
	}
	public static void Transfer(int n, int s, int b1, int b2, int d) {
		if(n>0) {
			Transfer(n-2,s,b2,d,b1);
			TransferTop(s,b2);
			TransferTop(s,d);
			TransferTop(b2,d);
			Transfer(n-2,b1,s,b2,d);
		}
	}
	public static void TransferTop(int s, int d) {
		if(!a[s].stack.isEmpty()) {
			int temp = a[s].stack.pop();
			System.out.println("Transfer disk"+temp+" from tower"+(s+1)+" to tower"+(d+1));
			a[d].stack.add(temp);
		}
	}
}