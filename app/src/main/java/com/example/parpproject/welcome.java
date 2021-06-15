package com.example.parpproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.parpproject.frag.HomeFragment;
import com.google.firebase.auth.FirebaseAuth;

public class welcome extends AppCompatActivity {


    private final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        // Testing if the user is already logged in or not
        if (firebaseAuth != null && firebaseAuth.getCurrentUser() != null){
            //Firebase sends infos so quickly so we need to slow down things to show progress bar effect by using Handler:)
            new Handler().postDelayed(() -> startActivity(new Intent(this, home.class)), 5000);

        }else{
            startActivity(new Intent(this, MainActivity.class));
        }


    }
}