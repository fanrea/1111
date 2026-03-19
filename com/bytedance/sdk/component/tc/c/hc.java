package com.bytedance.sdk.component.tc.c;

import android.os.AsyncTask;
import com.bytedance.sdk.component.tc.tc;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class hc<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public static Executor d = new c(0, 20, 3, TimeUnit.MILLISECONDS, new SynchronousQueue(), new tc("PAsyncTask"));

    public AsyncTask<Params, Progress, Result> d(Params... paramsArr) {
        return executeOnExecutor(d, paramsArr);
    }
}
