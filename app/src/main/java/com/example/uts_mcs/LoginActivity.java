package com.example.uts_mcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    TextView registerInt;
    EditText enterEmailLog, enterPasswordLog;
    Button loginButton;
    String emailLog, passwordLog;
    ImageView google, facebook, twitter;
    boolean passwordVisible;
    RegisDBHelper regisDBHelper;
    Boolean checkCredentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // find view by id all components
        enterEmailLog = findViewById(R.id.loginEmail);
        enterPasswordLog = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.loginBtn);
        google = findViewById(R.id.loginGoog);
        facebook = findViewById(R.id.loginFaceb);
        twitter = findViewById(R.id.loginTwitt);
        registerInt = findViewById(R.id.registerMoveText);

        regisDBHelper = new RegisDBHelper(this);

        // intent to login page
        registerInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

        // toggle for password
        enterPasswordLog.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int right = 2;
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(event.getRawX() >= enterPasswordLog.getRight()-enterPasswordLog.getCompoundDrawables()[right].getBounds().width()){
                        int selection = enterPasswordLog.getSelectionEnd();
                        if(passwordVisible) {
                            enterPasswordLog.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.password_off, 0);
                            // hide password
                            enterPasswordLog.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }
                        else {
                            enterPasswordLog.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.password_on, 0);
                            // show password
                            enterPasswordLog.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        enterPasswordLog.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        // login button clicked
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailLog = enterEmailLog.getText().toString();
                passwordLog = enterPasswordLog.getText().toString();
                validateLogin();
            }
        });

        // social media login method
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            }
        });
    }

    // condition to validate login
    private void validateLogin() {
        if(emailLog.equals("") || passwordLog.equals("")) {
            Toast.makeText(LoginActivity.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
        } else {
            checkCredentials = regisDBHelper.userDataCheck(emailLog, passwordLog);

            if (checkCredentials == true) {
                Toast.makeText(LoginActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            } else {
                Toast.makeText(LoginActivity.this, "Login failed, please check again", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

