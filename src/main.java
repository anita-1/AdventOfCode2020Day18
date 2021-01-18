import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Day18MathMain
{
    public static void main(String[] args) throws Exception
    {
        //get file
        File file = new File("C:\\Users\\unebe\\Documents\\2020 F\\AdventOfCode\\input.txt");

        //read file
        BufferedReader br = new BufferedReader(new FileReader(file));

        //add each line to lines
        String line;
        ArrayList<String> lines = new ArrayList<String>();
        while ((line = br.readLine()) != null)
        {
            lines.add(line);
        }

        //amount of lines
        int numLines = lines.size();

        //info
        String space = new String(" ");
        ArrayList<String> chars = new ArrayList<String>();
        long sum = 0;

        //for each line find result and then total sum
        for(int i = 0; i < numLines; i++)
        {
            line = lines.get(i);
            for(int j = 0; j < line.length(); j++)
            {
                if(!space.equals("" + line.charAt(j)))
                {
                    chars.add("" + line.charAt(j));
                }
            }

            //prints
            System.out.println(chars);
            //System.out.println("before sum: " + sum);
            long result = findSum(chars);
            System.out.println("result: " + result);
            sum = sum + result;
            System.out.println("totalsum" + (i + 1) + ": " + sum);
            //System.out.println();

            //clear chars
            chars.clear();
        }
    }

    //find the sum of a chars list, chars list unedited, as parenthesis
    static long findSum(ArrayList<String> charsList)
    {
        //info
        long sum = 0;
        int indexOpen = 0;
        int indexClose = 0;
        int numBraces = Collections.frequency(charsList, "(");

        //do math on inside of pairs of parenthesis and get rid of them
        for(numBraces = numBraces; numBraces > 0; numBraces--)
        {
            //create a new arraylist to store chars in parenthesis
            ArrayList<String> newChars = new ArrayList<String>();

            //find first index of )
            indexClose = charsList.indexOf(")");

            //add elements from 0 to )
            for(int index = 0; index < indexClose; index++)
            {
                newChars.add(charsList.get(index));
            }

            //find the last index of ( inside new list of chars
            indexOpen = newChars.lastIndexOf("(");

            //remove beginning to ( of list of chars
            for(int index = 0; index < indexOpen; index++)
            {
                newChars.remove(0);
            }

            //remove ( inside of new list of chars
            newChars.remove(0);

            //send new list of chars to mathString to get result
            long resultIt = mathString(newChars);

            //make long to String
            String resultItS = "" + resultIt;

            //remove used elements from charsList
            for(int times = 0; times < (indexClose - indexOpen + 1); times++)
            {
                charsList.remove(indexOpen);
            }

            //put sum back into charsList
            charsList.add(indexOpen, resultItS);
        }

        //parenthesis are done, if still has math, send to mathString, otherwise get index 0
        if(charsList.size() > 1)
        {
            sum = mathString(charsList);
        }else
        {
            sum = Integer.parseInt(charsList.get(0));
        }

        //return sum
        return sum;
    }

    //find the sum of a chars list, chars list is only math
    static long mathString(ArrayList<String> charsList)
    {
        //info
        //long mathResult = Long.parseLong(charsList.get(0));
        long mathResult = 0;
        int numAdds = Collections.frequency(charsList, "+");

        //do addition on the elements and get rid of them
        for(numAdds = numAdds; numAdds > 0 ; numAdds--)
        {
            //info
            int index = charsList.indexOf("+");
            long valPrev = Long.parseLong(charsList.get(index - 1));
            long valNext = Long.parseLong(charsList.get(index + 1));
            long resultHere = valPrev + valNext;
            String  resultHereS = "" + resultHere;

            //remove
            charsList.remove(index - 1);
            charsList.remove(index - 1);
            charsList.remove(index - 1);

            //add
            charsList.add((index - 1), resultHereS);

        }

        //if theres anything left, do multiplications, otherwise return first element
        if(charsList.size() > 1)
        {
            mathResult = mulString(charsList);
        }
        else
        {
            mathResult = Long.parseLong(charsList.get(0));
        }

        //return math result
        return mathResult;
    }

    //find the sum of a chars list, chars list is only multiply
    static long mulString(ArrayList<String> charsList)
    {
        //info
        //start w first element of result
        long mulResult = Long.parseLong(charsList.get(0));

        //iterate through list and multiply
        for(int index = 1; index < charsList.size(); index++)
        {
            mulResult = mulResult * Long.parseLong(charsList.get(index + 1));
            index++;
        }

        //return result
        return mulResult;
    }
}

