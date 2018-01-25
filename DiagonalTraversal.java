/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void diagnol(int a[][], int n)
    {
        for(int k=0;k<n-1;k++)
        {
            int i=k;
            int j=0;
            while(i>=0)
            {
                System.out.print(a[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }
        for(int k=0;k<n;k++)
        {
            int i=n-1;
            int j=k;
            while(j<n)
            {
                System.out.print(a[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }
        System.out.println();
    }
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
		    t--;
		    int n = sc.nextInt();
		    int a[][] = new int[n][n];
		    for(int i=0;i<n;i++)
		        for(int j=0;j<n;j++)
		            a[i][j] = sc.nextInt();
		    diagnol(a, n);
		}
		sc.close();
	}
}
