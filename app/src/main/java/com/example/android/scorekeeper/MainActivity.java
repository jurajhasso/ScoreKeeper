package com.example.android.scorekeeper;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int penaltyTeamA = 0;
    int penaltyTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Declare timer
    CountDownTimer cTimer = null;

    //start timer function
   public void startTimer(View v) {
       if(cTimer == null)
        cTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                TextView timerView = (TextView) findViewById(R.id.timer_new);
                timerView.setText(String.valueOf ("Time left: " + millisUntilFinished / 1000 + "s"));
            }

            public void onFinish() {
                TextView timerView = (TextView) findViewById(R.id.timer_new);
                timerView.setText(String.valueOf ("End of Game!"));
            }
        };
        cTimer.start();
    }

    //cancel timer
    public void cancelTimer() {
        if(cTimer!=null)
            cTimer.cancel();
    }

    public void addGoalA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void addPenaltyA(View v) {
        penaltyTeamA = penaltyTeamA + 1;
        displayPenaltyForTeamA(penaltyTeamA);
    }

    public void addGoalB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void addPenaltyB(View v) {
        penaltyTeamB = penaltyTeamB + 1;
        displayPenaltyForTeamB(penaltyTeamB);
    }

    public void displayForTeamA(int scoreTeamA) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }
    public void displayForTeamB(int scoreTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }

    public void displayPenaltyForTeamA(int penaltyTeamA) {
        TextView penaltyView = (TextView) findViewById(R.id.team_a_penalty);
        penaltyView.setText(String.valueOf(penaltyTeamA));
    }
    public void displayPenaltyForTeamB(int penaltyTeamB) {
        TextView penaltyView = (TextView) findViewById(R.id.team_b_penalty);
        penaltyView.setText(String.valueOf(penaltyTeamB));
    }


    public void reset(View v) {
        cancelTimer();
        TextView timerView = (TextView) findViewById(R.id.timer_new);
        timerView.setText(String.valueOf(60 + "s"));
        scoreTeamA = 0;
        scoreTeamB = 0;
        penaltyTeamA = 0;
        penaltyTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayPenaltyForTeamA(penaltyTeamA);
        displayPenaltyForTeamB(penaltyTeamB);
    }
}
