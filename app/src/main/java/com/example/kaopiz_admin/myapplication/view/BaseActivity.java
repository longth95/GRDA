package com.example.kaopiz_admin.myapplication.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.kaopiz_admin.myapplication.base.MyViewModelFactory;
import com.example.kaopiz_admin.myapplication.ultil.PreferenceHelper;
import com.example.kaopiz_admin.myapplication.ultil.Util;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;

public abstract class BaseActivity<V extends ViewDataBinding> extends AppCompatActivity {
    public abstract int getLayoutId();

    //    protected DialogErrorTitle alertDialogErr;
    protected V viewBinding;
    @Inject
    protected MyViewModelFactory viewModelFactory;
    @Inject
    protected PreferenceHelper preferenceHelper;
    private Util util;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewBinding = DataBindingUtil.setContentView(this, getLayoutId());
//        util = Util.getInstance();
    }

//    protected void returnLoginActivity() {
//        jp.tanqgakusha.hobro.ultil.Util.returnLogin(this);
//    }

//    public void handleErrorResponse(ResponseErrorState state) {
//        if (state == null) {
//            return;
//        }
//        switch (state) {
//            case UNAUTHORIZED:
//                preferenceHelper.putString(Constant.TOKEN_KEY, null);
//                if (alertDialogErr != null) {
//                    if (alertDialogErr.isShowing()) {
//                        alertDialogErr.dismiss();
//                        alertDialogErr.cancel();
//                        alertDialogErr = null;
//                    }
//                }
//                returnLoginActivity();
//                break;
//            case BAD_URL:
//            case NO_CONNECTION: {
//                if (alertDialogErr != null && alertDialogErr.isShowing()) {
//                    alertDialogErr.dismiss();
//                }
//
//                if (util.checkNetwork(this)) {
//                    DialogErrorTitle alertDialogErrConnection = new DialogErrorTitle(this, getString(R.string.server_timeout_error_title));
//                    alertDialogErrConnection.show();
//                } else {
//                    DialogErrorTitle alertDialogErrConnection = new DialogErrorTitle(this, getString(R.string.no_internet_access_title));
//                    alertDialogErrConnection.show();
//                }
//
//                break;
//            }
//            case TIME_OUT:
//                if (alertDialogErr == null) {
//                    alertDialogErr = new DialogErrorTitle(this, getString(R.string.server_timeout_error_title));
//                }
//
//                if (alertDialogErr.isShowing()) {
//                    return;
//                }
//                alertDialogErr.show();
//
//                break;
//        }
//    }

//    @Override
//    public AndroidInjector<Fragment> supportFragmentInjector() {
//        return fragmentDispatchingAndroidInjector;
//    }

    public Fragment getCurrentFragment(int id) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            Fragment fragment = fragmentManager.findFragmentById(id);
            return fragment;
        } else {
            return null;
        }

    }


    public Util getUtil() {
        return util;
    }
}
