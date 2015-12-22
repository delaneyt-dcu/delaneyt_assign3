package com.example.delaneyt.tdassignthree;

import java.util.ArrayList;
import java.util.Arrays;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * This is a child activity of the MainActivity class, launched by explicit intent with the
 * @+id/home_gallery_button. It loads layout resources from the activity_photo_gallery.xml file
 * which include an actionbar containing a clickable back action arrow with the activity name and a
 * gridView of clickable image thumbprints which lunch a ImageViewActivity. The origins of the code
 * used in this class is accredited to Dr Adam Porter (ref project: UIGrdLayout.java)
 * Created by delaneyt on 11/12/2015.
 */
public class PhotoGalleryActivity extends AppCompatActivity {

    /**
     * Debug Tag for use logging debug output to LogCat
     */
    private final String TAG = "PhotoGalleryActivity";

    // Declares a protected string variable EXTRA_RES_ID and initiates its value as POS
    protected static final String EXTRA_RES_ID = "POS";

    // Creates an array of resource image files which is a private instance to this class
    private ArrayList<Integer> mThumbIdsCars = new ArrayList<>(
            Arrays.asList(R.drawable.image1, R.drawable.image2,
                    R.drawable.image3, R.drawable.image4, R.drawable.image5,
                    R.drawable.image6, R.drawable.image7, R.drawable.image8,
                    R.drawable.image9, R.drawable.image10, R.drawable.image11,
                    R.drawable.image12));

    /**
     * Public void method that overrides the onCreate method of the AppCompatActivity class and
     * saves the state of the application in a bundle based on the value of the savedInstance State
     * and carries out button intent actions.
     * @param savedInstanceState is the argument passed back to onCreate if the activity needs to be
     *                           created (e.g., orientation change) so that you don't lose this prior
     *                           information. If no data was supplied, savedInstanceState is null.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        // Calls the onCreate constructor of the AppCompatActivity superclass
        super.onCreate(savedInstanceState);

        // Tag marker for this activity
        Log.i(TAG, "The activity is visible and about to be created.");

        // Passes the activity_photo_gallery resource file as an argument into the setContentView method
        setContentView(R.layout.activity_photo_gallery);

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

        // gridview is defined in the layout file
        GridView gridview = (GridView) findViewById(R.id.gridview);

        // Create a new ImageAdapter and set it as the Adapter for this GridView
        gridview.setAdapter(new ImageAdapter(this, mThumbIdsCars));

        // Set an setOnItemClickListener on the GridView
        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                //Create an Intent to start the ImageViewActivity
                Intent intent = new Intent(PhotoGalleryActivity.this,
                        ImageViewActivity.class);

                // Add the ID of the thumbnail to display as an Intent Extra
                intent.putExtra(EXTRA_RES_ID, (int) id);

                // Start the ImageViewActivity
                startActivity(intent);

                // Tag marker for this activity
                Log.i(TAG, "The activity is visible has been started.");
            }
        });
    }
}
