package com.example.parpproject.frag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.parpproject.R;
import com.example.parpproject.connectionBluetooth;
import com.example.parpproject.filtreProducts;
import com.example.parpproject.home;
import com.example.parpproject.signup;

public class staticsFragment extends Fragment {

  RelativeLayout filtre1 , courois1 ;
  Intent i ;
    Activity context ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        return  inflater.inflate(R.layout.fragment_statics, container, false);

    }

    public void onStart (){
        super.onStart();
         filtre1= (RelativeLayout) context.findViewById(R.id.filtre1);

        i = new Intent(context, filtreProducts.class);
        filtre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
    }

}