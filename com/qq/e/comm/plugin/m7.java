package com.qq.e.comm.plugin;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.util.UUID;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class m7 {
    final String a;
    final Thread b;
    final Throwable c;
    final long d;
    final long e;
    final StackTraceElement[] f;
    final String g;
    File h;
    final boolean i;
    byte[] j;

    public m7(String str, File file) throws NumberFormatException {
        this.g = str;
        Pair<String, Long> pairA = a(str);
        this.a = (String) pairA.first;
        this.d = ((Long) pairA.second).longValue();
        this.b = null;
        this.c = null;
        this.e = 0L;
        this.f = null;
        this.h = file;
        this.j = gu.e(file);
        this.i = false;
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.a) || this.d == 0) ? false : true;
    }

    public m7(Thread thread, Throwable th) {
        String string = UUID.randomUUID().toString();
        this.a = string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.d = jCurrentTimeMillis;
        this.g = jCurrentTimeMillis + "-" + string;
        this.e = jCurrentTimeMillis - g2.f();
        this.b = thread;
        this.c = th;
        this.f = th.getStackTrace();
        this.i = thread == Looper.getMainLooper().getThread();
    }

    private Pair<String, Long> a(String str) throws NumberFormatException {
        int iIndexOf = str.indexOf(45);
        long j = 0;
        if (iIndexOf == -1) {
            return new Pair<>(null, 0L);
        }
        String strSubstring = str.substring(iIndexOf + 1);
        try {
            j = Long.parseLong(str.substring(0, iIndexOf));
        } catch (NumberFormatException unused) {
        }
        return new Pair<>(strSubstring, Long.valueOf(j));
    }
}
