package com.kwad.lottie;

import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class j<V> {
    private final Throwable exception;
    private final V value;

    public j(V v) {
        this.value = v;
        this.exception = null;
    }

    public j(Throwable th) {
        this.exception = th;
        this.value = null;
    }

    public final V getValue() {
        return this.value;
    }

    public final Throwable getException() {
        return this.exception;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (getValue() != null && getValue().equals(jVar.getValue())) {
            return true;
        }
        if (getException() == null || jVar.getException() == null) {
            return false;
        }
        return getException().toString().equals(getException().toString());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), getException()});
    }
}
