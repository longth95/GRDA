package com.example.kaopiz_admin.myapplication.base;

import com.example.kaopiz_admin.myapplication.model.ResponseErrorState;
import com.example.kaopiz_admin.myapplication.ultil.Constant;
import com.example.kaopiz_admin.myapplication.ultil.ForgotLiveData;
import com.example.kaopiz_admin.myapplication.ultil.PreferenceHelper;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

public abstract class BaseRepository {
    protected final ForgotLiveData<ResponseErrorState> responseStateMutableLiveData;
    protected PreferenceHelper preferenceHelper;


    public BaseRepository(PreferenceHelper preferenceHelper) {
        this.preferenceHelper = preferenceHelper;
        responseStateMutableLiveData = new ForgotLiveData<>();

    }
    public ForgotLiveData<ResponseErrorState> getResponseStateMutableLiveData() {
        return responseStateMutableLiveData;
    }

    protected void handlerError(Throwable throwable) {
        if (throwable instanceof SocketTimeoutException) {
            responseStateMutableLiveData.postValue(ResponseErrorState.TIME_OUT);
        } else if (throwable instanceof IOException) {
            responseStateMutableLiveData.postValue(ResponseErrorState.NO_CONNECTION);
        }else if (throwable instanceof UnknownHostException) {
            responseStateMutableLiveData.postValue(ResponseErrorState.UNKNOWN);
        } else if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            if (httpException.code() == 401) {
                responseStateMutableLiveData.postValue(ResponseErrorState.UNAUTHORIZED);
            }
        } else {
            responseStateMutableLiveData.postValue(ResponseErrorState.UNKNOWN);
        }
    }

    protected String checkTokenNull() {
        if (getToken() == null) {
            responseStateMutableLiveData.postValue(ResponseErrorState.UNAUTHORIZED);
        }
        return getToken();
    }

    // always get token new
    protected String getToken() {
        return preferenceHelper.getString(Constant.TOKEN_KEY,null);
    }
}
