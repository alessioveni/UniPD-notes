public class UsaGen
{
	public static void main(String[] argv) throws QueueFullException
	{
		CodaGen<String> cg = new CodaGen<String>(3);

		for(int i=0;i<argv.length;i++)
		{
			cg.add(argv[i]);
		}
		System.out.println(cg.currentSize());
	}
}
