package com.android.newmommy.ui.viewmodel;

import android.util.Log;

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
public class SignUpViewModel extends ViewModel {
   private MutableLiveData <Boolean> userInfoMutableLiveData =new MutableLiveData<Boolean>(false);
    public LiveData<Boolean>userInfoLiveData=userInfoMutableLiveData;
    SetupRepo setupRepo;

    @Inject
    public SignUpViewModel(SetupRepo setupRepo) {
        this.setupRepo = setupRepo;
    }
    public void register(UserInfo userInfo){
        setupRepo.register(userInfo).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                userInfoMutableLiveData.setValue(Boolean.TRUE);
                Log.i("cccc", "onComplete: "+"Done SignUp");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("mmm", "onError: "+e.getLocalizedMessage());
            }
        });
    }


}
