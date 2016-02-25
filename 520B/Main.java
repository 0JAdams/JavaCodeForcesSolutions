import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static class Vertex 
	{
		public int currentM, step;
		public Vertex(int current, int stepCount)
		{
			currentM = current;
			step = stepCount;
		}
		@Override public boolean equals(Object a)
		{
			if(currentM == ((Vertex)a).currentM)
				return true;
			return false;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		ArrayList<Vertex> L = new ArrayList<Vertex>();
		int i=0;
	
		Vertex V = new Vertex(N, 0);
		L.add(V);
		
		while(L.get(i)!=null)
		{
			//V = Q.pollFirst();
			V = L.get(i);
			if(V.currentM==M)
			{
				break;
			}
			
			if(V.currentM*2<2*M)
			{
				Vertex V2 = new Vertex(V.currentM*2, V.step+1);
				if(!L.contains(V2))
					L.add(V2);
			}
			
			if(V.currentM>1)
			{
				Vertex V2 = new Vertex(V.currentM-1, V.step+1);
				if(!L.contains(V2))
					L.add(V2);
			}
			i++;
		}
		System.out.println(V.step);
	}

}
