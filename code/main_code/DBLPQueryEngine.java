import java.util.*;

public class DBLPQueryEngine
{
	private static DataProcessor my_data_processor;
	private static StringBuilder author_for_entity_resolution;
	private static Set<StringBuilder> title_tags_list;

	public DBLPQueryEngine()
	{
		my_data_processor = new DataProcessor();
	}

	public static void main(String[] args)
	{
		new DBLPQueryEngine();
		//author_for_entity_resolution = new StringBuilder();
		//author_for_entity_resolution.append("zxzxwqxzwqzx");
		//my_data_processor.performEntityResolution( author_for_entity_resolution );
		title_tags_list = new HashSet<StringBuilder>();
		title_tags_list.add( new StringBuilder("trees") );
		title_tags_list.add( new StringBuilder("Nets") );
		my_data_processor.findPublicationsByTitleTags(title_tags_list);
		StringBuilder sb = new StringBuilder();
		StringBuilder sb_2 = new StringBuilder();
		sb_2.append("2016");
		sb.append("2015");
		my_data_processor.getPublicationListBetweenTwoYears(sb,sb_2);
		my_data_processor.sortByDate();
		my_data_processor.printPublicationList();
	}

}