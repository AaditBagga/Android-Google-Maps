package com.example.evaluation9;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnPolylineClickListener,
GoogleMap.OnPolygonClickListener{

    ArrayList<LatLng> Points = DataServices.getPath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the SupportMapFragment and request notification when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //TODO: goto https://console.cloud.google.com/ to setup the google maps sdk for this project
        //TODO: use the https://developers.google.com/maps/documentation/android-sdk/config to setup the google maps sdk in this project

    }


    @Override
    public void onPolygonClick(@NonNull Polygon polygon) {

    }

    @Override
    public void onPolylineClick(@NonNull Polyline polyline) {

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        // Add polylines to the map.
        // Polylines are useful to show a route or some other connection between points.


        PolylineOptions polylineOptions = new PolylineOptions();
        LatLngBounds.Builder builder=new LatLngBounds.Builder();
        for(LatLng latLng : DataServices.getPath()) {
                    polylineOptions.add(latLng);
                    builder.include(latLng);

        }
        LatLng Start = Points.get(0);
        googleMap.addMarker(new MarkerOptions()
                .position(Start)
                .title("Start"));

        LatLng Stop = Points.get(Points.size()-1);
        googleMap.addMarker(new MarkerOptions()
                .position(Stop)
                .title("Stop"));




        Polyline polyline1 = googleMap.addPolyline(polylineOptions);

                // Position the map's camera near Alice Springs in the center of Australia,
        // and set the zoom factor so most of Australia shows on the screen.
        //googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-23.684, 133.903), 4));

        // Set listeners for click events.
       // googleMap.setOnPolylineClickListener(this);
        //googleMap.setOnPolygonClickListener(this);


    }
}

    //TODO: The retrieved trip points should be plotted on the Google Map
    // using “Polyline” shape https://developers.google.com/maps/documentation/android-sdk/polygon-tutorial

    //TODO: The start and end points of the trip should be indicated with markers
    // https://developers.google.com/maps/documentation/android-sdk/map-with-marker

    //TODO: Also map should be auto zoomed to include all the trip points in the map’s bounding box.
    //Check CameraUpdateFactory class check: https://developers.google.com/android/reference/com/google/android/gms/maps/CameraUpdateFactory

