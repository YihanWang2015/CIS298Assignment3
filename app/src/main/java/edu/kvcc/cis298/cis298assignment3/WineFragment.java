/*Yihan Wang
        CIS298Assignment3*/


package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
//import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;


import android.widget.EditText;

import java.util.UUID;

/**
 * Created by bigy on 11/11/15.
 */
public class WineFragment extends Fragment  {

    //static string as the key for parameters
    private static final String ARG_WINE_ID = "wine_id";

    //class level variable for a wine
    private Wine mWine;

    private EditText mNameField;
    private EditText mItemNumberField;
    private EditText mPackField;
    private EditText mPriceField;
    private CheckBox mActiveCheckBox;

    //static method to create a new instance of a wineFragment based on wineId
    public static WineFragment newInstance(String wineId){

        //create a new argument bundle
        Bundle args = new Bundle();
        //put the wineId in as a value to the bundle
        args.putString(ARG_WINE_ID, wineId);

        //create a new instance of this fragment
        WineFragment fragment = new WineFragment();
        //set the argument on the fragment with the bundle
        fragment.setArguments(args);
        //return the fragment
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get the string wineId
        String wineId = getArguments().getString(ARG_WINE_ID);
        //get the singleton instance of wineLab
        mWine = WineLab.get(getActivity()).getWine(wineId);

    }


    //inflate the view and get the content on the screen
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //make the layout that can be displayed
        View v = inflater.inflate(R.layout.fragment_wine, container, false);


        mNameField = (EditText)v.findViewById(R.id.wine_name);
        mNameField.setText(mWine.getName());
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mWine.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mItemNumberField = (EditText)v.findViewById(R.id.wine_item_number);
        mItemNumberField.setText(mWine.getItemNumber());
        mItemNumberField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mWine.setItemNumber(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mPackField = (EditText)v.findViewById(R.id.wine_pack);
        mPackField.setText(mWine.getPack());
        mPackField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mWine.setPack(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mPriceField = (EditText)v.findViewById(R.id.wine_price);
        mPriceField.setText("$"+ mWine.getPrice());
        mPriceField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mWine.setPrice(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mActiveCheckBox = (CheckBox)v.findViewById(R.id.wine_active);
        mActiveCheckBox.setChecked(mWine.isActive());
        mActiveCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                //Set the wine's active property
                mWine.setActive(isChecked);
            }
        });

        return v;
    }
}
