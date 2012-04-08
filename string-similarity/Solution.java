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
			output += suffix_similarity(str[i]) + "\n";
		}
		System.out.println(output.trim());
	}


	
	public static int find_similar_rec(String x, String y, int start, int end)
	{
		int count = 0;
		int factor = 0;
		//System.out.println("Ceil is " + Math.ceil(start + ((double)end-(double)start)/2));
		if(start >= end){
			
			//System.out.println("Start is " + start + " end is " + end);
			return count;
		}
		if((end - start) == 1)
		{
			if(x.charAt(start) == y.charAt(start))
			{
				return 1;
			}else
			{
				return 0;
			}
		}
		String xSub = x.substring(start, start+(end-start)/2);
		String ySub = y.substring(start,start+(end-start)/2);
		//System.out.println("X's substring is " + xSub + " Y's subString is " + ySub);
		if(xSub.equals(ySub)){
			//System.out.println("Found first half equal. Calling fsr with start " + (start+(end-start)/2) + " and end " + end);
			count = (end-start)/2 + find_similar_rec(x,y,start+(end-start)/2, end);
			//System.out.println("Found first half equal. Count is " + count);
		}
		else{
			//System.out.println("Found first half not equal. Calling fsr with start " + start + " and end " + (end-start)/2);
			count = find_similar_rec(x,y,start, (end-start)/2);
			//System.out.println("Found first half not equal. Count is " + count);
		}
			
		//System.out.println("######## \n About to return count. Count is " + count + "\n");
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
			//System.out.println("Calling find_similar_rec with start " + 0 + " and end " + ((m-i)));
			count += find_similar_rec(x, x.substring(i,m), 0, (m-i));
			//System.out.println("############# Count so far .. ################ " + count);
		}
		return count + m;
	}
}
