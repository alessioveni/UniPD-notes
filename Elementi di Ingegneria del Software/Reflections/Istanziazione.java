import java.io.*;

public class Istanziazione
{
	public static void main(String[] argv) throws ClassNotFoundException
	{
		Class clazz = null;
		BufferedReader br = null;

			br = new BufferedReader(new InputStreamReader(System.in));


		String line = null;

		try
		{
			System.out.print("? > ");
			while( (line = br.readLine()) != null)
			{
				clazz = Class.forName(line);
				System.out.println(clazz);
	
				try
				{
					Object o = clazz.newInstance();
					System.out.println(o);
			//Object o = new ......
				}
				catch(InstantiationException | IllegalAccessException ie)
				{
					ie.printStackTrace();
				}
				System.out.print("? > ");
			}
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
			System.exit(1);
		}
	}
}
