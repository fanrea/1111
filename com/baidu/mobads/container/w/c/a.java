package com.baidu.mobads.container.w.c;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private static volatile HandlerThread a;
    private static volatile Handler b;

    public static HandlerThread a() {
        HandlerThread handlerThread;
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new HandlerThread("default_godeye_thread");
                    a.start();
                    b = new Handler(a.getLooper());
                }
                handlerThread = a;
            }
            return handlerThread;
        }
        return a;
    }

    public static Handler b() {
        if (b == null) {
            a();
        }
        return b;
    }
}
