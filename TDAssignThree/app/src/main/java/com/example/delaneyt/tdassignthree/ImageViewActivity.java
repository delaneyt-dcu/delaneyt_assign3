package com.example.delaneyt.tdassignthree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

/**
 * This is a child activity of the PhotoGalleryActivity class, launched by explicit intent by a
 * clickable thumbprint image. It loads a drawable image.jpg  resource and displays in single view
 * by way of intent using ImageAdapter class and includes an actionbar containing a clickable back
 * action arrow with the activity name. The origins of the code used in this class is accredited to
 * Dr Adam Porter (ref project: UIGrdLayout.java)
 * Created by delaneyt on 11/12/2015.
 */
public class ImageViewActivity extends AppCompatActivity {

    /**
     * Public void method that overrides the onCreate method of the AppCompatActivity class and saves
     * the state of the application in a bundle based on the value of the savedInstance State and
     * carries out button intent actions.
     * @param savedInstanceState can be passed back to onCreate if the activity needs to be created
     *                           (e.g., orientation change) so that you don't lose this prior
     *                           information. If no data was supplied, savedInstanceState is null.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        /*
        Debug Tag for use logging debug output to LogCat
        */
        String TAG = "ImageViewActivity";

        // Calls the onCreate constructor of the AppCompatActivity superclass
        super.onCreate(savedInstanceState);

        // Get the Intent used to start this Activity
        Intent intent = getIntent();

        // Make a new ImageView
        ImageView imageView = new ImageView(getApplicationContext());

        // Get the ID of the image to display and set it as the image for this ImageView
        imageView.setImageResource(intent.getIntExtra(PhotoGalleryActivity.EXTRA_RES_ID, 0));

        // Passes the imageView as an argument into the setContentView method
        setContentView(imageView);

        // Tag marker for this activity
        Log.i(TAG, "The activity is visible and has been created.");
    }
}
