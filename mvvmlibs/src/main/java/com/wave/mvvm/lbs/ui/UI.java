package com.wave.mvvm.lbs.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.wave.mvvm.lbs.ui.vm.MVVMViewModel;

/**
 * MvvM UI 构建器
 * 支持 Activity 与 Fragment
 * @param <V>
 * @param <B>
 */
public class UI<V extends MVVMViewModel,B extends ViewDataBinding> {

    protected V viewModel;

    protected B binding;

    Builder builder;

    private UI(Builder builder) {
        this.builder = builder;
    }

    protected boolean isCacheView(){
        return builder.isCacheView;
    }

    protected void create(@NonNull ViewModelStoreOwner owner,@NonNull LayoutInflater inflater, @Nullable ViewGroup container){
        //Class<V> vClass = (Class <V>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Class<V> vClass = builder.viewModelClass;
        viewModel = new ViewModelProvider(owner).get(vClass);
        binding = DataBindingUtil.inflate(inflater,builder.layoutId,container,false);
        binding.setVariable(builder.variableId,viewModel);
    }

    protected void create(AppCompatActivity activity){
        Class<V> vClass = builder.viewModelClass;
        viewModel = new ViewModelProvider(activity).get(vClass);
        binding = DataBindingUtil.setContentView(activity,builder.layoutId);
        binding.setVariable(builder.variableId,viewModel);
    }

    public void setVariable(int variableId, @Nullable Object value){
        Log.e("wave","setVariable = "+variableId);
        binding.setVariable(variableId,value);
    }

    /**
     * 获取当前视图的主viewModel
     * @return
     */
    public V getViewModel() {
        return viewModel;
    }

    /**
     * 获取当前视图的binding
     * @return
     */
    public B getBinding() {
        return binding;
    }

    public static class Builder<V extends MVVMViewModel,B extends ViewDataBinding> {

        private Integer layoutId,variableId;

        private boolean isCacheView;

        private Class<V> viewModelClass;

        /**
         * 视图ID
         * @param layoutId
         * @return
         */
        public Builder setLayoutId(Integer layoutId) {
            this.layoutId = layoutId;
            return this;
        }

        /**
         * 主ViewModel 类型
         * @param viewModelClass
         * @return
         */
        public Builder setViewModelClass(Class<V> viewModelClass) {
            this.viewModelClass = viewModelClass;
            return this;
        }

        /**
         *  布局与viewModel 绑定 ID
         *  通情况下一个视图只需要一个viewModel 如 : variableId 与 viewModelClass 对应不上. 则绑定会无效
         *  如有复杂多绑定操作, 推荐使用 ui.setVariable(id,obj) 或 使用 ui.getBinding().setXXX(...) 函数操作
          * @param variableId
         * @return
         */
        public Builder setVariableId(Integer variableId) {
            this.variableId = variableId;
            return this;
        }

        /**
         * 当前视图是否开启缓存
         * 此函数仅对Fragment有效
         * 默认情况为不开启,
         * Fragment会重走onCrateView -> onCreateViewAfter 函数
         * 开启则, onCreateViewAfter 只会执行一次
         * @param cacheView
         * @return
         */
        public Builder setCacheView(boolean cacheView) {
            isCacheView = cacheView;
            return this;
        }

        public UI build(){
            return new UI<V,B>(this);
        }
    }
}
