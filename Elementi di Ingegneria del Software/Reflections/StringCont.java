public class StringCont
{
	public String val = null;

	public StringCont()
	{
		this("Valore di Default");
	}

	public StringCont(String v)
	{
		System.out.println("Sto costruendo uno StringCont");
		val = v;
	}

	public String toString()
	{
		return val;
	}
}
