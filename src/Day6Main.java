import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Day6Main
{
    public static void main(String[] args) throws Exception
    {
        //get file
        File file = new File("C:\\Users\\unebe\\Documents\\2020 F\\AdventOfCode\\input.txt");

        //read file
        BufferedReader br = new BufferedReader(new FileReader(file));


        //PART 2: HOW MANY QUESTIONS ALL PEOPLE ANSWERED 'YES' IN A GROUPS? SUM ALL GROUPS
        String line = "";
        ArrayList<String> ppl = new ArrayList<String>();
        ArrayList<Integer> sums = new ArrayList<Integer>();
        while ((line = br.readLine()) != null)
        {
            //System.out.println(line);
            if(!line.isBlank())
            {
                ppl.add(line);
            }
            else if (line.isBlank())
            {
                sums.add(allYes(ppl));
                //end
                ppl.clear();
            }
        }
        sums.add(allYes(ppl));

        //sum sums
        int sum = 0;
        for(int indexSums = 0; indexSums < sums.size(); indexSums++)
        {
            sum = sum + sums.get(indexSums);
        }
        System.out.println("sum:" + sum);


        //
        //PART 1: HOW MANY QUESTIONS EACH GROUP ANSWERED 'YES'? SUM ALL GROUPS
        /*
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

         */
    }

    static int allYes(ArrayList<String> group)
    {
        //System.out.println(group);
        //find max line and which line that is as person
        int maxIndivAns = 0;
        int person = 0;
        for(int eachPer = 0; eachPer < group.size(); eachPer++)
        {
            //maxIndivAns = Math.max(maxIndivAns, group.get(eachPer).length());
            if(group.get(eachPer).length() > maxIndivAns)
            {
                person = eachPer;
                maxIndivAns = group.get(eachPer).length();
            }
        }
        //System.out.println(maxIndivAns);


        int letters = 0;
        //for each char in person
        for(int maxIndivIndex = 0; maxIndivIndex < maxIndivAns; maxIndivIndex++)
        {
            int manyContains = 0;
            //for each person in group
            for(int eachPer = 0; eachPer < group.size(); eachPer++)
            {
                String thisPer = group.get(eachPer);
                //if person contains character
                if(thisPer.contains("" + group.get(person).charAt(maxIndivIndex)))
                {
                    manyContains++;
                }
            }
            //if all persons have the letter
            if(manyContains == group.size())
            {
                letters++;
            }
        }
        //System.out.println(letters);
        return letters;
    }
}
