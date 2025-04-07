public class UsaCoda1
{
	public static void main(String[] argv) throws QueueFullException, QueueEmptyException
	{
		//CodaObject co = new CodaObject();
		CodaGen co = new CodaGen();
		System.out.println("Coda di massimo " + co.maxSize() + " elementi, al momento con " + co.currentSize() + " elementi");

		for(int i=0;i<argv.length;i++)
		{
			co.add(argv[i]);
		}
		System.out.println("Coda di massimo " + co.maxSize() + " elementi, al momento con " + co.currentSize() + " elementi");
		System.out.println(co);

		while(co.currentSize() != 0)
		{
			System.out.println(co.remove());
			System.out.println("Coda di massimo " + co.maxSize() + " elementi, al momento con " + co.currentSize() + " elementi");
		}
	}
}
