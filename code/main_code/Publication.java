import java.util.*;

public class Publication							
{

	protected List<StringBuilder> author_array;
	private StringBuilder title,pages,year,volume,journal,number,url,ee;
	private static int relevance;

	public Publication()
	{
		author_array = new ArrayList<StringBuilder>();
		title = new StringBuilder();
		pages = new StringBuilder();
		year = new StringBuilder();
		volume = new StringBuilder();
		journal = new StringBuilder();
		number = new StringBuilder();
		url = new StringBuilder();
		ee = new StringBuilder();
	}

	public String toString()
	{
		System.out.println("Authors : ");
		printAuthorList();

		StringBuilder sb = new StringBuilder();

		if( getTitle() != null )
		{
			sb.append("Title : ");
			sb.append( getTitle().toString() );
		}

		if( getPages() != null )
		{
			sb.append("\nPages : ");
			sb.append( getPages().toString() );
		}

		if( getYear() != null )
		{
			sb.append("\nYear : ");
			sb.append( getYear().toString() );
		}

		if( getVolume() != null )
		{
			sb.append("\nVolume : ");
			sb.append( getVolume().toString() );
		}

		if( getJournal() != null )
		{
			sb.append("\nJournal : ");
			sb.append( getJournal().toString() );
		}

		if( getNumber() != null )
		{
			sb.append("\nNumber : ");
			sb.append( getNumber().toString() );
		}

		if( getURL() != null )
		{
			sb.append("\nURL : ");
			sb.append( getURL().toString() );
		}

		if( getEE() != null )
		{
			sb.append("\nEE : ");
			sb.append( getEE().toString() );
		}
		
		sb.append("\n\n");

		try
		{
			return sb.toString();
		}

		finally
		{
			sb = null;
		}
	}

	public Publication myClone()
	{
		Publication to_return = new Publication();

		to_return.author_array = new LinkedList<StringBuilder>(author_array);	// Deep Copying
		to_return.title = new StringBuilder(title);
		to_return.pages = new StringBuilder(pages);
		to_return.year = new StringBuilder(year);
		to_return.volume = new StringBuilder(volume);
		to_return.journal = new StringBuilder(journal);
		to_return.number = new StringBuilder(number);
		to_return.url = new StringBuilder(url);
		to_return.ee = new StringBuilder(ee);

		return to_return;
	}

	public void clearAuthorList()
	{
		author_array.clear();
	}

	public void printAuthorList()
	{
		Iterator<StringBuilder> iter = author_array.iterator();

		while( iter.hasNext() )
		{
			System.out.print( iter.next() + ", " );
		}

		System.out.println();
		iter = null;
	}

	public void setAuthor(char[] inp_author)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(inp_author);
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


	public int doesAuthorExist(String inp_author_name)
	{
		Integer count_total = 0,max = -2;
		Iterator<StringBuilder> iter = author_array.iterator();

		while( iter.hasNext() )
		{
			String my_author_name = iter.next().toString();		// Authors in this Publication
			count_total = 0;

			for( String first_string: inp_author_name.split(" ") )
			{
				for( String second_string: my_author_name.split(" ") )
				{
					if( first_string.equalsIgnoreCase(second_string) )
					{
						count_total = count_total + 1;

						//System.out.println(first_string + "----" + second_string);
					}

					second_string = null;
				}

				first_string = null;
			}

			if( count_total > max )
			{
				max = count_total;
			}

			my_author_name = null;
		}

		inp_author_name = null;
		iter = null;

		try
		{
			relevance = max;
			return max;
		}

		finally
		{
			count_total = null;
			max = null;
		}
	}


	public boolean doTitleTagsforPublicationMatch(Set<StringBuilder> inp_title_tags_list)
	{
		Iterator<StringBuilder> iter = inp_title_tags_list.iterator();
		boolean to_return = false;

		while( iter.hasNext() )
		{
			String tag_str = iter.next().toString();
			String pub_str = this.getTitle().toString();

			for( String publication_str: pub_str.split(" ") )
			{
				if( tag_str.equalsIgnoreCase(publication_str) )
				{
					to_return = true;
				}

				publication_str = null;
			}
			
			tag_str = null;
			pub_str = null;
		}

		iter = null;
		inp_title_tags_list = null;
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
	public int 		getRelevance()	{	return relevance;	}
	public List<StringBuilder> getAuthorArray()	{	return author_array;	}
}
