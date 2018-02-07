import java.util.Scanner;
import java.util.Stack;

class Stack1 {
	Stack<Integer> stack;
	Stack1() {
		stack = new Stack<Integer>();
	}
}
class TowersOfHanoi {
static Stack1[] a;
ArrayList<Integer> b;
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of towers");
		int t = s.nextInt();
		a = new Stack1[t];
		System.out.println("Enter number of disks");
		int n = s.nextInt();
		b = new ArrayList();
		for(int i=0;i<t;i++) {
			a[i] = new Stack1();
			b.add(i);
		}
		for(int i=n;i>0;i--)
			a[0].stack.push(i);
		Transfer(n,0,buffer,t-1,t-2);
	}
	public static void Transfer(int n, int s, ArrayList<Integer> b, int d, int size) {
			for(int i=0;i<b.size();i++)
				if(i==s || i==d) {
					b.remove(i);
					i--;
				}
			Transfer(n-size,s,d,b);
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