public class Searcher {
	// Linear Search
	public int linearSearch(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) return i;
		}
		return -1;
	}

	//Binary Search
	public int binarySearch(int[] arr, int target) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target) return mid;
			if (arr[mid] < target) left = mid + 1;
			else right = mid - 1;
		}
		return -1;
	}

	//Universal search method by type
	public int search(int[] arr, int target, String type) {
		if ("linear".equalsIgnoreCase(type)) {
			return linearSearch(arr, target);
		} else if ("binary".equalsIgnoreCase(type)) {
			return binarySearch(arr, target);
		} else {
			throw new IllegalArgumentException("Unknown search type: " + type);
		}
	}
}
