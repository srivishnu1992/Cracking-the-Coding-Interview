import java.util.*;
class Node {
	int data;
	Node next = null;
	Node(int n) {
		data=n;
	}
}
class AddLists {
public static Node n3 = new Node(0);
public static int carry = 0;
	public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter two numbers\n");
		Node n1 = createList(s.nextInt());
		Node n2 = createList(s.nextInt());
		System.out.println("The numbers are\n");
		printList(n1);
		System.out.println();
		printList(n2);
		addLists(n1,n2);
		if(carry!=0){
			Node temp = new Node(carry);
			temp.next = n3.next;
			n3.next = temp;
		}
		System.out.println("Sum is ");
		printList(n3.next);		
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
			System.out.print(n.data);
			n = n.next;
		}	
	}
	public static void addLists(Node n1,Node n2) {
		if(n1==null)
			return ;
		addLists(n1.next,n2.next);
		int data1 = n1.data+n2.data+carry;
		Node temp = new Node(data1%10);
		temp.next = n3.next;
		n3.next = temp;
		carry = data1/10;
	}
}