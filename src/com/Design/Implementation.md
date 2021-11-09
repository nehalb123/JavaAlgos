1. **Design LRU Cache - LeetCode** <br>
   
    LRU - Cache Eviction Policy
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
   Eliminate Shifting using Doubly LinkedLists
   Optimize Search using `HashMap<Integer,ListNode>`


2. **Design LFU Cache**


3. **Implement Two Stacks using an array (Easy)**
    1.  Divide the array from `mid` and create two stacks.
    This approach is **not** memory efficient. If one half 
        is full it leads to stackoverflow error.
        
    2.  Grow the stack from two extreme corners of the array.
    First stack grows from <code>0<sup>th</sup></code> index and other from
        <code>n-1<sup>th</sup></code>. Both stacks can grow 
        towards each other with no fixed capacity.


4. **Implement Semaphore**