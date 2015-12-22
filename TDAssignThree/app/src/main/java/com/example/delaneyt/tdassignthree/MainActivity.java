package com.example.delaneyt.tdassignthree;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * This is the main launch activity class for the App. It loads layout resources from the
 * activity_main.xml file which include an actionbar contain the App Name and two buttons with
 * explicit intent to launch two other internal App activities, namely PhotoGalleryActivity and
 * RubyMatch Activity
 * Created by delaneyt on 10/12/2015.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Debug Tag for use logging debug output to LogCat
     */
    private final String TAG = "MainActivity";

    /**
     * Protected method that overrides the onCreate method of the AppCompatActivity class and saves
     * the state of the application in a bundle based on the value of the savedInstance State and
     * carries out button intent actions.
     * @param savedInstanceState can be passed back to onCreate if the activity needs to be created
     *                           (e.g., orientation change) so that you don't lose this prior
     *                           information. If no data was supplied, savedInstanceState is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Calls the onCreate constructor of the AppCompatActivity superclass
        super.onCreate(savedInstanceState);

        // Tag marker for this activity
        Log.i(TAG, "The activity is visible and about to be created.");

        // Passes the activity_main resource file as an argument into the setContentView method
        setContentView(R.layout.activity_main);

        // my_toolbar is defined in the layout file
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

        // Passes the myToolbar as an argument into the setSupportActionBar method
        setSupportActionBar(myToolbar);

        // home_rugby_button is defined in the layout file
        Button button = (Button) findViewById(R.id.home_rugby_button);

        // sets the onClick listener for home_rugby_button to carry out an method/action
        button.setOnClickListener(new View.OnClickListener() {

            /**
             * Public void method which creates a intent to launch the RugbyMatchActivity class
             * upon a button click
             * @param arg0 is the argument in the form arg<PARAMETER_INDEX>, where
             *             PARAMETER_INDEX is 0 for the first parameter
             */
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, RugbyMatchActivity.class);
                startActivity(intent);
                Log.i(TAG, "The activity is visible and about to be started");
            }
        });

        // home_gallery_button is defined in the layout file
        Button button2 = (Button) findViewById(R.id.home_gallery_button);

        // sets the onClick listener for home_rugby_button to carry out an method/action
        button2.setOnClickListener(new View.OnClickListener() {

            /**
             * Public void method that creates a intent to launch the PhotoGalleryActivity class
             * upon a button click
             * @param arg0 is the name of the parameter in the form arg<PARAMETER_INDEX>, where
             *             PARAMETER_INDEX starts at 0 for the first parameter
             */
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, PhotoGalleryActivity.class);
                startActivity(intent);
                Log.i(TAG, "The activity is visible and about to be started");
            }
        });
    }
}
