package com.example.bill.movies1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Movies movieIntent = (Movies) intent.getSerializableExtra("Movie");

        if (movieIntent != null) {
            // Load Title text
            TextView titleText = (TextView) findViewById(R.id.detail_title);
            titleText.setText(movieIntent.getTitle());

            // Load image in Image View
            ImageView detailImage = (ImageView) findViewById(R.id.detail_image);
            Picasso.with(this).load("https://image.tmdb.org/t/p/w185" + movieIntent.getPosterPath())
                    .placeholder(R.drawable.no_poster)
                    .into(detailImage);

            // Load Release Date
            TextView releaseDateText = (TextView) findViewById(R.id.detail_release_date);
            releaseDateText.setText(movieIntent.getReleaseDate());

            // Load Popularity
            TextView popularityText = (TextView) findViewById(R.id.detail_popularity);
            popularityText.setText("Popularity: " + movieIntent.getPopularity());

            //Load Overview
            TextView overviewText = (TextView) findViewById(R.id.detail_overview);
            overviewText.setText(movieIntent.getOverview());

            // Load Average
            TextView voteAverageText = (TextView) findViewById(R.id.detail_vote_average);
            voteAverageText.setText("Voter Average: " + movieIntent.getVoteAverage());

            // Load Vote Count
            TextView voteCountText = (TextView) findViewById(R.id.detail_vote_count);
            voteCountText.setText("Voter Count: " + movieIntent.getVoteCount());
        } else {
            Toast.makeText(this, "ERROR No data was read",
                    Toast.LENGTH_LONG).show();
        }
    }
}
