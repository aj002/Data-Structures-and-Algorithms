public class Number
{
	public static void missingNumbers(int a[])
	{
		int n = a.length + 2;
		int missingXor = 0;

		for(int i=1;i<=n;i++)	missingXor ^= i;
		for(int i=0;i<a.length;i++)	missingXor ^= a[i];

		int set_bit_n = missingXor & ~(missingXor-1);

		int x=0, y=0;

		for(int i=1;i<=n;i++)
			if((i & set_bit_n) > 0)	x ^= i;
			else					y ^= i;

		for(int i=0;i<a.length;i++)
			if((a[i] & set_bit_n) > 0)	x ^= a[i];
			else					y ^= a[i];

		System.out.println(x + " " + y);
	}
	public static void main(String[] args)
	{
		int a[] = {1, 3, 5, 6};
		missingNumbers(a);
	}
}
