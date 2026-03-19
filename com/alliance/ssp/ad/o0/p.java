package com.alliance.ssp.ad.o0;

import android.content.pm.PackageManager;
import com.bytedance.sdk.djx.core.log.ILogConst;
import java.io.IOException;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.json.JSONException;

/* compiled from: SADefaultThreadFactory.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class p implements ThreadFactory {
    public static final Thread.UncaughtExceptionHandler d = new a();
    public final String b;
    public final ThreadGroup a = Thread.currentThread().getThreadGroup();
    public final AtomicInteger c = new AtomicInteger(0);

    public p(String str) {
        this.b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.a, runnable, this.b + SignatureImpl.SEP + this.c.getAndIncrement());
        thread.setUncaughtExceptionHandler(d);
        return thread;
    }

    /* compiled from: SADefaultThreadFactory.java */
    public static class a implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) throws JSONException, PackageManager.NameNotFoundException, IOException {
            String strA;
            try {
                strA = o.a(th);
            } catch (IOException unused) {
                strA = ILogConst.CACHE_PLAY_REASON_NULL;
            }
            new com.alliance.ssp.ad.d0.f().a(0, 0, "003", "thread: " + thread + ", " + strA, (Exception) null);
            int i = l.a;
        }
    }
}
