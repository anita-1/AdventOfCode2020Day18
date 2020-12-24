import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day1Main
{
    public static void main(String[] args) throws Exception
    {
        //get file
        File file = new File("C:\\Users\\unebe\\Documents\\2020 F\\AdventOfCode\\test.txt");

        //read file
        BufferedReader br = new BufferedReader(new FileReader(file));

        //add each line to lines
        String line;
        ArrayList<String> nums = new ArrayList<String>();
        while ((line = br.readLine()) != null)
        {
            nums.add(line);
        }

        //amount of lines
        int numLines = nums.size();
    }
}
