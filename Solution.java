package lecture1;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		
        Edges input[] = new Edges[E];
        for(int i=0;i<E;i++){
            input[i]= new Edges();
            input[i].source = s.nextInt();
            input[i].dest=s.nextInt();
            input[i].weight=s.nextInt();
        }
     
        
    Dijkstras(input,V);
        
	}
    public static void Dijkstras(Edges input[],int V){
        boolean visited[] = new boolean[V];
        int distance[] = new int[V];
        for(int i=1;i<V;i++){
            distance[i]=Integer.MAX_VALUE;
        }
        int count=0;
        while(count!=V-1){
            int v = min(distance,visited);
            
            visited[v]=true;
              int n =0;
            
        for(int i=0;i<input.length;i++){
            if(input[i].source==v||input[i].dest==v)
                n++;
        }
         Edges neigh[] = new Edges[n];
            int k=0;
            for(int i=0;i<input.length;i++){
                if(input[i].source==v||input[i].dest==v){
                    neigh[k]=input[i];
                    k++;
                }
            }
            
            for(int i=0;i<neigh.length;i++){
                if(!visited[neigh[i].dest]&&distance[v]!=Integer.MAX_VALUE){
                    int c_dist = distance[v]+neigh[i].weight;
                    if(c_dist<distance[neigh[i].dest])
                        distance[neigh[i].dest]=c_dist;
                }
                if(!visited[neigh[i].source]&&distance[v]!=Integer.MAX_VALUE){
                    int c_dist = distance[v]+neigh[i].weight;
                    if(c_dist<distance[neigh[i].source])
                        distance[neigh[i].source]=c_dist;
                }
            }
            count++;
        }
        for(int i=0;i<V;i++){
            System.out.println(i+" "+distance[i]);
        }
    }
    public static int min(int[] distance,boolean visited[]){
        
        int minindex=-1;
    
        for(int i=0;i<distance.length;i++){
            if(!visited[i]&&(minindex==-1 || distance[i]<distance[minindex])){
              minindex=i;
            }
        }
        return minindex;
    }
  
}
    
   class Edges{
       int source;
      int dest;
      int weight;
    }
