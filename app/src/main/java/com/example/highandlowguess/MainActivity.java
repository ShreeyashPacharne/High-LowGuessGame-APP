package com.example.highandlowguess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;


public class MainActivity extends AppCompatActivity {

    int rand; // intialise the variable up here to make it global;

    //using oop is considered best
    public void generateRandomNumber(){

        //method 1

//        int min = 1;
//        int max = 20;
//        rand = (int) Math.rint(Math.random()*(max-min+1)+min);

        //method 2
        Random r = new Random();
        rand = r.nextInt(20) + 1;

    }

    public void highLowGuess(View v) {
        EditText num = (EditText) findViewById(R.id.userIn);    //Taking input
        int guess = Integer.parseInt(num.getText().toString()); //converting EditText to Int
        String message;

        if (guess > rand) {
            message = "High";
        } else if (guess < rand) {
            message = "Low";
        } else {
            message = "You Guessed Right";
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // need to create the random number generation method here or it will create always new
        // random whenever we pressed the button
        generateRandomNumber();     //this function will generate random number
    }
}