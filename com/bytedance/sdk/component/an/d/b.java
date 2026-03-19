package com.bytedance.sdk.component.an.d;

import com.bytedance.sdk.component.tc.c.c;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static final TimeUnit d = TimeUnit.SECONDS;

    public static ExecutorService d() {
        c cVar = new c(1, 2, 30L, d, new LinkedBlockingQueue(), new d(ILogConst.PLAY_SOURCE_DEFAULT));
        cVar.allowCoreThreadTimeOut(true);
        return cVar;
    }
}
