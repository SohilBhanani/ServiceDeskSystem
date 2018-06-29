package com.hfad.servicedesksystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginUserActivity extends AppCompatActivity {

    private EditText login_email;
    private EditText login_password;
    private Button login_btn;

    private FirebaseAuth mAuth;

    private ProgressBar login_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        login_email = (EditText) findViewById(R.id.e_mailText);
        login_password = (EditText) findViewById(R.id.passwordText);
        login_btn = (Button) findViewById(R.id.signin_button);
        login_progress = (ProgressBar) findViewById(R.id.progressBar);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginEmail = login_email.getText().toString();
                String loginPass = login_password.getText().toString();

                if(!TextUtils.isEmpty(loginEmail) && !TextUtils.isEmpty(loginPass)){
                    login_progress.setVisibility(View.VISIBLE);
                    mAuth.signInWithEmailAndPassword(loginEmail, loginPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                sendToMain();

                            }else {
                                String errorMessage = task.getException().getMessage();
                                Toast.makeText(LoginUserActivity.this, "Error: " + errorMessage, Toast.LENGTH_LONG).show();

                            }

                            login_progress.setVisibility(View.INVISIBLE);

                        }
                    });

                }
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if(currentUser != null){

            sendToMain();

        }
    }

    private void sendToMain() {
        Intent mainIntent = new Intent(LoginUserActivity.this, ServiceActivity.class);
        startActivity(mainIntent);
        finish();
    }

    public void previous(View view){
        startActivity(new Intent(LoginUserActivity.this, UserSelection.class));
    }

}

