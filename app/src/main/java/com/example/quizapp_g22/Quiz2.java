package com.example.quizapp_g22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Quiz2 extends AppCompatActivity {

    //STEP 1 : declaration
    RadioButton radioButtonQ1,radioButtonQ2;
    Button bNext2;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        //Step 2: Recuperation des ids
        radioGroup=(RadioGroup) findViewById(R.id.radio);
        bNext2=(Button) findViewById(R.id.bNext2);
        radioButtonQ1= (RadioButton) findViewById(R.id.radioQ1);
        radioButtonQ2=(RadioButton) findViewById(R.id.radioQ2);
        //Step 3: Associattion de listeners

        bNext2.setOnClickListener(view -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();//

            if (selectedId==radioButtonQ2.getId()){
                Data.incremanteScore();
            }
            startActivity(new Intent(Quiz2.this,Quiz3.class));
        });
}

}