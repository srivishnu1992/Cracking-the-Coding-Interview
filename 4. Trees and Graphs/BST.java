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
class BST {
	public static void main(String args[]) {
		TreeNode root = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of nodes");
		int n = s.nextInt();
		for(int i=0;i<n;i++)
			root = insert(root, (i*17+2)%25);
		print(root);
		System.out.println("\nHeight of tree is "+height(root));
		if(isBalanced(root))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
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
	public static int height(TreeNode node) {
		if(node == null)
			return 0;
		return max(height(node.left),height(node.right))+1;
	}
	public static boolean isBalanced(TreeNode node) {
		if(node == null)
			return true;
		if(Math.abs(height(node.left)-height(node.right))>1)
			return false;
		else 
			return isBalanced(node.left) && isBalanced(node.right);
	}
	public static void print(TreeNode node) {
		if(node == null)
			return;
		System.out.print(node.val+" ");
		print(node.left);
		print(node.right);
	}
	public static int max(int a, int b) {
		if(a>b)
			return a;
		else
			return b;
	}
}