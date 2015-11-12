package edu.kvcc.cis298.cis298assignment3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * Created by bigy on 11/11/15.
 */
public class WineListFragment extends Fragment{

    private RecyclerView mWineRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wine_list, container, false);

        mWineRecyclerView = (RecyclerView) view.findViewById(R.id.wine_recycler_view);
        mWineRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}
