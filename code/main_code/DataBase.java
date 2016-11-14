
import java.util.*;

public class DataBase
{

	private static List<Publication> publication_list;
	private static DataParser my_data_parser;

	public DataBase()
	{
		
	}

	public static void main(String[] args)
	{
		publication_list = new LinkedList<Publication>();
		my_data_parser = new DataParser();
		my_data_parser.startParsing();
	}

	public static void storeCurrentPublication(Publication inp_publication)
	{
		Publication cloned_publication = (Publication) inp_publication.clone();
		publication_list.add(cloned_publication);
		cloned_publication = null;
		inp_publication = null;	
	}

	public static List getPublicationList()
	{
		return publication_list;
	}


}