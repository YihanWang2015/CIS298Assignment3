package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class BeverageActivity extends SingleFragmentActivity {

/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = new WineFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

    }*/

    public static final String EXTRA_WINE_ID =
            "edu.kvcc.cis298.cis298assignment3.wine_id";

    public static Intent newIntent(Context packageContext, UUID wineId){
            Intent intent = new Intent(packageContext, BeverageActivity.class);
            intent.putExtra(EXTRA_WINE_ID, wineId);
            return intent;
    }



    @Override
    protected Fragment createFragment(){
        return new WineFragment();
    }






}
