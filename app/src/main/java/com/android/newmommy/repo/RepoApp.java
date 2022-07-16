package com.android.newmommy.repo;

import com.android.newmommy.data.network.Service;
import com.android.newmommy.model.WeekModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.rxjava3.core.Observable;

@Singleton
public class RepoApp {

    Service service;


    @Inject
    public RepoApp(Service service) {
        this.service = service;
    }

    public  Observable<List<String>> getAllWeeks(){
        return service.getWeek();
    }
}
