public class Permutation
{
	private static void displayUtil(String s, int curr)
	{
		if(curr == s.length())
		{
			System.out.println(s);
			return;
		}
		for(int i=curr;i<s.length();i++)
		{
			//swap(s.charAt(curr), s.charAt(i));
			char ch[] = s.toCharArray();
			ch[curr] ^= ch[i] ^ (ch[i] = ch[curr]);
			s = String.valueOf(ch);
			displayUtil(s, curr+1);
		}
	}

	public static void display(String s)
	{
		if(s.length() == 0)	return;
		displayUtil(s, 0);
	}

	public static void main(String[] args)
	{
		Permutation.display("abc");
	}
}
