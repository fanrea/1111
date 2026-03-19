package com.component.lottie;

import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class bb<V> {
    private final V a;
    private final Throwable b;

    public bb(V v) {
        this.a = v;
        this.b = null;
    }

    public bb(Throwable th) {
        this.b = th;
        this.a = null;
    }

    public V a() {
        return this.a;
    }

    public Throwable b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bb)) {
            return false;
        }
        bb bbVar = (bb) obj;
        if (a() != null && a().equals(bbVar.a())) {
            return true;
        }
        if (b() == null || bbVar.b() == null) {
            return false;
        }
        return b().toString().equals(b().toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{a(), b()});
    }
}
