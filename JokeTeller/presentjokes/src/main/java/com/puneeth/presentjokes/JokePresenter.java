package com.puneeth.presentjokes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokePresenter extends AppCompatActivity {

    public static final String JOKE_KEY = "joke";

    public static Intent launchIntent(Context context, String joke) {
        Intent intent = new Intent(context, JokePresenter.class);
        intent.putExtra(JOKE_KEY, joke);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_presenter);

        String joke = getIntent().getStringExtra(JOKE_KEY);
        if (joke == null)
            joke = "No Sense of Humor Son! :(";

        TextView textView = (TextView) findViewById(R.id.joke);
        textView.setText(joke);
    }
}
