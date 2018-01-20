public class LPS	//longest palindromic subsequence
{
	public static int lps(String s)
	{
		if(s.length == 0)	return 0;
		int L[][] = new int[s.length][s.length];

		for(int k=0;k<s.length;k++)
		{
			for(int i=0;i<s.length-k;i++)
			{
				int j = i+k;
				if(i==j)	L[i][j] = 1;
				else if(s.charAt(i) != s.charAt(j))	L[i][j] = Math.max(L[i+1][j], L[i][j-1]);
				else if(i+1 == j)	L[i][j] = 2;
				else	L[i][j] = L[i+1][j-1] + 2;
			}
		}
		return L[0][s.length-1];
	}
				
	public static void main(String[] args)
	{
		String s = "arihant";
		System.out.println(lps(s));
	}
}
