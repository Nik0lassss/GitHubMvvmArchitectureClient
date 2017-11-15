package com.chirkevich.nikola.githubmvvmarchitectureclient.data.remote;

import com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.api.UserRequest;
import com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.api.UserResponse;

import io.reactivex.Observable;

/**
 * Created by nikolay on 15.11.2017.
 */

public interface ApiHelper {
    Observable<UserResponse> doGitHubGetUserCall(UserRequest.GitHubLoginRequest request);
}
