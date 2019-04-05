package com.example.kaopiz_admin.myapplication.view.login_screen;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.kaopiz_admin.myapplication.R;
import com.example.kaopiz_admin.myapplication.databinding.ActivityLoginBinding;
import com.example.kaopiz_admin.myapplication.view.BaseActivity;
import com.example.kaopiz_admin.myapplication.view.register_screen.RegisterActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {
    LoginViewModel loginViewModel;
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
    }


}

