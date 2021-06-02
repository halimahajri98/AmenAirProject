package com.example.parpproject.frag;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.parpproject.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class localisationFragment extends Fragment {
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;
    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_localisation, container, false);


        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_map);
/*
        client = LocationServices.getFusedLocationProviderClient(context);


        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            getCurrentLocation();
        } else {
             ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
        */



        supportMapFragment.getMapAsync (new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
               googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                   @Override
                   public void onMapClick(LatLng latLng) {

                       MarkerOptions markerOptions = new MarkerOptions();

                       markerOptions.position(latLng);

                       markerOptions.title(latLng.latitude+":" + latLng.longitude);

                       //remove marker
                       googleMap.clear();

                       googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                               latLng,10
                       ));

                       googleMap.addMarker(markerOptions);
                   }
               });

            }
        });






        return view;
    }

    /*

    private void getCurrentLocation() {

        @SuppressLint("MissingPermission") Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null){
                    supportMapFragment.getMapAsync (new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {

                            LatLng latLng = new LatLng(location.getAltitude(),
                                    location.getLongitude());
                            MarkerOptions options = new MarkerOptions().position(latLng)
                                    .title("I'am here");

                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng , 10));

                            googleMap.addMarker(options);

                        }
                    });
                }
            }
        });
    }

public void onRequestPermissionsResult (int requestCode , @NonNull String[] permissions , @NonNull int[] grantResults){

if (requestCode == 44){
    if (grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
        getCurrentLocation();
    }
}

}
*/

}