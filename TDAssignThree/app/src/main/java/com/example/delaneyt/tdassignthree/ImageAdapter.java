package com.example.delaneyt.tdassignthree;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

/**
 * This is a child activity contains formatting parameters used by the ImageViewActivity called by
 * explicit intent initiated by a clickable thumbprint image. This class does not launch a
 * screen/activity. The origins of the code used in this class is accredited to Dr Adam Porter
 * (ref project: UIGrdLayout.java)
 * Created by delaneyt on 11/12/2015.
 */
public class ImageAdapter extends BaseAdapter {

    // Variables declared and some set as CONSTANTS
    private static final int PADDING = 10;
    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;
    private Context mContext;
    private List<Integer> mThumbIds;

    // Store the list of image IDs
    public ImageAdapter(Context c, List<Integer> ids) {
        mContext = c;
        this.mThumbIds = ids;
    }

    // Return the number of items in the Adapter
    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    // Return the data item at position
    @Override
    public Object getItem(int position) {
        return mThumbIds.get(position);
    }

    // Will get called to provide the ID that
    // is passed to OnItemClickListener.onItemClick()
    @Override
    public long getItemId(int position) {
        return mThumbIds.get(position);
    }

    // Return an ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = (ImageView) convertView;

        // if convertView's not recycled, initialize some attributes
        if (imageView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(WIDTH, HEIGHT));
            imageView.setPadding(PADDING, PADDING, PADDING, PADDING);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        imageView.setImageResource(mThumbIds.get(position));
        return imageView;
    }
}
