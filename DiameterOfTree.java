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
public class TestClass 
{
    public static void inorder(Node rt)
    {
        if(rt==null)    return;
        inorder(rt.left);
        System.out.println(rt.data);
        inorder(rt.right);
    }
    
    public static int height(Node rt)
    {
        if(rt==null)    return 0;
        return Math.max(height(rt.left), height(rt.right))+1;
    }
    
    public static int diameter(Node rt)
    {
        if(rt==null)    return 0;
        int d = height(rt.left) + height(rt.right) + 1;
        int ld = diameter(rt.left);
        int rd = diameter(rt.right);
        return Math.max(d, Math.max(ld, rd));
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
        //inorder(rt);
        System.out.println(diameter(rt));
    }
}

