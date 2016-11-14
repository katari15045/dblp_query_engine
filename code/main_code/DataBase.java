
import java.util.*;

public class DataBase
{

	private static List<Publication> my_list;
	private static DataParser my_data_parser;

	public DataBase()
	{
		my_list = new LinkedList<Publication>();
	}

	public static void main(String[] args)
	{
		callDataParser();
	}

	public static void callDataParser()
	{
		my_data_parser = new DataParser();
		my_data_parser.startParsing();
	}

	public static void storeCurrentPublication(Publication inp_publication)
	{
		Publication cloned_publication = (Publication) inp_publication.clone();
		my_list.add(cloned_publication);
		cloned_publication = null;
		inp_publication = null;	
	}


}