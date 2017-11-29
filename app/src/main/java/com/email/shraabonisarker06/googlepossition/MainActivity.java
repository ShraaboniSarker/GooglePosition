package com.email.shraabonisarker06.googlepossition;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class MainActivity extends AppCompatActivity {

    TextView current_location;
    TextView choose_location;
    int REQUEST_CODE = 1;
    String current;
    boolean flag;
    ImageView gps_image;
    ImageView gps_image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getAttributes().windowAnimations = R.style.Fade;
        gps_image = (ImageView) findViewById(R.id.gps_image);
        gps_image1 = (ImageView) findViewById(R.id.gps_image1);
        current_location = (TextView) findViewById(R.id.current);
        choose_location = (TextView) findViewById(R.id.chosen);
        Intent intent = getIntent();
        current = intent.getStringExtra("current_location");

            current_location.setText(current);

        gps_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MapsActivity.class));

            }
        });
        gps_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                Intent place_intent;
                try {
                    place_intent = builder.build(MainActivity.this);
                    startActivityForResult(place_intent,REQUEST_CODE);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    protected void onActivityResult(int requestCode,int resultCode, Intent data){

        if(requestCode == REQUEST_CODE){

            if(resultCode == RESULT_OK){
                Place place = PlacePicker.getPlace(data,this);
                String address = String.format("Place %s",place.getAddress());
                choose_location.setText(address);
            }
        }

    }
}
