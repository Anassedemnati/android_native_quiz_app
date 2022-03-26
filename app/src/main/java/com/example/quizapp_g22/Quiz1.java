package com.example.quizapp_g22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Quiz1 extends AppCompatActivity {

    //STEP 1 : declaration
    RadioGroup radioGroup;
    RadioButton radioButtonQ1,radioButtonQ2;
    Button bNext1;
    TextView tVquestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        //Step 2: Recuperation des ids
        bNext1=(Button) findViewById(R.id.bNext1);
        radioGroup=(RadioGroup) findViewById(R.id.radio);

        tVquestion=(TextView) findViewById(R.id.tVquestion);


        radioButtonQ1= (RadioButton) findViewById(R.id.radioQ1);
        radioButtonQ2=(RadioButton) findViewById(R.id.radioQ2);
        //Step 3: Associattion de listeners

        bNext1.setOnClickListener(view -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();//

            if (selectedId==radioButtonQ2.getId()){
                Data.incremanteScore();
            }
            startActivity(new Intent(Quiz1.this,Quiz2.class));
        });


    }
}