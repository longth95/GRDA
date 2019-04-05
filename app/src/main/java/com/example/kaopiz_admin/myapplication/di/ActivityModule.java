package com.example.kaopiz_admin.myapplication.di;

import com.example.kaopiz_admin.myapplication.view.login_screen.LoginActivity;
import com.example.kaopiz_admin.myapplication.view.register_screen.RegisterActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    @ContributesAndroidInjector
    public abstract LoginActivity loginActivity();
    @ContributesAndroidInjector
    public abstract RegisterActivity registerActivity();
}
