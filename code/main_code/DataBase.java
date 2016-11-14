
import java.util.*;

public class DataBase
{
	protected static List<Publication> publication_list;
	DataParser my_data_parser;

	public void storeData()
	{
		my_data_parser = new DataParser();
		my_data_parser.startParsing();
	}

	public void storePublication(Publication inp_publication)
	{
		publication_list = new LinkedList<Publication>();
		Publication cloned_publication = (Publication) inp_publication.clone();
		publication_list.add(cloned_publication);
		cloned_publication = null;
		inp_publication = null;	
	}

	public List getPublicationList()
	{
		return publication_list;
	}


}