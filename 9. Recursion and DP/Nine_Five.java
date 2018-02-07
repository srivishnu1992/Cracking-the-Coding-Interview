import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
class Nine_Five {
	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(new File("input.txt"));
		String string = scanner.next();
		ArrayList<String> al = new ArrayList();
		al.add("");
		al = permutations(al, string, 0);
		for(int i=0;i<al.size();i++)
			System.out.println(al.get(i));
	}
	public static ArrayList<String> permutations(ArrayList<String> al, String string, int start) {
		if(al.get(0).length() == string.length())
			return al;
		ArrayList<String> next = new ArrayList();
		for(int i=0;i<al.size();i++) {
			String temp = al.get(i);
			char c = string.charAt(start);
			for(int j=0;j<temp.length()+1;j++)
				next.add(temp.substring(0,j)+c+temp.substring(j));
		}
		al = permutations(next,string,start+1);
		return al;
	}
}