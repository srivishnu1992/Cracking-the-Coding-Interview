import java.util.Scanner;
import java.util.HashMap;
class Nine_Eleven {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the expression");
		String str = s.next();
		boolean res = s.nextBoolean();
		HashMap<String,Integer> hm = new HashMap();
		int c = func(str,res,0,str.length()-1,hm);
		System.out.println("Total types of parentheses for "+res+" is "+c);
	}
	public static int func(String str, boolean res, int s, int e, HashMap<String,Integer> hm) {
		String key = ""+s+e;
		int c = 0;
		if(!hm.containsKey(key)) {
			if(s == e)
				c = (str.charAt(s)=='1')?1:0;
			else {
				for(int i=s+1;i<=e;i++) {
					char op = str.charAt(i);
					if(op == '&')
						c += func(str,true,s,i-1,hm)*func(str,true,i+1,e,hm);
					else if(op == '|') {
						int ways = total((i-1-s)/2)*total((e-i-1)/2);
						int false_ways = func(str,false,s,i-1,hm)*func(str,false,i+1,e,hm);
						c += ways - false_ways;
					}
					else if(op == '^') {
						c += func(str,true,s,i-1,hm)*func(str,false,i+1,e,hm);
						c += func(str,false,s,i-1,hm)*func(str,true,i+1,e,hm);
					}
				}
			}
			hm.put(key,c);
		}
		else {
			c += hm.get(key);
		}
		if(res)
			return c;
		else 
			return total((e-s)/2) - c;
	}
	public static int total(int n) {
		int total = 1;
		for(int i=n*2;i>n+1;i--)
			total *= i;
		for(int i=1;i<=n;i++)
			total /= i;
		return total;
	}
}