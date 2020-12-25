import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day3Main
{
    public static void main(String[] args) throws Exception
    {
        //get file
        File file = new File("C:\\Users\\unebe\\Documents\\2020 F\\AdventOfCode\\test.txt");

        //read file
        BufferedReader br = new BufferedReader(new FileReader(file));

        //variables info
        ArrayList<String> inputLines = new ArrayList<String>();
        int numTrees = 0;
        char tree = '#';

        //add each line to lines
        String line;
        while ((line = br.readLine()) != null)
        {
            inputLines.add(line);
        }

        //amount of columns
        int cols = inputLines.get(0).length();
        System.out.println(inputLines);
    }
}
