package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * Created by bigy on 11/11/15.
 */
public class WineLab {


    //Static variable to hold the instance of WineLab.
    private static WineLab sWineLab;
    //A variable that has generic Wine type of list.
    private List<Wine> mWines;
    //Variable to hold the context.
    private Context mContext;


    //Method to get an instance of WineLab
    public static WineLab get(Context context){

        //Check if the current instance in the variable is null
        if(sWineLab == null){

            //Create a new instance using the private constructor.
            sWineLab = new WineLab(context);
        }
        //Return the instance that exists.
        return sWineLab;
    }



    //WineLab constructor
   private WineLab(Context context){

       //Create an instance of the ArrayList
        mWines = new ArrayList<>();

       //Assign the passed in context to the class level one.
        mContext = context;

        //load the wine list
        this.loadWineList();
    }


    //Getter to get the wines
    public List<Wine> getWines(){

        return mWines;
    }



    //Method to get a specific wine based on the itemNumber that is passed in.
    public Wine getWine(String itemNumber){

        //foreach loop to go through all of the wines
        for(Wine wine : mWines){

            //return the found match
            if(wine.getItemNumber().equals(itemNumber)){
                return wine;
            }
        }
        //return null if there's no match
        return null;
    }



    //Method to load the wine list from the csv file
    private void loadWineList(){

        //create a new scanner that will get the data from the file
        Scanner scanner = null;

        try{
            //the created new scanner opens the file of beverage_list in the raw directory
            scanner = new Scanner(mContext.getResources().openRawResource(R.raw.beverage_list));

            //while loop to check the next line in the file
            while (scanner.hasNextLine()){
                //get the next line and assign it to the string "line"
                String line = scanner.nextLine();
                //split the line apart by the comma into an array
                String parts[] = line.split(",");

                //assign each part to the variables
                String itemNumber = parts[0];
                String name = parts[1];
                String pack = parts[2];
                String price = parts[3];
                String active = parts[4];

                //parse the active string to see if isActive should be true or false
                boolean isActive;

                if (active.equals("True")){
                    isActive = true;
                }else{
                    isActive = false;
                }

                //add the new wine to the mWines list.
                mWines.add(new Wine(itemNumber, name, pack, price, isActive));
            }
        }
        catch(Exception e){
            //Log the error to the LogCat
            Log.e("Read csv", e.toString());

        } finally {
            //close the scanner
            scanner.close();
        }
    }
}
