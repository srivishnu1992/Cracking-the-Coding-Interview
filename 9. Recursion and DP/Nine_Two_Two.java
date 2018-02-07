import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Point;
class Nine_Two_Two {
	public static void main(String args[]) {
		System.out.println("Enter destination points");
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		Hashtable<Point,Boolean> cache = new Hashtable();
		ArrayList<Point> path = new ArrayList();
		System.out.println("Path : "+getPath(x, y, cache, path));
	}
	public static boolean getPath(int x,int y,Hashtable<Point,Boolean> cache, ArrayList<Point> path) {
		if(x<0 || y<0)
			return false;
		Point point = new Point(x,y);
		if(cache.containsKey(point))
			return cache.get(point);
		boolean isOrigin = x==0 && y==0;
		boolean success = false;
		if(isOrigin || getPath(x-1,y,cache,path) || getPath(x,y-1,cache,path)) {
			path.add(point);
			success = true;
		}
		cache.put(point,success);
		return success;
	}
}