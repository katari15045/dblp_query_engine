
public class DataBase
{

	private static DataParser my_data_parser;

	public static void main(String[] args)
	{
		my_data_parser = new DataParser();
		my_data_parser.startParsing();
	}


}