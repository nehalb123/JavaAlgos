1. **Design LRU Cache - LeetCode** <br>
   
   LRU - Cache Eviction Policy<br>
   Cache has a limited size. If a page is not present
   in the cache it results in "Page Fault".
   ```
   Pages - 1 2 3 3 2 4 1 5
   Cache:
   1
   2 1
   3 2 1
   3 2 1
   2 3 1
   4 2 3
   1 4 2
   5 1 4
   ```
   * Eliminate Shifting using `Doubly LinkedLists`. <br>
   * Optimize Search using `HashMap<Integer,ListNode>`


2. **Design LFU Cache**


3. **Implement Two Stacks using an array (Easy)**
    1. **Approach 1**:   Divide the array from `mid` and create two stacks.
    This approach is **not** memory efficient. If one half 
        is full it leads to stackoverflow error.
        
    2. **Approach 2**: Grow the stack from two extreme corners of the array.
    First stack grows from <code>0<sup>th</sup></code> index and other from
        <code>n-1<sup>th</sup></code>. Both stacks can grow 
        towards each other with no fixed capacity.


4. **Implement Semaphore**


5. **Implement BlockingQueue**
    
    * A blocking queue is a queue that blocks when you try to dequeue and queue is empty, or if you try to 
      enqueue items and the queue is already full. 
    * A thread trying to dequeue from an empty queue is blocked until some other thread inserts an item into the queue. 
    * A thread trying to enqueue an item in a full queue is blocked until some other thread makes space in the queue, 
      either by dequeuing one or more items or clearing the queue completely.
   
    <p align="left">
   <br>
   <img  src="https://user-images.githubusercontent.com/17683048/146622260-fb7239f9-7add-4bb3-abf0-6e5b96bfc034.png">
   </p>

* **Producer Consumer Problem**
  <br>
  Problem: _Given the common fixed-size buffer, the task is to make sure that the producer can’t add data into the buffer
  when it is full and the consumer can’t remove data from an empty buffer._
   1. Manage shared memory access.
   2. Checking if buffer is full
   3. Checking if buffer is empty.
   


6. **Queue using two stacks** 
    
    <br>
   
   ![image](https://user-images.githubusercontent.com/17683048/153788239-91257884-f4b3-4045-ae05-f962ea7e0306.png)


7. **Min Stack**

    * push(), pop(), getMin() and peek() must be performed in constant time. 
      
    <br>

   ![image](https://user-images.githubusercontent.com/17683048/153789015-244dd519-0259-45f6-9782-41df51d100a0.png)
   ![image](https://user-images.githubusercontent.com/17683048/153789554-72e5dfae-5f33-43d7-a120-b92610f48911.png)


8. **Max Stack**

   * push(), pop(), getMin() and peek() must be performed in minimum time.
   * We use a combination of `doubly linked list` and `tree-map` for faster computation.
   * Time Complexity: `O(logN)` for all operations except peek which is `O(1)`

   <br>
   
   ![image](https://user-images.githubusercontent.com/17683048/154005261-aa74205e-9679-4994-98c3-88170ca25a9c.png)
   ![image](https://user-images.githubusercontent.com/17683048/154005306-bc0bcfd6-1ea4-4812-9f12-0611ab303f3d.png)
