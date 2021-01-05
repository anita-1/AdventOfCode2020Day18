import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day4Main
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
        //go through each passport
        for(int index = 0; index < inputLines.size(); index++)
        {
            int partsValid = 0;
            String pass = inputLines.get(index);

            //byr : birth year
            if( pass.contains("byr") )
            {
                String byrStr = pass.substring(pass.indexOf("byr") + 4);
                byrStr = byrStr.substring(0, byrStr.indexOf(" "));
                //System.out.println(byrStr);
                int byrInt = Integer.parseInt(byrStr);
                //System.out.println("byr : " + byrInt);
                if((1920 <= byrInt) && (byrInt <= 2002))
                {
                    partsValid++;
                }
            }
            //System.out.println("***paV: " + partsValid);
            if( pass.contains("iyr") )
            {
                String byrStr = pass.substring(pass.indexOf("iyr") + 4);
                try
                {
                    byrStr = byrStr.substring(0, byrStr.indexOf(" "));
                }
                catch (StringIndexOutOfBoundsException e)
                {

                }
                //System.out.println(byrStr);
                int byrInt = Integer.parseInt(byrStr);
                //System.out.println("iyr : " + byrInt);
                if((2010 <= byrInt) && (byrInt <= 2020))
                {
                    partsValid++;
                }
            }
            //System.out.println("***paV: " + partsValid);
            if( pass.contains("eyr") )
            {
                String byrStr = pass.substring(pass.indexOf("eyr") + 4);
                byrStr = byrStr.substring(0, byrStr.indexOf(" "));
                //System.out.println(byrStr);
                int byrInt = Integer.parseInt(byrStr);
                //System.out.println(" eyr : " + byrInt);
                if((2020 <= byrInt) && (byrInt <= 2030))
                {
                    partsValid++;
                }
            }
            //System.out.println("***paV: " + partsValid);
            if( pass.contains("hgt") )
            {
                String byrStr = pass.substring(pass.indexOf("hgt") + 4);
                if(byrStr.contains(" "))
                {
                    byrStr = byrStr.substring(0, byrStr.indexOf(" "));
                }
                //System.out.println("hgt : "  + byrStr);
                if(byrStr.contains("cm"))
                {
                    byrStr = byrStr.substring(0, byrStr.length() - 2);
                    //System.out.println(byrStr);
                    int hgtInt = Integer.parseInt(byrStr);
                    if((150 <= hgtInt) && (hgtInt <= 193))
                    {
                        partsValid++;
                    }
                }
                else if (byrStr.contains("in"))
                {
                    byrStr = byrStr.substring(0, byrStr.length() - 2);
                    //System.out.println(byrStr);
                    int hgtInt = Integer.parseInt(byrStr);
                    if((59 <= hgtInt) && (hgtInt <= 76))
                    {
                        partsValid++;
                    }
                }
            }
            //System.out.println("***paV: " + partsValid);
            if( pass.contains("hcl") )
            {
                String byrStr = pass.substring(pass.indexOf("hcl") + 4);
                byrStr = byrStr.substring(0, byrStr.indexOf(" "));
                //System.out.println("hcl: " + byrStr);
                if(byrStr.indexOf("#") == 0 && byrStr.length() == 7)
                {
                    byrStr = byrStr.substring(1);
                    //System.out.println(Integer.parseInt(byrStr));
                    int charsValid = 0;
                    for (int charAt = 0; charAt < byrStr.length(); charAt++ )
                    {
                        int toAsciiInt = byrStr.charAt(charAt);
                        if((48 <= toAsciiInt && toAsciiInt <= 57) || (97 <= toAsciiInt && toAsciiInt <= 102))
                        {
                            charsValid++;
                        }
                    }
                    if (charsValid == 6)
                    {
                        partsValid++;
                    }
                }
            }
            //System.out.println("***paV: " + partsValid);
            if( pass.contains("ecl") )
            {
                String byrStr = pass.substring(pass.indexOf("ecl") + 4);
                byrStr = byrStr.substring(0, byrStr.indexOf(" "));
                //System.out.println("ecl : " + byrStr);
                if (byrStr.equals("amb") ||
                        byrStr.equals("blu") ||
                        byrStr.equals("brn") ||
                        byrStr.equals("gry") ||
                        byrStr.equals("grn") ||
                        byrStr.equals("hzl") ||
                        byrStr.equals("oth"))
                {
                    partsValid++;
                }
            }
            //System.out.println("***paV: " + partsValid);
            if( pass.contains("pid") )
            {
                String byrStr = pass.substring(pass.indexOf("pid") + 4);
                try
                {
                    byrStr = byrStr.substring(0, byrStr.indexOf(" "));
                }
                catch (StringIndexOutOfBoundsException e)
                {

                }
                //System.out.println("pid:" + byrStr);
                int numNum = 0;
                if(byrStr.length() == 9)
                {
                    for(int idIndex = 0; idIndex < byrStr.length(); idIndex++)
                    {
                        int numOfChar = byrStr.charAt(idIndex);
                        if(48 <= numOfChar && numOfChar <= 57)
                        {
                            numNum++;
                        }
                    }
                    if(numNum == 9)
                    {
                        partsValid++;
                    }
                }
            }
            //System.out.println("***paV: " + partsValid);
            if(partsValid == 7)
            {
                numValid++;
            }
            //System.out.println("numV: " + numValid);
            //System.out.println();
        }
        System.out.println(numValid);
    }
}
