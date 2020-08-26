package com.wave.mvvm.lbs.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.wave.mvvm.lbs.ui.listener.OnMVVMListener;
import com.wave.mvvm.lbs.ui.vm.MVVMViewModel;

/**
 * MvvM 基类
 * 封装 Toast 及 Navigation
 */
public abstract class MVVMFragment extends Fragment {

    protected UI<? extends MVVMViewModel<OnMVVMListener>, ? extends ViewDataBinding> ui;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ui = onCreateUI();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(ui == null){
            ui = onCreateUI();
        }
        if(ui.isCacheView()){
            if(ui.binding == null){
                onCreateView(inflater,container);
            }
            return ui.binding.getRoot();
        }
        onCreateView(inflater,container);
        return ui.binding.getRoot();
    }

    private void onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container){
        ui.create(this,inflater,container);
        ui.viewModel.toastMagLiveData.observe(getViewLifecycleOwner(),(v)->onToastMsgChanged(v));
        ui.viewModel.toastResLiveData.observe(getViewLifecycleOwner(),(v)->onToastMsgChanged(getString(v)));
        ui.viewModel.navLiveData.observe(getViewLifecycleOwner(),(v)->onNavValueChanged(v));
        onCreateViewAfter();
    }

    public UI getUI(){return ui;}

    public abstract UI onCreateUI();

    public abstract void onCreateViewAfter();

    private void onToastMsgChanged(String msg){
        showToast(msg);
    }

    private void onNavValueChanged(@IdRes int resId){
        navigate(resId);
    }

    public void showToast(String msg){
        Toast.makeText(getContext(),msg,Toast.LENGTH_SHORT).show();
    }

    public void showToast(@StringRes int resId){
        Toast.makeText(getContext(),resId,Toast.LENGTH_SHORT).show();
    }

    public NavController nav(){
       return Navigation.findNavController(getView());
    }

    public void navigate(@IdRes int resId){
        nav().navigate(resId);
    }

    public void back(){
        nav().navigateUp();
    }
}
