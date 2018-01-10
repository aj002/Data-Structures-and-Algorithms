public class MinHeap
{
	private int a[];
	private int heap_size;
	private int capacity;

	public MinHeap(int capacity)
	{
		this.capacity = capacity;
		a = new int[capacity];
	}

	private void heapify(int i)
	{
		int left = 2*i + 1;
		int right = 2*i + 2;
		int smallest = i;
		if(left < heap_size && a[left] < a[smallest])
		{
			smallest = left;
		}
		if(right < heap_size && a[right] < a[smallest])
		{
			smallest = right;
		}
		if(i != smallest)
		{
			int temp = a[smallest];
			a[smallest] = a[i];
			a[i] = temp;
			heapify(smallest);
		}
	}

	public void insert(int val)
	{
		if(heap_size == capacity)
		{
			return;
		}
		int i = heap_size;
		a[i] = val;
		heap_size++;
		while(i != 0 && a[i/2] > a[i])
		{
			a[i/2] ^= a[i] ^ (a[i] = a[i/2]);
			i /= 2;
		}
	}

	public void display()
	{
		if(heap_size < 1)
		{
			System.out.println("Nothing to display");
			return;
		}
		for(int i=0;i<heap_size;i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		MinHeap h = new MinHeap(10);
		h.display();
		h.insert(30);
		h.insert(20);
		h.insert(10);
		h.insert(40);
		h.insert(25);
		h.display();
	}
}
