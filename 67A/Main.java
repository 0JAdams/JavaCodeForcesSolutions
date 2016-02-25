import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		char[] line = in.readLine().toCharArray();
		int[] differences = new int[N+1];
		int[] values = new int[N+1];
		
		for(int i=0; i<N-1; i++)
		{
			if(line[i]=='=')
			{
				differences[i+1] = 0;
			}
			else if(line[i]=='L')
			{
				differences[i+1] = -1;
			}
			else if(line[i]=='R')
			{
				differences[i+1] = 1;
			}
			
		}
		
		values[0] = 1;
		for(int i=1; i<N; i++) //scan right
		{
			if(line[i-1]=='L')
				values[i] = 1;
			else
				values[i] = values[i-1] + differences[i];
		}
		
		for(int i=N-2; i>=0; i--) //scan left
		{
			if(line[i]=='L')
				values[i] = Math.max(values[i], values[i+1]+1);
			else if(line[i]=='=')
				values[i] = values[i+1];
		}
		
		
		
		StringBuilder out = new StringBuilder();
		for(int i=0; i<N; i++)
		{
			out.append(values[i]);
			out.append(" ");
		}
		System.out.println(out.toString());
	}

}
