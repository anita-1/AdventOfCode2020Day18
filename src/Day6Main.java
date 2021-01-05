import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day6Main
{
    public static void main(String[] args) throws Exception
    {
        //get file
        File file = new File("C:\\Users\\unebe\\Documents\\2020 F\\AdventOfCode\\input.txt");

        //read file
        BufferedReader br = new BufferedReader(new FileReader(file));

        //list of each group
        ArrayList<String> eachGroupList = new ArrayList<String>();
        String line = "";
        String eachGroup = "";
        while ((line = br.readLine()) != null)
        {
            eachGroup = eachGroup + line;
            if(line.isBlank())
            {
                eachGroupList.add(eachGroup);
                eachGroup = "";
            }
        }
        eachGroupList.add(eachGroup);
        System.out.println(eachGroupList);

        ArrayList<Integer> sumEach = new ArrayList<Integer>();
        for(int indexGroup = 0; indexGroup < eachGroupList.size(); indexGroup++)
        {
            ArrayList<Character> charsYes = new ArrayList<Character>();
            for(int indexEach = 0; indexEach < eachGroupList.get(indexGroup).length(); indexEach++)
            {
                if(!charsYes.contains(eachGroupList.get(indexGroup).charAt(indexEach)))
                {
                    charsYes.add(eachGroupList.get(indexGroup).charAt(indexEach));
                }
            }
            //System.out.println("size of each group:" + charsYes.size());
            sumEach.add(charsYes.size());
        }

        int sum = 0;
        for(int indexSums = 0; indexSums < sumEach.size(); indexSums++)
        {
            sum = sum + sumEach.get(indexSums);
        }
        System.out.println(sum);
    }
}
