import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
	int data;
	TreeNode left, right;
	TreeNode(int n) {
		data = n;
		left = null;
		right = null;
	}
}
class AllPaths {
	public static void main(String args[]) {
		TreeNode root = null;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of nodes");
		int n = s.nextInt();
		for(int i=0;i<n;i++) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			root = insert(root, i+1, queue);
		}
		System.out.println("Enter the sum");
		int sum = s.nextInt();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		printByLevel(root, q);
/*		ArrayList<ArrayList<Integer>> res = new ArrayList();
		ArrayList<Integer> al = new ArrayList();
		pathsum(root,res,al,0,sum);
		System.out.println(res);
*/	}
	public static TreeNode insert(TreeNode root, int data, Queue<TreeNode> queue) {
		if(root == null)
			return new TreeNode(data);
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.remove();
			if(temp.left == null) {
				temp.left = new TreeNode(data);
				break;
			}
			else if(temp.right == null) {
				temp.right = new TreeNode(data);
				break;
			}
			else {
				queue.add(temp.left);
				queue.add(temp.right);
			}
		}
		return root;
	}
	public static void printByLevel(TreeNode root, Queue<TreeNode> q) {
		if(root == null)
			return;
		q.add(root);
		while(!q.isEmpty()) {
			Queue<TreeNode> q1 = new LinkedList<TreeNode>();
			while(!q.isEmpty()) {
				TreeNode temp = q.remove();
				System.out.print(temp.data+" ");
				q1.add(temp);
			}
			while(!q1.isEmpty()) {
				TreeNode temp = q1.remove();
				if(temp.left!=null)
					q.add(temp.left);
				if(temp.right!=null)
					q.add(temp.right);
			}
			System.out.println();
		}
	}
}