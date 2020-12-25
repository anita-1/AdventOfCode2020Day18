import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day3Main
{
    public static void main(String[] args) throws Exception
    {
        //get file
        File file = new File("C:\\Users\\unebe\\Documents\\2020 F\\AdventOfCode\\input.txt");

        //read file
        BufferedReader br = new BufferedReader(new FileReader(file));

        //variables info
        ArrayList<String> inputLines = new ArrayList<String>();


        //add each line to lines
        String line;
        while ((line = br.readLine()) != null)
        {
            inputLines.add(line);
        }


        //array list store numTrees for each slope
        ArrayList<Integer> eaNumTrees = new ArrayList<Integer>();

        //given slopes
        //right 3, down 1
        int[][] slopes =    {
                            {1, 1},
                            {3, 1},
                            {5, 1},
                            {7, 1},
                            {1, 2}
                            };

    /*
        //visualize 2d array
        for (int i = 0; i < 5; i++) //rows
        {
            for (int j = 0; j < 2; j++) //columns
            {
                System.out.println("arr[" + i + "][" + j + "] = " + slopes[i][j]);
            }
        }

     */

        //how many slopes
        int numsOfSlopes = slopes.length;

        //put result of numTrees of each slope into eaNumTrees
        for(int eaSlope = 0; eaSlope < numsOfSlopes; eaSlope++)
        {
            eaNumTrees.add(treesWhenSlopeIs(inputLines, slopes[eaSlope][0], slopes[eaSlope][1]));
        }
        System.out.println(eaNumTrees);

        //multiply all numTrees to get product
        long product = eaNumTrees.get(0);
        for(int index = 1; index < eaNumTrees.size(); index++)
        {
            product = product * eaNumTrees.get(index);
        }
        System.out.println(product);

    }

    //return num of trees with slope config
    static int treesWhenSlopeIs(ArrayList<String> listLines, int right, int down)
    {
        //info
        int numTrees = 0;
        char tree = '#';
        int cols = listLines.get(0).length();

        //amount of right
        int indexRight = 0;

        //go through input until finish at last line
        for(int lineNum = 0; lineNum < listLines.size(); lineNum++)
        {
            String activeLine = listLines.get(lineNum);
            char activeChar = activeLine.charAt(indexRight % cols); //% cols prevents out of bounds
            if(activeChar == tree)
            {
                numTrees++;
            }

            //toggle amount down
            if(down != 1)
            {
                lineNum = lineNum + down - 1;
            }

            //toggle amount right
            indexRight = indexRight + right;
        }
        //return num of trees given input and slope
        return numTrees;
    }
}
