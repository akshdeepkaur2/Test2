package com.example.androidparticlestarter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.androidparticlestarter.models.Question;
import com.example.androidparticlestarter.models.Quiz;

public class QuizActivity extends AppCompatActivity {

    private ImageView image;
    private LinearLayout bird;
    private LinearLayout fruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        image = findViewById(R.id.question);
        bird = findViewById(R.id.bird);
        fruit = findViewById(R.id.fruit);

        bird.setOnClickListener(onBirdClick);
        fruit.setOnClickListener(onFruitClick);

        initializeQuiz();
    }

    private void initializeQuiz() {
        Quiz.reset();

        Quiz.questions.add(new Question(R.drawable.apple, Question.ANSWER_FRUIT));
        Quiz.questions.add(new Question(R.drawable.pinyon_jay_bird, Question.ANSWER_BIRD));
        Quiz.questions.add(new Question(R.drawable.orange, Question.ANSWER_FRUIT));
        Quiz.questions.add(new Question(R.drawable.strawberry, Question.ANSWER_FRUIT));
        Quiz.questions.add(new Question(R.drawable.scarlet_tanager, Question.ANSWER_BIRD));

        image.setImageResource(Quiz.question().question);
    }

    private View.OnClickListener onBirdClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Quiz.judgeAnswer(Question.ANSWER_BIRD);
            if (Quiz.noMoreQuestions()) {
                startActivity(new Intent(QuizActivity.this, ResultActivity.class));
                finish();
            } else {
                image.setImageResource(Quiz.question().question);
            }

        }
    };

    private View.OnClickListener onFruitClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Quiz.judgeAnswer(Question.ANSWER_FRUIT);
            if (Quiz.noMoreQuestions()) {
                startActivity(new Intent(QuizActivity.this, ResultActivity.class));
                finish();
            } else {
                image.setImageResource(Quiz.question().question);
            }
        }
    };
}
