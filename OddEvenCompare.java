import java.util.*;
class OddEven implements Comparator
{
    public int compare(Object o1, Object o2)
    {
        Integer i1 = (Integer)o1;
        Integer i2=  (Integer)o2;
        if(i1==i2)  return 0;
        if(i1%2!=0 && i2%2!=0)
        {
            if(i1>i2)   return -1;
            else    return 1;
        }
        if(i1%2!=0 && i2%2==0)  return -1;
        if(i1%2==0 && i2%2!=0)  return 1;
        if(i1%2==0 && i2%2==0)
        {
            if(i1>i2)   return 1;
            else    return -1;
        }
        return 0;
    }
}
public class MyClass 
{
    public static void main(String args[]) 
    {
        Integer a[] = {1, -1, 0, 8, 2, 5, 4, 7};
        Arrays.sort(a, new OddEven());
        for(int x: a)   System.out.print(x + " ");
    }
}

