import java.util.*;

public class MyComparator implements Comparator<Publication>
{

	public int compare(Publication pub_1, Publication pub_2)
	{
		Integer first = Integer.parseInt( pub_1.getYear().toString() );
		Integer second = Integer.parseInt( pub_2.getYear().toString() );
		int to_return = 1;

		if( first > second )
		{
			to_return = -1;	// Reverse Sorting
		}

		else if( first < second )
		{
			to_return = 1;
		}

		else
		{
			to_return = 0;
		}

		pub_1 = null;
		pub_2 = null;
		first = null;
		second = null;

		return to_return;
	
	}

}