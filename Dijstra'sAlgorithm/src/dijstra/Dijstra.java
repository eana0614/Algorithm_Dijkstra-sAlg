package dijstra;

public class Dijstra {
	
	
	public Dijstra(){
		
	}
	
	public void printPath(int []p, int startV, int endV, int dis){
		
		System.out.println("Start Vertex = ["+startV+"], End Vertex = ["+endV+"] (distance = "+dis+")");
		printPathRecursive(p, startV, endV);
		System.out.println("-"+endV);
		
		
	}
	
	private void printPathRecursive(int[] p, int startV, int endV) {
		
		if(p[endV] == startV){
			System.out.print(p[endV]);
		}else{
			printPathRecursive(p, startV, p[endV]);
			System.out.print("-"+p[endV]);
		}
	}

	public void runDijstra(int[][] cost, int startV, int endV){
		int vertexLength = cost.length;
		
		int[] distance = new int[vertexLength];
		int[] path = new int[vertexLength];
		
		boolean[] foundVertex = new boolean[vertexLength];
		
		for(int i=0; i<vertexLength; i++){
			distance[i] = cost[startV][i];
			foundVertex[i] = false;
			path[i] = startV;
		}
		
		distance[startV] = 0;
		foundVertex[startV] = true;
		
		int[] q = distance;
		
		for(int i=0; i<vertexLength-1; i++){
			int u = extractMin(q, foundVertex);
			foundVertex[u] = true;
			
			for(int w =0; w<vertexLength; w++){
				if(!foundVertex[w]){
					if(distance[w] > distance[u] + cost[u][w] && cost[u][w] != Integer.MAX_VALUE){
						distance[w] = distance[u] + cost[u][w];
						path[w] = u;
					}
				}
			}
		}
		
		printPath(path, startV, endV, distance[endV]);
	}

	private int extractMin(int[] q, boolean[] foundVertex) {
		int result = -1;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<q.length; i++){
			if(q[i] < min && !foundVertex[i]){
				min = q[i];
				result = i;
			}
		}
		
		return result;
	}

}
