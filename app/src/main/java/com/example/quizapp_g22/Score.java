package com.example.quizapp_g22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Score extends AppCompatActivity {
    Button blogout;
    FirebaseAuth mAuth;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        blogout = (Button) findViewById(R.id.blogout);
        textView = (TextView) findViewById(R.id.tVscore);
        mAuth = FirebaseAuth.getInstance();

        textView.setText(Data.getScore()+" /4");

        blogout.setOnClickListener(view -> {
            mAuth.signOut();
            Data.restScore();
            startActivity(new Intent(Score.this,MainActivity.class));
        });

    }
}