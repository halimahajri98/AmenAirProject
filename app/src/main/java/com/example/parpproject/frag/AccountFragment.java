package com.example.parpproject.frag;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import android.graphics.Bitmap;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.parpproject.R;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;


import java.io.IOException;
import java.util.Objects;
import java.util.UUID;


public class AccountFragment extends Fragment {

    private static final int RESULT_OK = -1 ;
    Activity context ;
    private static final int PICK_IMAGE =1 ;
   ImageView changeimage;

    Uri imageUrl;
    private FirebaseStorage storage;
    private StorageReference storagereference ;
    private Bitmap imageBitmap;
    private Object ImageView;

    TextView user_name, user_email;
    Button update_profile;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();
        return  inflater.inflate(R.layout.fragment_account, container, false);


       // changeimage=view.findViewById(R.id.change_photo);
      //  storage = FirebaseStorage.getInstance();
       // storagereference= storage.getReference();

          //  return view;

    }



    public void onStart (){
        super.onStart();
        changeimage= context.findViewById(R.id.me_avatar);



       changeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
               startActivityForResult(Intent.createChooser(gallery, "select picture"),PICK_IMAGE);
            }
        });



    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data) ;
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            if(data != null){
                imageUrl = data.getData();
                Log.d("imageUrl","imageUrl : "+imageUrl);
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap((getActivity()).getContentResolver(),imageUrl);

                    changeimage.setImageBitmap(bitmap);
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }

}