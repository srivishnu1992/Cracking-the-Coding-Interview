import java.util.Scanner;
import java.util.Stack;

class MyQueue {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	MyQueue() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	public boolean isEmpty() {
		if(stack1.isEmpty() && stack2.isEmpty())
			return true;
		else
			return false;
	}
	public void enqueue(int n) {
		stack1.push(n);
	}
	public int dequeue() {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty())
				stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
}

class QueuebyStack {
	public static void main(String args[]) {
		MyQueue queue = new MyQueue();
		for(int i=1;i<=5;i++)
			queue.enqueue(i);
		for(int i=1;i<=3;i++)
			System.out.print(queue.dequeue()+"   ");		
		for(int i=6;i<=8;i++)
			queue.enqueue(i);
		for(int i=1;i<=3;i++)
			System.out.print(queue.dequeue()+"   ");
	}
}