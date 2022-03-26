package com.example.quizapp_g22;

public class Question {
    String mainQuestion;
    String question1;
    String question2;
    int correctQuestion;

    public String getMainQuestion() {
        return mainQuestion;
    }

    public void setMainQuestion(String mainQuestion) {
        this.mainQuestion = mainQuestion;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public int getCorrectQuestion() {
        return correctQuestion;
    }

    public void setCorrectQuestion(int correctQuestion) {
        this.correctQuestion = correctQuestion;
    }

    public Question(String mainQuestion, String question1, String question2, int correctQuestion) {
        this.mainQuestion = mainQuestion;
        this.question1 = question1;
        this.question2 = question2;
        this.correctQuestion = correctQuestion;
    }

    public Question(String question1, String question2) {

    }
}
