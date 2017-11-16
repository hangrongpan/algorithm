## Merge
### Input: sorted array C and D
### Output: sorted array B(length n)
### Implementation:
```
i:=1, j:=1; 
for k:=1 to n do    
    if C[i] < D[i]  
        B[k] := C[i++]  
    else    
        B[k] := D[i++]  
```
### TODO 
Add merge sort implementation.
