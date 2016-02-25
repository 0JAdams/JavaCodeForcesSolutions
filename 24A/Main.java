
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
	public static class Vertex
	{
		public int index;
		public Edge E1;
		public Edge E2;
		
		public Vertex(int index)
		{
			this.index = index;
			E1 = null;
			E2 = null;
		}
		
		public void AddEdge(Edge NewEdge)
		{
			if(E1==null)
			{
				E1 = NewEdge;
			}
			else
			{
				E2 = NewEdge;
			}
			
		}
	}
	
	public static class Edge
	{
		public Vertex V1;
		public Vertex V2;
		public int cost;
		
		public Edge(Vertex Vertex1, Vertex Vertex2, int Cost)
		{
			cost = Cost;
			V1 = Vertex1;
			V2 = Vertex2;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Vertex[] vs = new Vertex[N+1];
		
		
		
		for(int n=0; n<=N; n++)
		{
			vs[n] = new Vertex(n);
		}
		
		for(int n=0; n<N; n++)
		{
			String[] line = in.readLine().split(" ");
			int head = Integer.parseInt(line[0]);
			int tail = Integer.parseInt(line[1]);
			int cost = Integer.parseInt(line[2]);
			Edge newEdge = new Edge(vs[head], vs[tail], cost);
			vs[head].AddEdge(newEdge);
			vs[tail].AddEdge(newEdge);
		}
		
		//traverse cycle one direction summing the costs of all edges going the opposite direction
		Vertex current = vs[1];
		Vertex last = null;
		int sum1 = 0;
		for(int n=0; n<N; n++)
		{
			
			Edge E = current.E1;
			if(current.E1.V1==last ||current.E1.V2==last)
			{
				E = current.E2;
			}
			else
			{
				E = current.E1;
			}
			
			if(E.V1!=current)
			{
				last = current;
				sum1 += E.cost;
				current = E.V1;
			}
			else
			{
				last = current;
				current = E.V2;
			}
			
		}
		
		
		//traverse cycle the other direction summing its costs
		current = vs[1];
		last = null;
		int sum2 = 0;
		for(int n=0; n<N; n++)
		{
			
			Edge E = current.E2;
			if(current.E2.V1==last ||current.E2.V2==last)
			{
				E = current.E1;
			}
			else
			{
				E = current.E2;
			}
			
			if(E.V1!=current)
			{
				last = current;
				sum2 += E.cost;
				current = E.V1;
			}
			else
			{
				last = current;
				current = E.V2;
			}
			
		}
		
		//take the minimum of the two costs.
		System.out.println(Math.min(sum1,sum2));
	}

}
