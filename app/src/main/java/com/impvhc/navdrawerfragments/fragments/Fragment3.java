package com.impvhc.navdrawerfragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.impvhc.navdrawerfragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {


    public Fragment3() {
        // Required empty public constructor
    }


    View viewFragment3;

    Button btn_fragment3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewFragment3 =inflater.inflate(R.layout.fragment_fragment3, container, false);
        btn_fragment3 =(Button) viewFragment3.findViewById(R.id.btn_fragment3);
        btn_fragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "Fragment3", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        return viewFragment3;
    }


}
