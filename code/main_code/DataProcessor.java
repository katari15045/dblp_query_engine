import java.util.*;

public class DataProcessor
{
	DataBase my_data_base;

	public DataProcessor()
	{
		my_data_base = new DataBase();
		my_data_base.storeData();
	}

	public void printPublicationList()
	{
		List<Publication> my_list = my_data_base.getPublicationList();
		Iterator<Publication> iter = my_list.iterator();

		while( iter.hasNext() )
		{
			Publication temp_publication = iter.next();

			System.out.println();
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

		iter = null;
	}

}