package com.chirkevich.nikola.githubmvvmarchitectureclient.ui.base;

import android.databinding.ObservableBoolean;

import com.chirkevich.nikola.githubmvvmarchitectureclient.data.DataManager;
import com.chirkevich.nikola.githubmvvmarchitectureclient.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by nikolay on 16.11.2017.
 */

public abstract class BaseViewModel<N> {
    private N mNavigator;
    private final DataManager mDataManager;
    private final SchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;
    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);

    public BaseViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = compositeDisposable;
    }

    public void setNavigator(N navigator) {
        this.mNavigator = navigator;
    }

    public void onDestroy() {
        mCompositeDisposable.dispose();
    }

    public N getNavigator() {
        return mNavigator;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }
}
