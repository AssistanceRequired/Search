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
		 * breadthfirst path finder 
		 */
		Node city1 = new Node("L.A", null, null);
	    Node city2 = new Node("San Diego",city1);
	    Node city3 = new Node("San Francisco", city1);
	    Node city4 = new Node("Dallas", city1, city2);
	    Node city5 = new Node("Miami", city4);
	    Node city6 = new Node("Denver", city1, city3);
	    Node city7 = new Node("Chicago", city6, city3);
	    Node city8 = new Node("New York", city4, city5, city6, city7);
	    
	    BreadthFirstSearch bfs = new BreadthFirstSearch(city8, city1);

	    if(bfs.search())
	    	System.out.print("Path Found!");
	    
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
