package com.hfad.servicedesksystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity {

    private Button msendSring;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        //Firebase.setAndroidContext(this);

    //mref = new Firebase("https://servicedesksystem-a9d32.firebaseio.com/");
    //msendSring = (Button) findViewById(R.id.sendString);


    }
}
