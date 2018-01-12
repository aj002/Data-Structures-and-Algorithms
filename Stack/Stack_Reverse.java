import java.util.Stack;

public class Stack_Reverse
{
	private static Stack insertAtBottom(Stack s, Object x)
	{
		if(s.empty())
		{
			s.push(x);
			return s;
		}
		Object val = s.pop();
		s = insertAtBottom(s, x);
		s.push(val);
		return s;
	}

	public static Stack reverse(Stack s)
	{
		if(s.empty())	return s;
		Object x = s.pop();
		s = reverse(s);
		s = insertAtBottom(s, x);
		return s;
	}

	public static void main(String[] args)
	{
		Stack s = new Stack();
		s.push(1.03);
		s.push(2);
		s.push("Arihant");
		s.push(4);
		System.out.println(s);
		s = reverse(s);
		System.out.println(s);
	}
}
