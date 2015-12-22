package com.example.delaneyt.tdassignthree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * This is a child activity of the MainActivity class, launched by explicit intend with the
 * @+id/home_rugby_button. It loads layout resources from the activity_rugby_match.xml file
 * which include an actionbar containing a clickable back action arrow with the activity name; two
 * fragment containers which hold fragment-team-a.xml and fragment-team-b.xml and three buttons
 * which reset the variables/parameters, present a toast message summary and email this summary.
 * Created by delaneyt on 12/12/2015.
 */
public class RugbyMatchActivity extends AppCompatActivity {


    /**
     * Public method which take no parameters but returns a global variable which can be used
     * within the entire RugbyMatchActivity class
     * @return a string statement populated by multiple getMethods
     */
    public String getMatchStats() {
        return "SCORE:\n"
                // TeamNames are temporarily hardcoded until solution can be found
                + "Team A" + ":" + ((TeamAFragment) getFragmentManager().findFragmentById(R.id.teamA)).getTeamAScore() + "\n"
                + "Team B" + ":" + ((TeamBFragment) getFragmentManager().findFragmentById(R.id.teamB)).getTeamBScore() + "\n"
                + "\n"
                + "***MATCH STATISTICS***\n"
                + "\n"
                + "TEAM A: " + ((TeamAFragment) getFragmentManager().findFragmentById(R.id.teamA)).getTeamAStats() + "\n"
                + "TEAM B: " + ((TeamBFragment) getFragmentManager().findFragmentById(R.id.teamB)).getTeamBStats();
    }

    /**
     * Public void method that overrides the onCreate method of the AppCompatActivity class and
     * saves the state of the application in a bundle based on the value of the savedInstance State
     * and carries out button intent actions.
     * @param savedInstanceState is the argument passed back to onCreate if the activity needs to be
     *                           created (e.g., orientation change) so that you don't lose this prior
     *                           information. If no data was supplied, savedInstanceState is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Calls the onCreate constructor of the AppCompatActivity superclass
        super.onCreate(savedInstanceState);

        /*
        Debug Tag for use logging debug output to LogCat
        */
        String TAG = "RugbyMatchActivity";

        // Passes the activity_rugby_match resource file as an argument into the setContentView method
        setContentView(R.layout.activity_rugby_match);

        // my_toolbar is defined in the layout file
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        // Passes the myToolbar as an argument into the setSupportActionBar method
        setSupportActionBar(myToolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Back Arrow
        // To prevent NullPointerException error
        assert ab != null;

        //Boolean value of true used for variable
        ab.setDisplayHomeAsUpEnabled(true);

        // buttonReset is defined in the layout file
        Button buttonReset = (Button) findViewById(R.id.resetButton);

        // sets the onClick listener for buttonReset to reset the scoreText field
        buttonReset.setOnClickListener(new View.OnClickListener() {

            /**
             * Public void method that calls the resetText method within a fragment upon a button click
             * @param view with a scoreText value of null set by the resetText method
             */
            public void onClick(View view) {
                ((TeamAFragment) getFragmentManager().findFragmentById(R.id.teamA)).resetText();
                ((TeamBFragment) getFragmentManager().findFragmentById(R.id.teamB)).resetText();
                }
        });

        // Tag marker for this activity
        Log.i(TAG, "The score has been reset following Reset Button clicked.");

        // buttonSummary is defined in the layout file
        Button buttonSummary = (Button) this.findViewById(R.id.summaryButton);

        // sets the onClick listener for buttonSummary to produce matchStats
        buttonSummary.setOnClickListener(new View.OnClickListener() {

            /**
             * Public void method that calls the getMatchStats method to initiate the summaryStats
             * variable and passes its value into a toast message upon a button click
             * @param view of a toast message with summaryStats as its text
             */
            public void onClick(View view) {
                String summaryStats = getMatchStats();
                Toast.makeText(getApplicationContext(),summaryStats, Toast.LENGTH_LONG).show();
            }
        });

        // Tag marker for this activity
        Log.i(TAG, "The toast message is visible following Summary Button clicked.");

        // buttonEmail is defined in the layout file
        Button buttonEmail = (Button) findViewById(R.id.emailButton);

        // sets the onClick listener for buttonEmail to produce a email message
        buttonEmail.setOnClickListener(new View.OnClickListener() {

            /**
             * Public void method that calls the getMatchStats method to initiate the summaryStats
             * variable and passes its value into a toast message upon a button click
             * @param view if email message from users account with Match Results as subject and
             *             summaryStats as message text
             */
            public void onClick(View view) {

                // gets matchStats and uses its value to initiate summaryStats
                String summaryStats = getMatchStats();

                // Declares an implicit intent to create an email
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                // Provides parameters for the email
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Match Results");
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, summaryStats);

                // Start the ImageViewActivity
                startActivity(emailIntent);
            }
        });

        // Tag marker for this activity
        Log.i(TAG, "The email has been created following Email Button clicked.");
    }
}





