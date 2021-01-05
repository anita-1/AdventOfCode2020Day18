File: Day6Main.java
Date: 01/05/2021

Description:
PART 1: HOW MANY QUESTIONS EACH GROUP ANSWERED 'YES'? SUM ALL GROUPS
PART 2: HOW MANY QUESTIONS ALL PEOPLE ANSWERED 'YES' IN A GROUPS? SUM ALL GROUPS

Assumptions:
groups are separated by blank line, each line consists of a-z

Technical use:
java
readFile, ArrayList, String, int

Approach:
PART 1:
    make all persons answers in group in one line
    iterate through line
    if char not in list, add char to list
    return list size
PART 2:
    make group into list
    go to method
        find max length of all persons
        find index in list for that person
        if each person contains the character in maxperson
        add to letters
        return letters
    add letters to sum list
    sum sum list together


Example Input:
abc

a
b
c

ab
ac

a
a
a
a

b

Example Output:
sum:6