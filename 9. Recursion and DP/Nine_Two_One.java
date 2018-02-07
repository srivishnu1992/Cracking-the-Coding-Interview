import java.util.Scanner;
import java.util.ArrayList;
import java.awt.Point;

class Nine_Two_One {
	public static int count = 0;
	public static void main(String args[]) {
		System.out.println("Enter destination points");
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		int[][] free = new int[x+1][y+1];
		System.out.println("Enter number of blocked points");
		int n = s.nextInt();
		System.out.println("Enter blocked points");
		for(int i=0;i<n;i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			if(a<=x&&a>=0&&b<=y&&b>=0)
			free[a][b] = 1;
		}
		ArrayList<Point> path = new ArrayList();
		getPath(0, 0, x, y, free, path);
		System.out.println("Total Paths : "+count);	
	}
	public static void getPath(int cx, int cy, int x, int y, int[][] free, ArrayList<Point> path) {
		if(cx>x || cy>y)
			return;
		if(cx == x && cy == y) {
			path.add(new Point(cx,cy));
			count++;
			System.out.print("Path : ");
			for(int i=0;i<path.size();i++)
				System.out.print("("+path.get(i).x+","+path.get(i).y+") ");
			System.out.println();
			path.remove(path.size()-1);
		}
		if(free[cx][cy] == 0) {
			path.add(new Point(cx,cy));
			free[cx][cy] = 1;
			getPath(cx+1,cy,x,y,free,path);
			getPath(cx,cy+1,x,y,free,path);
			free[cx][cy] = 0;
			path.remove(path.size()-1);
		}
	}
}