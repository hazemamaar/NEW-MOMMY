package com.android.newmommy.repo;

import com.android.newmommy.data.network.Service;
import com.android.newmommy.model.UserInfo;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;

public class SetupRepo {

    Service service;

    @Inject
    public SetupRepo(Service service) {
        this.service = service;
    }

   public Completable register(UserInfo userInfo){
        return service.register(userInfo);
    }

    public Completable login(UserInfo userInfo){
        return service.login(userInfo);
    }
}
