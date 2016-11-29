
import java.util.*;

public class DataBase
{
	private static boolean store_for_entity_resolution;
	private static boolean store_for_title_tags;
	private static boolean store_for_k_authors;

	private static List<Publication> publication_list;
	private static Set<StringBuilder> title_tags_list;
	private static HashMap<String,Integer> author_hash_map;

	private static DataParser my_data_parser;
	private static StringBuilder author_name;

	public static void initializeObjects()
	{
		publication_list = new ArrayList<Publication>();
		title_tags_list = new HashSet<StringBuilder>();
		author_hash_map = new HashMap<String,Integer>();

		my_data_parser = new DataParser();
		author_name = new StringBuilder();
	}

	public static void storePublication(Publication inp_publication)
	{

		if(store_for_entity_resolution || store_for_title_tags)
		{
			if( decideToStorePublication(inp_publication) )
			{
				publication_list.add( inp_publication.myClone() );
			}
		}

		else if(store_for_k_authors)
		{
			Iterator<StringBuilder> iter = inp_publication.getAuthorArray().iterator();

			while( iter.hasNext() )
			{
				StringBuilder sb = new StringBuilder();
				sb.append( iter.next().toString() );

				if( author_hash_map.containsKey( sb.toString() ) )
				{
					author_hash_map.put( sb.toString() , author_hash_map.get( sb.toString() )+1 );
					sb = null;
				}

				else
				{
					author_hash_map.put( sb.toString() , 1);
				}

			}

			iter = null;
		}

		inp_publication = null;	
	}

	public static boolean decideToStorePublication(Publication inp_publication)
	{
		if(store_for_entity_resolution)
		{
			Integer max = inp_publication.doesAuthorExist( author_name.toString() );

			if(  max > 0 )
			{
				return true;
			}

			max = null;
		}

		else if(store_for_title_tags)
		{
			if( inp_publication.doTitleTagsforPublicationMatch( title_tags_list ) )
			{
				return true;
			}
		}

		return false;
	}

	// For Entity Resolution
	public static void storePublicationsForEntityResolution(StringBuilder inp_author_sb)	
	{	
		store_for_entity_resolution = true;
		store_for_title_tags = false;
		store_for_k_authors = false;
		publication_list.clear();

		String inp_author = inp_author_sb.toString();
		deleteStringBuilder(inp_author_sb);
		author_name.append(inp_author);

		my_data_parser.startParsing();

		inp_author_sb = null;
		inp_author = null;
	}

	public static void deleteStringBuilder(StringBuilder inp_sb)
	{
		if( inp_sb.length() >= 1 )
		{
			inp_sb.delete( 0,inp_sb.length()-1 );
		}
	}

	public static void storePublicationsBasedOnTitleTags(Set<StringBuilder> inp_title_tags_list)
	{
		store_for_title_tags = true;
		store_for_entity_resolution = false;
		store_for_k_authors = false;

		title_tags_list.clear();
		publication_list.clear();
		storeTitleTagsList(inp_title_tags_list);

		my_data_parser.startParsing();

		inp_title_tags_list.clear();
		inp_title_tags_list = null;
	}

	public static void storeTitleTagsList(Set<StringBuilder> inp_title_tags_list)
	{
		Iterator<StringBuilder> iter = inp_title_tags_list.iterator();

		while( iter.hasNext() )
		{
			String temp_str = iter.next().toString();
			StringBuilder sb = new StringBuilder();
			sb.append(temp_str);
			title_tags_list.add(sb);

			temp_str = null;
		}

		inp_title_tags_list.clear();
	}

	public static void storeAuthorsWithMoreThanKPublications(Integer k)
	{
		store_for_k_authors = true;
		store_for_entity_resolution = false;
		store_for_title_tags = false;

		author_hash_map.clear();

		my_data_parser.startParsing();

		k= null;
	}

	public static List<Publication> getPublicationList()
	{
		return publication_list;
	}

	public static HashMap<String,Integer> getAuthorHashMap()
	{
		return author_hash_map;
	}

}