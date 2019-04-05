package com.example.kaopiz_admin.myapplication.di;

import android.app.Application;
import android.content.Context;

import com.example.kaopiz_admin.myapplication.ultil.PreferenceHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ViewModelModule.class})
public class AppModule {
    @Singleton
    @Provides
    public Context provideContext(Application application){
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    public PreferenceHelper providePreferenceHelper(Context context){
        return new PreferenceHelper(context);
    }
}