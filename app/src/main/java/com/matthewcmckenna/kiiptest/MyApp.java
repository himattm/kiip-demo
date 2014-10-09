package com.matthewcmckenna.kiiptest;

import android.app.Application;

import me.kiip.sdk.Kiip;

/**
 * Created by mattmckenna on 6/21/14.
 */
public class MyApp extends Application {
    private final String MY_APP_KEY = "88b4ff279e0f151ec481638e68dd12d2";
    private final String MY_APP_SECRET = "9c90fdf1e1df6fdc3f3cc7d0bc5ddd69";

    @Override
    public void onCreate() {
        super.onCreate();
        Kiip kiip = Kiip.init(this, MY_APP_KEY, MY_APP_SECRET);
        Kiip.setInstance(kiip);
    }
}

