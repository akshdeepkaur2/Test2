package com.example.androidparticlestarter.models;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    public static int currentQuestion = 0;

    public static List<Question> questions = new ArrayList<>();

    public static int rightAnswers = 0;

    public static void judgeAnswer(String answer) {
        if(questions.get(currentQuestion).answer.contentEquals(answer)){
            rightAnswers ++;
        }
        currentQuestion++;
    }

    public static boolean noMoreQuestions() {
        return currentQuestion == questions.size();
    }

    public static Question question() {
        return questions.get(currentQuestion);
    }

    public static String score() {
        return rightAnswers + "/" + questions.size();
    }

    public static void reset() {
        Quiz.questions.clear();
        Quiz.currentQuestion = 0;
        Quiz.rightAnswers = 0;
    }

}
