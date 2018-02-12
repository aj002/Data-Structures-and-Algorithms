import java.util.*;
public class MyClass 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            t--;
            int n = sc.nextInt();
            int a[][] = new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    a[i][j] = sc.nextInt();
                }
            }
            int sum=0;
            int prev=0;
            int max=0;
            for(int i=0;i<n;i++)
            {
                max=prev;
                for(int j=0;j<n;j++)
                {
                    if(a[i][j]>max)
                    {
                        max=a[i][j];
                    }
                }
                if(max==prev)
                {
                    max=-1;
                    break;
                }
                sum+=max;
                prev=max;
            }
            if(max==-1) System.out.println(-1);
            else    System.out.println(sum);
        }
        sc.close();
    }
}
