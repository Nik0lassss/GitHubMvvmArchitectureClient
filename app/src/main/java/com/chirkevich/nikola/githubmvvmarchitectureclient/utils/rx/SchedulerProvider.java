package com.chirkevich.nikola.githubmvvmarchitectureclient.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by nikolay on 16.11.2017.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();
}
