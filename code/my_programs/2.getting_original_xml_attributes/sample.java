import javax.xml.parsers.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;

public class sample
{

	static
	{
		System.setProperty("jdk.xml.entityExpansionLimit", "0");
	}

	public static void main(String[] args) throws Exception
	{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		MyDefaultHandler dh = new MyDefaultHandler();
		sp.parse("dblp.xml",dh);
	}
}

class MyDefaultHandler extends DefaultHandler
{
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

	long count_entities=0;

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
	}

	public void characters(char ch[],int start,int length) throws SAXException
	{
		if(b_author)
		{
			//System.out.println("Author : " + new String(ch,start,length));
			b_author = false;
		}

		else if(b_title)
		{
			//System.out.println("Title : " + new String(ch,start,length));
			b_title = false;
		}

		else if(b_pages)
		{
			//System.out.println("Pages : " + new String(ch,start,length));
			b_pages = false;
		}

		else if(b_year)
		{
			//System.out.println("Year : " + new String(ch,start,length));
			b_year = false;
		}

		else if(b_volume)
		{
			//System.out.println("Volume : " + new String(ch,start,length));
			b_volume = false;
		}

		else if(b_journal)
		{
			//System.out.println("Journal : " + new String(ch,start,length));
			b_journal = false;
		}

		else if(b_number)
		{
			//System.out.println("Number : " + new String(ch,start,length));
			b_number = false;
		}

		else if(b_url)
		{
			//System.out.println("URL : " + new String(ch,start,length));
			b_url = false;
		}

		else if(b_ee)
		{
			//System.out.println("ee : " + new String(ch,start,length));
			b_ee = false;
			//System.out.println("--------------------");
		}

		else if(b_article)
		{
			b_article = false;
			count_entities = count_entities + 1;
		}
	}

	public void endDocument() throws SAXException
	{
		System.out.println("Entities : " + count_entities);
	}
}