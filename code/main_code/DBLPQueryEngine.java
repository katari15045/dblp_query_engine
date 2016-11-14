

public class DBLPQueryEngine
{
	DataParser my_data_parser;
	DataProcessor my_data_processor;

	public DBLPQueryEngine()
	{
		my_data_processor = new DataProcessor();
	}

	public static void main(String[] args)
	{
		new DBLPQueryEngine();
	}

}