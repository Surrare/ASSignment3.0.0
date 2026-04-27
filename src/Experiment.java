public class Experiment {
	private final Sorter sorter;
	private final Searcher searcher;

	public Experiment(Sorter sorter, Searcher searcher) {
		this.sorter = sorter;
		this.searcher = searcher;
	}

	// Measuring sorting time
	public long measureSortTime(int[] arr, String type) {
		int[] copy = arr.clone();
		long start = System.nanoTime();
		if ("basic".equalsIgnoreCase(type)) {
			sorter.basicSort(copy);
		} else if ("advanced".equalsIgnoreCase(type)) {
			sorter.advancedSort(copy);
		} else {
			throw new IllegalArgumentException("Unknown sort type: " + type);
		}
		long end = System.nanoTime();
		return end - start;
	}

	// Measuring search time
	public long measureSearchTime(int[] arr, int target, String type) {
		int[] copy = arr.clone();
		long start = System.nanoTime();
		searcher.search(copy, target, type);
		long end = System.nanoTime();
		return end - start;
	}

	// Launch all experiments
	public void runAllExperiments() {
		int[] sizes = {10, 100, 1000};
		String[] sortTypes = {"basic", "advanced"};
		String[] searchTypes = {"linear", "binary"};
		for (int size : sizes) {
			System.out.println("\nArray size: " + size);
			int[] randomArr = sorter.generateRandomArray(size);
			int[] sortedArr = sorter.generateSortedArray(size);

			// Sorting
			for (String sortType : sortTypes) {
				long timeRandom = measureSortTime(randomArr, sortType);
				long timeSorted = measureSortTime(sortedArr, sortType);
				System.out.println(sortType + " sort (random): " + timeRandom + " ns");
				System.out.println(sortType + " sort (sorted): " + timeSorted + " ns");
			}

			// Searching performance test
			System.out.println("\n--- SEARCHING ---");
			int target = randomArr[size / 2]; // Middle element as search target

			// Linear search works on both sorted and unsorted arrays
			for (String searchType : searchTypes) {
				if ("linear".equalsIgnoreCase(searchType)) {
					long timeRandom = measureSearchTime(randomArr, target, searchType);
					long timeSorted = measureSearchTime(sortedArr, target, searchType);
					System.out.println(searchType + " search (random): " + timeRandom + " ns");
					System.out.println(searchType + " search (sorted): " + timeSorted + " ns");
				} else if ("binary".equalsIgnoreCase(searchType)) {
					// Binary search requires sorted array
					long timeSorted = measureSearchTime(sortedArr, target, searchType);
					System.out.println(searchType + " search (sorted array only): " + timeSorted + " ns");
				}
			}
		}
	}
}
