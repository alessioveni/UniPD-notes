public class Test
{
	public Test()
	{
		this("pippero");
	}

	public Test(String a)
	{
		System.out.println("Io sono una nuova istanza di Test " + a);
	}

	public String toString()
	{
		return "sono un Test";
	}
}
