import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

class Permutation {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the String");
		String str = s.next();
		int n = str.length();
		char[] a = str.toCharArray();
		Arrays.sort(a);
		String temp = "";
		ArrayList<String> res = new ArrayList();
		boolean[] visited = new boolean[n];
		generate(a,temp,res,n,visited);
		System.out.println("The permutations are : \n");
		for(int i=0;i<res.size();i++)
			System.out.println(res.get(i));
	}
	public static void generate(char[] a, String temp, ArrayList<String> res, int n, boolean[] visited) {
		if(temp.length() == n) {
			String temp1 = temp;
			res.add(temp1);
		}
		for(int i=0;i<n;i++) {
			if(visited[i] == false) {
				temp = temp+a[i];
				visited[i] = true;
				generate(a,temp,res,n,visited);
				visited[i] = false;
				temp = temp.substring(0, temp.length()-1);
			}
		}
	}
}