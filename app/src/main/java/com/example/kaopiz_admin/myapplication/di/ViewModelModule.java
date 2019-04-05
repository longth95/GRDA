package com.example.kaopiz_admin.myapplication.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.kaopiz_admin.myapplication.base.MyViewModelFactory;
import com.example.kaopiz_admin.myapplication.view.login_screen.LoginViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel loginModel(LoginViewModel loginViewModel);

    @Binds
    abstract ViewModelProvider.Factory viewModelFactory(MyViewModelFactory myViewModelFactory);
}
