package com.kwad.sdk.core.threads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    public static final String TAG = "c";
    private static int bHS;
    private static final ConcurrentHashMap<ThreadPoolExecutor, Long> bHT = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ThreadPoolExecutor, String> bHU = new ConcurrentHashMap<>();

    public static void a(ThreadPoolExecutor threadPoolExecutor, String str) {
        bHT.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        bHU.put(threadPoolExecutor, str);
    }
}
