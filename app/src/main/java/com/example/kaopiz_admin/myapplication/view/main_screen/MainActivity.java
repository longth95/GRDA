package com.example.kaopiz_admin.myapplication.view.main_screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kaopiz_admin.myapplication.R;
import com.example.kaopiz_admin.myapplication.databinding.ActivityMainBinding;
import com.example.kaopiz_admin.myapplication.view.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}

