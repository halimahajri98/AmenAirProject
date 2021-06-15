package com.example.parpproject.frag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.parpproject.Bluetooth;
import com.example.parpproject.R;
import com.example.parpproject.connectionBluetooth;
import com.example.parpproject.consBatterie;
import com.example.parpproject.temperature;
import com.google.android.material.navigation.NavigationView;


public class HomeFragment extends Fragment {
   Activity context ;
    CardView mycard, mycard1 , batteriecard , cardventilo;
    LinearLayout ll;
    Intent i , intent , intent3 , intent4;



    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       context = getActivity();
       return  inflater.inflate(R.layout.fragment_home, container, false);






    }



    public void onStart (){
        super.onStart();
        ll = (LinearLayout) context.findViewById(R.id.ll);
        mycard = (CardView) context.findViewById(R.id.cardIdd);

        i = new Intent(context, connectionBluetooth.class);
        mycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
            }
        });
        mycard1 = (CardView) context.findViewById(R.id.cardId);
        intent = new Intent(context, temperature.class);
        mycard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        cardventilo = (CardView) context.findViewById(R.id.carventilo);
        intent4 = new Intent(context, Bluetooth.class);
        cardventilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent4);
            }
        });



        batteriecard = (CardView) context.findViewById(R.id.batteriecard);
        intent3 = new Intent(context, consBatterie.class);
        batteriecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });

    }



}