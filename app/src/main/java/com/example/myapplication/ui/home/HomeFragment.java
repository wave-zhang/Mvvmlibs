package com.example.myapplication.ui.home;

import android.util.Log;

import androidx.databinding.library.baseAdapters.BR;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.ui.listener.OnHomeListener;
import com.example.myapplication.ui.vm.HomeViewModel;
import com.wave.mvvm.lbs.ui.MVVMFragment;
import com.wave.mvvm.lbs.ui.UI;

public class HomeFragment extends MVVMFragment implements OnHomeListener {

    protected UI<HomeViewModel,FragmentHomeBinding> ui;

    @Override
    public UI onCreateUI() {
        return ui = new UI.Builder<HomeViewModel, FragmentHomeBinding>()
                .setViewModelClass(HomeViewModel.class)
                .setLayoutId(R.layout.fragment_home)
                .setVariableId(BR.vmHome)
                .setCacheView(true)
                .build();
    }

    public UI<HomeViewModel, FragmentHomeBinding> getUi() {
        return ui;
    }

    @Override
    public void onCreateViewAfter() {
        ui.getViewModel().listenerLiveData.setValue(this);
    }

    @Override
    public void onTabClick() {
        Log.e("wave","onTabClick.....");
    }
}