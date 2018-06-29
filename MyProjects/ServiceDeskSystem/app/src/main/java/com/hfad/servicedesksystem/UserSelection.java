package com.hfad.servicedesksystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserSelection extends AppCompatActivity {

    private Button admin_btn;
    private Button user_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selection);

        admin_btn = (Button) findViewById(R.id.admin_button);
        user_btn = (Button) findViewById(R.id.user_button);

        admin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adminLoginIntent = new Intent(UserSelection.this,LoginAdminActivity.class);
                startActivity(adminLoginIntent);
                finish();
            }
        });




        user_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userLoginIntent = new Intent(UserSelection.this, LoginUserActivity.class);
                startActivity(userLoginIntent);
                finish();
            }
        });


    }
}
