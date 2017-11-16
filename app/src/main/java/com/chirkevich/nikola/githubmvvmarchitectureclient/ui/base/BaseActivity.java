package com.chirkevich.nikola.githubmvvmarchitectureclient.ui.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


import com.chirkevich.nikola.githubmvvmarchitectureclient.utils.CommonUtils;
import com.chirkevich.nikola.githubmvvmarchitectureclient.utils.NetworkUtils;

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
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermissionSafely(String persmission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.BASE ||
                checkSelfPermission(persmission) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void openActivityOnTOkenExpire() {
        //startActivity() LoginActivity
        finish();
    }

    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    public void showLoading() {
        hideLoading();
        progressDialog = CommonUtils.showLoadingDialog(this);
    }


    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
    }

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
