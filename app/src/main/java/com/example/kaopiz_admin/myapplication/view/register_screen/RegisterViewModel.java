package com.example.kaopiz_admin.myapplication.view.register_screen;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.example.kaopiz_admin.myapplication.model.Resource;
import com.example.kaopiz_admin.myapplication.model.ResponseErrorState;
import com.example.kaopiz_admin.myapplication.model.User;
import com.example.kaopiz_admin.myapplication.ultil.ForgotLiveData;
import com.example.kaopiz_admin.myapplication.view.login_screen.LoginRepository;

import javax.inject.Inject;

public class RegisterViewModel extends ViewModel {
    RegisterRepository registerRepository;
    private ForgotLiveData<ResponseErrorState> responseErrorStateForgotLiveData;
    MutableLiveData<User> registerParam = new MutableLiveData<>();
    @Inject
    public  RegisterViewModel(RegisterRepository registerRepository){
        this.registerRepository = registerRepository;
        this.responseErrorStateForgotLiveData = registerRepository.getResponseStateMutableLiveData();
    }
    private LiveData<Resource<Boolean>> registerIsSuccess = Transformations.switchMap(registerParam, input -> registerRepository.register(input.getUserName(),
            input.getNumberPhone() , input.getAddress(),input.getMail(),input.getPassword()));
    public void register(String password ,String userName , String address , String mail , String numberPhone){
        registerParam.postValue(new User(userName,password,address,mail,0,numberPhone));
    }
    public LiveData<Resource<Boolean>> registerStateLiveData(){
        return registerIsSuccess;
    }
}
