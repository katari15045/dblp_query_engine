
import java.util.*;

public class DataBase
{
	protected static List<Publication> publication_list;
	DataParser my_data_parser;

	public void storeData()
	{
		publication_list = new LinkedList<Publication>();
		my_data_parser = new DataParser();
		my_data_parser.startParsing();
	}

	public void storePublication(Publication inp_publication)
	{
		publication_list.add(inp_publication);
		//inp_publication = null;	
	}

	public List<Publication> getPublicationList()
	{
		return publication_list;
	}


}