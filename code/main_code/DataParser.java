import javax.xml.parsers.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;

public class DataParser
{

	static
	{
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
	}

	public static void main(String[] args)
	{
		SAXParserFactory spf = null;
		SAXParser sp = null;
		MyDefaultHandler dh = new MyDefaultHandler();

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
			count_entities = count_entities + 1;
		}
	}

	public void characters(char ch[],int start,int length) throws SAXException
	{
		if(b_author)
		{
			
			my_publication.setAuthor( new String(ch,start,length) );
			//System.out.println("Author : " + new String(ch,start,length));
			b_author = false;
		}

		else if(b_title)
		{
			my_publication.setTitle( new String(ch,start,length) );
			//System.out.println("Title : " + new String(ch,start,length));
			b_title = false;
		}

		else if(b_pages)
		{
			my_publication.setPages( new String(ch,start,length) );
			//System.out.println("Pages : " + new String(ch,start,length));
			b_pages = false;
		}

		else if(b_year)
		{
			try
			{	
				year = Integer.parseInt( new String(ch,start,length) );
			}
			catch(Exception e)
			{
				System.out.println(e +  "----- Year ");
			}
			
			my_publication.setYear(year);
			//System.out.println("Year : " + new String(ch,start,length));
			b_year = false;
		}

		else if(b_volume)
		{
			my_publication.setVolume( new String(ch,start,length) );
			//System.out.println("Volume : " + new String(ch,start,length));
			b_volume = false;
		}

		else if(b_journal)
		{
			my_publication.setJournal( new String(ch,start,length) );
			//System.out.println("Journal : " + new String(ch,start,length));
			b_journal = false;
		}

		else if(b_number)
		{
			try
			{
				//number = Integer.parseInt( new String(ch,start,length) );
			}
			catch(Exception e)
			{
				System.out.println(e + "------ Number");
			}

			//my_publication.setNumber(number);
			//System.out.println("Number : " + new String(ch,start,length));
			b_number = false;
		}

		else if(b_url)
		{
			my_publication.setURL( new String(ch,start,length) );
			//System.out.println("URL : " + new String(ch,start,length));
			b_url = false;
		}

		else if(b_ee)
		{
			my_publication.setEE( new String(ch,start,length) );
			//System.out.println("ee : " + new String(ch,start,length));
			b_ee = false;
			//System.out.println("--------------------");
		}

		else if(b_article)
		{
			b_article = false;
		}

	}

	public void endDocument() throws SAXException
	{
		System.out.println("Entities : " + count_entities);
	}

/*
	public Publication getParsedPublication()
	{

	}

*/

}