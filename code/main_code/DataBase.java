
public class DataBase
{

	private static Publication[] publication_array;

	public DataBase()
	{
		initialize_publication_array();
	}

	private static void initialize_publication_array()
	{
		publication_array = new Publication[335071];
		int count = 0;

		while(count < 335071)
		{
			publication_array[count] = new Publication();
			count = count + 1;
		}
	}



}