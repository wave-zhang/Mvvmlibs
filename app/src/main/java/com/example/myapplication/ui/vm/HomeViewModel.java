package com.example.myapplication.ui.vm;

import androidx.lifecycle.MutableLiveData;
import com.example.myapplication.ui.listener.OnHomeListener;
import com.wave.mvvm.lbs.ui.vm.MVVMViewModel;

public class HomeViewModel extends MVVMViewModel<OnHomeListener> {

    public MutableLiveData<String> textLiveData = new MutableLiveData<>();

    {
        textLiveData.setValue("androidx.lifecycle.LiveData");
    }

}
