package edu.kvcc.cis298.cis298assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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


    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }



    private void updateUI(){

        WineLab wineLab = WineLab.get(getActivity());
        List<Wine> wines = wineLab.getWines();


        if(mAdapter == null ) {
            mAdapter = new WineAdapter(wines);
            mWineRecyclerView.setAdapter(mAdapter);
        }else{
            mAdapter.notifyDataSetChanged();
        }
    }








    private class WineHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //public TextView mNameTextView;

        private TextView mNameTextView;
        private TextView mItemNumberTextView;
        private TextView mPriceTextView;


        private Wine mWine;


        public WineHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);

          //  mNameTextView = (TextView) itemView;

            mNameTextView = (TextView) itemView.findViewById(R.id.list_item_wine_name_text_view);
            mItemNumberTextView = (TextView) itemView.findViewById(R.id.list_item_wine_item_number_text_view);
            mPriceTextView = (TextView) itemView.findViewById(R.id.list_item_wine_price_text_view);

        }


        @Override
        public void onClick(View v){
           /* Toast.makeText(getActivity(), mWine.getName() + "Clicked!", Toast.LENGTH_SHORT)
                    .show();*/


            //Intent intent = new Intent(getActivity(), BeverageActivity.class);
            Intent intent = BeverageActivity.newIntent(getContext(), mWine.getId());

            startActivity(intent);


        }


        public void bindWine(Wine wine){

            mWine = wine;
            mNameTextView.setText(mWine.getName());
            mItemNumberTextView.setText(mWine.getItemNumber());
            mPriceTextView.setText(mWine.getPrice());


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
            View view = layoutInflater.inflate(R.layout.list_item_wine, parent, false);
            return new WineHolder(view);
        }


        @Override
        public void onBindViewHolder(WineHolder holder, int position) {
            Wine wine = mWines.get(position);
        //  holder.mNameTextView.setText(wine.getName());
            holder.bindWine(wine);
        }


        @Override
        public int getItemCount() {
            return mWines.size();
        }
    }



}
