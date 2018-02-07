import java.util.Scanner;
import java.util.ArrayList;

class Five_Seven {
	public static void main(String args[]) {
		ArrayList<String> a = new ArrayList(20);
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the upper limit");
		int n = s.nextInt();
		System.out.println("Enter the missing number between 0 and "+(n-1));
		int m = s.nextInt();
		while(m<0 || m>=n) {
			System.out.println("Enter the missing number between 0 and "+(n-1));
			m = s.nextInt();
		}
		for(int i=0;i<=n;i++)
			if(i!=m)
				a.add(Integer.toBinaryString(i));
		int pad = a.get(a.size()-1).length()+2;
		for(int i=0;i<a.size();i++)
			for(int j=0;j<pad-a.get(i).length();j++)
				a.set(i,0+a.get(i));	
		String res = find(a,0);
		System.out.println("Missing number is "+Integer.parseInt(res,2)+" whose integer value is "+res);
	}
	public static String find(ArrayList<String> a, int col) {
		if(a.size()==0 || col>=a.get(0).length())
			return "";
		ArrayList<String> zeros = new ArrayList();
		ArrayList<String> ones = new ArrayList();
		for(int i=0;i<a.size();i++)
				if(a.get(i).charAt(a.get(i).length()-col-1) == '1')
					ones.add(a.get(i));
				else
					zeros.add(a.get(i));
		String res = "";	
		if(zeros.size() <= ones.size())
			res += find(zeros,col+1)+0;
		else
			res += find(ones,col+1)+1;
		return res;
	}
}
		