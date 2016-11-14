import java.util.*;

public class Publication implements Cloneable							
{

	private List<StringBuilder> author_array;
	private StringBuilder title,pages,year,volume,journal,number,url,ee;

	public Publication()
	{
		author_array = new LinkedList<StringBuilder>();
		title = new StringBuilder();
		pages = new StringBuilder();
		year = new StringBuilder();
		volume = new StringBuilder();
		journal = new StringBuilder();
		number = new StringBuilder();
		url = new StringBuilder();
		ee = new StringBuilder();
	}

	public Object clone()
	{
		Object to_return = null;

		try
		{
			to_return = super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			System.out.println(e);
		}

		return to_return;
	}

	public void clearAuthorArray()
	{
		author_array.clear();
	}

	public void setAuthor(char[] inp_author)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(inp_author);
		sb = null;
		author_array.add(sb);
		inp_author = null;
	}

	public void setTitle(char[] inp_title)
	{
		title.delete( 0,title.length() );
		title.append(inp_title);
		inp_title = null;
	}

	public void setPages(char[] inp_pages)
	{
		pages.delete( 0,pages.length() );
		pages.append(inp_pages);
		inp_pages = null;
	}

	public void setYear(char[] inp_year)
	{
		year.delete( 0,year.length() );
		year.append(inp_year);
		inp_year = null;
	}

	public void setVolume(char[] inp_volume)
	{
		volume.delete( 0,volume.length() );
		volume.append(inp_volume);
		inp_volume = null;
	}

	public void setJournal(char[] inp_journal)
	{
		journal.delete( 0,journal.length() );
		journal.append(inp_journal);
		inp_journal = null;
	}

	public void setNumber(char[] inp_number)
	{
		number.delete( 0,number.length() );
		number.append(inp_number);
		inp_number = null;
	}

	public void setURL(char[] inp_url)
	{
		url.delete( 0,url.length() );
		url.append(inp_url);
		inp_url = null;
	}

	public void setEE(char[] inp_ee)
	{
		ee.delete( 0,ee.length() );
		ee.append(inp_ee);
		inp_ee = null;
	}
//-----------------------------------------------------------


	public boolean doesAuthorExist(char[] inp_author)
	{
		boolean to_return = false;
		StringBuilder inp_author_sb = new StringBuilder();
		inp_author_sb.append(inp_author);
		String inp_author_name = inp_author_sb.toString();
		Iterator iter = author_array.iterator();

		while( iter.hasNext() )
		{
			String my_author_name = iter.next().toString();		// Authors in this Publication

			for( String first_string: inp_author_name.split(" ") )
			{
				for( String second_string: my_author_name.split(" ") )
				{
					if( first_string.equalsIgnoreCase(second_string) )
					{
						to_return = true;
					}

					second_string = null;
				}

				first_string = null;
			}

			my_author_name = null;
		}

		inp_author = null;
		inp_author_sb = null;
		inp_author_name = null;
		iter = null;

		return to_return;
	}

	public StringBuilder getTitle()		{	return title;	}
	public StringBuilder getPages()		{	return pages;	}
	public StringBuilder getYear()		{	return year;	}
	public StringBuilder getVolume()	{	return volume;	}
	public StringBuilder getJournal()	{	return journal;	}
	public StringBuilder getNumber()	{	return number;	}
	public StringBuilder getURL()		{	return url;		}
	public StringBuilder getEE()		{	return ee;		}

}
