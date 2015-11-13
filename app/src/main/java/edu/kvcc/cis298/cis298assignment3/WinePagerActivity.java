/*Yihan Wang
        CIS298Assignment3*/


package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

/**
 * Created by bigy on 11/12/15.
 */
public class WinePagerActivity extends FragmentActivity {

    //string constant for the key part of the EXTRA
    private static final String EXTRA_WINE_ID =
            "edu.kvcc.cis298.cis298assignment3.wine_id";

    //set the variable of viewPager
    private ViewPager mViewPager;

    //variable to hold all of wine records
    //<Wine> is the generic type
    private List<Wine> mWines;


    //public and static method allows any other activity or fragment get a properly formatted intent
    public static Intent newIntent(Context packageContext, String wineId){

        //make the new intent
        Intent intent = new Intent(packageContext, WinePagerActivity.class);

        //put the passed in wineId as an extra using the key declared
        intent.putExtra(EXTRA_WINE_ID, wineId);

        //return the intent
        return intent;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set the content of this activity to the pager layout
        setContentView(R.layout.activity_wine_pager);

        //get the wineId from the extra for the activity
        String wineId = getIntent().getStringExtra(EXTRA_WINE_ID);

        //get the view from the layout
        mViewPager = (ViewPager) findViewById(R.id.activity_wine_pager_view_pager);

        //get a reference of wine collection, wineLab
        mWines = WineLab.get(this).getWines();

        //create a new fragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //set the adapter for the viewpager with an unnamed fragmentStatePagerAdapter
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {

            @Override
            //get a specific item from the wines collection
            public Fragment getItem(int position) {

                //get the specific wine
                Wine wine = mWines.get(position);

                //return a new instance of a wine fragment using the static method
                return WineFragment.newInstance(wine.getItemNumber());
            }

            @Override
            //get the count for the size of the wine collection
            public int getCount() {
                return mWines.size();
            }
        });


        //foreach wine in the wines list
        for (int i = 0; i< mWines.size(); i++){

            //check if the id of the current wine matches the one that was sent in from the wineListActivity
            if(mWines.get(i).getItemNumber().equals(wineId)){

                //set the current item of the viewPager to the one that was sent from the list view.
                mViewPager.setCurrentItem(i);

                //break when match is found.
                break;
            }
        }
    }
}
