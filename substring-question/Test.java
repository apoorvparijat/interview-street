import java.util.ArrayList;

public class Test{


	public static void main(String args[])
	{
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("apoorv");
		ar.add("parijat");
		ar.add("bing");
		ar.add("apoorv");
		if(ar.contains("apoorv"))
		{
			System.out.println("True");
		}
		System.out.println(ar.contains("bing"));
		System.out.println(ar.size());
	}

}
