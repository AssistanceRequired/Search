import java.util.Arrays;

public class SearchRunner {
	
	public static void main(String[] args) {
		
		int[] arr = arrayBuilder(10);
		
		Searching search = new Searching();
		
		Arrays.sort(arr);
		printArray(arr);
		System.out.println("\n" + search.binarySearch(arr, 4, 0, arr.length));
		System.out.println(search.linearSearch(arr, 4));
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
