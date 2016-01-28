package com.example.bill.app0;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Toast.makeText(getApplicationContext(),
                        "This Button will help you contact me! ", Toast.LENGTH_LONG).
                        show();
            }
        });

        button1 = (Button) findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "This Button will Launch my " + ((Button) arg0).getText(), Toast.LENGTH_LONG).
                show();

            }
        });

        button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "This Button will Launch my "+ ((Button) arg0).getText(), Toast.LENGTH_LONG).
                        show();

            }
        });

        button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "This Button will Launch my "+ ((Button) arg0).getText(), Toast.LENGTH_LONG).
                        show();

            }
        });

        button4 = (Button) findViewById(R.id.button4);

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "This Button will Launch my "+ ((Button) arg0).getText(), Toast.LENGTH_LONG).
                        show();

            }
        });

        button5 = (Button) findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "This Button will Launch my "+ ((Button) arg0).getText(), Toast.LENGTH_LONG).
                        show();

            }
        });

        button6 = (Button) findViewById(R.id.button6);

        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(getApplicationContext(),
                        "This Button will Launch my "+ ((Button) arg0).getText(), Toast.LENGTH_LONG).
                        show();

            }
        });
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


}
