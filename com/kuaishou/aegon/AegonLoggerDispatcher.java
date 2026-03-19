package com.kuaishou.aegon;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AegonLoggerDispatcher {
    private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue<>();
    private static Executor b = null;

    private static Executor a() {
        Executor executor;
        Executor executor2 = b;
        if (executor2 != null) {
            return executor2;
        }
        synchronized (AegonLoggerDispatcher.class) {
            if (b == null) {
                b = Executors.newSingleThreadExecutor();
            }
            executor = b;
        }
        return executor;
    }

    static void a(a aVar) {
        a.add(aVar);
    }

    static void b(a aVar) {
        a.remove(aVar);
    }

    static void onConnectionStats(String str) {
        e.a("AegonLogger", str);
        if (a.isEmpty()) {
            return;
        }
        Executor executorA = a();
        Iterator<a> it = a.iterator();
        while (it.hasNext()) {
            executorA.execute(b.a(it.next(), str));
        }
    }

    static void onRequestFinished(AegonRequestFinishedInfo aegonRequestFinishedInfo) {
        if (a.isEmpty()) {
            return;
        }
        Executor executorA = a();
        Iterator<a> it = a.iterator();
        while (it.hasNext()) {
            executorA.execute(c.a(it.next(), aegonRequestFinishedInfo));
        }
    }
}
