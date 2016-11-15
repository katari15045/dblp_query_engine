
import java.util.*;

public class DataBase
{
	protected static List<Publication> publication_list;
	static DataParser my_data_parser;
	static boolean store_for_authors;
	static boolean store_for_title_tags;
	static StringBuilder store_based_on_author;

	public static void storePublication(Publication inp_publication)
	{
		//System.out.println("Austria");

		if(store_for_authors)
		{
			if( inp_publication.doesAuthorExist( store_based_on_author.toString() ) )
			{
				publication_list.add( inp_publication.clone() );
			}
		}

		else if(store_for_title_tags)
		{

		}

		inp_publication = null;	
	}

	// For Entity Resolution
	public static void storePublicationsForEntityResolution(StringBuilder inp_author_sb)	
	{	
		publication_list = new LinkedList<Publication>();
		my_data_parser = new DataParser();
		String inp_author = inp_author_sb.toString();
		store_based_on_author = new StringBuilder();

		store_for_authors = true;

		if( store_based_on_author.length() >= 1 )
		{
			store_based_on_author.delete( 0,store_based_on_author.length()-1 );
		}

		store_based_on_author.append(inp_author);
		my_data_parser.startParsing();
		inp_author_sb = null;
		inp_author = null;
	}

	public static List<Publication> getPublicationList()
	{
		return publication_list;
	}


}