This question is a great example of dynamic programming!

Firstly, we can represent valid strings as a state 
machine using the information we're given.

![image](https://user-images.githubusercontent.com/17683048/137417917-1fd06d91-0e06-4a3d-a567-e6017b9d6376.png)


In order to count how many valid strings there are of
length n, we need to use dynamic programming. One way
of doing this is to start with strings of length 1, 
and then consider adding 1 letter at a time, until we
have n letters.

So, we iterate from 1 to n, and at each step we 
determine how many strings of the current length 
could end with each letter, by extending the strings 
one size smaller. With n=1, there is exactly 1 option
for each (the string containing only that letter).

For n = 2, we now need to think about which letters 
the current letter we’re considering could have 
followed. For example, an “a” is could appear after 
an `“e”, “i”, or “u”`, but not after an “a” or an “o” 
as the information we’re given forbids this. Therefore,
the number of strings ending in an “a” is the sum of 
all the strings whose previous letter was `“e”, “i”, 
or “u”.`

We then need to look at our diagram above, to determine what letters each letter could have come out of (look at the arrows in the diagram in reverse to obtain this information).

`“a”` can follow any of `{“e”, “i”, “u”}`.<br>
`“e”` can follow any of `{“a”, “i”}`.<br>
`“i”` can follow any of `{“e”, “o”}`.<br>
`“o”` can follow `{“i”}`.<br>
`“u”` can follow any of `{“i, “o”}`.<br>

![image](https://user-images.githubusercontent.com/17683048/137417991-f2cc733c-459b-4493-b5a2-40357af5594f.png)


If we need to know how many strings are of length 7, 
we can add the 7th column 77 + 65 + 45 + 25 + 37 = 249.