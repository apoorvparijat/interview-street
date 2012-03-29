import java.util.Scanner;

class Solution
{
	public static void main(String args[])
	{
		int num_of_inputs;
		Scanner in = new Scanner(System.in);
		num_of_inputs = in.nextInt();
		String [] str = new String[num_of_inputs];
		String output = "";
		for(int i = 0; i < num_of_inputs; i++)
		{
			str[i] = in.next();
			output += suffix_similarity(str[i]);
		}
		System.out.println(output.trim());
	}

	public static int find_similar(String x, String y)
	{
		/*
		int count = 0;
		int m = x.length() < y.length() ? x.length() : y.length();
		for(int i = 0; i < m; i++)
		{
			if(x.charAt(i) == y.charAt(i))
				count++;
			else
				break;
		}
		return count;
		*/
		int factor = 1;
		return find_similar_rec(x,y,factor);
	}
	
	public static int find_similar_rec(String x, String y, int start, int end)
	{
		int count = 0;
		if(start <= end)
			return count;
			
		if(x.substring(start, (end-start)/2) == y.substring(start,(end-start)/2))
			count = (end-start)/2 + find_similar_rec(x,y,(end-start)/2, end);
		else
			count = find_similar_rec(x,y,start, (end-start)/2);
			
		return count;

	}

	//extracts suffixes and calles find_similar_rec
	// abababa
	// find_similar("abababa", "bababa")
	// find_similar("abababa", "ababa")
	// find_similar("abababa", "ababa")
	
	public static int suffix_similarity(String x)
	{
		int count = 0;
		int m = x.length();
		for(int i = 1; i < m; i++)
		{
			count += find_similar_rec(x, x.substring(i,m), 0, (m-i));
		}
		return count + m;
	}
}
