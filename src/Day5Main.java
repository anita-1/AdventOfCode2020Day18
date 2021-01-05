import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Day5Main
{
    public static void main(String[] args) throws Exception
    {
        //get file
        File file = new File("C:\\Users\\unebe\\Documents\\2020 F\\AdventOfCode\\input.txt");

        //read file
        BufferedReader br = new BufferedReader(new FileReader(file));

        ArrayList<Integer> seats = new ArrayList<Integer>();
        String line = "";
        int maxSeatID = 0;
        while((line = br.readLine()) != null)
        {
            int rowStart = 0;
            int rowEnd = 127;
            int colStart = 0;
            int colEnd = 7;
            int seatID = 0;

            //each line
            for(int index = 0; index < line.length(); index++)
            {
                if(0 <= index && index <= 6)
                {
                    int mid = (rowStart + rowEnd) / 2;
                    if(line.charAt(index) == 'F')
                    {
                        rowEnd = mid;
                    }
                    else if(line.charAt(index) == 'B')
                    {
                        rowStart = mid;
                    }
                }
                else if(7 <= index && index <= 9)
                {
                    int mid = (colStart + colEnd) / 2;
                    if(line.charAt(index) == 'L')
                    {
                        colEnd = mid;
                    }
                    else if(line.charAt(index) == 'R')
                    {
                        colStart = mid;
                    }
                }
                seatID = rowEnd * 8 + colEnd;

            }
            maxSeatID = Math.max(maxSeatID, seatID);
            /*
            System.out.println("row " + rowEnd + ", " +
                                "column " + colEnd + ", " +
                                "seat ID " + seatID);
            */
            //System.out.println("maxSeatID:" + maxSeatID);

            seats.add(seatID);
        }
        System.out.println("maxSeatID:" + maxSeatID);

        Collections.sort(seats);
        //System.out.println(seats);
        int mySeat = -1;
        for(int thisSeat = seats.get(0); thisSeat < seats.get(seats.size() - 1); thisSeat++)
        {
            if(!seats.contains(thisSeat))
            {
                if(seats.contains(thisSeat - 1) && seats.contains(thisSeat + 1))
                {
                    mySeat = thisSeat;
                }
            }
        }
        System.out.println("mySeat:" + mySeat);

    }
}
