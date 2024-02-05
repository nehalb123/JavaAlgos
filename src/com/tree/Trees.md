##Trees 🌳

####Properties:
    1.  Trees do not contain a cycle.
    2.  Tree with 'n' nodes has 'n-1' edges

### Construct a tree from traversal

#### Will you be able to construct a tree uniquely?

From a **preorder traversal** we have only information about root, but we don’t know up to which part is its left subtree 
and which is right subtree. Actually we can construct Catalan(n) number of trees from its preorder traversal where 
`Catalan(n)` is `nth Catalan number`

Same goes for inorder, postorder traversal too. <span style="color:#ED8B76">So, it’s confirmed that we can’t convert to a 
unique binary tree from only one traversal.</span> So we need at least two. But is it possible for any two condition?

1. Inorder & preorder: We can construct a unique binary tree from its preorder & inorder traversals.
2. Inorder & postorder: We can construct a unique binary tree from its postorder & inorder traversals.
3. Postorder & preorder: We <span style="color:#ED8B76">can't</span> construct a unique binary tree from its preorder & postorder traversals.

<br>

![image](https://user-images.githubusercontent.com/17683048/153769466-ef437243-7db0-4eb9-abda-2a5333c63579.png)

<br>

### Construct a tree from inorder and preorder:

1.  Preorder gives us the root.
2.  Find this root in inorderMap
3.  Recursively repeat the process until you are 
left with a single node. Attach the nodes when recursion is unrolling. <br><br>
![Construction](https://user-images.githubusercontent.com/17683048/133401473-e725873b-8351-4a0b-a132-ce1b2ea5a485.png) 


### BSTs

#### Seach, Insert and Delete in BST

1. For searching a value in a sorted array, we could have performed binary search. This will take `O(log n)` time. Search operation in BST will be very similar. we start with a search space of ‘n’ nodes and as we discard one of the sub-trees, we discard ‘n/2’ nodes so our search space gets reduced to ‘n/2’. In the next step, we reduce the search space to ‘n/4’ and we repeat until we find the element or our search space is reduced to only one node. Time Complexity: `O(h)`

2. Inserion: `O(h)`

3. Deletion: `O(h)`

#### Following are some important points in favor of BSTs.

1. We can get **all keys in sorted order** by just doing Inorder Traversal of BST. This is not a natural operation in Hash Tables and requires extra efforts.
2. Doing **order statistics, finding closest lower and greater elements, doing range queries** are easy to do with BSTs. Like sorting, these operations are not a natural operation with Hash Tables.
3. BSTs are easy to implement compared to hashing, we can easily implement our own customized BST. To implement hashing, we generally rely on libraries provided by programming languages.
4. With Self-Balancing BSTs, all operations are guaranteed to work in `O(log n)` time. But with hashing, `Θ(1)` is average time and some particular operations may be costly i.e, `O(n^2)`, especially when table resizing happens.
5. In BST we can do range searches efficiently but in hash Table we cannot do range search efficienly.
6. BST are memory efficient but hash table is not.

![image](https://user-images.githubusercontent.com/17683048/200789219-6c99bd7f-09be-46c3-b3f2-19019364f653.png)


