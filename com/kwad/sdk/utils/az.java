package com.kwad.sdk.utils;

import java.lang.Comparable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class az<T extends Comparable<? super T>> {
    private final T cmO;
    private final T cmP;

    public az(T t, T t2) {
        this.cmO = (T) ax.checkNotNull(t);
        this.cmP = (T) ax.checkNotNull(t2);
        ax.checkArgument(t.compareTo(t2) <= 0);
    }

    public final T getLower() {
        return this.cmO;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof az) {
            az azVar = (az) obj;
            if (this.cmO.equals(azVar.cmO) && this.cmP.equals(azVar.cmP)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return String.format("[%s, %s]", this.cmO, this.cmP);
    }

    public final int hashCode() {
        return toString().hashCode();
    }
}
