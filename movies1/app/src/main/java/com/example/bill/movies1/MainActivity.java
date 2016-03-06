package com.example.bill.movies1;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

	//Replace API_KEY in Line 50

    final static String LOG_TAG = "Movie 1";

    GridView mMainGrid;
    ArrayList<Movies> mPopularList;
    ArrayList<Movies> mTopVotedList;
    final static String POP_LIST = "popList";
    final static String TOP_VOTE_LIST = "topVoteList";
    String poplarityURL;
    String ratingURL;
   String API_KEY = "";

    @Override
    protected void onStart() {
        super.onStart();

        if (mPopularList == null || mTopVotedList == null){ // Checking to see if data is present before loading
            if (NetworkActions.networkcheck(MainActivity.this)) {
                new MainSync().execute();
            } else {
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setMessage(getString(R.string.network_message));
                dialog.setCancelable(false);
                dialog.show();
            }
        } else {
            loadPreferenceList();
        }

        mMainGrid.setOnItemClickListener(MainActivity.this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  Add Toolbar for setting menu
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMainGrid = (GridView) findViewById(R.id.topMovieGrid);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent optionIntent = new Intent(this, SortPreferenceActivity.class);
            startActivity(optionIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Movies movie = (Movies) parent.getAdapter().getItem(position);

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("Movie", movie);
        startActivity(intent);
    }

    public class MainSync extends AsyncTask<Void, Void, Void> {
        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            dialog.setTitle("Loading...");
            dialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {

            poplarityURL = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key="
                    + API_KEY;

            ratingURL = "http://api.themoviedb.org/3/discover/movie?sort_by=vote_average.desc&api_key="
                    + API_KEY;

            mPopularList = new ArrayList<>();
            mTopVotedList = new ArrayList<>();

            URLResult(poplarityURL, mPopularList);
            URLResult(ratingURL, mTopVotedList);

            mPopularList.toString();

            return null;
        }


        @Override
        protected void onPostExecute(Void  s) {
            super.onPostExecute(s);
            loadPreferenceList();
            dialog.cancel();
        }
    }

    private void loadPreferenceList() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        if (sharedPreferences.getString("PREFERENCE_LIST", "popular").equals("popular")) {
            loadMovieAdapter(mPopularList);
        } else {
            loadMovieAdapter(mTopVotedList);

        }
    }

    private void loadMovieAdapter(ArrayList<Movies> _list) {
        CustomGridAdapter adapter = new CustomGridAdapter(MainActivity.this,_list);
        mMainGrid.setAdapter(adapter);
    }

    private void URLResult(String webAddress, ArrayList<Movies> _List) {
        try {

            URL url = new URL(webAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            String results = IOUtils.toString(inputStream);
            movieDBJsonParser(results, _List);
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void movieDBJsonParser(String s, ArrayList<Movies> movies) {
        try {
            JSONObject mainObject = new JSONObject(s);

            JSONArray resultsArray = mainObject.getJSONArray("results");
            for (int i = 0; i < resultsArray.length(); i++) {
                JSONObject indexObject = resultsArray.getJSONObject(i);
                Movies indexMovie = new Movies();
                indexMovie.setPath(indexObject.getString("backdrop_path"));
                indexMovie.setId(indexObject.getInt("id"));
                indexMovie.setOriginalTitle(indexObject.getString("original_title"));
                indexMovie.setOverview(indexObject.getString("overview"));
                indexMovie.setReleaseDate(indexObject.getString("release_date"));
                indexMovie.setPosterPath(indexObject.getString("poster_path"));
                indexMovie.setPopularity(indexObject.getDouble("popularity"));
                indexMovie.setTitle(indexObject.getString("title"));
                indexMovie.setVoteAverage(indexObject.getInt("vote_average"));
                indexMovie.setVoteCount(indexObject.getInt("vote_count"));

                movies.add(indexMovie);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(LOG_TAG, "JSON Error", e);
        }
    }

    public class CustomGridAdapter extends BaseAdapter {
        Context context;
        ArrayList<Movies> movieList;

        public CustomGridAdapter(Context context, ArrayList<Movies> movieDbList) {
            this.context = context;
            this.movieList = movieDbList;
        }

        @Override
        public long getItemId(int position) {
            return 123456000 + position;
        }

        @Override
        public int getCount() {
            return movieList.size();
        }

        @Override
        public Movies getItem(int position) {
            return movieList.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.poster_view, parent, false);
            }
            Movies movieDb = getItem(position);


            ImageView imageViewcustom = (ImageView) convertView.findViewById(R.id.customImageView);
            Picasso.with(context).load("https://image.tmdb.org/t/p/w185" + movieDb.getPosterPath())
                    .placeholder(R.drawable.no_poster)
                    .into(imageViewcustom);

            return convertView;
        }
    }

}
