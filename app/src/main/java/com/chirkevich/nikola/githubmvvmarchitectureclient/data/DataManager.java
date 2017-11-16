package com.chirkevich.nikola.githubmvvmarchitectureclient.data;

import com.chirkevich.nikola.githubmvvmarchitectureclient.data.local.db.DbHelper;
import com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.db.User;
import com.chirkevich.nikola.githubmvvmarchitectureclient.data.remote.ApiHelper;

import io.reactivex.Observable;


/**
 * Created by nikolay on 16.11.2017.
 */

public interface DataManager extends ApiHelper, DbHelper {
}
