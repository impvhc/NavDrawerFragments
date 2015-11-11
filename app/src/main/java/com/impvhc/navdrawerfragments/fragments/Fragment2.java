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
public class Fragment2 extends Fragment {


    public Fragment2() {
        // Required empty public constructor
    }


    View viewFragment2;

    Button btn_fragment2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewFragment2 =inflater.inflate(R.layout.fragment_fragment2, container, false);
        btn_fragment2 =(Button) viewFragment2.findViewById(R.id.btn_fragment2);
        btn_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getContext(), "Fragment2", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        return viewFragment2;
    }


}
