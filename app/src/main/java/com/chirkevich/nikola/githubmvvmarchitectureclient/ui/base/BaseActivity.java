package com.chirkevich.nikola.githubmvvmarchitectureclient.ui.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


/**
 * Created by nikolay on 16.11.2017.
 */

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity implements BaseFragmnet.Callback {

    //TODO: activity component
    //private ActivityComponent


    private ProgressDialog progressDialog;

    private T viewDataBinding;
    private V baseViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeActivityComponent();
        performDependencyInjection();
        performDataBinding();
    }


    private void initializeActivityComponent() {
        //TODO: initialize component
    }

    private void performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.baseViewModel = baseViewModel == null ? getViewModel() : baseViewModel;
        viewDataBinding.setVariable(getBindingVariable(), baseViewModel);
        viewDataBinding.executePendingBindings();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions,requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean gasPermission

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public T getViewDataBinding() {
        return viewDataBinding;
    }

    public abstract V getViewModel();

    public abstract @IdRes
    int getBindingVariable();

    public abstract
    @LayoutRes
    int getLayoutId();

    public abstract void performDependencyInjection();

}
