

public class DBLPQueryEngine
{
	private static DataProcessor my_data_processor;
	private static StringBuilder author_for_entity_resolution;

	public DBLPQueryEngine()
	{
		my_data_processor = new DataProcessor();
		author_for_entity_resolution = new StringBuilder();
	}

	public static void main(String[] args)
	{
		new DBLPQueryEngine();
		author_for_entity_resolution.append("ravishankar");
		my_data_processor.performEntityResolution( author_for_entity_resolution );
		my_data_processor.printPublicationList();
	}

}