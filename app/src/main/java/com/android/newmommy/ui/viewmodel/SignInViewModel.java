package com.android.newmommy.ui.viewmodel;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.newmommy.model.UserInfo;
import com.android.newmommy.repo.SetupRepo;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class SignInViewModel extends ViewModel {
   private MutableLiveData<Boolean> userMutableLiveData =new MutableLiveData<>();
   public LiveData<Boolean> userInfoLiveData=userMutableLiveData;
    SetupRepo setupRepo;

    @Inject
    public SignInViewModel(SetupRepo setupRepo) {
        this.setupRepo = setupRepo;
    }

    public void login(UserInfo userInfo){
        setupRepo.login(userInfo).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                userMutableLiveData.setValue(true);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("mmmm", "onError: "+e.getLocalizedMessage());
            }
        });
    }
}
