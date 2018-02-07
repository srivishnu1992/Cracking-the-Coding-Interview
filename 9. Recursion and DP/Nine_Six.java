import java.util.Scanner;
import java.util.ArrayList;
class Nine_Six {
	public static void main(String[] args) {
		System.out.println("Enter number of pair of braces");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<String> al = new ArrayList();
		braces(al,n,n,n,"");
		for(int i=0;i<al.size();i++)
			print(al.get(i));
	}
	public static void braces(ArrayList<String> al, int n, int remleft, int remright, String str) {
		if(str.length() > n*2 || remleft>remright)
			return;
		if(remleft==0 && remright==0) {
			String temp = str;
			al.add(temp);
			return;
		}
		braces(al,n,remleft-1,remright,str+"{");
		braces(al,n,remleft,remright-1,str+"}");
	}
	public static void print(String str) {
		int open = 0;
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c == '{') {
				for(int j=0;j<open;j++)
					System.out.print("\t");
				open++;
			}
			else if(c == '}') {
				open--;
				for(int j=0;j<open;j++)
					System.out.print("\t");
			}
			System.out.print(c);
			System.out.println();
		}
		System.out.println("\n");
	}
}