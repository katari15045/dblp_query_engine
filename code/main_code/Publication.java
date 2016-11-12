

public class Publication
{

	private List<String> author_array;
	private String title;
	private String pages;
	private int year;
	private String volume;
	private String journal;
	private int number;
	private String url;
	private String ee;

	public Publication()
	{
		author_array = new LinkedList<String>;
		title = new String();
		pages = new String();
		volume = new String();
		journal = new String();
		url = new String();
		ee = new String();
	}

	public void setAuthor(String inp_author)
	{
		author_array.add(inp_author);
	}

	public void setTitle(String inp_title)
	{
		title = inp_title;
	}

	public void setPages(String inp_pages)
	{
		pages = inp_pages;
	}

	public void setYear(int inp_year)
	{
		year = inp_year;
	}

	public void setVolume(String inp_volume)
	{
		volume = inp_volume;
	}

	public void setJournal(String inp_journal)
	{
		journal = inp_journal;
	}

	public void setNumber(int inp_number)
	{
		number = inp_number;
	}

	public void setURL(String inp_url)
	{
		url = inp_url;
	}

	public void setEE(String inp_ee)
	{
		ee = inp_ee;
	}
//-----------------------------------------------------------

	public boolean doesAuthorExists(String inp_author_name)
	{
		Iterator<String> iter = author_array.iterator();

		while( iter.hasNext() )
		{
			String my_author_name = iter.next();

			for( String first_string: inp_author_name.split(" ") )
			{
				for( String second_string: my_author_name.split(" ") )
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

	public String getTitle()
	{
		return title;
	}

	public String getPages()
	{
		return pages;
	}

	public int getYear()
	{
		return year;
	}

	public String getVolume()
	{
		return volume;
	}

	public String getJournal()
	{
		return journal;
	}

	public int getNumber()
	{
		return number;
	}

	public String getURL()
	{
		return url;
	}

	public String getEE()
	{
		return ee;
	}

}
