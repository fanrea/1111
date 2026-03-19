package com.qq.e.comm.plugin;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class k8 {

    /* compiled from: A */
    private static class a {
        static final Handler a = new Handler(Looper.getMainLooper());
    }

    /* compiled from: A */
    private static class b {
        static final Handler a;

        static {
            HandlerThread handlerThread = new HandlerThread("DLThread");
            handlerThread.start();
            a = new Handler(handlerThread.getLooper());
        }
    }

    public static Handler a() {
        return a.a;
    }

    public static Handler b() {
        return b.a;
    }
}
