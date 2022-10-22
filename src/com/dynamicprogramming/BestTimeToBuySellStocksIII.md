## Best Time to Buy & Sell Stocks III

#### Let's write a recursive solution first
<img width="600" alt="image" src="https://user-images.githubusercontent.com/17683048/195689376-fe27753a-9bdf-45a8-b4e4-22be2f776d3b.png">

#### We can cache the values of the recursion trees that are repeated to speed up computation
<img width="600" alt="image" src="https://user-images.githubusercontent.com/17683048/195689806-392da595-3189-4094-a387-1b65a4f83d11.png">

<img width="600" alt="image" src="https://user-images.githubusercontent.com/17683048/195689907-4feff3fc-f43e-4776-a08a-9965ee9ee48a.png">

#### As the memoized solution still has auxillary stack space, we remove it by tabulation
<img width="600" alt="image" src="https://user-images.githubusercontent.com/17683048/195691574-03b345a7-afab-46c0-a8c3-148262dc5164.png">
<img width="600" alt="image" src="https://user-images.githubusercontent.com/17683048/195699959-a40cd14b-8f1a-402c-bc7a-694663216533.png">
<img width="600" alt="image" src="https://user-images.githubusercontent.com/17683048/195728276-06f6a046-5cde-4521-8f3c-7b2d9560798a.png">

