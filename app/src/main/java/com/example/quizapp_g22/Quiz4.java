package com.example.quizapp_g22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz4 extends AppCompatActivity {


    //STEP 1 : declaration
    RadioButton radioButtonQ1, radioButtonQ2;
    Button bNext4;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz4);
        //Step 2: Recuperation des ids
        bNext4 = (Button) findViewById(R.id.bNext4);
        radioButtonQ1 = (RadioButton) findViewById(R.id.radioQ1);
        radioButtonQ2 = (RadioButton) findViewById(R.id.radioQ2);
        radioGroup=(RadioGroup) findViewById(R.id.radio);
        //Step 3: Associattion de listeners

        bNext4.setOnClickListener(view -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();//

            if (selectedId==radioButtonQ1.getId()){
                Data.incremanteScore();
            }
            startActivity(new Intent(Quiz4.this, Score.class));
        });
    }

}