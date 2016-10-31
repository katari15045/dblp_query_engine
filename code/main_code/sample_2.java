

public class sample_2
{
	public static void main(String[] args)
	{
		Publication m = new Publication();
		m.set_author("Saketh");
		m.set_title("Forever Feeling");
		m.set_pages("24-98");
		m.set_year(2022);
		m.set_volume("3");
		m.set_journal("My Self");
		m.set_number(6);
		m.set_url("www.forever.com");
		m.set_ee("Me ee");

		System.out.println("Author : " + m.get_author());
		System.out.println("Title : " + m.get_title());
		System.out.println("Pages : " + m.get_pages());
		System.out.println("Year : " + m.get_year());
		System.out.println("Volume : "  + m.get_volume());
		System.out.println("Journal : " + m.get_journal());
		System.out.println("Number : " + m.get_number());
		System.out.println("URL : " + m.get_url());
		System.out.println("ee : " + m.get_ee());
	}
}