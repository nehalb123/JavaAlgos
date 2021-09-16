##Linked Lists 🚃-🚃-🚃

1.  <b>Cycle Detection/ Floyd's Algorithm:</b>
    Use `slow` and `fast` pointers to detect the loop. Similar to how
    a fast runner catches up a slow runner while running in a circular
    track, these pointers meet and prove that there exists a loop.
    

2.  <b>Starting point of a loop in LL:</b>
    Provided that `X` is the length from head to the start point of loop and
    `Y` is the length of the loop. We know slow pointer moves `t` steps, while fast
    pointer moves `2t` steps. They meet at `K`, where `K` is the length from the start
    point of the loop.

    Then we have :

    ```
    t = X + nY + K (For slow pointer)
    2t = X + mY + K (For fast pointer)
    ```

    , then we get

    ```
    X + K  =  (m-2n)Y
    X = cY - K  [c = m-2n]
    X = Y - K  [c = 1, c can be anything, it really doesn't matter]
    ```
    This suggests that when we move the same number of steps from the point where 
    they meet and from the head. We get the start point of the loop.
    

3.  