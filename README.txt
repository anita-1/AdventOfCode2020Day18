File: Day18MathMain
Author: Anita Luo
Date: 12/23/2020

Description:
Find the sum of each line of input using specific operation priorities.
Left to right, parenthesis, addition, then multiplication

Assumptions:
Each line consists of integers, *, (, )

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

Technical use:
Java
data types: long, ArrayList