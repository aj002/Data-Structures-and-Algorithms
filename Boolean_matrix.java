class BooleanMatrix
{
	public static void transform(boolean a[][])
	{
		if(a.length == 0 || a[0].length == 0)	return;

		boolean rowZero = false, colZero = false;

		for(boolean b: a[0])	rowZero |= b;
		for(boolean b[]: a)		colZero |= b[0];

		for(int i=1;i<a.length;i++)
		{	for(int j=1;j<a[0].length;j++)
			{	if(a[i][j])
				{	a[i][0] = a[0][j] = true;
				}
			}
		}

		for(int i=1;i<a.length;i++)
		{	if(a[i][0])
			{	for(int j=1;j<a[i].length;j++)
				{	a[i][j] = true;
				}
			}
		}

		for(int i=1;i<a[0].length;i++)
		{	if(a[0][i])
			{	for(int j=1;j<a.length;j++)
				{	a[j][i] = true;
				}
			}
		}

		if(rowZero)
			for(int i=0;i<a[0].length;i++)	
				a[0][i] = true;

		if(colZero)
			for(int i=0;i<a.length;i++)	
				a[i][0] = true;
	}
	
	public static void display(boolean b[][])
	{
		for(boolean x[] : b)
		{	for(boolean y: x)
			{	System.out.print(y + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String args[])
	{
		boolean b[][] = {	{true , false, false},
							{false, false, false},
							{false, false, true}
						};
		display(b);
		transform(b);
		display(b);
	}
}
