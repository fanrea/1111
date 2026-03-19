package com.tachikoma.lottie;

import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class l<V> {
    private final Throwable exception;
    private final V value;

    public l(V v) {
        this.value = v;
        this.exception = null;
    }

    public l(Throwable th) {
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
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (getValue() != null && getValue().equals(lVar.getValue())) {
            return true;
        }
        if (getException() == null || lVar.getException() == null) {
            return false;
        }
        return getException().toString().equals(getException().toString());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{getValue(), getException()});
    }
}
