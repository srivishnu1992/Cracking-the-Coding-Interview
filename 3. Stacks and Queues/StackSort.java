import java.util.Scanner;
import java.util.Stack;

class StackSort {
static Stack<Integer> stack1;
static Stack<Integer> stack2;
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of elements to be sorted");
		int n = s.nextInt();
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		for(int i=1;i<=n;i++)
			stack1.push(s.nextInt());
		Sort(stack1, stack2);
		while(!stack2.isEmpty())
			System.out.print(stack2.pop()+" ");
	}
	public static void Sort(Stack<Integer> stack1, Stack<Integer> stack2) {
		while(!stack1.isEmpty()) {
			int temp = stack1.pop();
			while(!stack2.isEmpty() && temp<stack2.peek())
				stack1.push(stack2.pop());
			stack2.push(temp);
		}
	}
}