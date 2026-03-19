package com.bytedance.framwork.core.ef;

import android.content.Context;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: LogQueue.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d {
    private static d a;
    private final Context b;
    private final Map<String, a> c;
    private final f d;
    private final AtomicBoolean e;
    private final LinkedList<b> f;

    static void a(String str) {
    }

    static void a(String str, String str2) {
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    private d(Context context) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.e = atomicBoolean;
        LinkedList<b> linkedList = new LinkedList<>();
        this.f = linkedList;
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.c = new ConcurrentHashMap();
        f fVar = new f(applicationContext, this, linkedList, atomicBoolean);
        this.d = fVar;
        fVar.start();
    }

    public void a(String str, a aVar) {
        if (b() || aVar == null) {
            return;
        }
        this.c.put(str, aVar);
    }

    a b(String str) {
        return this.c.get(str);
    }

    Map<String, a> a() {
        return this.c;
    }

    boolean a(String str, byte[] bArr) {
        if (b() || bArr == null || bArr.length <= 0 || b(str) == null) {
            return false;
        }
        synchronized (this.f) {
            if (this.e.get()) {
                return false;
            }
            if (this.f.size() >= 2000) {
                this.f.poll();
            }
            boolean zAdd = this.f.add(new b(str, bArr));
            this.d.a();
            return zAdd;
        }
    }

    boolean b() {
        return this.e.get();
    }
}
