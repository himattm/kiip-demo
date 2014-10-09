package com.matthewcmckenna.kiiptest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import me.kiip.sdk.Kiip;
import me.kiip.sdk.Poptart;


public class MyActivity extends KiipActivity {

    Button myButton;
    private final String MY_MOMENT_ID = "You Pressed The Button!!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        myButton = (Button) findViewById(R.id.my_Button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kiip.getInstance().saveMoment(MY_MOMENT_ID, new Kiip.Callback() {
                    @Override
                    public void onFinished(Kiip kiip, Poptart reward) {
                        onPoptart(reward);
                    }

                    @Override
                    public void onFailed(Kiip kiip, Exception exception) {
                        // handle failure
                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
