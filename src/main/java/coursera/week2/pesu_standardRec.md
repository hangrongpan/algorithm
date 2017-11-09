## Standard Recurrence format
### Base case:
T(n) < a (constant) for all sufficient enough small n
### General Case
For larger value of n, 
T(n) <= a.T(n/b) + O(n^d)
### Parameters: 
1. a: number of recursive calls
2. b: input size shrinkage factor
3. d: exponent in runtime of the "combine step"