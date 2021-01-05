Project: Advent of Code 2020
Author: Anita Luo

File: Day4Main.java
Date: 01/04/2021

Description:
confirm data is present and fit the parameters

Assumptions:
each data is separated is a blank line, info for parameters is behind <:>

Technical use:
Java
readFile, ArrayList, int, try catch statements, String, String methods

Approach:
go through file and make an ArrayList where each line is one passport
    if contains specific data needed:
        isolate that String
        manipulate String
        compare String to parameters
    if all specific data, add to int
print int


Example Input:
eyr:1972 cid:100
hcl:#18171d ecl:amb hgt:170 pid:186cm iyr:2018 byr:1926

iyr:2019
hcl:#602927 eyr:1967 hgt:170cm
ecl:grn pid:012533040 byr:1946

hcl:#888785
hgt:164cm byr:2001 iyr:2015 cid:88
pid:545766238 ecl:hzl
eyr:2022

iyr:2010 hgt:158cm hcl:#b6652a ecl:blu byr:1944 eyr:2021 pid:093154719

Example Output:
2
* * *