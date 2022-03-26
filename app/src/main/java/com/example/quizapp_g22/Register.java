package com.example.quizapp_g22;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    //STEP 1 : declaration
    EditText etFirstName,etLastName,etLogin,etPassword,etConfirm;
    Button blogin;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Step 2: Recuperation des ids
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        etLogin = (EditText) findViewById(R.id.etLogin);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirm = (EditText) findViewById(R.id.etConfirm);
        blogin = (Button) findViewById(R.id.blogin);

        mAuth= FirebaseAuth.getInstance();
        blogin.setOnClickListener(view -> {
            createUSer();
        });
    }

    private void createUSer() {
        String email = etLogin.getText().toString();

        String password ="";
        if (etPassword.getText().toString()!="" && etConfirm.getText().toString()!=""){
            password=etPassword.getText().toString();
        }

        if (TextUtils.isEmpty(email)){
            etLogin.setError("Email cannot be empty");
            etLogin.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            etPassword.setError("password cannot be empty");
            etPassword.requestFocus();
            etConfirm.setError("password cannot be empty");
            etConfirm.requestFocus();

        }else {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Register.this,"User registred succsessfully",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this,MainActivity.class));
                    }else {
                        Toast.makeText(Register.this,"Registration Error : "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}