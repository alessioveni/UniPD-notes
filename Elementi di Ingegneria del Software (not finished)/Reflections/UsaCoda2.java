public class UsaCoda2
{
	public static void main(String[] argv) throws QueueFullException, QueueEmptyException
	{
		int accumulatore = 0;
		CodaObject co = new CodaObject();
		System.out.println("Coda di massimo " + co.maxSize() + " elementi, al momento con " + co.currentSize() + " elementi");

		for(int i=0;i<argv.length;i++)
		{
			co.add(argv[i]);
		}
		System.out.println("Coda di massimo " + co.maxSize() + " elementi, al momento con " + co.currentSize() + " elementi");
		System.out.println(co);

		while(co.currentSize() != 0)
		{
			Integer e = (Integer)co.remove();
			System.out.println(e);
			accumulatore += e;
			co.add(accumulatore);
			System.out.println("Coda di massimo " + co.maxSize() + " elementi, al momento con " + co.currentSize() + " elementi");
		}
	}
}
