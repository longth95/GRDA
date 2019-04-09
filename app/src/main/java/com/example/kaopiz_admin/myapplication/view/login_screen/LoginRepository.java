package com.example.kaopiz_admin.myapplication.view.login_screen;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
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

public class LoginRepository extends BaseRepository {
    Context context;
    @Inject
    public LoginRepository(PreferenceHelper preferenceHelper, Context context) {
        super(preferenceHelper);
        this.context = context;
    }

    public LiveData<Resource<User>> login(String mail, String password) {
        MutableLiveData<Resource<User>> login = new MutableLiveData<>();
        login.postValue(Resource.loading());
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.URL_LOGIN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                JSONObject jsonObject = new JSONObject(response);
                if(jsonObject.getInt("code") == 200){
                    String content = jsonObject.getString("content");
                    User user = new Gson().fromJson(content,User.class);
                    login.postValue(Resource.success(user));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            }
        }, error -> {
            int errorCode = 0;
            if (error instanceof TimeoutError) {
                errorCode = -7;
            } else if (error instanceof NoConnectionError) {
                errorCode = -1;
            } else if (error instanceof AuthFailureError) {
                errorCode = -6;
            } else if (error instanceof ServerError) {
                errorCode = 0;
            } else if (error instanceof NetworkError) {
                errorCode = -1;
            } else if (error instanceof ParseError) {
                errorCode = -8;
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<>();
                param.put(Constant.MAIL,mail);
                param.put(Constant.PASS_WORD,password);
                return param;
            }
        };
        requestQueue.add(stringRequest);
        return login;
    }
}
