import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.TreeSet;


public class Main {
	static class Vertex implements Comparable<Vertex>
	{	
		int i;
		long pathWeight;
		
		ArrayList<Edge> edges = new ArrayList<Edge>();
		Vertex parent;
		
		public Vertex(int index)
		{
			i=index;
			pathWeight = Long.MAX_VALUE;
		}

		@Override
		public int compareTo(Vertex v) {
			if(pathWeight < v.pathWeight)
				return -1;
			if(pathWeight > v.pathWeight)
				return 1;
			else
				return i-v.i;
		}
		
	}
	
	static class Edge
	{
		
		Vertex vb;
		int weight;
		public Edge(Vertex Child, int Weight)
		{
		
			vb = Child;
			weight = Weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		Vertex[] nodes = new Vertex[N+1];
		for(int i=1; i<=N; i++)
		{
			nodes[i] = new Vertex(i);
		}
		
		for(int m=0; m<M; m++)
		{
			line = in.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int w = Integer.parseInt(line[2]);
			
			Edge E = new Edge(nodes[b], w);
			nodes[a].edges.add(E);
			E = new Edge(nodes[a], w);
			nodes[b].edges.add(E);
		}
		
		nodes[1].pathWeight = 0;
		nodes[1].parent = null;
		TreeSet<Vertex> Q = new TreeSet<Vertex>();
		Q.add(nodes[1]);
		
		Vertex V = null;
		while(!Q.isEmpty())
		{
			V = Q.first();
			Q.remove(V);
			if(V == nodes[N]) //if true we've reached the final node
			{
				LinkedList<Integer> path = new LinkedList<Integer>();
				StringBuilder out = new StringBuilder();
				while(V!= null)
				{
					path.addFirst(V.i);
					V = V.parent;
				}
				for(int i : path)
				{
					out.append(i);
					out.append(" ");
				}
				System.out.println(out.toString());
				return;
			}
			
			for(Edge E : V.edges)
			{
				if(E.vb.pathWeight > V.pathWeight + E.weight)
				{
					Q.remove(E.vb);
					E.vb.pathWeight = V.pathWeight + E.weight;
					E.vb.parent = V;
					Q.add(E.vb);
				}
			}
		
		}
		System.out.println("-1");
				
	}

}
