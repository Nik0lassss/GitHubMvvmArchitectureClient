package com.chirkevich.nikola.githubmvvmarchitectureclient.ui.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nikolay on 16.11.2017.
 */

public abstract class BaseFragmnet<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {

    private BaseActivity baseActivity;
    private T viewDataBinding;
    private V baseViewModel;
    private View rootView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        rootView = viewDataBinding.getRoot();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        baseViewModel = getViewModel();
        viewDataBinding.setVariable(getBindingVariable(), baseViewModel);
        viewDataBinding.executePendingBindings();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof BaseActivity)
        {
            BaseActivity activity = (BaseActivity) context;
            this.baseActivity = activity;
            baseActivity.onFragmentAttached();

        }
    }

    @Override
    public void onDetach() {
        baseActivity = null;
        super.onDetach();
    }

    public BaseActivity getBaseActivity()
    {
        return baseActivity;
    }


    public interface Callback {
        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }

    public abstract V getViewModel();


    public abstract @IdRes
    int getBindingVariable();


    public abstract @LayoutRes
    int getLayoutId();
}
