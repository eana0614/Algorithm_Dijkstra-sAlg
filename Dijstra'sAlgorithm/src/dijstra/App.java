package dijstra;

public class App {
	
	static int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) {
	
		int[][] cost = {{0, MAX, 8, 6, 5},
						{MAX, 0, 1, MAX, 2},
						{8, 1, 0, 7, MAX},
						{6, MAX, 7, 0, MAX},
						{5, 2, MAX, MAX, 0}};
		
		
	Dijstra dij = new Dijstra();

	for(int i=0; i<cost.length; i++){
		for(int j=0; j<cost.length; j++){
			dij.runDijstra(cost, i, j);
		}
	}
	
	
	}
}
