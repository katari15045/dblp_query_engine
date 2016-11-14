

public class DBLPQueryEngine
{
	private static DataProcessor my_data_processor;

	public DBLPQueryEngine()
	{
		my_data_processor = new DataProcessor();
	}

	public static void main(String[] args)
	{
		new DBLPQueryEngine();
		my_data_processor.printPublicationList();
	}

}