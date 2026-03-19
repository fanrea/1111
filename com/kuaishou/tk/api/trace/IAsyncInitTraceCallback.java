package com.kuaishou.tk.api.trace;

import com.kuaishou.tk.api.TKContext;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public interface IAsyncInitTraceCallback {
    void onDispose();

    void onError(Throwable th);

    void onFinished(TKContext tKContext);

    void onStart();
}
