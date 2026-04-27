Assignment 3: Algorithm Analysis

A. Project Overview

Comparing the real-world execution times of basic vs advanced sorting and searching algorithms using `System.nanoTime()`.

B. Algorithm Descriptions

Insertion Sort: Slides each element into its correct sorted position. Time: O(n²) average, O(n) best (sorted).

Merge Sort: Halves the array down to 1 element, then merges them back in order. Time: O(n log n) always.

Linear Search: Checks every item one by one from start to finish. Time: O(n).

Binary Search: Checks the middle element and throws away the wrong half. Time: O(log n).

C. Results Summary

(Note: Times in nanoseconds)

Small Arrays (10 items): Insertion Sort (~7k ns) and Linear Search (~1k ns) win because simpler algorithms have less memory overhead.

Large Arrays (1000 items): Merge Sort (~288k ns) destroys Insertion Sort (~4.5m ns). Binary Search (~5k ns) beats Linear Search (~20k ns).

Sorted Data: Insertion sort runs almost instantly on sorted arrays (~7k ns) compared to random arrays.

D. Analysis Questions

1. Which sort is faster? Merge Sort is vastly faster on large arrays because its O(n log n) math scales much better than Insertion Sort's O(n²).

   
2. Input size impact? When array size increases 10x, Insertion sort time increases 100x (quadratic). Merge sort time only increases slightly.

   
3. Sorted vs Unsorted? Insertion sort is extremely fast on sorted data because it only makes one comparison per element. Merge sort speed stays about the same either way.

   
4. Matches Big-O? Yes. The execution times perfectly match the expected mathematical growth curves.

   
5. Which search is faster? Binary Search is faster for large data, but Linear Search is required if the data is unsorted.

    
6. Why Binary needs sorted arrays: It assumes the left half is smaller and the right half is larger. If unsorted, throwing away half the array might delete the target number.
    
E. Screenshots

[not yet]

F. Reflection

I learned that Big-O notation is very real—O(n²) algorithms practically break on large datasets while O(n log n) handles them easily. The biggest difference between theory and practice is that on tiny arrays (10 elements), the "worse" algorithms are actually faster due to less setup overhead. The main challenge was realizing my Binary Search was returning -1 on random arrays until I realized it mathematically only works on pre-sorted data.

