import java.util.*;

public class Publication
{

	private List<StringBuilder> author_array;
	private StringBuilder title;
	private StringBuilder pages;
	private int year;
	private StringBuilder volume;
	private StringBuilder journal;
	private int number;
	private StringBuilder url;
	private StringBuilder ee;

	public Publication()
	{
		author_array = new LinkedList<StringBuilder>();
		title = new StringBuilder();
		pages = new StringBuilder();
		volume = new StringBuilder();
		journal = new StringBuilder();
		url = new StringBuilder();
		ee = new StringBuilder();
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
	}

	public void setTitle(char[] inp_title)
	{
		title.delete( 0,title.length() );
		title.append(inp_title);
	}

	public void setPages(char[] inp_pages)
	{
		pages.delete( 0,pages.length() );
		pages.append(inp_pages);
	}

	public void setYear(int inp_year)
	{
		year = inp_year;
	}

	public void setVolume(char[] inp_volume)
	{
		volume.delete( 0,volume.length() );
		volume.append(inp_volume);
	}

	public void setJournal(char[] inp_journal)
	{
		journal.delete( 0,journal.length() );
		journal.append(inp_journal);
	}

	public void setNumber(int inp_number)
	{
		number = inp_number;
	}

	public void setURL(char[] inp_url)
	{
		url.delete( 0,url.length() );
		url.append(inp_url);
	}

	public void setEE(char[] inp_ee)
	{
		ee.delete( 0,ee.length() );
		ee.append(inp_ee);
	}
//-----------------------------------------------------------

/*
	public boolean doesAuthorExists(StringBuilder inp_author_name)
	{
		Iterator<StringBuilder> iter = author_array.iterator();

		while( iter.hasNext() )
		{
			StringBuilder my_author_name = iter.next();

			for( StringBuilder first_string: inp_author_name.split(" ") )
			{
				for( StringBuilder second_string: my_author_name.split(" ") )
				{
					if( first_string.equalsIgnoreCase(second_string) )
					{
						return true;
					}
				}
			}
		}

		return false;
	}
*/
	public StringBuilder getTitle()
	{
		return title;
	}

	public StringBuilder getPages()
	{
		return pages;
	}

	public int getYear()
	{
		return year;
	}

	public StringBuilder getVolume()
	{
		return volume;
	}

	public StringBuilder getJournal()
	{
		return journal;
	}

	public int getNumber()
	{
		return number;
	}

	public StringBuilder getURL()
	{
		return url;
	}

	public StringBuilder getEE()
	{
		return ee;
	}

}
