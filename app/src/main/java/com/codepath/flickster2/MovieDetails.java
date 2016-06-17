package com.codepath.flickster2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by annechen on 6/17/16.
 */

public class MovieDetails extends MoviesActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
    }

    public void onSubmit(View view) {
        Toast.makeText(this, "Thanks for rating!", Toast.LENGTH_SHORT).show();
    }
}
