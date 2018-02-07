import java.util.*;
class StackOfStacks {
	
	static ArrayList<Integer[]> al = new ArrayList();
	static int max = 5;
	static int stacktop = -1;
	static int top = max - 1;
		
	public static void main(String args[]) {
		for(int i=1;i<=12;i++)
			push(i);
		for(int i=1;i<=14;i++) {
			int n = pop();
			if(n == -1)
				System.out.println("Empty stack of stacks");
			else
				System.out.println(n);
		}		
	}
	public static void push(int i) {
		if(top+1 >= max) {
			top=0;
			stacktop++;
			al.add(new Integer[5]);
			al.get(stacktop)[top] = i;
		}
		else {
			top++;
			al.get(stacktop)[top] = i;	
		}
	}
	public static int pop() {
		if(stacktop==-1)
			return -1;
		int i = al.get(stacktop)[top];
		if(top-1<0) {
			top = max - 1;
			al.remove(stacktop);
			stacktop--;
		}
		else
			top--;
		return i;
	}
}