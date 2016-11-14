
public class DataBase
{

	private static DataParser my_data_parser;

	public static void main(String[] args)
	{
		storePublicationsOfAnAuthor();
	}

	public static void storePublicationsOfAnAuthor()
	{
		my_data_parser = new DataParser();
		my_data_parser.startParsing();
	}


}