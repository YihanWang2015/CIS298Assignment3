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

    private static final String EXTRA_WINE_ID =
            "edu.kvcc.cis298.cis298assignment3.wine_id";

    private ViewPager mViewPager;
    private List<Wine> mWines;



    public static Intent newIntent(Context packageContext, String wineId){
        Intent intent = new Intent(packageContext, WinePagerActivity.class);
        intent.putExtra(EXTRA_WINE_ID, wineId);
        return intent;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_pager);


      //  UUID wineId = (UUID) getIntent().getSerializableExtra(EXTRA_WINE_ID);

        String wineId = getIntent().getStringExtra(EXTRA_WINE_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_wine_pager_view_pager);

        mWines = WineLab.get(this).getWines();

        FragmentManager fragmentManager = getSupportFragmentManager();

        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {

                Wine wine = mWines.get(position);
                return WineFragment.newInstance(wine.getItemNumber());
            }

            @Override
            public int getCount() {
                return mWines.size();
            }
        });



        for (int i = 0; i< mWines.size(); i++){

            if(mWines.get(i).getItemNumber().equals(wineId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }



    }



}
