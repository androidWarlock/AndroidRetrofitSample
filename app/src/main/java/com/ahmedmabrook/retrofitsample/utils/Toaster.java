package com.ahmedmabrook.retrofitsample.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Authored by Ahmed Mabrook - ahmed.mabrook@chestnut.com
 * On Jan 2017 .
 * Toaster: Describtion goes here.
 */

public class Toaster {
    private static Toaster toaster;
    Context mContext;

    private Toaster(Context context) {
        mContext = context;
    }

    public static Toaster with(Context context) {
        return getLogAndToast(context);
    }

    private static Toaster getLogAndToast(Context context) {

        if (toaster == null)
            return new Toaster(context);
        return toaster;
    }

    public void LogAndToast(String message){
        Log.d("Toaster",message);
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();

    }
}
