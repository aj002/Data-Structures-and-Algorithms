/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG 
{
	public static void gen(StringBuilder str, int ptr)
	{
	    if(ptr==str.length())
	    {
	        System.out.print(str + " ");
	        return;
	    }
	    if(str.charAt(ptr)=='?')
	    {
	        str.setCharAt(ptr, '0');
	        gen(str, ptr+1);
	        str.setCharAt(ptr, '1');
	        gen(str, ptr+1);
	        str.setCharAt(ptr, '?');
	    }
	    else
	    {
	        gen(str, ptr+1);
	    }
	}
	public static void main (String[] args) 
	{
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
		    t--;
		    StringBuilder str = new StringBuilder(sc.next());
		    gen(str, 0);
		    System.out.println();
		}
	}
}
