package com.example.android.scorebite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int HPA = 50;
    int HPB = 50;
    int damage1 = 2;
    int damage2 = 4;
    int damage3 = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Damage done by Creature A to Creature B
     */

    public void displayForCreatureB(int hit_points) {
        TextView hit_pointsView = (TextView) findViewById(R.id.hit_points_b);
        hit_pointsView.setText(String.valueOf(hit_points));
    }

    /**
     * Damage done by Creature B to Creature A
     */

    public void displayForCreatureA(int hit_points) {
        TextView hit_pointsView = (TextView) findViewById(R.id.hit_points_a);
        hit_pointsView.setText(String.valueOf(hit_points));
    }

    /**
     * Displaying a special message upon winning
     */

    public void displaySpecialMessage(String stat_change) {
        TextView stat_changeView = (TextView) findViewById(R.id.special_message);
        stat_changeView.setText(String.format(stat_change));
    }

    /**
     * Repeat method for attacks by Player 1
     */

    public void hitResultsA() {
        if (HPB <= 0) {
            displayForCreatureB(0);
            ImageView creatureB = (ImageView) findViewById(R.id.creatureB);
            creatureB.setVisibility(View.INVISIBLE);
            displaySpecialMessage("Player 1 wins!\nPlease click 'Full Heal' to play again!");
        } else {
            displayForCreatureB(HPB);
            /** ImageView got_hit_B = (ImageView) findViewById(R.id.strike2);
            got_hit_B.setVisibility(View.VISIBLE);
            got_hit_B.setVisibility(View.INVISIBLE); **/
        }
    }

    /**
     * Attacks for Player 1 to Player 2
     */

    public void atk1A(View v) {
        HPB -= damage1;
        hitResultsA();
    }

    public void atk2A(View v) {
        HPB -= damage2;
        hitResultsA();
    }

    public void atk3A(View v) {
        HPB -= damage3;
        hitResultsA();
    }

    /**
     * Repeat method for attacks by Player 1
     */

    public void hitResultsB() {
        if (HPA <= 0) {
            displayForCreatureA(0);
            ImageView creatureA = (ImageView) findViewById(R.id.creatureA);
            creatureA.setVisibility(View.INVISIBLE);
            displaySpecialMessage("Player 2 wins!\nPlease click 'Full Heal' to play again!");
        } else {
            displayForCreatureA(HPA);
            /** ImageView got_hit_A = (ImageView) findViewById(R.id.strike1);
            got_hit_A.setVisibility(View.VISIBLE);
            got_hit_A.setVisibility(View.INVISIBLE); **/
        }
    }

    /**
     * Attacks for Player 2 to Player 1
     */

    public void atk1B(View v) {
        HPA -= damage1;
        hitResultsB();
    }

    public void atk2B(View v) {
        HPA -= damage2;
        hitResultsB();
    }

    public void atk3B(View v) {
        HPA -= damage3;
        hitResultsB();
    }

    public void reset(View v) {
        HPA = 50;
        HPB = 50;
        displayForCreatureB(HPB);
        displayForCreatureA(HPA);
        ImageView creatureA = (ImageView) findViewById(R.id.creatureA);
        ImageView creatureB = (ImageView) findViewById(R.id.creatureB);
        creatureA.setVisibility(View.VISIBLE);
        creatureB.setVisibility(View.VISIBLE);
        displaySpecialMessage("");
    }
}
