import javax.xml.parsers.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;

public class DataParser extends DefaultHandler
{
	static
	{
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
	}

	SAXParserFactory spf;
	SAXParser sp;
	Publication my_publication;
	DataBase my_data_base;
	
	boolean b_article,b_author,b_title,b_pages,b_year,b_volume,b_journal,b_number,b_url,b_ee;	// By Default Boolean variable is false
	int count_entities=0;

	public DataParser()
	{
		spf = null;
		sp = null;
		my_publication = new Publication();
		my_data_base = new DataBase();
	}

	public void startParsing()
	{
		try
		{
			spf = SAXParserFactory.newInstance();
			sp = spf.newSAXParser();
			sp.parse("sample.xml",this);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			spf = null;
			sp = null;
		}
	}

	private char[] getCharArray(char[] inp_array,Integer start,Integer length)
	{
		String temp_string = new String(inp_array,start,length);

		try
		{
			return temp_string.toCharArray();
		}

		finally
		{
			inp_array = null;
			start = null;
			length = null;
			temp_string = null;
		}
	}

	public void startElement(String uri,String local_name,String q_name,Attributes attr) throws SAXException
	{
		if(q_name.equalsIgnoreCase("author"))		b_author = true;
		else if(q_name.equalsIgnoreCase("title"))	b_title = true;
		else if(q_name.equalsIgnoreCase("pages"))	b_pages = true;
		else if(q_name.equalsIgnoreCase("year"))	b_year = true;
		else if(q_name.equalsIgnoreCase("volume"))	b_volume = true;
		else if(q_name.equalsIgnoreCase("journal"))	b_journal = true;
		else if(q_name.equalsIgnoreCase("number"))	b_number = true;
		else if(q_name.equalsIgnoreCase("url"))		b_url = true;
		else if(q_name.equalsIgnoreCase("ee"))		b_ee = true;
		else if(q_name.equalsIgnoreCase("article"))	b_article = true;
		
		uri = null;
		local_name = null;
		q_name = null;
		attr = null;
	}

	public void characters(char ch[],int start,int length) throws SAXException
	{
		if(b_author)		{	b_author = false;	my_publication.setAuthor( getCharArray(ch,start,length) );	}
		else if(b_title)	{	b_title = false;	my_publication.setTitle( getCharArray(ch,start,length) );	}
		else if(b_pages)	{	b_pages = false;	my_publication.setPages( getCharArray(ch,start,length) );	}
		else if(b_year)		{	b_year = false;		my_publication.setYear( getCharArray(ch,start,length) );	}
		else if(b_volume)	{	b_volume = false;	my_publication.setVolume( getCharArray(ch,start,length) );	}
		else if(b_journal)	{	b_journal = false;	my_publication.setJournal( getCharArray(ch,start,length) );	}
		else if(b_number)	{	b_number = false;	my_publication.setNumber( getCharArray(ch,start,length) );	}
		else if(b_url)		{	b_url = false;		my_publication.setURL( getCharArray(ch,start,length) );		}
		else if(b_ee)		{	b_ee = false;		my_publication.setEE( getCharArray(ch,start,length) );		}
		else if(b_article)	{	b_article = false;	}

		ch = null;
	}

	public void endElement (String uri, String localName, String qName) throws SAXException
    {
        if( qName.equalsIgnoreCase("article") )
        {
        	my_data_base.storePublication(my_publication);
        	my_publication.clearAuthorArray();
			count_entities = count_entities + 1;
        }

        uri = null;
        localName = null;
        qName = null;
    }

	public void endDocument() throws SAXException
	{
		System.out.println("Entities : " + count_entities);
	}

}

