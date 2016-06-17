package com.codepath.flickster2.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by annechen on 6/15/16.
 */
public class Movie {

    public String title;
    public String posterUrl;
    public String backdropUrl;
    public String rating;
    public String overview;

    public Movie(JSONObject jsonObject)throws JSONException { // ctrl-N to autocreate
        this.title = jsonObject.getString("original_title");
        this.posterUrl = jsonObject.getString("poster_path");
        this.rating = jsonObject.getString("vote_average");
        this.backdropUrl = jsonObject.getString("backdrop_path");
        this.overview = jsonObject.getString("overview");
    }

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterUrl);
    }

    public String getBackdropUrl() {
        return String.format("https://image.tmdb.org/t/p/w780/%s", backdropUrl);
    }

    public String getRating() {
        return rating;
    }

    public String getOverview() {
        return overview;
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();

        for (int i = 0; i < array.length(); i++){
            try {
                results.add(new Movie(array.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    public String toString(){
        return title + "-" + rating;
    }
}