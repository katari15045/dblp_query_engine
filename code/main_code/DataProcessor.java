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

	public void printPublicationList()
	{
		List<Publication> my_list = my_data_base.getPublicationList();
		Iterator<Publication> iter = my_list.iterator();
		Integer count = 0;

		while( iter.hasNext() )
		{
			Publication temp_publication = iter.next();
			count = count + 1;

			System.out.println();
			//System.out.print("Authors : ");
			//temp_publication.printAuthorList();
			System.out.println("Title : " + temp_publication.getTitle());
			System.out.println("Pages : " + temp_publication.getPages());
			System.out.println("Year : " + temp_publication.getYear());
			System.out.println("Volume : " + temp_publication.getVolume());
			System.out.println("Journal : " + temp_publication.getJournal());
			System.out.println("Number : " + temp_publication.getNumber());
			System.out.println("URL : " + temp_publication.getURL());
			System.out.println("EE : " + temp_publication.getEE());
			System.out.println();

			temp_publication = null;
		}

		if( count == 0 )
		{
			System.out.println();
			System.out.println("No such Author!!!");
			System.out.println();
		}

		else
		{
			System.out.println();
			System.out.println("count : " + count);
			System.out.println();
		}

		iter = null;
		count = null;
	}

}