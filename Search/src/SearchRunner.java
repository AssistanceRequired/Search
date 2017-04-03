import java.util.ArrayList;
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
	    
	    Node NYC = new Node("New York City",0);
        Node CHI = new Node("Chicago",1);
        Node DEN = new Node("Denver",2);
        Node MIA = new Node("Miami",3);
        Node DAL = new Node("Dallas",4);
        Node SD = new Node("San Diego",5);
        Node LA = new Node("Los Angeles",6);
        Node SF = new Node("San Francisco",7);
        
	    NYC.setChildren(new ArrayList<Node>(Arrays.asList(CHI,DEN,MIA,DAL)));
        CHI.setChildren(new ArrayList<Node>(Arrays.asList(NYC,SF,DEN)));
        DEN.setChildren(new ArrayList<Node>(Arrays.asList(CHI,NYC,LA,SF)));
        MIA.setChildren(new ArrayList<Node>(Arrays.asList(NYC,DAL)));
        DAL.setChildren(new ArrayList<Node>(Arrays.asList(NYC,SD,MIA,LA)));
        SD.setChildren(new ArrayList<Node>(Arrays.asList(LA,DAL)));
        LA.setChildren(new ArrayList<Node>(Arrays.asList(SD,SF,DEN,DAL)));
        SF.setChildren(new ArrayList<Node>(Arrays.asList(LA,DEN,CHI)));
	    /**
	     * adjmatrix that contains all the costs for the cities for dijkstra
	     */
        int[][] adjMat = new int[][]{
        	{0,338,725,1613,0,0,0,0,0,0,0,0},//Boston
        	{338,0,383,0,2145,0,0,0,0,0,0,0},//New York
        	{725,383,0,1145,1709,0,2113,0,0,0,0,0},//DC
        	{1613,0,1145,0,0,661,0,0,0,0,0,0},//Chicago
        	{0,2145,1709,0,0,0,2161,0,0,0,0,0},//Miami
        	{0,0,0,661,0,0,1532,1483,0,2661,0,0},//Minneapolis
        	{0,0,2113,0,2161,1532,1258,0,1983,0,0,0},//Dallas
        	{0,0,0,0,0,1483,1258,0,1225,2161,0,0},//Denver
        	{0,0,0,0,0,0,1983,1225,0,0,919,435},//LasVegas
        	{0,0,0,0,0,2661,0,2161,0,0,1306,0},//Seattle
        	{0,0,0,0,0,0,0,0,919,1306,0,629},//SanFran
        	{0,0,0,0,0,0,0,0,435,0,629,0}//LA
        };	
        Dijkstra dijkstra = new Dijkstra(NYC,SF,adjMat);
        dijkstra.search();
        	
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
	    
	    System.out.println("\n" + "AStar search ");
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
