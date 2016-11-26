
import java.util.*;

public class DataBase
{
	protected static List<Publication> publication_list;
	static DataParser my_data_parser;
	static boolean store_for_authors;
	static StringBuilder author_name;
	static boolean store_for_title_tags;
	static List<StringBuilder> title_tags_list;

	public static void initializeObjects()
	{
		publication_list = new LinkedList<Publication>();
		my_data_parser = new DataParser();
		author_name = new StringBuilder();
		title_tags_list = new LinkedList<StringBuilder>();
	}

	public static void storePublication(Publication inp_publication)
	{
		if( decideToStore(inp_publication) )
		{
			publication_list.add( inp_publication.clone() );
		}

		inp_publication = null;	
	}

	public static boolean decideToStore(Publication inp_publication)
	{
		if(store_for_authors)
		{
			if( inp_publication.doesAuthorExist( author_name.toString() ) )
			{
				return true;
			}
		}

		else if(store_for_title_tags)
		{

		}

		return false;
	}

	// For Entity Resolution
	public static void storePublicationsForEntityResolution(StringBuilder inp_author_sb)	
	{	
		store_for_authors = true;

		String inp_author = inp_author_sb.toString();
		deleteStringBuilder(inp_author_sb);
		author_name.append(inp_author);

		my_data_parser.startParsing();

		inp_author_sb = null;
	}

	public static void deleteStringBuilder(StringBuilder inp_sb)
	{
		if( inp_sb.length() >= 1 )
		{
			inp_sb.delete( 0,inp_sb.length()-1 );
		}
	}

	public static void storePublicationsBasedOnTitleTags(List<StringBuilder> inp_title_tags_list)
	{
	
	}

	public static void getStringListFromStringBuilderList(List<StringBuilder> inp_title_tags_list)
	{
		Iterator<StringBuilder> iter = inp_title_tags_list.iterator();

		while( iter.hasNext() )
		{

		}
	}

	public static List<Publication> getPublicationList()
	{
		return publication_list;
	}


}