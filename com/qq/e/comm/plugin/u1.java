package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.atomic.AtomicLong;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class u1 {
    private static volatile u1 e;
    private final boolean a;
    private final AtomicLong b;
    private final AtomicLong c;
    private final SharedPreferences d;

    private SharedPreferences a(Context context) {
        return (SharedPreferences) pro.getobjresult(604, 0, this, context);
    }

    public static u1 a() {
        return (u1) pro.getobjresult(605, 1, new Object[0]);
    }

    private synchronized void a(long j) {
        pro.getVresult(606, 0, this, Long.valueOf(j));
    }

    public Long b() {
        return (Long) pro.getobjresult(607, 0, this);
    }

    private u1() {
        this.a = xc.a("skradrtse", 1, tc.c()) == 1;
        AtomicLong atomicLong = new AtomicLong(-1L);
        this.b = atomicLong;
        AtomicLong atomicLong2 = new AtomicLong(-1L);
        this.c = atomicLong2;
        SharedPreferences sharedPreferencesA = a(r1.d().a());
        this.d = sharedPreferencesA;
        atomicLong.set(sharedPreferencesA.getLong("tfrt", -1L));
        atomicLong2.set(sharedPreferencesA.getLong("pfrt", -1L));
    }
}
