package com.example.kaopiz_admin.myapplication.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.kaopiz_admin.myapplication.R;

public class DialogConfirmNoTitle  extends Dialog implements
        android.view.View.OnClickListener {
    TextView tv,btnCancel,btnYes;
    String tv1;
    Activity activity;
    CallBackDialogActivityCom callBackDialogCom;
    public DialogConfirmNoTitle(@NonNull Context context, String tv1, Activity activity, CallBackDialogActivityCom callBackDialogCom) {
        super(context);
        this.tv1 = tv1;
        this.activity = activity;
        this.callBackDialogCom = callBackDialogCom;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_no_title);
        tv = findViewById(R.id.tv);
        btnCancel = findViewById(R.id.iie);
        btnYes = findViewById(R.id.hai);
        btnCancel.setOnClickListener(this);
        tv.setText(tv1);
        btnYes.setOnClickListener(this);
    }
    public interface CallBackDialogActivityCom{

        void Btn2Click();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hai:
                callBackDialogCom.Btn2Click();
                break;
            case R.id.iie:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}


