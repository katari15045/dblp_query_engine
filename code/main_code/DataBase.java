
import java.util.*;

public class DataBase
{
	protected static List<Publication> publication_list;
	static DataParser my_data_parser;
	static boolean store_for_authors;
	static boolean store_for_title_tags;
	static StringBuilder author_name;

	public static void storePublication(Publication inp_publication)
	{
		//System.out.println("Austria");

		if( decideToStore )
		{
			publication_list.add( inp_publication.clone() );
		}

		inp_publication = null;	
	}

	public static boolean decideToStore()
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
		publication_list = new LinkedList<Publication>();
		my_data_parser = new DataParser();
		String inp_author = inp_author_sb.toString();
		author_name = new StringBuilder();

		store_for_authors = true;

		if( author_name.length() >= 1 )
		{
			author_name.delete( 0,author_name.length()-1 );
		}

		author_name.append(inp_author);
		my_data_parser.startParsing();
		inp_author_sb = null;
		inp_author = null;
	}

	public static List<Publication> getPublicationList()
	{
		return publication_list;
	}


}