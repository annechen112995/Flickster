package com.codepath.flickster2.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.flickster2.R;
import com.codepath.flickster2.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class MoviesAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
        TextView tvTitle2;
        TextView tvDesc;
        ImageView ivJesus;
    }

    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, R.layout.item_movie, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // here's access to the data from before. here's some data, match up the data and view and return the view

        // Get the data item for this position
        Movie movie = getItem(position);

        ViewHolder viewHolder;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.ivJesus = (ImageView) convertView.findViewById(R.id.ivJesus);
            viewHolder.tvTitle2 = (TextView) convertView.findViewById(R.id.tvTitle2);
            viewHolder.tvDesc = (TextView) convertView.findViewById(R.id.tvDesc);
            convertView.setTag(viewHolder);
        } // inflates that xml. creates a representation in memory so we can access it
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // find the textView inside the convertView wrapper

        // Lookup view for data population
        //TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        //TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        ImageView ivPoster= (ImageView) convertView.findViewById(R.id.ivPoster);

        String imageUri = null;

        int orientation = getContext().getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            imageUri = movie.getPosterUrl();
        }
        else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            imageUri = movie.getBackdropUrl();
        }

        // Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(movie.getTitle());
        viewHolder.tvOverview.setText(movie.getOverview());
        //viewHolder.tvTitle2.setText(movie.getTitle());
        //viewHolder.tvDesc.setText(movie.getOverview());

        Log.d("MoviesAdapter", "Position: " + position);

        // rounded corners + loading screen
        Picasso.with(getContext()).load(imageUri).fit().centerCrop()
                .placeholder(R.drawable.loading).transform(new RoundedCornersTransformation(10, 10)).into(ivPoster);

        // Return the completed view to render on screen
        return convertView;


    }
}