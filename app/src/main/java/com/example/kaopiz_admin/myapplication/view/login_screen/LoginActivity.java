package com.example.kaopiz_admin.myapplication.view.login_screen;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.kaopiz_admin.myapplication.R;
import com.example.kaopiz_admin.myapplication.databinding.ActivityLoginBinding;
import com.example.kaopiz_admin.myapplication.dialog.DialogConfirmNoTitle;
import com.example.kaopiz_admin.myapplication.model.State;
import com.example.kaopiz_admin.myapplication.ultil.Constant;
import com.example.kaopiz_admin.myapplication.view.BaseActivity;
import com.example.kaopiz_admin.myapplication.view.main_screen.MainActivity;
import com.example.kaopiz_admin.myapplication.view.register_screen.RegisterActivity;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> implements DialogConfirmNoTitle.CallBackDialogActivityCom {
    LoginViewModel loginViewModel;
    DialogConfirmNoTitle dialogConfirm;
    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel.class);
        viewBinding.txtEmailError.setVisibility(View.GONE);
        viewBinding.txtPassError.setVisibility(View.GONE);
        dialogConfirm = new DialogConfirmNoTitle(getApplicationContext(),getString(R.string.login_err),this,this);
        loginViewModel.loginStateLiveData().observe(this, userResource -> {
            if (userResource.state == State.SUCCESS) {
                if(userResource.t!=null){
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    i.putExtra(Constant.USER, userResource.t);
                    startActivity(i);
                    finish();

                }else {
                    dialogConfirm.show();
                }
            }

        });
        viewBinding.edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                viewBinding.txtEmailError.setVisibility(View.GONE);
                viewBinding.txtPassError.setVisibility(View.GONE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    viewBinding.edtEmail.setBackground(getResources().getDrawable(R.drawable.edittext_background));
                } else {
                    viewBinding.edtEmail.setBackground(getResources().getDrawable(R.drawable.edt_bg_change_text));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        viewBinding.edtPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                viewBinding.txtEmailError.setVisibility(View.GONE);
                viewBinding.txtPassError.setVisibility(View.GONE);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    viewBinding.edtPass.setBackground(getResources().getDrawable(R.drawable.edittext_background));
                } else {
                    viewBinding.edtPass.setBackground(getResources().getDrawable(R.drawable.edt_bg_change_text));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        viewBinding.btnRegister.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
        viewBinding.btnLogin.setOnClickListener(view -> {
            if (viewBinding.edtEmail.getText().toString().trim().length() == 0) {
                viewBinding.txtEmailError.setVisibility(View.VISIBLE);
                viewBinding.txtEmailError.setText(getString(R.string.err_empy));
                viewBinding.edtEmail.setBackground(getResources().getDrawable(R.drawable.edt_bg_err));
            }
            if (viewBinding.edtPass.getText().toString().trim().length() == 0) {
                viewBinding.txtPassError.setVisibility(View.VISIBLE);
                viewBinding.txtPassError.setText(getString(R.string.err_empy));
                viewBinding.edtPass.setBackground(getResources().getDrawable(R.drawable.edt_bg_err));
            }
            if (viewBinding.edtPass.getText().length() != 0 && viewBinding.edtEmail.getText().length() != 0)
                loginViewModel.login(viewBinding.edtPass.getText().toString(), viewBinding.edtEmail.getText().toString());
        });
    }


    @Override
    public void Btn2Click() {
        viewBinding.edtEmail.setText("");
        viewBinding.edtPass.setText("");
        dialogConfirm.dismiss();
    }
}

