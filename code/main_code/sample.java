
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

		if ( doesAuthorExist("S R K") > 0 )  
		{
			System.out.println("bye");
		}
	}


	public static int doesAuthorExist(String inp_author_name)
	{
		Integer count_total = 0,max = -2;
		Iterator<StringBuilder> iter = author_array.iterator();

		while( iter.hasNext() )
		{
			String my_author_name = iter.next().toString();		// Authors in this Publication
			count_total = 0;

			for( String first_string: inp_author_name.split(" ") )
			{
				for( String second_string: my_author_name.split(" ") )
				{
					if( first_string.equalsIgnoreCase(second_string) )
					{
						count_total = count_total + 1;
						//System.out.println(first_string + "----" + second_string);
					}

					second_string = null;
				}

				first_string = null;
			}

			if( count_total > max )
			{
				max = count_total;
			}

			my_author_name = null;
		}

		inp_author_name = null;
		iter = null;

		try
		{
			//relevance = max;
			return max;
		}

		finally
		{
			count_total = null;
			max = null;
		}
	}
}