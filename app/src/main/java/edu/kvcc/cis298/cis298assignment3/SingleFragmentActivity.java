/*Yihan Wang
        CIS298Assignment3*/



package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by bigy on 11/11/15.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    //This method is declared as abstract so that every activity must implement this method
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        //create an instance fm of FragmentManager and get the support method
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            //create a new stance of wineFragment, and then attach and commit the changes.
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

    }




}
