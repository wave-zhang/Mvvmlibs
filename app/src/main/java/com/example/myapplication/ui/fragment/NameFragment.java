package com.example.myapplication.ui.fragment;


import com.example.myapplication.R;

import androidx.databinding.library.baseAdapters.BR;
import com.example.myapplication.ui.vm.NameViewModel;
import com.example.myapplication.ui.listener.OnNameListener;
import com.example.myapplication.databinding.FragmentNameBinding;
import com.wave.mvvm.lbs.ui.MVVMFragment;
import com.wave.mvvm.lbs.ui.UI;

/**
 * MvvM Generate NameFragment
 * MvvM 一键生成类
 */
public class NameFragment extends MVVMFragment implements OnNameListener {
    /**
     * MvvM Generate UI
     * 覆盖父类ui变量,并明确泛型类型,更便捷的操控UI
     */
    protected UI<NameViewModel, FragmentNameBinding> ui;

    @Override
    public UI onCreateUI() {
        return ui = new UI.Builder<NameViewModel, FragmentNameBinding>()
                .setViewModelClass(NameViewModel.class)
                .setLayoutId(R.layout.fragment_name)
                .setVariableId(BR.vmNameViewModel)
                //.setCacheView(true) // 是否需要开启视图缓存
                .build();
    }

    @Override
    public void onCreateViewAfter() {
        ui.getViewModel().listenerLiveData.setValue(this);
        // TODO ui ...
    }

}
