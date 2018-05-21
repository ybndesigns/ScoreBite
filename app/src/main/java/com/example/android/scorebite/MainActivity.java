package com.example.android.scorebite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int HPA = 50;
    int HPB = 50;
    int damage1 = 2;
    int damage2 = 4;
    int damage3 = 7;
    String specialMessage;

    ImageView img;
    Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation = AnimationUtils.loadAnimation(this, R.anim.blink);
        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                img.setVisibility(View.GONE);
            }
        });
    }

    public void flash(){
        img.setVisibility(View.VISIBLE);
        img.startAnimation(animation);
    }

    /**
     * Damage done by Creature A to Creature B
     */

    public void displayForCreatureB(int hit_points) {
        TextView hit_pointsView = findViewById(R.id.hit_points_b);
        hit_pointsView.setText(String.valueOf(hit_points));
    }

    /**
     * Damage done by Creature B to Creature A
     */

    public void displayForCreatureA(int hit_points) {
        TextView hit_pointsView = findViewById(R.id.hit_points_a);
        hit_pointsView.setText(String.valueOf(hit_points));
    }

    /**
     * Disables all playable buttons
     */

    public void disableButtons() {
        Button attackA1 = findViewById(R.id.attack_A1);
        Button attackA2 = findViewById(R.id.attack_A2);
        Button attackA3 = findViewById(R.id.attack_A3);
        Button attackB1 = findViewById(R.id.attack_B1);
        Button attackB2 = findViewById(R.id.attack_B2);
        Button attackB3 = findViewById(R.id.attack_B3);
        attackA1.setEnabled(false);
        attackA2.setEnabled(false);
        attackA3.setEnabled(false);
        attackB1.setEnabled(false);
        attackB2.setEnabled(false);
        attackB3.setEnabled(false);
    }

    /**
     * Enables all playable buttons
     */
    public void enableButtons() {
        Button attackA1 = findViewById(R.id.attack_A1);
        Button attackA2 = findViewById(R.id.attack_A2);
        Button attackA3 = findViewById(R.id.attack_A3);
        Button attackB1 = findViewById(R.id.attack_B1);
        Button attackB2 = findViewById(R.id.attack_B2);
        Button attackB3 = findViewById(R.id.attack_B3);
        attackA1.setEnabled(true);
        attackA2.setEnabled(true);
        attackA3.setEnabled(true);
        attackB1.setEnabled(true);
        attackB2.setEnabled(true);
        attackB3.setEnabled(true);
    }


    /**
     * Repeat method for attacks by Player 1
     */

    public void hitResultsA() {
        if (HPB <= 0) {
            displayForCreatureB(0);
            ImageView creatureB = findViewById(R.id.creatureB);
            creatureB.setVisibility(View.INVISIBLE);
            specialMessage = ("Player 1 wins!\nPlease click 'Full Heal' to play again!");
            disableButtons();
            Toast.makeText(this, specialMessage, Toast.LENGTH_LONG).show();
        } else {
            displayForCreatureB(HPB);
            img = findViewById(R.id.strike2);
            flash();
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
            ImageView creatureA = findViewById(R.id.creatureA);
            creatureA.setVisibility(View.INVISIBLE);
            specialMessage = ("Player 2 wins!\nPlease click 'Full Heal' to play again!");
            disableButtons();
            Toast.makeText(this, specialMessage, Toast.LENGTH_LONG).show();
        } else {
            displayForCreatureA(HPA);
            img = findViewById(R.id.strike1);
            flash();
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
        ImageView creatureA = findViewById(R.id.creatureA);
        ImageView creatureB = findViewById(R.id.creatureB);
        creatureA.setVisibility(View.VISIBLE);
        creatureB.setVisibility(View.VISIBLE);
        enableButtons();
    }
}
