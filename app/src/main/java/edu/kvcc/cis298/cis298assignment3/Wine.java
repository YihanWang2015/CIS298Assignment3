/*Yihan Wang
        CIS298Assignment3*/


package edu.kvcc.cis298.cis298assignment3;

import java.util.UUID;

/**
 * Created by bigy on 11/11/15.
 */
public class Wine {

    //private variables
    private UUID mId;
    private String mName;
    private String mItemNumber;
    private String mPack;
    private String mPrice;
    private boolean mActive;


    //Default constructor
    public Wine(){
        //Generate unique identifier
        mId = UUID.randomUUID();
    }


    //4 parameter constructor to make a new wine
    public Wine(String itemNumber, String name, String pack, String price, boolean isActive){

        mItemNumber = itemNumber;
        mName = name;
        mPack = pack;
        mPrice = price;
        mActive = isActive;
    }


    //Getter for the id
    public UUID getId() {
        return mId;
    }

    //getter for the name
    public String getName() {
        return mName;
    }

    //setter for the name
    public void setName(String name) {
       mName = name;
    }

    //getter for the itemNumber
    public String getItemNumber() {
        return mItemNumber;
    }

    //setter for the itemNumber
    public void setItemNumber(String itemNumber) {
        mItemNumber = itemNumber;
    }

    //getter for the pack
    public String getPack() {
        return mPack;
    }

    //setter for the pack
    public void setPack(String pack) {
        mPack = pack;
    }

    //getter for the price
    public String getPrice() {
        return mPrice;
    }

    //setter for the price
    public void setPrice(String price) {
        mPrice = price;
    }

    //getter for the active
    public boolean isActive() {return mActive;}

    //setter for the active
    public void setActive(boolean active) {
        mActive = active;
    }
}
