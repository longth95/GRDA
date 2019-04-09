package com.example.kaopiz_admin.myapplication.view.login_screen;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.example.kaopiz_admin.myapplication.model.Resource;
import com.example.kaopiz_admin.myapplication.model.ResponseErrorState;
import com.example.kaopiz_admin.myapplication.model.User;
import com.example.kaopiz_admin.myapplication.model.UserLogin;
import com.example.kaopiz_admin.myapplication.ultil.ForgotLiveData;
import com.google.gson.JsonObject;

import javax.inject.Inject;

public class LoginViewModel extends ViewModel {
    LoginRepository loginRepository;
    private ForgotLiveData<ResponseErrorState> responseErrorStateForgotLiveData;
    MutableLiveData<UserLogin> loginParam = new MutableLiveData<>();
    @Inject
    public  LoginViewModel(LoginRepository loginRepository){
        this.loginRepository = loginRepository;
        this.responseErrorStateForgotLiveData = loginRepository.getResponseStateMutableLiveData();
    }
    private LiveData<Resource<User>> loginIsSuccess = Transformations.switchMap(loginParam,input -> loginRepository.login(input.getMail(),input.getPassword()));
    public void login(String password , String mail){
        loginParam.postValue(new UserLogin(mail,password));
    }
    public LiveData<Resource<User>> loginStateLiveData(){
        return loginIsSuccess;
    }
}

