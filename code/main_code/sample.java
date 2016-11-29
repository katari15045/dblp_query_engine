
import java.util.*;

public class sample
{

	public static List<StringBuilder> author_array;

	public static void main(String[] args)
	{
		author_array = new ArrayList<StringBuilder>();
		StringBuilder sb = new StringBuilder();
		sb.append("Oded Shmueli");
		author_array.add(sb);

		System.out.println( doesAuthorExist("Mark S. Fox") );  
	}


	public static int doesAuthorExist(String inp_author_name)
	{
		int count_total = 0;
		int count_word = 0;
		Iterator<StringBuilder> iter = author_array.iterator();

		while( iter.hasNext() )
		{
			String my_author_name = iter.next().toString();		// Authors in this Publication

			for( String first_string: inp_author_name.split(" ") )
			{
				for( String second_string: my_author_name.split(" ") )
				{
					if( first_string.equalsIgnoreCase(second_string) )
					{
						count_total = count_total + 1;
						count_word = count_word + 1;
					}

					if( first_string.length() == 1 || second_string.length() == 1 || first_string.length() == 2 || second_string.length() == 2  )
					{
						Integer difference = first_string.charAt(0) - second_string.charAt(0);

						if( difference == 32 || difference == -32 || difference == 0 )
						{
							Integer status_store = 1;

							if( (first_string.length() == 2 && first_string.charAt(1) != '.') || (second_string.length() == 2 && second_string.charAt(1) != '.') )
							{
								status_store = 0;
							}

							if( status_store == 1 )
							{
								count_total = count_total + 1;
							}

							status_store = null;
						}

						difference = null;
					}

					second_string = null;
				}

				first_string = null;
			}

			my_author_name = null;
		}


		inp_author_name = null;
		iter = null;

		return count_word;
	}
}