package graphtheory;

/**
 * Created by sramachandran on 3/10/17
 *Input:
 *2
 *4 2
 *1 2
 *1 3
 *1
 *3 1
 *2 3
 *2
 *Output:
 *6 6 -1
 *-1 6
 *
 *
 **/
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt();
        for(int i =0; i<q;i++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            boolean graph[][] = new boolean[n][n];
            for(int j=0;j<m;j++){
                int u=scanner.nextInt();
                int v=scanner.nextInt();
                u--;
                v--;
                graph[u][v]=true;
                graph[v][u]=true;
            }
            int s = scanner.nextInt();
            bfs(graph,s);
        }

    }

    public static void bfs(boolean[][] graph, int source){
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[graph.length];
        int[] dist = new int[graph.length];
        visited[source-1] = true;
        q.add(source-1);
        while(!q.isEmpty()){
            int node = q.remove();
            for(int i=0;i<graph.length;i++)
            {
                if(graph[node][i]&&(!visited[i]))
                {
                    q.add(i);
                    visited[i]=true;
                    dist[i] = dist[node] + 6;
                }
            }
        }
        for(int i=0;i<dist.length;i++){
            if(i != source-1)
                System.out.print(((dist[i]!=0)?dist[i]:-1)+" ");
        }
        System.out.println();
    }

}