import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day4Main
{
    public static void main(String[] args) throws Exception
    {
        //get file
        File file = new File("C:\\Users\\unebe\\Documents\\2020 F\\AdventOfCode\\test.txt");

        //read file
        BufferedReader br = new BufferedReader(new FileReader(file));

        //variables info
        ArrayList<String> inputLines = new ArrayList<String>();

        //add each line to lines
        String line;
        String eachPass = "";
        while ((line = br.readLine()) != null)
        {
            eachPass = eachPass + " " + line;
            //System.out.println("each : " + eachPass);
            if (line.isBlank())
            {
                inputLines.add(eachPass);
                eachPass = "";
            }
        }
        inputLines.add(eachPass);
        //System.out.println(inputLines);

        int numValid = 0;
        for(int index = 0; index < inputLines.size(); index++)
        {
            String pass = inputLines.get(index);
            if( pass.contains("byr") &&
                    pass.contains("iyr") &&
                    pass.contains("eyr") &&
                    pass.contains("hgt") &&
                    pass.contains("hcl") &&
                    pass.contains("ecl") &&
                    pass.contains("pid") )
            {
                numValid++;
            }
        }
        System.out.println(numValid);
    }
}
