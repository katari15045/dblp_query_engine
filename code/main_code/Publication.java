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
