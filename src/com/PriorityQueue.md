##Priority Queues

💻 [code here](./heap/MinHeap.java)

1.  Time Complexity to build a heap: `O(n)`
    

2.  <i>Time Complexity to insert</i>: <br>
    In the **worst case**, we need one swap at each level of 
    the tree. So the total number of the swaps would be 
    equal to the height of the heap tree. The height of a 
    balanced complete tree with N number of nodes is `log N`.
    Each swap takes `O(1)` time.
    <br> <br>
    Time taken to insert a node: `O(log N)`

<table border="0"><tbody><tr><th>Operations</th>
				<th>peek</th>
				<th>insert</th>
				<th>delete</th>
			</tr><tr><td>Linked List</td>
				<td><code>O(1)</code></td>
				<td><code>O(n)</code></td>
				<td><code>O(1)</code></td>
			</tr><tr><td>Binary Heap</td>
				<td><code>O(1)</code></td>
				<td><code>O(log n)</code></td>
				<td><code>O(log n)</code></td>
			</tr><tr><td>Binary Search Tree</td>
				<td><code>O(1)</code></td>
				<td><code>O(log n)</code></td>
				<td><code>O(log n)</code></td>
			</tr></tbody></table>


Notice that both BSTs and Heaps can perform the operations in similar time.

### Why do we choose heaps for operations of priority queues?

* Since binary heap is implemented using arrays, there is always better locality of reference and operations are more cache friendly.
*  We can build a binary heap in `O(n)` time. Self Balancing BSTs require `O(n logn)` time to construct.
*  Binary heap doesn’t require extra space for pointers.
  Binary heap is easier to implement.
*  There are variations of binary heap like Fibonacci Heap that can support insert and decrease-key in `Θ(1)` time

### Building a Heap

1. Iterated insertion will take: `O(n logn)` time.


2. Linear Build Heap Operation
    <br>  
    <img alt="image" src="https://user-images.githubusercontent.com/17683048/179423883-216bf914-a9c2-49a0-a082-11e715dc0a4d.png">