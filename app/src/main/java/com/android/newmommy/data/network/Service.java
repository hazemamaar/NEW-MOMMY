package com.android.newmommy.data.network;

import com.android.newmommy.model.UserInfo;
import com.android.newmommy.model.UserModel;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Service {

    @GET("days/en")
     Observable<List<String>> getWeek();
     @POST("signup")
     Completable register(@Body UserInfo userInfo);
     @POST("signin")
     Observable<UserModel> login(@Body UserInfo userInfo);
}