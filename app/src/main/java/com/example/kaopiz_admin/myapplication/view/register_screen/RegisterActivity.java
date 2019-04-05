package com.example.kaopiz_admin.myapplication.view.register_screen;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.kaopiz_admin.myapplication.R;
import com.example.kaopiz_admin.myapplication.databinding.ActivityRegisterBinding;
import com.example.kaopiz_admin.myapplication.dialog.DialogConfirmNoTitle;
import com.example.kaopiz_admin.myapplication.view.BaseActivity;
import com.example.kaopiz_admin.myapplication.view.login_screen.LoginActivity;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding> implements DialogConfirmNoTitle.CallBackDialogActivityCom {

    DialogConfirmNoTitle dialogConfirm;
    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding.bar.title.setText(R.string.title_register);
        goneTxtErr();
        viewBinding.edtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                goneTxtErr();
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
                goneTxtErr();
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
        viewBinding.edtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                goneTxtErr();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    viewBinding.edtPhone.setBackground(getResources().getDrawable(R.drawable.edittext_background));
                } else {
                    viewBinding.edtPhone.setBackground(getResources().getDrawable(R.drawable.edt_bg_change_text));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        viewBinding.edtAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                goneTxtErr();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    viewBinding.edtAddress.setBackground(getResources().getDrawable(R.drawable.edittext_background));
                } else {
                    viewBinding.edtAddress.setBackground(getResources().getDrawable(R.drawable.edt_bg_change_text));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        viewBinding.edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                goneTxtErr();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    viewBinding.edtName.setBackground(getResources().getDrawable(R.drawable.edittext_background));
                } else {
                    viewBinding.edtName.setBackground(getResources().getDrawable(R.drawable.edt_bg_change_text));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        viewBinding.btnRegister.setOnClickListener(v -> {
            if (viewBinding.edtName.getText().toString().trim().length() == 0) {
                viewBinding.txtNameError.setVisibility(View.VISIBLE);
                viewBinding.txtNameError.setText(getString(R.string.err_empy));
                viewBinding.edtName.setBackground(getResources().getDrawable(R.drawable.edt_bg_err));
            }
            if (viewBinding.edtPhone.getText().toString().trim().length() == 0) {
                viewBinding.txtPhoneError.setVisibility(View.VISIBLE);
                viewBinding.txtPhoneError.setText(getString(R.string.err_empy));
                viewBinding.edtPhone.setBackground(getResources().getDrawable(R.drawable.edt_bg_err));
            }
            if (viewBinding.edtAddress.getText().toString().trim().length() == 0) {
                viewBinding.txtAddressError.setVisibility(View.VISIBLE);
                viewBinding.txtAddressError.setText(getString(R.string.err_empy));
                viewBinding.edtAddress.setBackground(getResources().getDrawable(R.drawable.edt_bg_err));
            }
            if (viewBinding.edtPass.getText().toString().trim().length() == 0) {
                viewBinding.txtPassError.setVisibility(View.VISIBLE);
                viewBinding.txtPassError.setText(getString(R.string.err_empy));
                viewBinding.edtPass.setBackground(getResources().getDrawable(R.drawable.edt_bg_err));
            }
            if (viewBinding.edtEmail.getText().toString().trim().length() == 0) {
                viewBinding.txtEmailError.setVisibility(View.VISIBLE);
                viewBinding.txtEmailError.setText(getString(R.string.err_empy));
                viewBinding.edtEmail.setBackground(getResources().getDrawable(R.drawable.edt_bg_err));
            }
            if (viewBinding.edtName.getText().toString().trim().length() != 0 && viewBinding.edtEmail.getText().toString().trim().length() != 0
                    && viewBinding.edtPhone.getText().toString().trim().length() != 0 && viewBinding.edtPass.getText().toString().trim().length() != 0
                    && viewBinding.edtAddress.getText().toString().trim().length() != 0) {
                dialogConfirm = new DialogConfirmNoTitle(this, getString(R.string.name) + " : "+viewBinding.edtName.getText().toString()+"\n\n"
                        +getString(R.string.mail) + " : "+viewBinding.edtEmail.getText().toString()+"\n\n"
                        +getString(R.string.pass_login) + " : "+viewBinding.edtPass.getText().toString()+"\n\n"
                        +getString(R.string.phone) + " : "+viewBinding.edtPhone.getText().toString()+"\n\n"
                        +getString(R.string.address) + " : "+viewBinding.edtAddress.getText().toString()+"\n", this, this);
                dialogConfirm.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogConfirm.show();
            }

        });
        viewBinding.bar.iconBar.setOnClickListener(v -> finish());
    }

    private void goneTxtErr() {
        viewBinding.txtEmailError.setVisibility(View.GONE);
        viewBinding.txtPassError.setVisibility(View.GONE);
        viewBinding.txtNameError.setVisibility(View.GONE);
        viewBinding.txtAddressError.setVisibility(View.GONE);
        viewBinding.txtPhoneError.setVisibility(View.GONE);
    }

    @Override
    public void Btn2Click() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}

