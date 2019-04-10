package com.example.mvvm;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {


    private static AppPreferences appPreference;
    private SharedPreferences sharedPreferences;

    private AppPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("email", Context.MODE_PRIVATE);
    }

    public static AppPreferences init(Context context) {
        if (appPreference == null) {
            appPreference = new AppPreferences(context);
        }
        return appPreference;
    }


    public void SaveString(String key, String value) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String GetString(String key) {

        return sharedPreferences.getString(key, "");
    }

    public void Logout(Activity activity) {

        sharedPreferences.edit().clear().apply();
    }
}
