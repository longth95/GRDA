package com.example.kaopiz_admin.myapplication.ultil;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;

public class ForgotLiveData<D> extends MediatorLiveData<D> {
    private boolean isChanged;

    @Override
    public void postValue(D value){
        isChanged = true;
        super.postValue(value);
    }

    @Override
    public void setValue(D value) {
        isChanged = true;
        super.setValue(value);
    }

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<D> observer) {
        super.observe(owner, responseErrorState -> {
            if (isChanged){
                observer.onChanged(responseErrorState);
                isChanged = false;
            }
        });
    }
}
