import java.util.Arrays;

public class SearchRunner {
	
	public static void main(String[] args) {
		
		int[] arr = arrayBuilder(10);
		
		Searching search = new Searching();
		
		Arrays.sort(arr);
		printArray(arr);
		System.out.println("\n" + search.binarySearch(arr, 4, 0, arr.length));
		System.out.println(search.linearSearch(arr, 4));
		
		/**
		 * breadthfirst path finder nodes
		 * depthfirst path finder nodes
		 * dijkstra path finder nodes with index
		 */
		Node city1 = new Node("L.A",0, null, null);
	    Node city2 = new Node("San Diego", 1, city1);
	    Node city3 = new Node("San Francisco", 2, city1);
	    Node city4 = new Node("Dallas", 3, city1, city2);
	    Node city5 = new Node("Miami", 4, city4);
	    Node city6 = new Node("Denver", 5, city1, city3);
	    Node city7 = new Node("Chicago", 6, city6, city3);
	    Node city8 = new Node("New York", 7, city4, city5, city6, city7);
	    
	    /**
	     * adjmatrix that contains all the costs for the cities for dijkstra
	     */
	    int[][] adjMat = new int[][]{
        	{0,75,100,90,125,0,0,0},
        	{75,0,20,0,0,0,0,25},
        	{100,20,0,0,0,0,100,75},
        	{90,0,0,0,50,0,0,0},
        	{125,0,0,50,0,90,80,0},
        	{0,0,0,0,80,45,0,0},
        	{0,0,100,0,80,45,0,45},
        	{0,25,75,0,0,0,45,0}};
        	
        /*
         * a star map
         */
        int[][] map = new int[][] {
            {1,1,1,1,0,1,1,1},
            {1,1,0,1,0,1,0,1},
            {1,1,0,1,1,1,0,1},
            {1,1,0,1,0,0,0,1},
            {1,1,0,1,0,1,0,1},
            {1,1,0,1,1,1,0,1},
            {1,1,0,1,0,1,0,1},
            {1,1,1,1,0,1,1,1}};
           
        Node start11 = new Node(0,0);
        Node goal11 = new Node(7,7);
	    
	    BreadthFirstSearch bfs = new BreadthFirstSearch(city8, city1);
	    
	    DepthFirstSearch dfs = new DepthFirstSearch(city8,city1);
	    
	    Dijkstra dij = new Dijkstra(city8,city1,adjMat);
	    
	    AStar astar = new AStar(start11, goal11, map, 8);

	    System.out.println("\n" + "breadthfirst search ");
	    if (bfs.search())
	    	System.out.println("Path Found!");
	    
	    System.out.println("\n" + "depthfirst search ");
	    if (dfs.search())
	    	System.out.println("Path Found!");
	    
	    System.out.println("\n" + "dijksttra search ");
	    if (dij.search()) 
	    	System.out.println("Path Found!");
	    
	    System.out.println("\n" + "astar search ");
	    if (astar.search())
	    	System.out.println("Path Found!");
	}
	
	public static int[] arrayBuilder(int size) {
		
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = (int) (Math.random()*10);
		}
		return arr;
	}
	
	public static void printArray(int[] arr) {
		
		for(int x: arr) {
			System.out.print(x + " ");
		}
	}

}
