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

public class RegisterActivity extends AppCompatActivity {

    TextView loginInt;
    EditText enterNameReg, enterEmailReg, enterPassReg, enterConfPassReg;
    Button registerButton;
    String nameReg, emailReg, createPasswordReg, confPasswordReg;
    ImageView google, facebook, twitter;
    boolean passwordVisible;
    Boolean checkEmailUser, insertDataDb;
    RegisDBHelper regisDBHelper;

    public static ArrayList<DataUser> dataUserArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // find view by id all components
        enterNameReg = findViewById(R.id.registerName);
        enterEmailReg = findViewById(R.id.registerEmail);
        enterPassReg = findViewById(R.id.registerPassword);
        enterConfPassReg = findViewById(R.id.registerConfPassword);
        google = findViewById(R.id.regisGoog);
        facebook = findViewById(R.id.regisFaceb);
        twitter = findViewById(R.id.regisTwitt);
        registerButton = findViewById(R.id.registerBtn);
        loginInt = findViewById(R.id.loginMoveText);

        regisDBHelper = new RegisDBHelper(this);

        // intent to login page
        loginInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });

        // toggle for create password
        enterPassReg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int right = 2;
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(event.getRawX() >= enterPassReg.getRight()-enterPassReg.getCompoundDrawables()[right].getBounds().width()){
                        int selection = enterPassReg.getSelectionEnd();
                        if(passwordVisible) {
                            enterPassReg.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.password_off, 0);
                            // hide password
                            enterPassReg.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }
                        else {
                            enterPassReg.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.password_on, 0);
                            // show password
                            enterPassReg.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        enterPassReg.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        // toggle for confirm password
        enterConfPassReg.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int right = 2;
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(event.getRawX() >= enterConfPassReg.getRight()-enterConfPassReg.getCompoundDrawables()[right].getBounds().width()){
                        int selection = enterConfPassReg.getSelectionEnd();
                        if(passwordVisible) {
                            enterConfPassReg.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.password_off, 0);
                            // hide password
                            enterConfPassReg.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }
                        else {
                            enterConfPassReg.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.password_on, 0);
                            // show password
                            enterConfPassReg.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        enterConfPassReg.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        // register button clicked
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameReg = enterNameReg.getText().toString();
                emailReg = enterEmailReg.getText().toString();
                createPasswordReg = enterPassReg.getText().toString();
                confPasswordReg = enterConfPassReg.getText().toString();
                validateRegister();
            }
        });

        // social media register method
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                finish();
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                finish();
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                finish();
            }
        });
    }

    // condition to validate register
    private void validateRegister() {
        if (nameReg.equals("") || emailReg.equals("") || createPasswordReg.equals("") || confPasswordReg.equals("")) {
            Toast.makeText(RegisterActivity.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
        } else {
            if (nameReg.length() > 0 && emailReg.length() > 0 && createPasswordReg.length() > 0 && confPasswordReg.length() > 0) {
                if(nameReg.length() < 5) {
                    enterNameReg.setError("Name must be at least 5 characters");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailReg).matches()) {
                    enterEmailReg.setError("Email not valid, please insert valid email");
                } else if (createPasswordReg.length() < 5) {
                    enterPassReg.setError("Password must be at least 5 characters");
                } else if (!createPasswordReg.matches("(.*[A-Z].*)")) {
                    enterPassReg.setError("Password must be at least 1 uppercase");
                } else if (!createPasswordReg.matches("(.*[0-9].*)")) {
                    enterPassReg.setError("Password must be at least 1 number");
                } else if (!createPasswordReg.matches("(.*[a-z].*)")) {
                    enterPassReg.setError("Password must be at least 1 lowercase");
                } else if (!createPasswordReg.matches("(.*[@,#,\\,$,%,^,&,+,=,!].*)")) {
                    enterPassReg.setError("Password must be at least 1 special character");
                }
            }

            if (createPasswordReg.equals(confPasswordReg)) {
                checkEmailUser = regisDBHelper.emailCheck(emailReg);
                if (checkEmailUser == false) {
                    insertDataDb = regisDBHelper.insertData(nameReg, emailReg, createPasswordReg);
                    if (insertDataDb == true) {
                        Toast.makeText(RegisterActivity.this, "Successfully Register", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration failed, please check again", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Email already registered", Toast.LENGTH_SHORT).show();
                }
            } else {
                enterConfPassReg.setError("Password didn't matched");
            }
        }
    }
}