package com.example.kaopiz_admin.myapplication;

import android.app.Activity;
import android.app.Application;

import com.example.kaopiz_admin.myapplication.di.AppComponent;
import com.example.kaopiz_admin.myapplication.di.DaggerAppComponent;
import com.example.kaopiz_admin.myapplication.ultil.Constant;
import com.example.kaopiz_admin.myapplication.ultil.RetrofitHelper;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import timber.log.Timber;

public class GRDAApp extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (Constant.IS_DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        RetrofitHelper.init(this);
        appComponent =  DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

}