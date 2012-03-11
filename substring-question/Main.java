import java.util.Scanner;
import java.util.ArrayList;

public class Main
{

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int numStrings = in.nextInt();
		String [] words = new String[numStrings];
		String wordsString = "";
		for(int x = 0; x < numStrings; x++)
		{
			words[x] = in.next();
			wordsString += words[x];
		}
		System.out.println((char)127);
	}

	public static ArrayList<String> getSubstringList(String x)
	{
		ArrayList<String> ar = new ArrayList<String>();

		return null;
			
	}

}
