
public class Sorter {
	// Basic Sorting: Insertion Sort
	public void basicSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	// Advanced Sorting: Merge Sort
	public void advancedSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private void merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; ++i)
			L[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[mid + 1 + j];
		int i = 0, j = 0, k = left;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k++] = L[i++];
			} else {
				arr[k++] = R[j++];
			}
		}
		while (i < n1) arr[k++] = L[i++];
		while (j < n2) arr[k++] = R[j++];
	}

	// Print array
	public void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// Generate random array
	public int[] generateRandomArray(int size) {
		int[] arr = new int[size];
		java.util.Random rand = new java.util.Random();
		for (int i = 0; i < size; i++) {
			arr[i] = rand.nextInt(10000); // Диапазон значений
		}
		return arr;
	}

	// Generate sorted array
	public int[] generateSortedArray(int size) {
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		}
		return arr;
	}
}
