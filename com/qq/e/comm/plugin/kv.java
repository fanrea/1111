package com.qq.e.comm.plugin;

import java.util.Locale;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class kv {
    public final String a;
    public final int b;
    public final int c;
    public final long d;
    public final int e;
    public final String f;

    public String toString() {
        return String.format(Locale.getDefault(), "{type:%s, value:%s, source:%s, server:%s, timestamp:%d, ttl:%d}", Integer.valueOf(this.b), this.a, Integer.valueOf(this.e), this.f, Long.valueOf(this.d), Integer.valueOf(this.c));
    }

    public kv(String str, int i, int i2, long j, int i3, String str2) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = j;
        this.e = i3;
        this.f = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kv)) {
            return false;
        }
        kv kvVar = (kv) obj;
        return this.a.equals(kvVar.a) && this.b == kvVar.b && this.c == kvVar.c && this.d == kvVar.d;
    }

    public boolean a() {
        return this.b == 1;
    }

    public boolean b() {
        return this.b == 28;
    }

    public boolean c() {
        return this.b == 5;
    }
}
