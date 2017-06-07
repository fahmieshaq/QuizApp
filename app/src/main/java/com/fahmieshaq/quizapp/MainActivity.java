package com.fahmieshaq.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Some quiz questions worth 1 point and others worth half a point
    private final int QUIZ_SCORE_ONE_POINT = 1;
    private final double QUIZ_SCORE_HALF_POINT = .5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Evaluate user's answer and assign a score. Correct answer worths 1 point
     *
     * @return a score of either 1 or 0
     */
    private int evaluateQuestion1() {
        int score = 0;
        RadioButton radioButton = (RadioButton) findViewById(R.id.radiobutton_question1_option3);
        if (radioButton.isChecked()) {
            score = QUIZ_SCORE_ONE_POINT;
        }

        return score;
    }

    /**
     * Evaluate user's answer and assign a score. Correct answer worths 1 point
     *
     * @return a score of either 1 or 0
     */
    private int evaluateQuestion2() {
        int score = 0;
        RadioButton radioButton = (RadioButton) findViewById(R.id.radiobutton_question2_option3);
        if (radioButton.isChecked()) {
            score = QUIZ_SCORE_ONE_POINT;
        }

        return score;
    }

    /**
     * Evaluate user's answer and assign a score. Correct answer worths 1 point
     *
     * @return a score of either 1 or 0
     */
    private int evaluateQuestion3() {
        int score = 0;
        RadioButton radioButton = (RadioButton) findViewById(R.id.radiobutton_question3_option1);
        if (radioButton.isChecked()) {
            score = QUIZ_SCORE_ONE_POINT;
        }

        return score;
    }

    /**
     * Evaluate user's answer and assign a score. Question 4 multiple choices are
     * presented in checkboxes. There are two correct answers and each answer
     * worths half a point. If a user selects a wrong answer, .5 point is deducted.
     *
     * @return a score of either 1 , .5, or 0
     */
    private double evaluateQuestion4() {
        // Keep a score of the first correct answer
        double scoreOption1 = 0;

        // Keep a score of the second correct answer
        double scoreOption2 = 0;

        // Keep a score of the wrong answer
        double deductHalfPoint = 0;

        // Keep a total score of question 4
        double overallQuestion4Score = 0;

        CheckBox checkBoxOption1 = (CheckBox) findViewById(R.id.checkbox_question4_option1);
        CheckBox checkBoxOption2 = (CheckBox) findViewById(R.id.checkbox_question4_option2);
        CheckBox checkBoxOption3 = (CheckBox) findViewById(R.id.checkbox_question4_option3);

        // Correct answer
        if (checkBoxOption1.isChecked()) {
            scoreOption1 = QUIZ_SCORE_HALF_POINT;
        }

        // Correct answer
        if (checkBoxOption2.isChecked()) {
            scoreOption2 = QUIZ_SCORE_HALF_POINT;
        }

        // Wrong answer
        if (checkBoxOption3.isChecked()) {
            deductHalfPoint = .5;
        }

        // Calculate score
        overallQuestion4Score = scoreOption1 + scoreOption2 - deductHalfPoint;

        // Do not allow a negative score. A negative score of -0.5 happens when a user
        // selects the wrong answer only and never selects the two correct answers
        if (overallQuestion4Score < 0) {
            overallQuestion4Score = 0;
        }

        return overallQuestion4Score;
    }

    /**
     * Evaluate user's answer and assign a score. Correct answer worths 1 point
     *
     * @return a score of either 1 or 0
     */
    private int evaluateQuestion5() {
        int score = 0;
        EditText question5EditText = (EditText) findViewById(R.id.edittext_question5);
        String answer = question5EditText.getText().toString();

        if (answer.equalsIgnoreCase("ottawa")) {
            score = QUIZ_SCORE_ONE_POINT;
        }

        return score;
    }

    /**
     * Evaluate all answers and calculate the final score. Correct answer worths 1 point
     *
     */
    public void submitQuiz(View view) {
        int question1Score = evaluateQuestion1();
        int question2Score = evaluateQuestion2();
        int question3Score = evaluateQuestion3();
        double question4Score = evaluateQuestion4();
        int question5Score = evaluateQuestion5();

        double totalScore = question1Score + question2Score + question3Score + question4Score + question5Score;

        // Prepare a toast message that displays the total score and a score of each question
        String finalResults = getString(R.string.mainActivity_toast_finalResults, String.valueOf(totalScore), String.valueOf(question1Score), String.valueOf(question2Score), String.valueOf(question3Score), String.valueOf(question4Score), String.valueOf(question5Score));

        Toast.makeText(this, finalResults, Toast.LENGTH_LONG).show();
    }
}
