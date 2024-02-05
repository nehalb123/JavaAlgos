### Endianess

- Endianess is not a problem when we are dealing with a single computer. However, it needs to dealt with when sending bytes through the network or writing it to disk.
- Little and big endian are two ways of storing multibyte data-types ( int, float, etc).
- Hint to remember: if **L**SB at **L**ower address then, Little Endian.


<img width="600" alt="image" src="https://user-images.githubusercontent.com/17683048/209499368-edf91672-c72d-4a53-b579-6c11afc1472c.png">


<br>


#### Code to check if the machine is little endian or big endian

<img width="600" alt="image" src="https://user-images.githubusercontent.com/17683048/214031094-e5b89a3c-4d06-4087-96b5-ddd36b829ee5.png">