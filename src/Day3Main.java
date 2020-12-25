import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day3Main
{
    public static void main(String[] args) throws Exception
    {
        //get file
        File file = new File("C:\\Users\\unebe\\Documents\\2020 F\\AdventOfCode\\test.txt");

        //read file
        BufferedReader br = new BufferedReader(new FileReader(file));

        //add each line to lines
        String line;
        while ((line = br.readLine()) != null)
        {
            int cols = line.length();
            System.out.println(cols);
        }
    }
}
