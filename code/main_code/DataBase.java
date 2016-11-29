
import java.util.*;

public class DataBase
{
	private static boolean store_for_entity_resolution;
	private static boolean store_for_title_tags;
	private static boolean store_for_k_authors;
	private static boolean store_for_years;

	private static List<Publication> publication_list;
	private static Set<StringBuilder> title_tags_list;
	private static HashMap<String,Integer> author_hash_map;
	private static HashMap<String,Integer> year_hash_map_1;
	private static HashMap<String,Integer> year_hash_map_2;
	private static HashMap<String,Integer> year_hash_map_3;
	private static HashMap<String,Integer> year_hash_map_4;
	private static HashMap<String,Integer> year_hash_map_5;

	private static DataParser my_data_parser;
	private static StringBuilder author_name_entity_res;
	private static StringBuilder author_name_predictor_1;
	private static StringBuilder author_name_predictor_2;
	private static StringBuilder author_name_predictor_3;
	private static StringBuilder author_name_predictor_4;
	private static StringBuilder author_name_predictor_5;
	private static StringBuilder year_for_query_3;

	public static void initializeObjects()
	{
		publication_list = new ArrayList<Publication>();
		title_tags_list = new HashSet<StringBuilder>();
		author_hash_map = new HashMap<String,Integer>();
		year_hash_map_1 = new HashMap<String,Integer>();
		year_hash_map_2 = new HashMap<String,Integer>();
		year_hash_map_3 = new HashMap<String,Integer>();
		year_hash_map_4 = new HashMap<String,Integer>();
		year_hash_map_5 = new HashMap<String,Integer>();

		author_name_predictor_1 = new StringBuilder();
		author_name_predictor_2 = new StringBuilder();
		author_name_predictor_3 = new StringBuilder();
		author_name_predictor_4 = new StringBuilder();
		author_name_predictor_5 = new StringBuilder();
		year_for_query_3 = new StringBuilder();

		my_data_parser = new DataParser();
		author_name_entity_res = new StringBuilder();
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

		else if(store_for_years)
		{
			Iterator<StringBuilder> iter = inp_publication.getAuthorArray().iterator();

			while( iter.hasNext() )
			{
				StringBuilder sb_author = new StringBuilder();
				StringBuilder sb_year = new StringBuilder();
				sb_author.append( iter.next() );
				sb_year.append( inp_publication.getYear().toString() );


				if( year_for_query_3.toString().compareTo( sb_year.toString() ) < 0 )
				{
					continue;
				}

				if( sb_author.toString().equalsIgnoreCase( author_name_predictor_1.toString() ) )
				{
					if( year_hash_map_1.containsKey( sb_year.toString() ) )
					{
						year_hash_map_1.put( sb_year.toString(), year_hash_map_1.get( sb_year.toString() ) + 1 );
					}

					else
					{
						year_hash_map_1.put( sb_year.toString(), 1 );
					}
				}

				if( sb_author.toString().equalsIgnoreCase( author_name_predictor_2.toString() ) )
				{
					if( year_hash_map_2.containsKey( sb_year.toString() ) )
					{
						year_hash_map_2.put( sb_year.toString(), year_hash_map_2.get( sb_year.toString() ) + 1 );
					}

					else
					{
						year_hash_map_2.put( sb_year.toString(), 1 );
					}
				}

				if( sb_author.toString().equalsIgnoreCase( author_name_predictor_3.toString() ) )
				{
					if( year_hash_map_3.containsKey( sb_year.toString() ) )
					{
						year_hash_map_3.put( sb_year.toString(), year_hash_map_3.get( sb_year.toString() ) + 1 );
					}

					else
					{
						year_hash_map_3.put( sb_year.toString(), 1 );
					}
				}

				if( sb_author.toString().equalsIgnoreCase( author_name_predictor_4.toString() ) )
				{
					if( year_hash_map_4.containsKey( sb_year.toString() ) )
					{
						year_hash_map_4.put( sb_year.toString(), year_hash_map_4.get( sb_year.toString() ) + 1 );
					}

					else
					{
						year_hash_map_4.put( sb_year.toString(), 1 );
					}
				}


				if( sb_author.toString().equalsIgnoreCase( author_name_predictor_5.toString() ) )
				{
					if( year_hash_map_5.containsKey( sb_year.toString() ) )
					{
						year_hash_map_5.put( sb_year.toString(), year_hash_map_5.get( sb_year.toString() ) + 1 );
					}

					else
					{
						year_hash_map_5.put( sb_year.toString(), 1 );
					}
				}



			}
		}

		inp_publication = null;	
	}

	public static boolean decideToStorePublication(Publication inp_publication)
	{
		if(store_for_entity_resolution)
		{
			Integer max = inp_publication.doesAuthorExist( author_name_entity_res.toString() );

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
		store_for_years = false;
		publication_list.clear();

		String inp_author = inp_author_sb.toString();
		deleteStringBuilder(inp_author_sb);
		author_name_entity_res.append(inp_author);

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
		store_for_years = false;

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
		store_for_years = false;

		author_hash_map.clear();

		my_data_parser.startParsing();

		k= null;
	}

	public static void storeHashMapsForPrediction(StringBuilder author_1,StringBuilder author_2,StringBuilder author_3,StringBuilder author_4,StringBuilder author_5,StringBuilder inp_year)
	{
		store_for_years = true;
		store_for_entity_resolution = false;
		store_for_title_tags = false;
		store_for_k_authors = false;

		year_hash_map_1.clear();
		year_hash_map_2.clear();
		year_hash_map_3.clear();
		year_hash_map_4.clear();
		year_hash_map_5.clear();

		author_name_predictor_1.append( author_1.toString() );
		author_name_predictor_2.append( author_2.toString() );
		author_name_predictor_3.append( author_3.toString() );
		author_name_predictor_4.append( author_4.toString() );
		author_name_predictor_5.append( author_5.toString() );
		year_for_query_3.append( inp_year.toString() );

		my_data_parser.startParsing();

		author_name_predictor_1 = null;
		author_name_predictor_2 = null;
		author_name_predictor_3 = null;
		author_name_predictor_4 = null;
		author_name_predictor_5 = null;
		year_for_query_3 = null;
	}

	public static List<Publication> getPublicationList()
	{
		return publication_list;
	}

	public static HashMap<String,Integer> getAuthorHashMap()
	{
		return author_hash_map;
	}

	public static HashMap<String,Integer> getYearHashMap1()
	{
		return year_hash_map_1;
	}

	public static HashMap<String,Integer> getYearHashMap2()
	{
		return year_hash_map_2;
	}

	public static HashMap<String,Integer> getYearHashMap3()
	{
		return year_hash_map_3;
	}

	public static HashMap<String,Integer> getYearHashMap4()
	{
		return year_hash_map_4;
	}

	public static HashMap<String,Integer> getYearHashMap5()
	{
		return year_hash_map_5;
	}

}