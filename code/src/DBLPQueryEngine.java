/*

@author

Mayank Bhoria(2015054)
Saketh Katari(2015045)

*/



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
		//author_for_entity_resolution.append("Oded Shmueli");
		//my_data_processor.performEntityResolution( author_for_entity_resolution );
		//title_tags_list = new HashSet<StringBuilder>();
		//title_tags_list.add( new StringBuilder("trees") );
		//title_tags_list.add( new StringBuilder("Nets") );
		//my_data_processor.findPublicationsByTitleTags(title_tags_list);
		//my_data_processor.getAuthorsWithMoreThanKPublications(300);
		StringBuilder sb_3 = new StringBuilder();
		sb_3.append("2000");
		StringBuilder sb_00 = new StringBuilder();
		StringBuilder sb_01 = new StringBuilder();
		StringBuilder sb_02 = new StringBuilder();
		StringBuilder sb_03 = new StringBuilder();
		StringBuilder sb_04 = new StringBuilder();

		sb_00.append("Sanjeev Saxena");
		sb_01.append("Hans Ulrich Simon");
		sb_02.append("Oded Shmueli");
		sb_03.append("Norbert Blum");
		sb_04.append("Juha Honkala");
		my_data_processor.predictPublications(sb_00,sb_01,sb_02,sb_03,sb_04,sb_3);

		//StringBuilder sb = new StringBuilder();
		//StringBuilder sb_2 = new StringBuilder();
		//sb_2.append("2016");
		//sb.append("2015");
		//my_data_processor.getPublicationListBetweenTwoYears(sb,sb_2);
		//my_data_processor.sortByDate();
		//my_data_processor.sortByRelevance();

		//my_data_processor.printPublicationList();
	}

}