package com.wave.mvvm.lbs.ui.vm;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.wave.mvvm.lbs.ui.listener.OnMVVMListener;

public class MVVMViewModel<L extends OnMVVMListener> extends ViewModel {

    public MutableLiveData<L> listenerLiveData = new MutableLiveData<>();

    public MutableLiveData<String> toastMagLiveData = new MutableLiveData<>();

    public MutableLiveData<Integer> toastResLiveData = new MutableLiveData<>();

    public MutableLiveData<Integer> navLiveData = new MutableLiveData<>();

    public void setListener(L listener){
        this.listenerLiveData.setValue(listener);
    }

    public void showToast(String msg){
        if(msg == null)return;
        this.toastMagLiveData.setValue(msg);
    }

    public void showToast(@StringRes Integer res){
        if(res == null)return;
        this.toastResLiveData.setValue(res);
    }

    public void navigate(@IdRes int resId){
        this.navLiveData.setValue(resId);
    }
}
