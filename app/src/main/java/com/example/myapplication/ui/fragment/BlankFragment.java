package com.example.myapplication.ui.fragment;

import androidx.databinding.library.baseAdapters.BR;

import com.example.myapplication.R;
import com.example.myapplication.databinding.BlankFragmentBinding;
import com.example.myapplication.ui.listener.OnBlankListener;
import com.example.myapplication.ui.vm.BlankViewModel;
import com.wave.mvvm.lbs.ui.MVVMFragment;
import com.wave.mvvm.lbs.ui.UI;

/**
 * Create MvvM Fragment
 */
public class BlankFragment extends MVVMFragment implements OnBlankListener {

    @Override
    public UI onCreateUI() {
        return new UI.Builder<BlankViewModel, BlankFragmentBinding>()
                .setLayoutId(R.layout.blank_fragment)
                .setVariableId(BR.vmBlankViewModel)
                .build();
    }

    public void onCreateViewAfter(){
        // TODO -- getViewModel, getBinding() //getViewModel().setListener(this);
        // ui.getViewModel()

    }
}
