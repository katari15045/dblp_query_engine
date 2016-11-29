import java.util.*;


public class Predictor
{

	HashMap<String,Integer> hash_map_1;
	HashMap<String,Integer> hash_map_2;
	HashMap<String,Integer> hash_map_3;
	HashMap<String,Integer> hash_map_4;
	HashMap<String,Integer> hash_map_5;
	StringBuilder year;

	Integer min_year_1;
	Integer min_year_2;
	Integer min_year_3;
	Integer min_year_4;
	Integer min_year_5;

	private void initializeObjects()
	{
		hash_map_1 = DataBase.getYearHashMap1();
		hash_map_2 = DataBase.getYearHashMap2();
		hash_map_3 = DataBase.getYearHashMap3();
		hash_map_4 = DataBase.getYearHashMap4();
		hash_map_5 = DataBase.getYearHashMap5();

		year = new StringBuilder();

		min_year_1 = DataBase.getMinYear1ForPredictor();
		min_year_2 = DataBase.getMinYear2ForPredictor();
		min_year_3 = DataBase.getMinYear3ForPredictor();
		min_year_4 = DataBase.getMinYear4ForPredictor();
		min_year_5 = DataBase.getMinYear5ForPredictor();

		year.append( DataBase.getYearForPredictor().toString() );
	}

	public void predictPublications()
	{
		initializeObjects();
		fillYearsInHashMap();
		printYearHashMap();
	}

	private void fillYearsInHashMap()
	{
		Integer count_1 = min_year_1;
		Integer count_2 = min_year_2;
		Integer count_3 = min_year_3;
		Integer count_4 = min_year_4;
		Integer count_5 = min_year_5;

		Integer year_int = Integer.parseInt( year.toString() );

		System.out.println("Count 1 : " + count_1 + "   Year_int : " + year_int);

		while( count_1 <= year_int )
		{
			String temp_str = Integer.toString(count_1);
			if( hash_map_1.get(temp_str) == null )
			{
				hash_map_1.put(temp_str,0);
			}

			temp_str = null;
			count_1 = count_1 + 1;
		}

		while( count_2 <= year_int )
		{
			String temp_str = Integer.toString(count_2);
			if( hash_map_2.get(temp_str) == null )
			{
				hash_map_2.put(temp_str,0);
			}

			temp_str = null;
			count_2 = count_2 + 1;
		}

		while( count_3 <= year_int )
		{
			String temp_str = Integer.toString(count_3);
			if( hash_map_3.get(temp_str) == null )
			{
				hash_map_3.put(temp_str,0);
			}

			temp_str = null;
			count_3 = count_3 + 1;
		}

		while( count_4 <= year_int )
		{
			String temp_str = Integer.toString(count_4);
			if( hash_map_4.get(temp_str) == null )
			{
				hash_map_4.put(temp_str,0);
			}

			temp_str = null;
			count_4 = count_4 + 1;
		}

		while( count_5 <= year_int )
		{
			String temp_str = Integer.toString(count_5);
			if( hash_map_5.get(temp_str) == null )
			{
				hash_map_5.put(temp_str,0);
			}

			temp_str = null;
			count_5 = count_5 + 1;
		}

	}


	public Integer getNumerator(List<Integer> inp_list)
	{
		Iterator<Integer> iter = inp_list.iterator();
		Integer count = 1;
		Integer to_return = 0;

		while( iter.hasNext() )
		{
			to_return = to_return + ( iter.next() * count );
			count = count + 1;
		}

		try
		{
			return to_return;
		}

		finally
		{
			iter = null;
			to_return = null;
			count = null;
		}

	}


	public Integer getDenominator(Integer inp_length)
	{
		return ( (inp_length)*(inp_length + 1) ) / 2;
	}


	public void printYearHashMap()
	{
		HashMap<String,Integer> hm_1 = DataBase.getYearHashMap1();
		HashMap<String,Integer> hm_2 = DataBase.getYearHashMap2();
		HashMap<String,Integer> hm_3 = DataBase.getYearHashMap3();
		HashMap<String,Integer> hm_4 = DataBase.getYearHashMap4();
		HashMap<String,Integer> hm_5 = DataBase.getYearHashMap5();
		Integer result_count = 0;

		for( String my_key: hm_1.keySet() )
		{
			Integer my_count = hm_1.get(my_key);
			System.out.println(my_key + "---" + my_count);
			result_count = result_count + 1;
			my_count = null;
			my_key = null;
		}

		System.out.println("Result Count : " + result_count);
		System.out.println("Min Year : " + DataBase.getMinYear1ForPredictor() );
		System.out.printf("\n----------------------------------------------------\n");

		result_count = 0;

		for( String my_key: hm_2.keySet() )
		{
			Integer my_count = hm_2.get(my_key);
			System.out.println(my_key + "---" + my_count);
			result_count = result_count + 1;
			my_count = null;
			my_key = null;
		}

		System.out.println("Result Count : " + result_count);
		System.out.println("Min Year : " + DataBase.getMinYear2ForPredictor() );
		System.out.printf("\n----------------------------------------------------\n");

		result_count = 0;

		for( String my_key: hm_3.keySet() )
		{
			Integer my_count = hm_3.get(my_key);
			System.out.println(my_key + "---" + my_count);
			result_count = result_count + 1;
			my_count = null;
			my_key = null;
		}

		System.out.println("Result Count : " + result_count);
		System.out.println("Min Year : " + DataBase.getMinYear3ForPredictor() );
		System.out.printf("\n----------------------------------------------------\n");

		result_count = 0;

		for( String my_key: hm_4.keySet() )
		{
			Integer my_count = hm_4.get(my_key);
			System.out.println(my_key + "---" + my_count);
			result_count = result_count + 1;
			my_count = null;
			my_key = null;
		}

		System.out.println("Result Count : " + result_count);
		System.out.println("Min Year : " + DataBase.getMinYear4ForPredictor() );
		System.out.printf("\n----------------------------------------------------\n");

		for( String my_key: hm_5.keySet() )
		{
			Integer my_count = hm_5.get(my_key);
			System.out.println(my_key + "---" + my_count);
			result_count = result_count + 1;
			my_count = null;
			my_key = null;
		}

		System.out.println("Result Count : " + result_count);
		System.out.println("Min Year : " + DataBase.getMinYear5ForPredictor() );
		System.out.printf("\n----------------------------------------------------\n");

		hm_1 = null;
		hm_2 = null;
		hm_3 = null;
		hm_4 = null;
		hm_5 = null;
		result_count = null;

	}
	


}	
	