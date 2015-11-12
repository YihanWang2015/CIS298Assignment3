package edu.kvcc.cis298.cis298assignment3;

import java.util.UUID;

/**
 * Created by bigy on 11/11/15.
 */
public class Wine {

    private UUID mId;
    private String mName;


    public Wine(){
        //Generate unique identifier
        mId = UUID.randomUUID();
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
}
