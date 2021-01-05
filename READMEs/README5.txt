File: Day5Main.java
Date: 01/04/2020

Description:
part 1: get specific number by manipulating ranges using midpoint
part 2: find missing number in range

Assumptions:
each line is 10 characters
0-6 is either a <F> or <B>
7-9 is either a <L> or <R>

Technical use:
java
readFile, ArrayList, Collections

Approach:
read in each line
read each character
manipulate ranges of numbers
compute unique number
add unique numbers to list
sort list
find max number
find missing number


Example Input:
BFFFBBFRRR
FFFBBBFRRR
BBFFBBFRLL

Example Output:
row 70, column 7, seat ID 567
row 14, column 7, seat ID 119
row 102, column 4, seat ID 820
maxSeatID:820