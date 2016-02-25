import java.io.BufferedReader;
import java.io.InputStreamReader;

//This solution is for problem 1A on codeforces
// http://www.codeforces.com/problemset/problem/1/A


public class Main {

	public static void main(String[] args) throws Exception
	{

		
		int n = 0;
		int m = 0;
		int a = 0;
		
		int x = 0;
		int y = 0;
		
		try{
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			
			String line = in.readLine();
			String[] splitLine = {"a","b","c"};
			while(line!=null && line != "")
			{
				splitLine = line.split(" ");
				n = Integer.parseInt(splitLine[0]);
				m = Integer.parseInt(splitLine[1]);
				a = Integer.parseInt(splitLine[2]);
				if(n%a !=0)
				{
					x = (n/a)+1;
					
				}
				else
				{
					x = n/a;
				}
				
				if(m%a != 0)
				{
					y= (m/a)+1;
				}
				else
				{
					y = m/a;
				}
				System.out.println((long)(x)*y);
				line = in.readLine();
			}
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
