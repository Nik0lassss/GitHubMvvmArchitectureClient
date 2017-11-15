package com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.api.UserResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nikolay on 15.11.2017.
 */


@Entity(tableName = "repositories")
public class Repository {



    @SerializedName("id")
    @Expose
    @PrimaryKey
    private Integer id;
    @SerializedName("owner")
    @Expose
    private UserResponse owner;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("private")
    @Expose
    private Boolean _private;
    @SerializedName("fork")
    @Expose
    private Boolean fork;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;

}
