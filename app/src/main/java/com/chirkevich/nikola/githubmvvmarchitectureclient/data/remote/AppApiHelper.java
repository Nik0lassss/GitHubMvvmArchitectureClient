package com.chirkevich.nikola.githubmvvmarchitectureclient.data.remote;

import com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.api.UserRequest;
import com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.api.UserResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by nikolay on 15.11.2017.
 */

@Singleton
public class AppApiHelper implements ApiHelper {
    @Override
    public Observable<UserResponse> doGitHubGetUserCall(UserRequest.GitHubLoginRequest request) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GIT_HUB_USER).addPathParameter(request).build().getObjectObservable(UserResponse.class);
    }
}
