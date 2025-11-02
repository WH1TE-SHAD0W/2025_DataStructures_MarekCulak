# Performance Measurement
Tables inserted with results as nanoseconds converted into a markdown form the output of the PerformanceMethods.

Example output: [[5270.0, 4243.0, 3883.0], [4.2849892E7, 3455374.0, 2.1715094E7]]
A 2D list, which in practice is a table.

## Method Add
Logic 
- LinkedList:
Takes the string, makes a new Node and makes it a tail. 

- ArrayList:
Verifies the size and puts the string to the end of the data in the array. This could make the list expand due to reached 
capacity. 

Both lists use the simple short algorithm to put it to the end. The complexity is not tied to the list length. Although, 
the LinkedList uses less overhead for validation. 

|        Add |  Run 1 |  Run 2 |  Run 3 |
|-----------:|-------:|-------:|-------:|
|  ArrayList | 7772.0 | 5023.0 | 6849.0 |
| LinkedList | 2970.0 |  798.0 | 1924.0 |

## Method Get
In LinkedList the complexity is based on the length of the list. It has to loop until it gets to the desired Node. O(n) 
notation.

ArrayList uses the direct access, which makes it significantly faster.


|        Get |      Run 1 |      Run 2 |       Run 3 |
|-----------:|-----------:|-----------:|------------:|
|  ArrayList |     4988.0 |     3419.0 |      4945.0 |
| LinkedList | 8.161938E7 | 4.462444E7 | 1.0155175E7 |

## Method remove
In the ArrayList the loop get from the point of the index until the end, where as at the LinkedList it has to find the
Node, once found it just swaps the Node its pointing to the next one. 

|     Remove |        Run 1 |        Run 2 |       Run 3 |
|-----------:|-------------:|-------------:|------------:|
|  ArrayList | 1.96732437E8 | 1.27460595E8 | 1.7261053E8 |
| LinkedList |  1.2998583E7 |   4.289965E7 | 2.1959677E7 |
