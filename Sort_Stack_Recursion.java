class Sort_Stack
{
	private static Stack<Integer> insert(Stack<Integer> s, int x)
	{
		if(s.empty())
		{
			s.push(x);
			return s;
		}
		if(s.peek() > x)
		{
			int val = s.pop();
			insert(s, x);
			s.push(val);
		}
		else
		{
			s.push(x);
		}
		return s;
	}
	public static Stack<Integer> sort(Stack<Integer> s)
	{
		if(s.empty())	return s;
		int x = s.pop();
		s = sort(s);
		s = insert(s, x);
		return s;
	}

	public static void main(String[] args)
	{
		Stack<Integer> s = new Stack<>();
		s.push(30);
		s.push(-5);
		s.push(18);
		s.push(14);
		s.push(-3);
		System.out.println(s);
		s = sort(s);
		System.out.println(s);
	}
}
