package com.example.delaneyt.tdassignthree;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
 * This is one of two fragment activities used by the RugbyMatchActivity class to provide contained
 * functionality which allows the user to enter a teamNameB in a editText filed and chick on three
 * buttons each which increment teamScoreB textView field formatting parameters. It loads layout
 * resources from the fragment_team_b.xml file.
 * Created by delaneyt on 16/12/2015.
 */

public class TeamBFragment extends Fragment implements Button.OnClickListener {

    /**
     * Debug Tag for use logging debug output to LogCat
     */
    private final String TAG = "TeamBFragment";

    // Variables declared and some set
    Button btn1, btn2, btn3;
    TextView scoreText;
    EditText teamNameText;
    int counter = 0, noOfPenalties = 0, noOfConversions = 0, noOfTries = 0;

    // To prevent NullPointerException error
    @Nullable

    /**
     * Public View method that inflates the layout with a value each time a button is pressed.
     */
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team_b, container, false);
        btn1 = (Button) view.findViewById(R.id.penaltyButton);
        btn2 = (Button) view.findViewById(R.id.conversionButton);
        btn3 = (Button) view.findViewById(R.id.tryButton);
        scoreText = (TextView) view.findViewById(R.id.scoreTextView);
        teamNameText = (EditText) view.findViewById(R.id.editText);

        // Consider using the alternative switch/case to check which button is clicked
        // When +3 Penalty button is clicked, 3 points are added to current score
        btn1.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        noOfPenalties++;
                                        counter = counter + 3;
                                        scoreText.setText(Integer.toString(counter));
                                    }
                                }
        );

        // Tag marker for this activity
        Log.i(TAG, "The view has been inflated following +3Penalty Button clicked.");

        // When +2 Conversion button is clicked, 2 points are added to current score
        btn2.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        noOfConversions++;
                                        counter = counter + 2;
                                        scoreText.setText(Integer.toString(counter));
                                    }
                                }
        );

        // Tag marker for this activity
        Log.i(TAG, "The view has been inflated following +2Conversion Button clicked.");

        // When +5 Try button is clicked, 5 points are added to current score
        btn3.setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        noOfTries++;
                                        counter = counter + 5;
                                        scoreText.setText(Integer.toString(counter));
                                    }
                                }
        );

        // Tag marker for this activity
        Log.i(TAG, "The view has been inflated following +5Try Button clicked.");

        // view to be returned each time a button is pressed
        return view;
    }

    // Method called upon Reset in RugbyMatchActivity resetButton pressed
    public void resetText() {

        //TextView bound in fragment onCreate as member variable so that
        // score buttons above start from reset default (zero again)
        counter = 0;
        noOfPenalties = 0;
        noOfConversions = 0;
        noOfTries = 0;
        scoreText.setText(Integer.toString(counter));

        // teamNameText set to null following a failed manual test, refer to Test Schedule
        teamNameText.setText(null);

        // Tag marker for this activity
        Log.i(TAG, "The text was been reset.");
    }

    //Current value of counter used as teamScore in RugbyMatchActivity class
    public int getTeamBScore() {
        return counter;
    }

    //Current values used to pass as teamStats in RugbyMatchActivity class
    public String getTeamBStats() {
        return "PENALITIES- " + noOfPenalties + ", CONVERSION- " + noOfConversions + ", TRIES- " + noOfTries;
    }

    // This method does not work, further research required!
    //public EditText getTeamBName() {
    //    return teamNameText;
    //}

    @Override
    public void onClick(View v) {
    }
}