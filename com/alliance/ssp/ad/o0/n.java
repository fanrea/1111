package com.alliance.ssp.ad.o0;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: NMThreadDispatcher.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class n {
    public static final n d = new n();
    public final ExecutorService a = Executors.newFixedThreadPool(16, new p("nm-pool-thread"));
    public final ScheduledExecutorService b = Executors.newScheduledThreadPool(2, new p("nm-scheduler-thread"));
    public final Handler c = new Handler(Looper.getMainLooper());
}
