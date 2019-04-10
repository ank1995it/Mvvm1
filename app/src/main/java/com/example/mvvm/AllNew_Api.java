package com.example.mvvm;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import com.example.mvvm.Demo.*;

public interface AllNew_Api {
    @FormUrlEncoded
    @POST("userRegister")
    Call<UserRegisterModel> UserRegister(@Field("name") String name,
                                         @Field("email") String email,
                                         @Field("phone") String phone,
                                         @Field("password") String password,
                                         @Field("device_type") String device_type,
                                         @Field("reg_id") String reg_id);

}
