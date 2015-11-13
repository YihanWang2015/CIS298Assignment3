package edu.kvcc.cis298.cis298assignment3;

import java.util.UUID;

/**
 * Created by bigy on 11/11/15.
 */
public class Wine {

    private UUID mId;
    private String mName;

    private String mItemNumber;
    private String mPack;
    private String mPrice;
    private boolean mActive;

    public Wine(){
        //Generate unique identifier
        mId = UUID.randomUUID();
    }


    public Wine(String itemNumber, String name, String pack, String price, boolean isActive){

        mItemNumber = itemNumber;
        mName = name;
        mPack = pack;
        mPrice = price;
        mActive = isActive;
    }


    public UUID getId() {
        return mId;
    }


    public String getName() {
        return mName;
    }

    public void setName(String name) {
       mName = name;
    }


    //Getter and setter for the new fields of mItemNumber, mPack, mPrice, mActive


    public String getItemNumber() {
        return mItemNumber;
    }

    public void setItemNumber(String itemNumber) {
        mItemNumber = itemNumber;
    }

    public String getPack() {
        return mPack;
    }

    public void setPack(String pack) {
        mPack = pack;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public boolean isActive() {
        return mActive;
    }

    public void setActive(boolean active) {
        mActive = active;
    }
}
