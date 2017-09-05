import javax.xml.parsers.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;

public class sample
{
	public static void main(String[] args) throws Exception
	{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		MyDefaultHandler dh = new MyDefaultHandler();
		sp.parse("sample.xml",dh);
	}
}

class MyDefaultHandler extends DefaultHandler
{
	boolean b_name=false;
	boolean b_price=false;
	boolean b_description=false;
	boolean b_calories=false;

	public void startElement(String uri,String local_name,String q_name,Attributes attr) throws SAXException
	{
		if(q_name.equalsIgnoreCase("name"))
		{
			b_name = true;
		}

		if(q_name.equalsIgnoreCase("price"))
		{
			b_price = true;
		}

		if(q_name.equalsIgnoreCase("description"))
		{
			b_description = true;
		}

		if(q_name.equalsIgnoreCase("calories"))
		{
			b_calories = true;
		}
	}

	public void characters(char ch[],int start,int length) throws SAXException
	{
		if(b_name)
		{
			System.out.println("Name : " + new String(ch,start,length));
			b_name = false;
		}

		else if(b_price)
		{
			System.out.println("Price : " + new String(ch,start,length));
			b_price = false;
		}

		else if(b_description)
		{
			System.out.print("Description : " + new String(ch,start,length));
			b_description = false;
		}

		else if(b_calories)
		{
			System.out.println("Calories : " + new String(ch,start,length));
			b_calories = false;
			System.out.println("--------------------------------------");
		}

	}
}