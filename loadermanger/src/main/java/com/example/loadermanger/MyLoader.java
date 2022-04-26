package com.example.loadermanger;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.Random;

public class MyLoader extends AsyncTaskLoader<String>{

    public final String TAG = "MyLoader";
    public static final String ARG_WORD = "word";
    private String mWord;

    public MyLoader(Context context, Bundle args) {
        super(context);
        if (args != null)
            mWord = args.getString(ARG_WORD);
        Log.d(TAG, mWord);
    }

    @Override
    public String loadInBackground() {
        if (mWord == null) {
            return null;
        }
        Log.d(TAG, "loadInBackground");
        return generateString(mWord);
    }

    @Override
    public void forceLoad() {
        Log.d(TAG, "forceLoad");
        super.forceLoad();
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        Log.d(TAG, "onStartLoading");
        forceLoad();
    }

    @Override
    protected void onStopLoading() {
        super.onStopLoading();
        Log.d(TAG, "onStopLoading");
    }

    @Override
    public void deliverResult(String data) {
        Log.d(TAG, "deliverResult");
        super.deliverResult(data);
    }


    private String generateString(String text) {
        char [] characters = text.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = (int)(Math.random() * characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}
