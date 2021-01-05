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
        //go through each passport
        for(int index = 0; index < inputLines.size(); index++)
        {
            int partsValid = 0;
            String pass = inputLines.get(index);

            //byr : birth year
            if( pass.contains("byr") )
            {
                String byrStr = pass.substring(pass.indexOf("byr") + 4);
                try
                {
                    byrStr = byrStr.substring(0, byrStr.indexOf(" "));
                }catch (StringIndexOutOfBoundsException e){}
                //System.out.println(byrStr);
                int byrInt = Integer.parseInt(byrStr);
                //System.out.println("byr : " + byrInt);
                if((1920 <= byrInt) && (byrInt <= 2002))
                {
                    partsValid++;
                }
            }
            //System.out.println("***paV: " + partsValid);

            //iyr : issue year
            if( pass.contains("iyr") )
            {
                String iyrStr = pass.substring(pass.indexOf("iyr") + 4);
                try
                {
                    iyrStr = iyrStr.substring(0, iyrStr.indexOf(" "));
                }
                catch (StringIndexOutOfBoundsException e) {}
                //System.out.println(byrStr);
                int iyrInt = Integer.parseInt(iyrStr);
                //System.out.println("iyr : " + byrInt);
                if((2010 <= iyrInt) && (iyrInt <= 2020))
                {
                    partsValid++;
                }
            }
            //System.out.println("***paV: " + partsValid);

            //eyr : expiration year
            if( pass.contains("eyr") )
            {
                String eyrStr = pass.substring(pass.indexOf("eyr") + 4);
                try
                {
                    eyrStr = eyrStr.substring(0, eyrStr.indexOf(" "));
                }catch (StringIndexOutOfBoundsException e){}
                //System.out.println(byrStr);
                int eyrInt = Integer.parseInt(eyrStr);
                //System.out.println(" eyr : " + byrInt);
                if((2020 <= eyrInt) && (eyrInt <= 2030))
                {
                    partsValid++;
                }
            }
            //System.out.println("***paV: " + partsValid);

            //hgt : height
            if( pass.contains("hgt") )
            {
                String hgtStr = pass.substring(pass.indexOf("hgt") + 4);
                try
                {
                    hgtStr = hgtStr.substring(0, hgtStr.indexOf(" "));
                }catch (StringIndexOutOfBoundsException e){}
                //System.out.println("hgt : "  + byrStr);
                if(hgtStr.contains("cm"))
                {
                    hgtStr = hgtStr.substring(0, hgtStr.length() - 2);
                    //System.out.println(byrStr);
                    int hgtInt = 0;
                    try
                    {
                        hgtInt = Integer.parseInt(hgtStr);
                    }
                    catch (NumberFormatException e){}
                    if((150 <= hgtInt) && (hgtInt <= 193))
                    {
                        partsValid++;
                    }
                }
                else if (hgtStr.contains("in"))
                {
                    hgtStr = hgtStr.substring(0, hgtStr.length() - 2);
                    //System.out.println(byrStr);
                    int hgtInt = 0;
                    try
                    {
                        hgtInt = Integer.parseInt(hgtStr);
                    }catch (NumberFormatException e){}
                    if((59 <= hgtInt) && (hgtInt <= 76))
                    {
                        partsValid++;
                    }
                }
            }
            //System.out.println("***paV: " + partsValid);

            //hcl : hair color
            if( pass.contains("hcl") )
            {
                String hclStr = pass.substring(pass.indexOf("hcl") + 4);
                hclStr = hclStr.substring(0, hclStr.indexOf(" "));
                //System.out.println("hcl: " + byrStr);
                if(hclStr.indexOf("#") == 0 && hclStr.length() == 7)
                {
                    hclStr = hclStr.substring(1);
                    //System.out.println(Integer.parseInt(byrStr));
                    int charsValid = 0;
                    for (int charAt = 0; charAt < hclStr.length(); charAt++ )
                    {
                        int toAsciiInt = hclStr.charAt(charAt);
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

            //ecl : eye color
            if( pass.contains("ecl") )
            {
                String eclStr = pass.substring(pass.indexOf("ecl") + 4);
                try
                {
                    eclStr = eclStr.substring(0, eclStr.indexOf(" "));
                }catch (StringIndexOutOfBoundsException e) {}
                //System.out.println("ecl : " + byrStr);
                if (eclStr.equals("amb") ||
                        eclStr.equals("blu") ||
                        eclStr.equals("brn") ||
                        eclStr.equals("gry") ||
                        eclStr.equals("grn") ||
                        eclStr.equals("hzl") ||
                        eclStr.equals("oth"))
                {
                    partsValid++;
                }
            }
            //System.out.println("***paV: " + partsValid);

            //pid : passport id
            if( pass.contains("pid") )
            {
                String pidStr = pass.substring(pass.indexOf("pid") + 4);
                try
                {
                    pidStr = pidStr.substring(0, pidStr.indexOf(" "));
                }
                catch (StringIndexOutOfBoundsException e) { }
                //System.out.println("pid:" + byrStr);
                int numNum = 0;
                if(pidStr.length() == 9)
                {
                    for(int idIndex = 0; idIndex < pidStr.length(); idIndex++)
                    {
                        int numOfChar = pidStr.charAt(idIndex);
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
