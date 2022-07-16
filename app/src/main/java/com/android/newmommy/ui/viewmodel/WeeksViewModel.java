package com.android.newmommy.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.newmommy.model.WeekModel;
import com.android.newmommy.repo.RepoApp;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class WeeksViewModel extends ViewModel {
    private MutableLiveData<List<String>> mutableLiveData = new MutableLiveData<>();
    public LiveData<List<String>> liveData = mutableLiveData;
    RepoApp repoApp;

    @Inject
    public WeeksViewModel(RepoApp repoApp) {
        this.repoApp = repoApp;
    }

    public void getWeeks() {
        repoApp.getAllWeeks().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<String> strings) {
                mutableLiveData.setValue(strings);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}