import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
class Box {
	int w,h,d;
	Box(int w, int h, int d) {
		this.w = w;
		this.h = h;
		this.d = d;
	}
}
class Nine_Ten_DP {
	public static void main(String args[]) {
		System.out.println("Enter no. of boxes");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Enter dimensions of");
		int w,h,d;
		Box[] boxes = new Box[n];
		for(int i=0;i<n;i++) {
			System.out.println("Box"+(i+1));
			w = s.nextInt();
			h = s.nextInt();
			d = s.nextInt();
			boxes[i] = new Box(w,h,d);			
		}
		ArrayList<Box> res = new ArrayList();
		HashMap<Box, ArrayList<Box>> hm = new HashMap();
		res = func(boxes, null, hm);
		System.out.println("Stack : ");
		for(int i=0;i<res.size();i++) 
			System.out.println(res.get(i).w+" "+res.get(i).h+" "+res.get(i).d);
	}
	public static ArrayList<Box> func(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> hm) {
		if(bottom != null && hm.containsKey(bottom))
			return (ArrayList<Box>) hm.get(bottom).clone();
		ArrayList<Box> max = new ArrayList();
		int max_height = 0;
		for(int i=0;i<boxes.length;i++) {
			if(isFeasible(bottom,boxes[i])) {
				ArrayList<Box> al = func(boxes, boxes[i], hm);
				int height = getHeight(al);
				if(height>max_height) {
					max_height = height;
					max = al;
				}
			}
		}
		if(max == null)
			max = new ArrayList<Box>();
		if(bottom != null)
			max.add(bottom);
		return max;
	}
	public static boolean isFeasible(Box bottom, Box up) {
		if(bottom == null)
			return true;
		if(bottom.w > up.w && bottom.h > up.h && bottom.d > up.d)
			return true;
		return false;
	}
	public static int getHeight(ArrayList<Box> al) {
		int height = 0;
		for(int i=0;i<al.size();i++)
			height += al.get(i).h;
		return height;
	}
}