import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int R = N-1;
		int L = 1;
		
		for(int i=0; i<N-1; i++)
		{
			R--;
			L++;
			if(R>0&& R%2==0 && L%2==0)
			{
				System.out.println("YES");
				return;
			}
		}
		System.out.println("NO");
	}

}
