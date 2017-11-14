package com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Колян on 14.11.2017.
 */

public class UserRequest {


    public UserRequest() {
    }


    public static class GitHubLoginRequest
    {
        @Expose
        @SerializedName("userLogin")
        private String userLogin;

        public GitHubLoginRequest(String userLogin) {
            this.userLogin = userLogin;
        }

        public String getUserLogin() {
            return userLogin;
        }

        public void setUserLogin(String userLogin) {
            this.userLogin = userLogin;
        }
    }

}
