
public class DataBase
{

	private static Publication[] publication_array;

	public DataBase()
	{
		initialize_publication_array();
	}

	private static void initialize_publication_array()
	{
		publication_array = new Publication[1525486];
		int count = 0;

		while(count < 1525486)
		{
			publication_array[count] = new Publication();
			count = count + 1;
		}
	}

	//public static void store_



}