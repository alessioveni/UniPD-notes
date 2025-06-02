public class CodaGen<E>
{
	E[] elems = null;
	int first, last, size;

	public CodaGen(int len)
	{
		first = last = size = 0;
		elems = (E[])(new Object[len]);
		//elems = (new E[len]);
	}

	public CodaGen()
	{
		this(10);
	}

	int add(E o) throws QueueFullException
	{
		if(size == elems.length)
		{
			throw new QueueFullException();
		}
		elems[last] = o;
		last = (last+1)%elems.length;
		size = size+1;
		return size;
	}

	E remove() throws QueueEmptyException
	{
		E retval = null;
		if(size == 0)
		{
			throw new QueueEmptyException();
		}
		retval = elems[first];
		first = (first+1)%elems.length;
		size = size -1;
		return retval;
	}

	int currentSize()
	{
		return size;
	}

	int maxSize()
	{
		return elems.length;
	}

	public String toString()
	{
		String retval = "";
		for(int i=0;i<size;i++)
		{
			Object o = elems[i%elems.length];
			if(o == null)
			{
				retval = retval + "null; ";
			}
			else
			{
				retval = retval + o.toString() + "; ";
			}
		}
		return retval;
	}
}
