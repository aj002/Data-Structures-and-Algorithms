public class Subarray
{
	public static int subarray(int a[][])
	{
		int r = a.length;
		if(r == 0)	return 0;
		int c = a[0].length;
		if(c == 0) return 0;
		int sizes[][] = new int[r][c];
		int max = 0;
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(i==0 || j==0)
				{
					sizes[i][j] = a[i][j];
				}
				else if(a[i][j] == 1)
				{
					sizes[i][j] = Math.min(Math.min(sizes[i-1][j], sizes[i-1][j-1]), sizes[i][j-1]) + 1;
				}
				if(sizes[i][j] > max)
				{
					max = sizes[i][j];
				}
			}	
		}
		return max;
	}

	public static void main(String[] args)
	{
		int M[][] =  {{0, 1, 1, 0, 1}, 
                      {1, 1, 0, 1, 0}, 
                      {0, 1, 1, 1, 0},
                      {1, 1, 1, 1, 0},
                      {1, 1, 1, 1, 1},
                      {0, 0, 0, 0, 0}};
		System.out.println(subarray(M));
	}
}
