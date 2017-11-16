package com.chirkevich.nikola.githubmvvmarchitectureclient.data;

import android.content.Context;

import com.chirkevich.nikola.githubmvvmarchitectureclient.data.local.db.DbHelper;
import com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.api.UserRequest;
import com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.api.UserResponse;
import com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.db.Repository;
import com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.db.User;
import com.chirkevich.nikola.githubmvvmarchitectureclient.data.remote.ApiHelper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by nikolay on 16.11.2017.
 */

@Singleton
public class AppDataManager implements DataManager {

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final ApiHelper mApiHelper;

    //TODO:add annotation
    @Inject
    public AppDataManager(Context mContext, DbHelper mDbHelper, ApiHelper mApiHelper) {
        this.mContext = mContext;
        this.mDbHelper = mDbHelper;
        this.mApiHelper = mApiHelper;
    }

    @Override
    public Observable<UserResponse> doGitHubGetUserCall(UserRequest.GitHubLoginRequest request) {
        return mApiHelper.doGitHubGetUserCall(request);
    }

    @Override
    public Observable<Boolean> insertUser(User user) {
        return mDbHelper.insertUser(user);
    }

    @Override
    public Observable<List<User>> getAllUsers() {
        return mDbHelper.getAllUsers();
    }

    @Override
    public Observable<List<Repository>> getAllRepositories() {
        return mDbHelper.getAllRepositories();
    }

    @Override
    public Observable<Boolean> saveRepository(Repository repository) {
        return mDbHelper.saveRepository(repository);
    }
}
