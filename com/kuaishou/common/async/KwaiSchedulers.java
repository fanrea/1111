package com.kuaishou.common.async;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KwaiSchedulers {
    public static final Scheduler MAIN = AndroidSchedulers.mainThread();
    public static final Scheduler NETWORKING = Schedulers.from(Async.newFixedThreadPoolExecutor("ksad-retrofit-api-thread", 4));
    public static final Scheduler ASYNC = Schedulers.from(Async.getCacheThreadPoolExecutor());
    public static final Scheduler UPLOAD = Schedulers.from(Async.newFixedThreadPoolExecutor("retrofit-upload-thread", 4));
}
