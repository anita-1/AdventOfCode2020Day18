File: Day3Main.java
Date: 12/25/2020

Description:
parse lines, find char in line given how much down and right, compare character to <>, count result
find product of all results

Assumptions:
format of each line consists of <.> and <#>

Technical use:
Java
read File, ArrayLists, 2 dimensional arrays, int, long

Approach:
parse each line
go through lines and find char to compare
char found by adding const right value to var
compare chars
return result
find product


Example Input:
..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#

Example Output:
[2, 7, 3, 4, 2]
336
* * *