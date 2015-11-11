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
public class Fragment1 extends Fragment {


    public Fragment1() {
        // Required empty public constructor
    }


    View viewFragment1;

    Button btn_fragment1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewFragment1=inflater.inflate(R.layout.fragment_fragment1, container, false);
        btn_fragment1=(Button) viewFragment1.findViewById(R.id.btn_fragment1);
        btn_fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getContext(),"Fragment1",Toast.LENGTH_LONG);
                toast.show();
            }
        });

        return viewFragment1;
    }


}
