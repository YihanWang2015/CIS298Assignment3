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

    private static WineLab sWineLab;

    private List<Wine> mWines;


    private Context mContext;


    public static WineLab get(Context context){

        if(sWineLab == null){
            sWineLab = new WineLab(context);
        }
        return sWineLab;
    }

    private WineLab(Context context){
        mWines = new ArrayList<>();

        mContext = context;

  /*      for(int i = 0; i<10; i++){
            Wine wine = new Wine();
            wine.setName("Wine Name" + i);
            wine.setItemNumber("Wine #" + i);
            wine.setPack("Wine Pack" + i);
            wine.setPrice("Wine Price $" + i);
            wine.setActive(i % 2 == 0);
            mWines.add(wine);

        }*/

        this.loadWineList();
    }



    public List<Wine> getWines(){

        return mWines;
    }


    public Wine getWine(UUID id){

        for(Wine wine : mWines){
            if(wine.getId().equals(id)){
                return wine;
            }
        }
        return null;
    }



    private void loadWineList(){

        Scanner scanner = null;

        try{
            scanner = new Scanner(mContext.getResources().openRawResource(R.raw.beverage_list));

            while (scanner.hasNextLine()){

                String line = scanner.nextLine();

                String parts[] = line.split(",");

                String itemNumber = parts[0];
                String name = parts[1];
                String pack = parts[2];
                String price = parts[3];
                String active = parts[4];

                UUID uuid = UUID.fromString(itemNumber);


                boolean isActive;

                if (active.equals("True")){
                    isActive = true;
                }else{
                    isActive = false;
                }


                mWines.add(new Wine(uuid, name, pack, price, isActive));


            }
        }
        catch(Exception e){

            Log.e("Read csv", e.toString());

        } finally {

            scanner.close();
        }


    }




}
