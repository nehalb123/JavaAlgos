## Next Greater Element

### Using a Stack

To speed things up, what we can do is use an auxiliary data
structure that helps us keep track of comparisons. Why don't we use a stack?

With a stack, instead of nested loop, we can do one pass instead. This is done by using the follow pseudocode:

**Step 1**: 
-   Push the first element to the stack.<br><br>
    ![image](https://user-images.githubusercontent.com/17683048/136673704-dc34b4a5-0f09-41eb-bdd7-0e98ffac1a8a.png)


**Step 2/3**: Iterate through the rest of the elements in a 
for-loop.

1.  Mark the iterated on/current element as the `next` element.
2.  If stack is not empty, compare top element of the stack 
with `next`.
3.  If `next` is greater than the top element, pop the element 
from the stack. What this means is that we've determined 
    `next` is the next greater element for the popped number.
While the popped element is smaller than `next`, keep popping
    off the top of the stack. As the logic follows, `next` 
    becomes the next greater element for all the popped 
    elements.
    <br><br>
    ![image](https://user-images.githubusercontent.com/17683048/136673711-4dd080de-2dd0-4a3d-b92b-784e2f65c2a9.png)

