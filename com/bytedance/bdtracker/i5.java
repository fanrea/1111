package com.bytedance.bdtracker;

import android.util.Log;
import com.bytedance.applog.log.LoggerImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class i5 implements Runnable {
    public final Runnable a;
    public final String b;
    public final String c = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

    public i5(Runnable runnable, String str) {
        this.a = runnable;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.run();
        } catch (Throwable th) {
            LoggerImpl.global().error(1, a.a("Thread:").append(this.b).append(" exception\n").append(this.c).toString(), th, new Object[0]);
        }
    }
}
