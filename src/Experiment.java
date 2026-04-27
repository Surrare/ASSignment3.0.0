public class Experiment {
	private final Sorter sorter;
	private final Searcher searcher;

	public Experiment(Sorter sorter, Searcher searcher) {
		this.sorter = sorter;
		this.searcher = searcher;
	}

	// Измерение времени сортировки
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

	// Измерение времени поиска
	public long measureSearchTime(int[] arr, int target, String type) {
		int[] copy = arr.clone();
		long start = System.nanoTime();
		searcher.search(copy, target, type);
		long end = System.nanoTime();
		return end - start;
	}

	// Запуск всех экспериментов
	public void runAllExperiments() {
		int[] sizes = {10, 100, 1000};
		String[] sortTypes = {"basic", "advanced"};
		String[] searchTypes = {"linear", "binary"};
		for (int size : sizes) {
			System.out.println("\nArray size: " + size);
			int[] randomArr = sorter.generateRandomArray(size);
			int[] sortedArr = sorter.generateSortedArray(size);

			// Сортировка
			for (String sortType : sortTypes) {
				long timeRandom = measureSortTime(randomArr, sortType);
				long timeSorted = measureSortTime(sortedArr, sortType);
				System.out.println(sortType + " sort (random): " + timeRandom + " ns");
				System.out.println(sortType + " sort (sorted): " + timeSorted + " ns");
			}

			// Поиск
			int target = randomArr[size / 2]; // Середина массива
			for (String searchType : searchTypes) {
				long timeRandom = measureSearchTime(randomArr, target, searchType);
				long timeSorted = measureSearchTime(sortedArr, target, searchType);
				System.out.println(searchType + " search (random): " + timeRandom + " ns");
				System.out.println(searchType + " search (sorted): " + timeSorted + " ns");
			}
		}
	}
}
