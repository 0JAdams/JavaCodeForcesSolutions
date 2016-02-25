import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	static class Vertex
	{
		public int employeeNumber;
		public int qualifications;
		public int costToAdd;
		public Vertex supervisor;
		public boolean joined;
		public ArrayList<Edge> edges = new ArrayList<Edge>();
		
		
		public Vertex(int employeeNumber, int qualifications)
		{
			joined = false;
			costToAdd = Integer.MAX_VALUE;
			supervisor = this;
			this.employeeNumber = employeeNumber;
			this.qualifications = qualifications;
		}
	}
	
	static class Edge
	{
		public Vertex parent;
		public Vertex child;
		public int cost;
		
		public Edge(Vertex parent, Vertex child, int cost)
		{
			this.parent = parent;
			this.child = child;
			this.cost = cost;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] line = in.readLine().split(" ");
		int[] people = new int[n+1];
		ArrayList<Vertex> peopleVs = new ArrayList<Vertex>();
		peopleVs.add(new Vertex(Integer.MAX_VALUE,Integer.MAX_VALUE));
		
		for(int i=1; i<=n; i++)
		{
			people[i] = Integer.parseInt(line[i-1]);
			peopleVs.add(new Vertex(i, people[i]));
		}
		
		int m = Integer.parseInt(in.readLine());
		
		for(int i=0; i<m; i++)
		{
			line = in.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int c = Integer.parseInt(line[2]);
			
			peopleVs.get(a).edges.add(new Edge(peopleVs.get(a), peopleVs.get(b), c));
		}
		
		
		for(int i=1; i<=n; i++)
		{
			Vertex V = peopleVs.get(i);
			for(int j=0; j<V.edges.size(); j++)
			{
				if(V.edges.get(j).cost < V.edges.get(j).child.costToAdd)
				{
					V.edges.get(j).child.costToAdd = V.edges.get(j).cost;
					V.edges.get(j).child.supervisor = V;
					V.edges.get(j).child.joined = true;
				}
			}
		}
		
		Vertex treeTop = null;
		boolean alreadyFound = false;
		
		for(int i=1; i<=n; i++)
		{
			Vertex V = peopleVs.get(i);
			if(V.joined == false)
			{
				if(alreadyFound)
				{
					System.out.println(-1);
					return;
				}
				else
				{
					treeTop = V;
					alreadyFound = true;
					
				}
			}
			
		}
		treeTop.costToAdd=0;
		
		int totalCost=0;
		
		for(int i=1; i<=n; i++)
		{
			Vertex V = peopleVs.get(i);
			totalCost += V.costToAdd;
		}
		
		System.out.println(totalCost);

	}

}
