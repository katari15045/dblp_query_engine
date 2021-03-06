/*

@author

Mayank Bhoria(2015054)
Saketh Katari(2015045)

*/


import java.util.*;

public class DataProcessor
{

	Integer result_count;
	Predictor my_predictor;

	public DataProcessor()
	{
		DataBase.initializeObjects();
		result_count = 0;
		my_predictor = new Predictor();
	}

	public void performEntityResolution(StringBuilder inp_author)
	{
		DataBase.storePublicationsForEntityResolution(inp_author);
		inp_author = null;
	}

	public void findPublicationsByTitleTags( Set<StringBuilder> inp_title_tags_list_sb )
	{
		DataBase.storePublicationsBasedOnTitleTags(inp_title_tags_list_sb);
		inp_title_tags_list_sb = null;
	}

	public void getAuthorsWithMoreThanKPublications(Integer k)
	{
		DataBase.storeAuthorsWithMoreThanKPublications(k);
		HashMap<String,Integer> my_hash_map = DataBase.getAuthorHashMap();

		for( String my_key: my_hash_map.keySet() )
		{
			Integer my_count = my_hash_map.get(my_key);

			if( my_count > k )
			{
				System.out.println(my_key + "---" + my_count);
				result_count = result_count + 1;
			}

			my_count = null;
			my_key = null;
		}

		System.out.println("Result Count : " + result_count);

		my_hash_map = null;
		k = null;
	}

	public void predictPublications(StringBuilder sb_1, StringBuilder sb_2, StringBuilder sb_3, StringBuilder sb_4, StringBuilder sb_5, StringBuilder sb_year)
	{
		DataBase.storeHashMapsForPrediction(sb_1,sb_2,sb_3,sb_4,sb_5,sb_year);
		my_predictor.predictPublications();
	}

	public void sortByDate()
	{
		Collections.sort( DataBase.getPublicationList(), new Comparator<Publication>()
		{

			public int compare(Publication pub_1, Publication pub_2)
			{
				Integer first = Integer.parseInt( pub_1.getYear().toString() );
				Integer second = Integer.parseInt( pub_2.getYear().toString() );
				int to_return = 1;

				if( first > second )
				{
					to_return = -1;	// Reverse Sorting
				}

				else if( first < second )
				{
					to_return = 1;
				}

				else
				{
					to_return = 0;
				}

				pub_1 = null;
				pub_2 = null;
				first = null;
				second = null;

				return to_return;			
			}
		} );
	}

	public void sortByRelevance()
	{
		Collections.sort( DataBase.getPublicationList(), new Comparator<Publication>()
		{

			public int compare(Publication pub_1, Publication pub_2)
			{
				if( pub_1.getRelevance() > pub_2.getRelevance() )
				{
					return -1;
				}

				if( pub_1.getRelevance() < pub_2.getRelevance() )
				{
					return 1;
				}

				return 0;
			}

		} );
	}

	public void printPublicationList()
	{
		Iterator<Publication> iter = DataBase.getPublicationList().iterator();
		Integer count = 0;

		while( iter.hasNext() )
		{
			count = count + 1;
			Publication temp_pub = iter.next();

			if( temp_pub.getAuthorArray().size() > 99 )
			{
				temp_pub = null;
				continue;
			}

			System.out.println( temp_pub );

			temp_pub = null;
		}

		System.out.printf("\ncount : %d\n\n",count);
		iter = null;
		count = null;
	}

	public void getPublicationListSinceAnYear(StringBuilder inp_year)
	{
		Iterator<Publication> iter = DataBase.getPublicationList().iterator();
		Integer count = 0;
		Integer input_year = Integer.parseInt( inp_year.toString() );

		while( iter.hasNext() )
		{
			count = count + 1;
			Publication temp_pub = iter.next();
			Integer publication_year = Integer.parseInt( temp_pub.getYear().toString() );

			if( publication_year < input_year )
			{
				iter.remove();
			}

			temp_pub = null;
			publication_year = null;
		}

		iter = null;
		count = null;
		inp_year = null;	
		input_year = null;
	}

	public void getPublicationListBetweenTwoYears(StringBuilder inp_year_1, StringBuilder inp_year_2)
	{
		Iterator<Publication> iter = DataBase.getPublicationList().iterator();
		Integer count = 0;
		Integer input_year_1 = Integer.parseInt( inp_year_1.toString() );
		Integer input_year_2 = Integer.parseInt( inp_year_2.toString() );

		while( iter.hasNext() )
		{
			count = count + 1;
			Publication temp_pub = iter.next();
			Integer publication_year = Integer.parseInt( temp_pub.getYear().toString() );

			if( publication_year < input_year_1 || publication_year > input_year_2 )
			{
				iter.remove();
			}

			temp_pub = null;
			publication_year = null;
		}

		iter = null;
		count = null;
		inp_year_1 = null;
		inp_year_2 = null;
		input_year_1 = null;
		input_year_2 = null;
	}

}