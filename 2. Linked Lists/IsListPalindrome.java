import java.util.*;
class Res {
	Node node;
	boolean result;
	Res(Node n, boolean x){
		node = n;
		result = x;
	}
}
class Node {
	int data;
	Node next = null;
	Node(int n) {
		data = n;
	}
}
class IsListPalindrome {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number");
		Node n = createList(s.nextInt());
		int len = length(n);		
		if(isPalindrome(n,len).result)
			System.out.println("It's a palindrome");
		else
			System.out.println("Not a palindrome");	
	}

	public static Res isPalindrome(Node n, int len) {
		if(n==null || len==0)
			return new Res(null,true);
		else if(len==1)
			return new Res(n.next,true);
		else if(len==2)
			return new Res(n.next.next,n.data==n.next.data);
		Res res = isPalindrome(n.next,len-2);
		if(!res.result || res.node==null)
			return res;
		else {
			res.result = n.data==res.node.data;
			res.node = res.node.next;
			return res;
		}
	}

	public static Node createList(int m) {
		Node head = new Node(0);
		while(m>0) {
			Node temp = new Node(m%10);
			temp.next = head.next;
			head.next = temp;
			m=m/10;
		}
		return head.next;
	}
	public static int length(Node n) {
		int len=0;
		while(n!=null) {
			len++;
			n = n.next;
		}
		return len;
	}
}