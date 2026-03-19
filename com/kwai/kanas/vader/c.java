package com.kwai.kanas.vader;

import com.kwai.middleware.azeroth.async.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class c {
    public static ExecutorService a(String str) {
        return Executors.newSingleThreadExecutor(new DefaultThreadFactory(str));
    }

    public static ScheduledExecutorService b(String str) {
        return Executors.newSingleThreadScheduledExecutor(new DefaultThreadFactory(str));
    }
}
