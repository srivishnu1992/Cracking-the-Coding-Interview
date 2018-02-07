import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int n) {
		val = n;
		left = null;
		right = null;
	}
}
class TreetoLL {
	public static void main(String args[]) {
		TreeNode root = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of nodes");
		int n = s.nextInt();
		for(int i=0;i<n;i++)
			root = insert(root, (i*17+2)%25);
		ArrayList<LinkedList<TreeNode>> res = new ArrayList();
		treetoLL(root,res,0);
		print(root);
		System.out.println();
		for(int i=0;i<res.size();i++) {
			LinkedList<TreeNode> temp = res.get(i);
			for(int j=0;j<temp.size();j++)
				System.out.print(temp.get(j).val+" ");
			System.out.println();
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
	public static void print(TreeNode node) {
		if(node == null)
			return;
		System.out.print(node.val+" ");
		print(node.left);
		print(node.right);
	}
	public static void treetoLL(TreeNode root, ArrayList<LinkedList<TreeNode>> res, int level) {
		if(root == null)
			return;
		LinkedList<TreeNode> temp;
		if(res.size() == level) {
			temp = new LinkedList();
			res.add(temp);
		}
		else {
			temp = res.get(level);
		}
		temp.add(root);
		treetoLL(root.left, res, level+1);
		treetoLL(root.right, res, level+1);
	}
}