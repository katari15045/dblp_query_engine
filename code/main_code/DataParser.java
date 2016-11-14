import javax.xml.parsers.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;

public class DataParser
{

	static
	{
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
	}

	SAXParserFactory spf;
	SAXParser sp;
	MyDefaultHandler dh;

	public DataParser()
	{
		spf = null;
		sp = null;
		dh = new MyDefaultHandler();
	}

	public void startParsing()
	{
		try
		{
			spf = SAXParserFactory.newInstance();
			sp = spf.newSAXParser();
			sp.parse("dblp.xml",dh);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			spf = null;
			sp = null;
			dh = null;
		}
	}

}

class MyDefaultHandler extends DefaultHandler
{
	Publication my_publication;
	DataBase my_data_base;
	

	boolean b_article=false;
	boolean b_author=false;
	boolean b_title=false;
	boolean b_pages=false;
	boolean b_year=false;
	boolean b_volume=false;
	boolean b_journal=false;
	boolean b_number=false;
	boolean b_url=false;
	boolean b_ee=false;

	int count_entities=0;
	int year,number;
	

	public MyDefaultHandler()
	{
		my_publication = new Publication();
		my_data_base = new DataBase();
	}

	public void startElement(String uri,String local_name,String q_name,Attributes attr) throws SAXException
	{
		if(q_name.equalsIgnoreCase("author"))
		{
			b_author = true;
		}

		else if(q_name.equalsIgnoreCase("title"))
		{
			b_title = true;
		}

		else if(q_name.equalsIgnoreCase("pages"))
		{
			b_pages = true;
		}

		else if(q_name.equalsIgnoreCase("year"))
		{
			b_year = true;
		}

		else if(q_name.equalsIgnoreCase("volume"))
		{
			b_volume = true;
		}

		else if(q_name.equalsIgnoreCase("journal"))
		{
			b_journal = true;
		}

		else if(q_name.equalsIgnoreCase("number"))
		{
			b_number = true;
		}

		else if(q_name.equalsIgnoreCase("url"))
		{
			b_url = true;
		}

		else if(q_name.equalsIgnoreCase("ee"))
		{
			b_ee = true;
		}

		else if(q_name.equalsIgnoreCase("article"))
		{
			b_article = true;
		}

		uri = null;
		local_name = null;
		q_name = null;
		attr = null;
	}

	public void characters(char ch[],int start,int length) throws SAXException
	{
		if(b_author)
		{
			
			my_publication.setAuthor(ch);
			b_author = false;
		}

		else if(b_title)
		{
			my_publication.setTitle(ch);
			b_title = false;
		}

		else if(b_pages)
		{
			my_publication.setPages(ch);
			b_pages = false;
		}

		else if(b_year)
		{
			my_publication.setYear(ch);
			b_year = false;
		}

		else if(b_volume)
		{
			my_publication.setVolume(ch);
			b_volume = false;
		}

		else if(b_journal)
		{
			my_publication.setJournal(ch);
			b_journal = false;
		}

		else if(b_number)
		{
			my_publication.setNumber(ch);
			b_number = false;
		}

		else if(b_url)
		{
			my_publication.setURL(ch);
			b_url = false;
		}

		else if(b_ee)
		{
			my_publication.setEE(ch);
			b_ee = false;
		}

		else if(b_article)
		{
			b_article = false;
		}

		ch = null;

	}

	public void endElement (String uri, String localName, String qName) throws SAXException
    {
        if( qName.equalsIgnoreCase("article") )
        {
        	my_data_base.storeCurrentPublication(my_publication);
        	my_publication.clearAuthorArray();
			count_entities = count_entities + 1;
        }
    }

	public void endDocument() throws SAXException
	{
		System.out.println("Entities : " + count_entities);
	}

}