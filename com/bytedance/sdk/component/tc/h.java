package com.bytedance.sdk.component.tc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends an {
    public static d hc;
    public static final int d = Runtime.getRuntime().availableProcessors();
    public static boolean b = true;
    public static int c = 120;

    public static void d(tt ttVar) {
        ttVar.setPriority(10);
        mk.hc.tc().execute(ttVar);
    }

    public static ExecutorService d() {
        return mk.hc.uo();
    }

    public static void hc(tt ttVar) {
        d().execute(ttVar);
    }

    public static void d(tt ttVar, int i) {
        ttVar.setPriority(i);
        mk.hc.uo().execute(ttVar);
    }

    public static ThreadPoolExecutor hc() {
        return mk.hc.tt();
    }

    public static void b(tt ttVar) {
        hc().execute(ttVar);
    }

    public static void c(tt ttVar) {
        mk.hc.uo().execute(ttVar);
    }

    public static void hc(tt ttVar, int i) {
        ttVar.setPriority(i);
        mk.hc.uo().execute(ttVar);
    }

    public static ExecutorService b() {
        return d();
    }

    public static ScheduledExecutorService c() {
        return mk.hc.mq();
    }

    public static boolean u() {
        return b;
    }

    public static void d(boolean z) {
        b = z;
    }

    public static void d(d dVar) {
        hc = dVar;
    }

    public static void u(tt ttVar) {
        mk.hc.tc().execute(ttVar);
    }

    public static void d(int i) {
        c = i;
    }
}
