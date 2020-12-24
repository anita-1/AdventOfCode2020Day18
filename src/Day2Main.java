import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Day2Main
{
    public static void main(String[] args) throws Exception
    {
        //get file
        File file = new File("C:\\Users\\unebe\\Documents\\2020 F\\AdventOfCode\\test.txt");

        //read file
        BufferedReader br = new BufferedReader(new FileReader(file));

        //initialize number of valid passwords variable
        int validPswds = 0;

        //add each line to lines
        String line;
        while ((line = br.readLine()) != null)
        {
            //info
            int dashIndex = line.indexOf("-");
            int firstOccur = Integer.parseInt(String.valueOf(line.substring(0, dashIndex)));
            int firstSpaceIndex = line.indexOf(" ");
            int secondOccur = Integer.parseInt(String.valueOf(line.substring((dashIndex + 1), firstSpaceIndex)));
            String key = "" + line.charAt((firstSpaceIndex + 1));
            String pswd = line.substring((line.lastIndexOf(" ") + 1));
            ArrayList<String> pswdChars = new ArrayList<String>();
            for(int index = 0; index < pswd.length(); index++)
            {
                pswdChars.add("" + pswd.charAt(index));
            }
            int freqKey = Collections.frequency(pswdChars, key);
            String charFirst = "" + pswd.charAt((firstOccur - 1));
            String charSecond = "" + pswd.charAt((secondOccur - 1));

            //System.out.println(line + "," + firstOccur + "," + secondOccur + "," + key + "," + pswd + "," + charFirst + "," + charSecond);

            //if charFirst xor charSecond equals the key, add to validPswd
            //System.out.println(charFirst.equals(key));
            //System.out.println(charSecond.equals(key));
            if((charFirst.equals(key) && !(charSecond.equals(key))) || (!charFirst.equals(key) && (charSecond.equals(key))))
            {
                //System.out.println(line);
                validPswds++;
            }
            //System.out.println();
        }

        System.out.println(validPswds);
    }
}
