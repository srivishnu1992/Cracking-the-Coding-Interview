import java.util.Scanner;
import java.util.ArrayList;
class Nine_Ten {
	public static void main(String args[]) {
		System.out.println("Enter no. of boxes");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] w = new int[n];
		int[] h = new int[n];
		int[] d = new int[n];
		for(int i=0;i<n;i++) {
			w[i] = s.nextInt();
			h[i] = s.nextInt();
			d[i] = s.nextInt();
		}
		ArrayList<Integer> a = new ArrayList();
		ArrayList<Integer> max = new ArrayList();
		int[] occ = new int[n];
		max = func(a,max,occ,n,w,h,d,0);
		System.out.println("Size "+max.size());
		for(int i=0;i<max.size();i++)
			System.out.print("Box "+(max.get(i)+1)+" : "+w[max.get(i)]+" "+h[max.get(i)]+" "+d[max.get(i)]+"\n");
	}
	public static ArrayList<Integer> func(ArrayList<Integer> a, ArrayList<Integer> max, int[] occ, int n, int[] w, int[] h, int[] d, int k) {
		if(k == n) {
			for(int i=0;i<a.size();i++)
				System.out.print(a.get(i)+" ");
			System.out.println();
			if(height(a,h)>height(max,h)) {
				for(int i=0;i<max.size();i++)
					max.clear();
				for(int i=0;i<a.size();i++) {
					int temp = a.get(i);
					max.add(temp);
				}
			}
		}
		for(int i=0;i<n;i++) {
			if(occ[i] != 0)
				continue;
			if(isFeasible(a,i,w,h,d)) {
				a.add(i);
				occ[i] = 1;
				func(a,max,occ,n,w,h,d,k+1);
				occ[i] = 0;
				a.remove(a.size()-1);
			}
			else {
				occ[i] = 1;
				func(a,max,occ,n,w,h,d,k+1);
				occ[i] = 0;	
			}
		}
		return max;
	}
	public static boolean isFeasible(ArrayList<Integer> a, int i, int[] w, int[] h, int[] d) {
		if(a.size() == 0)
			return true;
		int index = a.get(a.size()-1);
		if(w[index] > w[i] && h[index] > h[i] && d[index] > d[i])
			return true;
		return false;
	}
	public static int height(ArrayList<Integer> a, int[] h) {
		int height = 0;
		for(int i=0;i<a.size();i++)
			height += h[a.get(i)];
		return height;
	}
}