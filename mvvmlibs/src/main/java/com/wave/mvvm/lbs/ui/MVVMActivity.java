package com.wave.mvvm.lbs.ui;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

/**
 * MvvM 基类
 * 封装 Toast 及 Navigation
 */
public abstract class MVVMActivity extends AppCompatActivity {

    protected UI ui;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = onCreateUI();
        ui.create(this);
        onCreateViewAfter();
    }


    public abstract UI onCreateUI();

    public abstract void onCreateViewAfter();

    private void onToastMsgChanged(String msg){
        showToast(msg);
    }

    private void onNavValueChanged(@IdRes int resId){
        //navigate(resId);
    }

    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public void showToast(@StringRes int resId){
        Toast.makeText(this,resId,Toast.LENGTH_SHORT).show();
    }

//    public NavController nav(){
//        return Navigation.findNavController(ui.binding.getRoot());
//    }

//    public void navigate(@IdRes int resId){
//        nav().navigate(resId);
//    }

    public void back(){
        this.finish();
    }
}
