package com.chirkevich.nikola.githubmvvmarchitectureclient.data.local.db;

/**
 * Created by nikolay on 15.11.2017.
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.chirkevich.nikola.githubmvvmarchitectureclient.data.local.db.dao.RepositoryDao;
import com.chirkevich.nikola.githubmvvmarchitectureclient.data.local.db.dao.UserDao;
import com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.db.Repository;
import com.chirkevich.nikola.githubmvvmarchitectureclient.data.model.db.User;

@Database(entities = {User.class, Repository.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public abstract RepositoryDao repositoryDao();
}
