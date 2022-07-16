package com.android.newmommy.di;

import com.android.newmommy.data.network.Service;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class ModuleApp {

    @Provides
    public static Service provideProduct() {
        return new Retrofit.Builder().baseUrl("https://api-app101.herokuapp.com/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).
                        addConverterFactory(GsonConverterFactory.create())
                .build().create(Service.class);

    }
}
