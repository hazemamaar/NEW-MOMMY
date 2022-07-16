package com.android.newmommy.repo;

import com.android.newmommy.data.network.Service;
import com.android.newmommy.model.UserInfo;
import com.android.newmommy.model.UserModel;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

public class SetupRepo {

    Service service;

    @Inject
    public SetupRepo(Service service) {
        this.service = service;
    }

   public Completable register(UserInfo userInfo){
        return service.register(userInfo);
    }

    public Observable<UserModel> login(UserInfo userInfo){
        return service.login(userInfo);
    }
}
