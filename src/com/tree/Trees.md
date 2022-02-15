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
