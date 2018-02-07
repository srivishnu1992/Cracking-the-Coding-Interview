import java.util.Scanner;
class Five_Three {
	public static void main(String args[]) {
		System.out.println("Enter a number");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int res = big(n);
		if(res == -1)
			System.out.println("There is no bigger number\n");
		else
			System.out.print(" = "+res+"\n\n");
		res = small(n);
		if(res == -1)
			System.out.println("There is no smaller number");
		else
			System.out.print(" = "+res);
	}
	public static int big(int n) {
		int temp = n;
		int count = 0;
		int count1 = 0;
		boolean one = false;
		while(temp>0) {
			int bit = 1<<count;
			if(one==true && (n&bit) == 0) {
				n = n|bit;
				break;
			}
			else if((n&bit) == bit) {
				one = true;
				count1++;
			}
			temp = temp&~bit;
			count++;
		}
		System.out.println("After Setting 1 : "+binary(n));
		if(count == 31 || count == 0)
			return -1;
		n &= ~((1<<count)-1);
		System.out.println("After Setting 0's : "+binary(n));
		n |= (1<<(count1-1))-1;
		System.out.print("Final Answer : "+binary(n));
		return n;
	}

	public static int small(int n) {
		int temp = n;
		int c0 = 0, c1 = 0;
		while((temp & 1) == 1) {
			c1++;
			temp >>= 1;
		}
		if(c1>=31)
			return -1;
		while((temp & 1) == 0 && temp != 0) {
			c0++;
			temp >>= 1;
		}
		int index = c0+c1;
		n&=~(1<<index);
		System.out.println("After Setting 0 : "+binary(n));
		n&=(~0)<<index;
		System.out.println("After Setting 1's : "+binary(n));
		n|=((1<<(c1+1))-1)<<(c0-1);
		System.out.println("Final Answer : "+binary(n));
		return n;
	}
	public static String binary(int n) {
		int temp = n;
		StringBuilder sb = new StringBuilder();
		while(temp>0) {
			sb.append(temp%2);
			temp /= 2;
		}
		return sb.reverse().toString();
	}
}