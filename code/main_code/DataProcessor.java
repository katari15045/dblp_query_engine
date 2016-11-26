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

	public void printPublicationListSortedByYear()
	{
		Iterator<Publication> iter = DataBase.getPublicationList().iterator();
		Integer count = 0;

		while( iter.hasNext() )
		{
			count = count + 1;
			System.out.println( iter.next() );
		}

		if( count == 0 )
		{
			System.out.printf("\nNo such Author!!!\n\n");
		}

		else
		{
			System.out.printf("\ncount : %d\n\n",count);
		}

		iter = null;
		count = null;
	}

}