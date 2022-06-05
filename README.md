In this exercise you should parallelize the Mergesort sorting algorithm learned from the lecture. For that, a ForkJoinPool from the standard library can be used.

Benchmark
The BenchmarkApproaches class is already included in the template. The execution of the contained main method performs a benchmark of the three mergesort implementations. If you have not yet implemented all versions, you can simply comment out the relevant benchmark.

The benchmarks do not test the implementation for correctness, but only measure the time that is required for execution!

For the benchmarks you should import the project as a Maven project, for this you have to do the following:
Eclipse: Simply import the project as a Maven project
Maybe do that: https://chat.tum.de/group/NQtiHN7BfDiWMwze8?msg=wyDH3aDKtsPNv2TkB
IntelliJ: After the first import, do this: Shift + Ctrl + A -> Reimport all Maven Projects

If that doesn't work, you can ask your tutor during the exercise.

Classes
You should implement two different variants of the algorithm and then compare them with a sequential variant. The sequential variant is already implemented in the template, as are the methods of the classes ParallelMergeSort andBetterParallelMergeSort.

In order to be able to use a ForkJoinPool, your classes have to implement the abstract classRecursiveAction and the abstract method compute. Within the compute class you can useinvoke and invokeAll to start the execution of furtherRecursiveActions, which are then executed by the ForkJoinPool.

 ParallelMergeSort 0 of 1 tests passing
Complete the class ParallelMergeSort. Every time the array is split into two sub-arrays, the class should submit two tasks to the ForkJoinPool. As soon as your implementation is finished and the public correctness test is successful, test the performance and compare it with the sequential solution!

 BetterParallelMergeSort 0 of 1 tests passing
You should have noticed that ParallelMergeSort is significantly slower than the sequential solution. This is because we are creating new tasks for sorting very small arrays too, and this involves a lot of overhead. A parallel mergesort implementation that is supposed to achieve better performance should therefore create fewer tasks during execution. Complete the class BetterParallelMergeSort, which sorts arrays that are below a certain size sequentially.

You should then empirically determine the boundary between parallel and sequential execution. Try different values ​​for this. Try to find a value that executes fastest for an array of 100,000 elements!

The values ​​can vary depending on the hardware, operating system and other factors. So there is no one-stop solution here!
