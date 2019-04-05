package com.example.kaopiz_admin.myapplication.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kaopiz_admin.myapplication.base.MyViewModelFactory;
import com.example.kaopiz_admin.myapplication.ultil.PreferenceHelper;
import com.example.kaopiz_admin.myapplication.ultil.Util;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<V extends ViewDataBinding> extends Fragment {
    protected V viewBinding;
    @Inject
    protected MyViewModelFactory viewModelFactory;
    @Inject
    protected PreferenceHelper preferenceHelper;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return viewBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public abstract int getLayoutId();

    protected void returnLoginActivity() {
        Util.returnLogin(getActivity());
    }
}


