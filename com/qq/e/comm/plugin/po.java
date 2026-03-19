package com.qq.e.comm.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class po {
    private static Class a;
    private static Class b;
    private static Object c;
    private static Method d;
    private static Method e;

    static {
        try {
            Class<?> cls = Class.forName("android.support.v4.content.LocalBroadcastManager");
            a = cls;
            c = cls.getMethod("getInstance", Context.class).invoke(null, r1.d().a());
            d = a.getMethod("sendBroadcast", Intent.class);
            e = a.getMethod("registerReceiver", BroadcastReceiver.class, IntentFilter.class);
        } catch (Throwable th) {
            try {
                Class<?> cls2 = Class.forName("androidx.localbroadcastmanager.content.LocalBroadcastManager");
                b = cls2;
                c = cls2.getMethod("getInstance", Context.class).invoke(null, r1.d().a());
                d = b.getMethod("sendBroadcast", Intent.class);
                e = b.getMethod("registerReceiver", BroadcastReceiver.class, IntentFilter.class);
            } catch (Throwable unused) {
                b = null;
                c = null;
                d = null;
                e = null;
                th.getMessage();
            }
        }
    }

    public static void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        Object obj = c;
        if (obj != null) {
            try {
                e.invoke(obj, broadcastReceiver, intentFilter);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }
}
