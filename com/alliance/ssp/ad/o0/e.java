package com.alliance.ssp.ad.o0;

import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CrashHandler.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e implements Thread.UncaughtExceptionHandler {
    public static final /* synthetic */ int b = 0;
    public Map<String, String> a = new HashMap();

    static {
        new e();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            throw null;
        }
    }
}
