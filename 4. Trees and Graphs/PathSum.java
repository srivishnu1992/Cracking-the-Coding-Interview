import java.util.Scanner;
import java.util.ArrayList;

class TreeNode {
	int data;
	TreeNode left, right;
	TreeNode(int n) {
		data = n;
		left = null;
		right = null;
	}
}
class PathSum {
	public static void main(String args[]) {
		TreeNode root = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of nodes");
		int n = s.nextInt();
		System.out.println("Enter nodes");
		for(int i=0;i<n;i++)
			root = insert(root, s.nextInt());
		System.out.println("Enter the sum");
		int sum = s.nextInt();
		print(root);
		ArrayList<ArrayList<Integer>> res = new ArrayList();
		ArrayList<Integer> al = new ArrayList();
		pathsum(root,res,al,0,sum);
		System.out.println(res);
	}
	public static void pathsum(TreeNode root, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> al, int cursum, int sum) {
		if(root == null) {
			return;
		}
		cursum += root.data;
		al.add(root.data);
		if(cursum == sum) {
			ArrayList<Integer> temp = new ArrayList();
			for(int i=0;i<al.size();i++)
				temp.add(al.get(i));
			res.add(temp);
		}
		pathsum(root.left, res, al, cursum, sum);
		cursum += root.data;
		al.add(root.data);
		if(cursum == sum) {
			ArrayList<Integer> temp = new ArrayList();
			for(int i=0;i<al.size();i++)
				temp.add(al.get(i));
			res.add(temp);
		}
		pathsum(root.right, res, al, cursum, sum);	
		cursum -= root.data;
		al.remove(al.size()-1);
	}
	public static TreeNode insert(TreeNode node, int data) {
		if(node == null)
			return new TreeNode(data);
		if(node.left == null) {
			node.left = new TreeNode(data);
		}
		else if(node.right == null){
			node.right = new TreeNode(data);
		}
		else {
			insert(node.left, data);
		}
		return node;
	}
	public static void print(TreeNode node) {
		if(node == null)
			return;
		print(node.left);
		System.out.print(node.data+" ");
		print(node.right);
	}
}