public class CodaObject
{
	Object[] elems = null;
	int first, last, size;

	public CodaObject(int len)
	{
		first = last = size = 0;
		elems = new Object[len];
	}

	public CodaObject()
	{
		this(10);
	}

	int add(Object o) throws QueueFullException
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

	Object remove() throws QueueEmptyException
	{
		Object retval = null;
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
}
