File: Day2Main.java
Date: 12/24/2020

Description:
parse lines, find number of lines fulfill rule
rule -xor chars at 2 places

Assumptions:
format of each line -<integer>-<integer> <charKey>: <password>

Technical use:
Java
read File, ArrayLists, ints

Approach:
parse each line as String, get info
do comparisions
 add to variable
print variable


Example Input:
1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc

Example Output:
1
* * *