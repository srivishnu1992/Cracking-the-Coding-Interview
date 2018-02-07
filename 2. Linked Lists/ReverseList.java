import java.util.*;
class Node {
	int data;
	Node next = null;
	Node(int n) {
		data=n;
	}
}
class ReverseList{
	public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number\n");
		Node n1 = createList(s.nextInt());
		Node n2 = clone(n1);
		n2 = reverse(n2);
		printList(n1);
		System.out.println();
		printList(n2);
	}
	public static Node reverse(Node n1) {
		Node prev = null;
		Node cur = n1;
		Node next = cur.next;
		while(cur!=null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
	public static Node clone(Node n1) {
		Node head = new Node(0);
		Node temp = head;
		while(n1!=null) {
			Node temp1 = new Node(n1.data);
			temp.next = temp1;
			temp = temp.next;
			n1 = n1.next;
		}
		return head.next;
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
	public static void printList(Node n) {
		while(n!=null) {
			System.out.print(n.data+"  ");
			n = n.next;
		}	
	}
}