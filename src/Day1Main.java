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
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while ((line = br.readLine()) != null)
        {
            nums.add(Integer.parseInt(line));
        }

        //amount of lines
        int numLines = nums.size();

        //number of for loops = amount of elements to add to compare
        for(int index1 = 0; index1 < (numLines - 2); index1++)
        {
            for(int index2 = (index1 + 1); index2 < (numLines - 1); index2++)
            {
                for(int index3 = (index2 +1); index3 < numLines; index3++)
                {
                    int result = nums.get(index1) + nums.get(index2) + nums.get(index3);
                    //if result, then print and break
                    if(result == 2020)
                    {
                        System.out.println(nums.get(index1) * nums.get(index2) * nums.get(index3));
                        break;
                    }
                }

            }
        }

        //System.out.println(nums);
    }
}
