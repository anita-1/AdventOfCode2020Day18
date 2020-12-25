Project: Advent of Code 2020
Author: Anita Luo

* * *
File: Day1Main.java
Date: 12/24/2020

Description:
find elements to sum to something, multiply those elements together to get result

Assumptions:
each input line is an integer

Technical use:
Java
read File, ArrayList, Integers

Approach:
nested for loops
element + all elements after
compare
print result

Example Input:
1721
979
366
299
675
1456

Example Output:
241861950

* * *
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
File: Day18MathMain.java
Date: 12/23/2020

Description:
Find the sum of each line of input using specific operation priorities.
Left to right, parenthesis, addition, then multiplication

Assumptions:
Each line consists of integers, *, (, )

Technical use:
Java
read File, long, ArrayList

Approach:
Read file
Read each line
linear iteration
Extract inside the insides of parenthesis from left to right in findSum() and send to mathString()
Find addition sum in mathString()
    do additions
        remove the used elements
        add the result back into list
    if there are other elements after the additions, send to mulString() otherwise send result back to findSum()
Find product result in mulString()
    send result back to mathString()
remove used elements
add result sum back into list
next parenthesis
return line sum to main()
Add line sum to product


Example Input:
1 + (2 * 3) + (4 * (5 + 6))
2 * 3 + (4 * 5)
5 + (8 * 3 + 9 + 3 * 4 * 3)
5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))
((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2

Example Output:
"C:\Program Files\Java\jdk-12.0.2\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.3.3\lib\idea_rt.jar=52487:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2019.3.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Users\unebe\Documents\2020 F\AdventOfCode\out\production\AdventOfCode" Day18MathMain
[1, +, (, 2, *, 3, ), +, (, 4, *, (, 5, +, 6, ), )]
result: 51
totalsum1: 51
[2, *, 3, +, (, 4, *, 5, )]
result: 46
totalsum2: 97
[5, +, (, 8, *, 3, +, 9, +, 3, *, 4, *, 3, )]
result: 1445
totalsum3: 1542
[5, *, 9, *, (, 7, *, 3, *, 3, +, 9, *, 3, +, (, 8, +, 6, *, 4, ), )]
result: 669060
totalsum4: 670602
[(, (, 2, +, 4, *, 9, ), *, (, 6, +, 9, *, 8, +, 6, ), +, 6, ), +, 2, +, 4, *, 2]
result: 23340
totalsum5: 693942

Answer: 693942
