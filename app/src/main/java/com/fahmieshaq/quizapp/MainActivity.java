package com.fahmieshaq.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int QUIZ_SCORE_ONE_POINT = 1;
    private final double QUIZ_SCORE_HALF_POINT = .5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int evaluateQuestion1() {
        int score = 0;
        RadioButton radioButton = (RadioButton) findViewById(R.id.radiobutton_question1_option3);
        if(radioButton.isChecked()) {
            score = QUIZ_SCORE_ONE_POINT;
        }

        return score;
    }

    private int evaluateQuestion2() {
        int score = 0;
        RadioButton radioButton = (RadioButton) findViewById(R.id.radiobutton_question2_option3);
        if(radioButton.isChecked()) {
            score = QUIZ_SCORE_ONE_POINT;
        }

        return score;
    }

    private int evaluateQuestion3() {
        int score = 0;
        RadioButton radioButton = (RadioButton) findViewById(R.id.radiobutton_question3_option1);
        if(radioButton.isChecked()) {
            score = QUIZ_SCORE_ONE_POINT;
        }

        return score;
    }

    private double evaluateQuestion4() {
        double scoreOption1 = 0;
        double scoreOption2 = 0;
        double deductHalfPoint = 0;
        double overallQuestion4Score = 0;
        CheckBox checkBoxOption1 = (CheckBox) findViewById(R.id.checkbox_question4_option1);
        CheckBox checkBoxOption2 = (CheckBox) findViewById(R.id.checkbox_question4_option2);
        CheckBox checkBoxOption3 = (CheckBox) findViewById(R.id.checkbox_question4_option3);

        if(checkBoxOption1.isChecked()) {
            scoreOption1 = QUIZ_SCORE_HALF_POINT;
        }

        if(checkBoxOption2.isChecked()) {
            scoreOption2 = QUIZ_SCORE_HALF_POINT;
        }

        if(checkBoxOption3.isChecked()) {
            deductHalfPoint = .5;
        }

        overallQuestion4Score = scoreOption1 + scoreOption2 - deductHalfPoint;
        if (overallQuestion4Score < 0) {
            overallQuestion4Score = 0;
        }

        return overallQuestion4Score;
    }

    private int evaluateQuestion5() {
        int score = 0;
        EditText question5EditText = (EditText) findViewById(R.id.edittext_question5);
        String answer = question5EditText.getText().toString();
        if(answer.equalsIgnoreCase("ottawa")) {
            score = QUIZ_SCORE_ONE_POINT;
        }
        return score;
    }

    public void submitQuiz(View view) {
        int question1Score = evaluateQuestion1();
        int question2Score = evaluateQuestion2();
        int question3Score = evaluateQuestion3();
        double question4Score = evaluateQuestion4();
        int question5Score = evaluateQuestion5();

        double totalScore = question1Score + question2Score + question3Score + question4Score + question5Score;

        String finalResults = getString(R.string.mainActivity_toast_finalResults, String.valueOf(totalScore), String.valueOf(question1Score), String.valueOf(question2Score), String.valueOf(question3Score), String.valueOf(question4Score), String.valueOf(question5Score));
        Toast.makeText(this, finalResults, Toast.LENGTH_LONG).show();
    }
}
