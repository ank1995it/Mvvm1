package com.example.mvvm;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewModelDemo extends ViewModel {

    private MutableLiveData<UserRegisterModel> register1;


    public LiveData<UserRegisterModel> UserRegister(final Activity activity,String name,String email,String phone,String password,String device_type,String id) {
        register1 = new MutableLiveData<>();
        AllNew_Api api =RetrofitObject.get_client().create(AllNew_Api.class);
        api.UserRegister(name,email,phone,password,device_type,id).enqueue(new Callback<UserRegisterModel>() {
            @Override
            public void onResponse(Call<UserRegisterModel> call, Response<UserRegisterModel> response) {

                if (response.body() != null) {
                    register1.setValue(response.body());
                } else {
                    Toast.makeText(activity, "wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserRegisterModel> call, Throwable t) {

            }
        });
        return register1;
    }

}