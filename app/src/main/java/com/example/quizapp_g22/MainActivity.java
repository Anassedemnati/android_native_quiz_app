package com.example.quizapp_g22;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //STEP 1 : declaration
    EditText etLogin,etPassword;
    Button bLogin;
    TextView tvRegister;

    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Step 2: Recuperation des ids
        etLogin=(EditText) findViewById(R.id.etLogin);
        etPassword=(EditText) findViewById(R.id.etPassword);
        bLogin=(Button) findViewById(R.id.blogin);
        tvRegister = (TextView) findViewById(R.id.tvRegister);
        mAuth= FirebaseAuth.getInstance();

        //Step 3: Associattion de listeners
        bLogin.setOnClickListener(view -> {
            //Step 4 : taritement
            loginUser();
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Step 4:Traitemet
                startActivity(new Intent(MainActivity.this,Register.class));
            }

        });




    }

    private void loginUser() {
        String email = etLogin.getText().toString();

        String password=etPassword.getText().toString();


        if (TextUtils.isEmpty(email)){
            etLogin.setError("Email cannot be empty");
            etLogin.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            etPassword.setError("password cannot be empty");
            etPassword.requestFocus();


        }else {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                 if (task.isSuccessful()){
                     Toast.makeText(MainActivity.this,"User logged succsessfully",Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(MainActivity.this,Quiz1.class));
                 }else {
                     Toast.makeText(MainActivity.this," logged Error : "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                 }
                }
            });
        }
    }





}

