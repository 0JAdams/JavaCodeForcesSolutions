import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int v = Integer.parseInt(line[2]);
		
		int min = n-1;
		int max = (((n-1)*(n-2)) / 2) +1;
		
		if( m < min || m > max)
		{
			System.out.println(-1);
			return;
		}
		
		StringBuilder out = new StringBuilder();
		int outerV = 0;
		if(v>1)
		{
			outerV = 1;
		}
		else
		{
			outerV = 2;
		}
		
		int edges = 0;
		//connect all vertices to V
		for(int i=1; i<=n; i++)
		{
			if(i==v)
			{
				continue;
			}
			out.append(v);
			out.append(" ");
			out.append(i);
			out.append("\n");
			edges++;
		}
		
		//connect random other edges, but not to v or outerV so that we don't double edges or make outerV connected to anything but v
		for(int i=1; i<=n; i++)
		{
			if(edges == m)
			{
				break;
			}
			
			if(i == outerV || i == v)
			{
				continue;
			}
			
			for(int j=1; j<i; j++)
			{
				if(edges == m)
				{
					break;
				}
				
				if(j == outerV || j == v)
				{
					continue;
				}
				
				out.append(i);
				out.append(" ");
				out.append(j);
				out.append("\n");
				
				edges++;
			}
		}
		
		System.out.println(out.toString());

	}

}
