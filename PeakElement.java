public class PeakElement
{
	public static void main(String[] args)
	{
		int a[] = {100, 3, 20, 4, 1, 0};
		Integer pk = peak(a);
		System.out.println(pk);
	}

	public static Integer peak(int[] a)
	{
		if(a.length == 0)   return null;
		int start = 0;
		int end = a.length-1;
		while(start<=end)
		{
		    int mid = (start+end)/2;
		    if(mid==0 && a[mid]>=a[mid+1])  return a[mid];
		    if(mid==a.length-1 && a[mid]>=a[mid-1]) return a[mid];
		    if(a[mid-1]<=a[mid] && a[mid+1]<=a[mid])    return a[mid];
		    if(mid>0 && a[mid]<=a[mid-1])   end = mid-1;
		    else start = mid+1;
		}
		return null;
	}
}
