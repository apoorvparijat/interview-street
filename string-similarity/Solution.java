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
	}

	public static int suffix_similarity(String x)
	{
		int count = 0;
		int m = x.length();
		for(int i = 1; i < m; i++)
		{
			count += find_similar(x, x.substring(i,m));
		}
		return count + m;
	}
}
