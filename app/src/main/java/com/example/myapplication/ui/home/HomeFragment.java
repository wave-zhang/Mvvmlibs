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
    public UI<HomeViewModel,FragmentHomeBinding> onCreateUI() {
        return ui = new UI.Builder<HomeViewModel, FragmentHomeBinding>()
                .setViewModelClass(HomeViewModel.class)
                .setLayoutId(R.layout.fragment_home)
                .setVariableId(BR.vmHome)
                .build();
        //return new UI(R.layout.fragment_home,BR.vmHome,HomeViewModel.class);
    }

    public UI<HomeViewModel, FragmentHomeBinding> getUi() {
        return ui;
    }

    @Override
    public void onCreateViewAfter() {
//        ui.getViewModel().listenerLiveData.setValue(this);
//        ui.getViewModel().textLiveData.setValue("这是一条假数据");
//        HomeViewModel viewModel = (HomeViewModel)ui.getViewModel();
//        viewModel.setListener(this);
//        viewModel.textLiveData.setValue("这是一条假数据");
    }

    @Override
    public void onTabClick() {
        Log.e("wave","onTabClick.....");
    }
}