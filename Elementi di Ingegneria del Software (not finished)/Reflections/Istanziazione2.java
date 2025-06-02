import java.io.*;
import java.lang.reflect.*;

public class Istanziazione2
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

				Constructor[] constructors = clazz.getDeclaredConstructors();
				for(int i=0;i<constructors.length;i++)
				{
					System.out.println(constructors[i]);
				}

				try
				{
					//Selezione del costruttore senza parametry (nullary)
					Constructor c1 = clazz.getDeclaredConstructor();
					System.out.println(c1);

					//urilizzo del costruttore senza parametri per ottenere un'istanza
					Object o = c1.newInstance();
					System.out.println(o); 

					//lista dei campi della classe caricata
					Field[] fields = clazz.getDeclaredFields();
					for(int i=0;i<fields.length;i++)
					{
						System.out.println(fields[i]);
					}
					//o = c1.newInstance(o);
					//System.out.println(o);

					//estrazione di un campo dal nome "hardcoded"
					try
					{
						Field f1 = clazz.getDeclaredField("val");
						System.out.println(f1.get(o));
						f1.set(o, "Ti ho cambiato");
						System.out.println(f1.get(o));
					}
					catch(NoSuchFieldException nsfe)
					{
						nsfe.printStackTrace();
					}

					Method[] methods = clazz.getDeclaredMethods();
					for(int i=0;i<methods.length;i++)
					{
						System.out.println(methods[i]);
					}

					//Method m1 = clazz.getDeclaredMethod("toString");
					while(br.readLine().equals("CONT"))
					{
						Method m1 = null;
						String methName = null;
						System.out.println("Dimmi il nome del metodo che vuoi eseguire");
						methName = br.readLine();
						System.out.println("Dimmi il numero dei parametri del metodo");
						int parnum = Integer.parseInt(br.readLine());
						Class[] partypes = new Class[parnum];
						for(int i=0;i<partypes.length;i++)
						{
							System.out.println("Dimmi il nome della classe del parametro " + i);
							partypes[i] = Class.forName(br.readLine());
						}
						m1 = clazz.getDeclaredMethod(methName, partypes);
	
						System.out.println(m1);
	
						parnum = m1.getParameterCount();
						Object[] params = new Object[parnum];
						for(int i=0;i<params.length;i++)
						{
							System.out.println("Dimmi il tipo del parametro " + i);
							line = br.readLine();
							params[i] = Class.forName(line).getDeclaredConstructor().newInstance();
						}
						partypes = m1.getParameterTypes();
						for(int i=0;i<partypes.length;i++)
						{
							if(!(params[i].getClass().isInstance(partypes[i])))
							{
								throw new IllegalArgumentException("type mismatch " + i);
							}
						}
						System.out.println("E la risposta e'.....");
						m1.invoke(o, params);
						System.out.println(o);
					}
				}
				catch(InvocationTargetException ite)
				{
					System.out.println(ite.getCause());
					ite.printStackTrace();
				}
				catch(IllegalArgumentException | NoSuchMethodException | InstantiationException | IllegalAccessException ie)
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
