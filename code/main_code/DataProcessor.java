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
		Collections.sort( DataBase.publication_list, new MyComparator() );
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

			if( publication_year <= input_year )
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
}