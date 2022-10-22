## Knapsack Problems

1.  Fractional Knapsack - Greedy
    
2.  0/1 Knapsack (DP)
    
3.  Unbounded Knapsack (DP) - Coin Change, Rod Cutting

### Fractional Knapsack

* Calculate the ratio(value/weight) for each item.
* Sort all the items in decreasing order of the ratio.

```

- store ratios in a list i.e. items
- sort it 

for item in items:
    if capacity >= item.wt:
        capacity -= item.wt
        totalValue += item.value
    else:
        totalValue += capacity*ratio
        break

return totalValue
```

### 0/1 Knapsack

**Problem Statement:** Given a set of n items numbered from 1 up
to n, each with a weight w<sub>i</sub> and a value v<sub>i</sub>, along with a 
maximum weight capacity W, **_maximize the sum of the values_** of 
the items in the knapsack so that the **_sum of the weights is 
less than or equal to the knapsack's capacity_**.

What is 0/1? -> items cannot be broken which means we should
take the item as a whole or should leave it.


![image](https://user-images.githubusercontent.com/17683048/158238054-76d92e64-c9b5-4912-a347-81ec88f9a4b7.png)


**Space Optimization:** As we are only using previous row of the table to compute the current results, we keep only the previous row