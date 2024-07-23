import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBfs {
    // Driver code
    public static void main(String args[])
    {
        GraphBfs g = new GraphBfs(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Breadth First Traversal "
                        + "(starting from vertex 2)");

        g.bfs(0);
    }
    private int v;
    private LinkedList<Integer>[] adj;
    GraphBfs(int v){
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(int v, int e){
        adj[v].add(e);
    }
    public void bfs(int s){
        //boolean[] visited = new boolean[v];
        int[] visited = new int[v];
        Queue<Integer> queue = new LinkedList<>();
        //visited[s] = true;
        visited[s] = 1;
        queue.add(s);
        while(!queue.isEmpty()){
           s = queue.poll();
            System.out.print(s +" ");
            Iterator<Integer> iterator = adj[s].iterator();
            while(iterator.hasNext()){
                int n = iterator.next();
                /*if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }*/
                if(visited[n] != 1){
                    visited[n] = 1;
                    queue.add(n);
                }
            }
        }
    }
}
