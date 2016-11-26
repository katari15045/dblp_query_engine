
import java.util.*;

public class sample
{

	public static List<StringBuilder> author_array;

	public static void main(String[] args)
	{
		author_array = new ArrayList<StringBuilder>();
		StringBuilder sb = new StringBuilder();
		sb.append("Saketh Ram Katari");
		author_array.add(sb);

		System.out.println( doesAuthorExist("saketh r.") );  
	}


	public static int doesAuthorExist(String inp_author_name)
	{
		int count = 0;
		int max = -2;
		Iterator<StringBuilder> iter = author_array.iterator();

		while( iter.hasNext() )
		{
			String my_author_name = iter.next().toString();		// Authors in this Publication
			count = 0;

			for( String first_string: inp_author_name.split(" ") )
			{
				for( String second_string: my_author_name.split(" ") )
				{
					if( first_string.equalsIgnoreCase(second_string) )
					{
						count = count + 1;

						System.out.println(first_string + "----" + second_string);
					}

					if( first_string.length() == 1 || second_string.length() == 1 || first_string.length() == 2 || second_string.length() == 2  )
					{
						Integer difference = first_string.charAt(0) - second_string.charAt(0);

						if( difference == 32 || difference == -32 || difference == 0 )
						{
							count = count + 1;
							System.out.println(first_string + "----" + second_string);
						}

						difference = null;
					}

					second_string = null;
				}

				first_string = null;
			}

			if( count > max )
			{
				max = count;
			}

			my_author_name = null;
		}

		inp_author_name = null;
		iter = null;

		return max;
	}
}