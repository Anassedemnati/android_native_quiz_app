package com.example.quizapp_g22;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static int score=0;
static List<Question> questionList =new ArrayList();
public static void incremanteScore(){
    score++;
}
public static String getScore(){
    return String.valueOf(score);
}
public static void restScore(){
    score=0;
}


    public static void main(String[] args) {

           questionList.add(new Question("A cette intersection, je laisse la priorité à droite :","oui","non",2));
           questionList.add(new Question("Le panneau de danger prend effet à :","6 km","150 km",2));
           questionList.add(new Question("Avant de partir, je laisse tourner mon moteur pour qu'il monte en température ","oui","nom",2));
           questionList.add(new Question("En tant qu'automobiliste, vous devez être plus vigilant lorsque : ","Le tramway est arrêté","Le tramway circule",1));

    }
}
