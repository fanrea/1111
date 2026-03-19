package com.bykv.vk.component.ttvideo.utils;

import com.bytedance.sdk.component.tc.c.c;
import com.bytedance.sdk.component.tc.tc;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class EngineThreadPool {
    private static ThreadPoolExecutor a;

    public static ExecutorService a() {
        if (a == null) {
            synchronized (EngineThreadPool.class) {
                if (a == null) {
                    c cVar = new c(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new tc("EngineThreadPool"));
                    a = cVar;
                    cVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return a;
    }

    public static void setExcutorInstance(ThreadPoolExecutor threadPoolExecutor) {
        synchronized (EngineThreadPool.class) {
            a = threadPoolExecutor;
        }
    }
}
