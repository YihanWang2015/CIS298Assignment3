package edu.kvcc.cis298.cis298assignment3;

import android.support.v4.app.Fragment;

/**
 * Created by bigy on 11/11/15.
 */
public class WineListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new WineListFragment();
    }
}
