package edu.kvcc.cis298.cis298assignment3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by bigy on 11/11/15.
 */
public class WineListFragment extends Fragment{

    private RecyclerView mWineRecyclerView;

    private WineAdapter mAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wine_list, container, false);

        mWineRecyclerView = (RecyclerView) view.findViewById(R.id.wine_recycler_view);
        mWineRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }






    private void updateUI(){

        WineLab wineLab = WineLab.get(getActivity());
        List<Wine> wines = wineLab.getWines();

        mAdapter = new WineAdapter(wines);
        mWineRecyclerView.setAdapter(mAdapter);
    }








    private class WineHolder extends RecyclerView.ViewHolder{

        public TextView mNameTextView;

        public WineHolder(View itemView){
            super(itemView);

            mNameTextView = (TextView) itemView;
        }
    }









    private class WineAdapter extends RecyclerView.Adapter<WineHolder>{

        private List<Wine> mWines;

        public WineAdapter(List<Wine> wines){
            mWines = wines;
        }

        @Override
        public WineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            return new WineHolder(view);
        }


        @Override
        public void onBindViewHolder(WineHolder holder, int position) {
            Wine wine = mWines.get(position);
            holder.mNameTextView.setText(wine.getName());
        }


        @Override
        public int getItemCount() {
            return mWines.size();
        }
    }



}
