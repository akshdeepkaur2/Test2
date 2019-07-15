package com.example.androidparticlestarter.models;

public class Question {

    public static String ANSWER_BIRD = "bird";
    public static String ANSWER_FRUIT = "fruit";

    public Question(int question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public int question;

    public String answer;
}
