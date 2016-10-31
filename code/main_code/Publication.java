

public class Publication
{

	public Publication()
	{
		author = new String();
		title = new String();
		pages = new String();
		volume = new String();
		journal = new String();
		url = new String();
		ee = new String();
	}

	private String author;
	private String title;
	private String pages;
	private int year;
	private String volume;
	private String journal;
	private int number;
	private String url;
	private String ee;

	public void set_author(String inp_author)
	{
		author = inp_author;
	}

	public void set_title(String inp_title)
	{
		title = inp_title;
	}

	public void set_pages(String inp_pages)
	{
		pages = inp_pages;
	}

	public void set_year(int inp_year)
	{
		year = inp_year;
	}

	public void set_volume(String inp_volume)
	{
		volume = inp_volume;
	}

	public void set_journal(String inp_journal)
	{
		journal = inp_journal;
	}

	public void set_number(int inp_number)
	{
		number = inp_number;
	}

	public void set_url(String inp_url)
	{
		url = inp_url;
	}

	public void set_ee(String inp_ee)
	{
		ee = inp_ee;
	}
//-----------------------------------------------------------
	public String get_author()
	{
		return author;
	}

	public String get_title()
	{
		return title;
	}

	public String get_pages()
	{
		return pages;
	}

	public int get_year()
	{
		return year;
	}

	public String get_volume()
	{
		return volume;
	}

	public String get_journal()
	{
		return journal;
	}

	public int get_number()
	{
		return number;
	}

	public String get_url()
	{
		return url;
	}

	public String get_ee()
	{
		return ee;
	}

}