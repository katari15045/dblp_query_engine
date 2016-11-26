import java.util.*;

public class DataProcessor
{
	DataBase my_data_base;

	public DataProcessor()
	{
		my_data_base = new DataBase();
		DataBase.initializeObjects();
	}

	public void performEntityResolution(StringBuilder inp_author)
	{
		my_data_base.storePublicationsForEntityResolution(inp_author);
		inp_author = null;
	}

	public void findPublicationsByTitleTags( Set<StringBuilder> inp_title_tags_list_sb )
	{
		my_data_base.storePublicationsBasedOnTitleTags(inp_title_tags_list_sb);
		inp_title_tags_list_sb = null;
	}

	public void sortByDate()
	{
		Collections.sort( DataBase.publication_list, new Comparator<Publication>()
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
		Collections.sort( DataBase.publication_list, new Comparator<Publication>()
		{

			public int compare( Publication pub_1, Publication pub_2 )
			{
				int to_return = 0;

				if( pub_1.getRelevance() > pub_2.getRelevance() )
				{
					to_return = -1;
				}

				else if( pub_1.getRelevance() < pub_2.getRelevance() )
				{
					to_return = 1;
				}

				else
				{
					to_return = 0;
				}

				pub_1 = null;
				pub_2 = null;

				return to_return;
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
			System.out.println( iter.next() );
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