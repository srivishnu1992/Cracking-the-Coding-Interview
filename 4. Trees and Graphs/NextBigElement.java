import java.util.Scanner;

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int n) {
		val = n;
		left = null;
		right = null;
	}
}
class NextBigElement {
	public static void main(String args[]) {
		TreeNode root = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of nodes");
		int n = s.nextInt();
		for(int i=0;i<n;i++)
			root = insert(root, (i*17+2)%25);
		ArrayList<Integer> al = new ArrayList();
		System.out.println("InOrder Traversal");
		print(root,al);
		System.out.println();
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i)+" --> "+nextBig(root, al.get(i)).val);
		}
	}
	public static TreeNode insert(TreeNode node, int val) {
		if(node == null)
			return new TreeNode(val);
		if(val<=node.val) {
			node.left = insert(node.left,val);
		}
		else {
			node.right = insert(node.right,val);
		}
		return node;
	}
	public static void print(TreeNode node, ArrayList<Integer> al) {
		if(node == null)
			return;
		print(node.left, al);
		System.out.print(node.val+" ");
		al.add(node.val);
		print(node.right, al);
	}
}