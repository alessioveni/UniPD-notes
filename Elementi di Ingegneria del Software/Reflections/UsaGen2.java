public class UsaGen2
{
	public static void main(String[] argv) throws QueueFullException, QueueEmptyException
	{
		int acc = 0;
		int maxLen = 0;
		CodaGen<Integer> cg = new CodaGen<Integer>(3);

		for(int i=0;i<argv.length;i++)
		{
			//cg.add(Integer.parseInt(argv[i]));
			try
			{
				cg.add(new Integer(argv[i]));
			}
			catch(NumberFormatException nfe)
			{
				nfe.printStackTrace();
			}
		}
		System.out.println(cg.currentSize());
		maxLen = cg.currentSize();
		for(;cg.currentSize() != 0;)
		{
			acc += cg.remove();
		}
		System.out.println(acc/maxLen);
	}
}
