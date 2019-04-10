package com.example.mvvm;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {
    public static String key = "http://54.218.174.225/allNew/index.php/api/user/";
    public static Retrofit retrofit;

    public static Retrofit get_client() {
        if (retrofit == null)
            retrofit = new Retrofit.Builder().baseUrl(key).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
}
