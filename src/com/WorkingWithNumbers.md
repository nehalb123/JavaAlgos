1.  Integer ~ 2 * 10<sup>9</sup> <br>
    Long ~ 9 * 10<sup>18</sup>


2.  A common mistake when using the type long long is that the type
    int is still used somewhere in the code.
    ```
    int a = 123456789;
    long b = a*a;
    cout << b << "\n"; // -1757895751
    ```
    The problem can be solved by changing the type of a to 
    long or by changing the expression to `(long)a*a`.


3.  Floating point number can't be represented accurately in Java/C++.
    ```
    double x = 0.3*3+0.1;
    System.out.println(x); //0.9999999999999999
    ```
    It is risky to compare floating point numbers with 
    the `==` operator, because it is possible that the 
    values should be equal but they are not because of 
    precision errors. A better way to compare floating 
    point numbers is to assume that two numbers are equal 
    if the difference between them is less than `ε`,
    
    ```
    if (abs(a-b) < 1e-9) {
        // a and b are equal
    }
    ```


4.  Consider for overflows in the calculations:
    mid = left + (right-left)/2;


5.  For Arrays questions:
    1. Visualize using continuous histogram
    2. Use index as implicit counter


6.  When a sorted array is given things that must come to mind:
    1. Binary Search
    2. Two pointer technique -> Three Sum, Container with most water.

    Consider using max & min functions.



Best Trick:
Meditate before the interview. :)