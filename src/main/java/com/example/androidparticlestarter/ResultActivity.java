package com.example.androidparticlestarter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidparticlestarter.models.Quiz;

public class ResultActivity extends AppCompatActivity {

    public TextView score;

    public Button playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        score = findViewById(R.id.score);
        playAgain = findViewById(R.id.play_again);

        score.setText(Quiz.score());

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, QuizActivity.class));
                finish();
            }
        });
    }
}
