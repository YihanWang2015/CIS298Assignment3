package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by bigy on 11/11/15.
 */
public class WineLab {

    private static WineLab sWineLab;

    private List<Wine> mWines;



    public static WineLab get(Context context){

        if(sWineLab == null){
            sWineLab = new WineLab(context);
        }
        return sWineLab;
    }

    private WineLab(Context context){
        mWines = new ArrayList<>();

        for(int i = 0; i<100; i++){
            Wine wine = new Wine();
            wine.setItemNumber("Wine #" + i);
            wine.setPack("Wine Pack" + i);
            wine.setPrice("Wine Price" + i);
            wine.setActive(i % 2 == 0);
            mWines.add(wine);

        }


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








}
