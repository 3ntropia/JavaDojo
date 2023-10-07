# Plus Minus
Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the decimal value of each fraction on a new line with
places after the decimal.

Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to
are acceptable.

## Example
`arr=[1,1,0,-1,-1]`
There are elements `n=5`, two positive, two negative and one zero. Their ratios are `2/5=0.40000`, `2/5=0.40000` and `1/5=0.20000`. 
Results are printed as:
```
0.40000
0.40000
0.20000
```
## Function Description

Complete the plusMinus function in the editor below.

plusMinus has the following parameter(s):

    int arr[n]: an array of integers

## Print
Print the ratios of positive, negative and zero values in the array. Each value should be printed on a separate line with
digits after the `6` decimal. The function should not return a value.  
## Output Format

Print the following
lines, each to

decimals:
```
    proportion of positive values
    proportion of negative values
    proportion of zeros
```

## Sample Input
`arr = [-4, 3, -9, 0, 4, 1]`

## Sample Output

```
0.500000
0.333333
0.166667
```