package com.qq.e.comm.plugin;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h2 {

    /* compiled from: A */
    private static class a {
        static final Handler a;

        static {
            HandlerThread handlerThread = new HandlerThread("GDTAirbagThread");
            handlerThread.start();
            a = new Handler(handlerThread.getLooper());
        }
    }

    public static Handler a() {
        return a.a;
    }
}
