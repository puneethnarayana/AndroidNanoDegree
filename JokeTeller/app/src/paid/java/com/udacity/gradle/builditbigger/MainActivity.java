package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.puneeth.presentjokes.JokePresenter;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellTheJoke(View view) {
        getAndDisplayJokeFromGCE();
    }

//    private void initialToastJokeTeler(){
//        Joker myJoker = new Joker();
//        Toast.makeText(this, myJoker.getJoke(), Toast.LENGTH_SHORT).show();
//    }

//    private void launchJokePresenterActivity(View view) {
//        Intent intent = new Intent(this, JokePresenter.class);
//        Joker myJoker = new Joker();
//        String joke = myJoker.getJoke();
//        intent.putExtra(JokePresenter.JOKE_KEY, joke);
//        startActivity(intent);
//    }

    private void getAndDisplayJokeFromGCE() {

        new JokerAsyncTask() {
            @Override
            protected void onPostExecute(String s) {
                if (s != null) {
                    startActivity(JokePresenter.launchIntent(MainActivity.this, s));
                } else {
                    Toast.makeText(MainActivity.this, "Houston we've a problem!", Toast.LENGTH_LONG).show();
                }
            }
        }.execute();
    }
}
