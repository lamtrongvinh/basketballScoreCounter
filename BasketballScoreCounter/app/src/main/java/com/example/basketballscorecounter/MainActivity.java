package com.example.basketballscorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView nameTeamA;
    private TextView nameTeamB;
    private TextView textViewTeamA;
    private TextView textViewTeamB;
    private Button btn1_teamA;
    private Button btn2_teamA;
    private Button btn3_teamA;
    private Button btn1_teamB;
    private Button btn2_teamB;
    private Button btn3_teamB;
    private Button btn_resetValue;
    private int pointOfTeamA = 0;
    private int pointOfTeamB = 0;

    public void setPointOfTeamA(int point) {
        this.pointOfTeamA = point;
    }

    public int getPointOfTeamA() {
        return this.pointOfTeamA;
    }

    public void setPointOfTeamB(int point) {
        this.pointOfTeamB = point;
    }

    public int getPointOfTeamB() {
        return this.pointOfTeamB;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setElementWithID();
        this.addClickListener();
    }

    private void setElementWithID() {
        this.nameTeamA = findViewById(R.id.textNameTeamA);
        this.nameTeamB = findViewById(R.id.textNameTeamB);
        this.textViewTeamA = findViewById(R.id.teamA_score_value);
        this.textViewTeamB = findViewById(R.id.teamB_score_value);
        this.btn1_teamA = findViewById(R.id.btn_teamA_1point);
        this.btn2_teamA = findViewById(R.id.btn_teamA_2point);
        this.btn3_teamA = findViewById(R.id.btn_teamA_3point);
        this.btn1_teamB = findViewById(R.id.btn_teamB_1point);
        this.btn2_teamB = findViewById(R.id.btn_teamB_2point);
        this.btn3_teamB = findViewById(R.id.btn_teamB_3point);
        this.btn_resetValue = findViewById(R.id.btn_resetValue);
    }

    private void addClickListener() {
        this.btn1_teamA.setOnClickListener(this);
        this.btn2_teamA.setOnClickListener(this);
        this.btn3_teamA.setOnClickListener(this);
        this.btn1_teamB.setOnClickListener(this);
        this.btn2_teamB.setOnClickListener(this);
        this.btn3_teamB.setOnClickListener(this);
        this.btn_resetValue.setOnClickListener(this);

    }

    private void updateValuePoint() {
        this.textViewTeamA.setText(String.valueOf(pointOfTeamA));
        this.textViewTeamB.setText(String.valueOf(pointOfTeamB));
    }

    private void showTeamWin(String nameTeamWin) {
        Context context = getApplicationContext();
        CharSequence text = nameTeamWin + " Win";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_teamA_1point:
                this.pointOfTeamA++;
                this.updateValuePoint();
                break;
            case R.id.btn_teamA_2point:
                this.pointOfTeamA += 2;
                this.updateValuePoint();
                break;
            case R.id.btn_teamA_3point:
                this.pointOfTeamA += 3;
                this.updateValuePoint();
                break;
            case R.id.btn_teamB_1point:
                this.pointOfTeamB++;
                this.updateValuePoint();
                break;
            case R.id.btn_teamB_2point:
                this.pointOfTeamB += 2;
                this.updateValuePoint();
                break;
            case R.id.btn_teamB_3point:
                this.pointOfTeamB += 3;
                this.updateValuePoint();
                break;
            case R.id.btn_resetValue:
                this.pointOfTeamA = 0;
                this.pointOfTeamB = 0;
                this.updateValuePoint();
                break;
        }

        if (this.pointOfTeamA >= 20) {
            this.showTeamWin(this.nameTeamA.getText().toString());
            this.pointOfTeamA = 0;
            this.pointOfTeamB = 0;
            this.updateValuePoint();
        } else if (this.pointOfTeamB >= 20) {
            this.showTeamWin(this.nameTeamB.getText().toString());
            this.pointOfTeamA = 0;
            this.pointOfTeamB = 0;
            this.updateValuePoint();
        }

    }

}