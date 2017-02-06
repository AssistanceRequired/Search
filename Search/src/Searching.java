
public class Searching {

	/**
	 * Implements linear search for integers in an array
	 * @param arr - a sorted array
	 * @param the value/integer the algorithm is searching for
	 * @return the index of the item
	 */
	public int linearSearch(int[] arr, int key) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == key) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Implements Binary Search
	 * @param arr - a sorted array
	 * @param key - the value/integer the algorithm is searching for
	 * @param low - the lower bound
	 * @param high - the higher bound + 1 (arr.length instead of the last item array.length - 1)
	 * @return - the index of the item
	 */
	public int binarySearch(int[] arr, int key, int low, int high) {
		
		if (high <= low) {
			return -1;
		}else {
			int mid = (high + low)/ 2; 
            if(arr[mid] == key) {
            	return mid;
            }else {
                if (key < arr[mid]) {
                    return binarySearch(arr, key, low, mid);
                     
                }else {
                    return binarySearch(arr, key, mid +1 , high);
                }
            }
		}
	}
}
