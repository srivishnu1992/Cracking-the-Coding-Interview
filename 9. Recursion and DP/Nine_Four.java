import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
class Nine_Four {
	public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(new File("input.txt"));
		int t = s.nextInt();
		int n;
		ArrayList<Integer> a; 
		ArrayList<Integer> b; 
		ArrayList<ArrayList<Integer>> c;
		while(t-->0) {
			n = s.nextInt();
			a = new ArrayList();
			b = new ArrayList();
			c = new ArrayList();
			for(int i=0;i<n;i++) {
				a.add(s.nextInt());
			}
			System.out.println("Set : ");
			print(a);
			subsets(a,b,c,0,n);
			System.out.println("Subsets");
			for(int i=0;i<c.size();i++)
				print(c.get(i));
			System.out.println();
		}
	}

	public static void subsets(ArrayList<Integer> a,ArrayList<Integer> b,ArrayList<ArrayList<Integer>> c,int st,int count) {
		if(b.size() <= count) {
			ArrayList<Integer> temp = new ArrayList();
			for(int i=0;i<b.size();i++)
				temp.add(b.get(i));
			c.add(temp);
			if(b.size()>=count)
				return;
		}
		for(int i=st;i<a.size();i++) {
			b.add(a.get(i));
			subsets(a,b,c,i+1,count);
			b.remove(b.size()-1);
		}
	}

	public static void print(ArrayList<Integer> a) {
		System.out.print("{");
		for(int i=0;i<a.size();i++) {
			System.out.print(a.get(i));
			if(i<a.size()-1)
				System.out.print(",");
		}
		System.out.print("}");
		System.out.println();
	}
}