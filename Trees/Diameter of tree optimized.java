import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    public Node(int data)
    {
        this.data = data;
    }
}

class IntPointer
{
    int value;
}

public class TestClass 
{
    public static int diameterUtil(Node rt, IntPointer h)
    {
        if(rt==null)
        {
            h.value = 0;
            return 0;
        }
        IntPointer lh = new IntPointer();
        IntPointer rh = new IntPointer();
        int ld = diameterUtil(rt.left, lh);
        int rd = diameterUtil(rt.right, rh);
        h.value = Math.max(lh.value, rh.value) + 1;
        return Math.max(lh.value + rh.value + 1, Math.max(ld, rd));
    }
    
    public static int diameter(Node rt)
    {
        IntPointer h = new IntPointer();
        return diameterUtil(rt, h);
    }
    
    public static void main(String args[] ) throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node rt = new Node(sc.nextInt());
        n--;
        while(n>0)
        {
            n--;
            Node curr = rt;
            String str = sc.next();
            for(int i=0;i<str.length()-1;i++)
            {
                if(str.charAt(i)=='L')
                {
                    curr = curr.left;
                }
                else
                {
                    curr = curr.right;
                }
            }
            if(str.charAt(str.length()-1) == 'L')
                curr.left = new Node(sc.nextInt());
            else
                curr.right = new Node(sc.nextInt());
        }
        sc.close();
        System.out.println(diameter(rt));
    }
}

