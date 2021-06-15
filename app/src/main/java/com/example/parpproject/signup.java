package com.example.parpproject;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class signup extends AppCompatActivity {


    TextView enregister;
    EditText user_name, user_email, user_pass, user_password;
    private FirebaseAuth mFirebaseAuth ;

    FirebaseDatabase database =FirebaseDatabase.getInstance() ;
    DatabaseReference myRef = database.getReference().child("users") ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        enregister = (TextView) findViewById(R.id.enregistrer);
        user_name = findViewById(R.id.username);
        user_email = findViewById(R.id.email);
        user_pass = findViewById(R.id.password);
        user_password = findViewById(R.id.passwordpass);

       

        mFirebaseAuth = FirebaseAuth.getInstance();

        enregister.setOnClickListener(v -> {
           final String email = user_email.getText().toString().trim();
           final String password = user_pass.getText().toString().trim();
           final String passwordpass = user_password.getText().toString().trim();
          final  String username = user_name.getText().toString().trim();

            if (email.equals("")) {
                user_email.setError("please enter your email ... ");
                user_email.requestFocus();
                return;
            } else if (username.equals("")) {
                user_name.setError("please enter your username ... ");
                user_name.requestFocus();
                return;
            } else if (password.equals("")) {
                user_pass.setError("please enter your password ... ");
                user_pass.requestFocus();
                return;
            } else if (passwordpass.equals("")) {
                user_password.setError("please enter your password ... ");
                user_password.requestFocus();
                return;
            } else if (password.length() < 6) {
                user_password.setError("password must be > 6!!");
                user_password.requestFocus();
                return;
            } else if (!password.equals(passwordpass)) {
                user_password.setError("Password Didn't match !!");
                user_password.requestFocus();
                return;
            } else {

                mFirebaseAuth.createUserWithEmailAndPassword("" + user_email.getText(), "" + user_pass.getText())
                        .addOnCompleteListener(signup.this, task -> {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mFirebaseAuth.getCurrentUser();
                                Log.d("SUCCESS_SIGN", "createUserWithEmail:success" + mFirebaseAuth.getCurrentUser());
                                startActivity(new Intent(signup.this, home.class));
                                finish();
//                                        updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("ERROR_SIGN", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(signup.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
//                                        updateUI(null);
                            }

                            // ...
                        });

            }

            {
                HashMap<String, String> userMap = new HashMap<>();
                userMap.put("email", email);
                userMap.put("password", password);
                userMap.put("passwordpass", passwordpass);
                userMap.put("username", username);
                myRef.setValue(userMap);
                startActivity(new Intent(signup.this, home.class));
               finish();
            }


        });


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }







}