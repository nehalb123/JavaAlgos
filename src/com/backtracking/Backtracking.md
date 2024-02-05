### Rules for Recursion

[Simple Recursion Intro:](https://web.stanford.edu/class/archive/cs/cs106b/cs106b.1206/lectures/intro-to-recursion/) Faster Power Example, i.e. find power of a number in O(log n) using recursion.

<img width="600" alt="image" src="https://user-images.githubusercontent.com/17683048/219816743-e39a3df8-1b4f-4d07-85ae-24b69edf2f41.png">

#### 1. `Express the problem in terms of index and think what should be the parameters of the function.`
#### 2. `Explore all possiblities (pick and not pick)`
#### 3. `What outcome are we expecting e.g. max(all possibilities)`
#### 4. `Think of base case in terms of single element`

### Easy way to approach backtracking problem is by drawing the state-tree diagram.

![image](https://user-images.githubusercontent.com/17683048/148861680-42fc6a99-7bd5-42f8-9467-331fae8239b5.png)
![image](https://user-images.githubusercontent.com/17683048/148861707-9357c700-5c72-4ee3-8671-e8ed54f10648.png)

### Note 👇 : There should be one more recursion call for not pick before return false; `if(f() == true)`

![image](https://user-images.githubusercontent.com/17683048/148861736-4b0af3b7-d1fe-4c6f-9a83-e663641ff401.png)
![image](https://user-images.githubusercontent.com/17683048/148861759-adecddf1-ac43-47af-9012-848ed1588f29.png)



