package com.example.kaopiz_admin.myapplication.view.register_screen;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kaopiz_admin.myapplication.base.BaseRepository;
import com.example.kaopiz_admin.myapplication.model.Resource;
import com.example.kaopiz_admin.myapplication.model.Respone;
import com.example.kaopiz_admin.myapplication.model.User;
import com.example.kaopiz_admin.myapplication.ultil.Constant;
import com.example.kaopiz_admin.myapplication.ultil.PreferenceHelper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class RegisterRepository  extends BaseRepository {
    Context context;
    @Inject
    public RegisterRepository(PreferenceHelper preferenceHelper, Context context) {
        super(preferenceHelper);
        this.context = context;
    }

    public LiveData<Resource<Boolean>> register(String name , String phone , String address ,String mail, String password) {
        MutableLiveData<Resource<Boolean>> register = new MutableLiveData<>();
        register.postValue(Resource.loading());
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.URL_REGISTER, response -> {
            try {
                JSONObject jsonObject = new JSONObject(response);
                if(jsonObject.getInt("code") == 200){
                    register.postValue(Resource.success(true));
                }else {
                    register.postValue(Resource.success(false));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> {
           register.postValue(Resource.error("LOI"));
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<>();
                param.put(Constant.MAIL,mail);
                param.put(Constant.PASS_WORD,password);
                param.put(Constant.ADDRESS,address);
                param.put(Constant.USER_NAME,name);
                param.put(Constant.NUMBER_PHONE,phone);
                return param;
            }
        };
        requestQueue.add(stringRequest);
        return register;
    }
}
