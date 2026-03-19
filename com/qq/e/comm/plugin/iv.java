package com.qq.e.comm.plugin;

import java.lang.Comparable;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class iv<T extends Comparable<? super T>> {
    private final T a;
    private final T b;

    public iv(T t, T t2) {
        this.a = (T) a((Object) t, (Object) "lower must not be null");
        this.b = (T) a((Object) t2, (Object) "upper must not be null");
        if (t.compareTo(t2) > 0) {
            throw new IllegalArgumentException("lower must be less than or equal to upper");
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof iv)) {
            return false;
        }
        iv ivVar = (iv) obj;
        return this.a.equals(ivVar.a) && this.b.equals(ivVar.b);
    }

    public String toString() {
        return String.format("[%s, %s]", this.a, this.b);
    }

    public static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public boolean a(T t) {
        a((Object) t, (Object) "value must not be null");
        return (t.compareTo(this.a) >= 0) && (t.compareTo(this.b) <= 0);
    }

    public static <T extends Comparable<? super T>> iv<T> a(T t, T t2) {
        return new iv<>(t, t2);
    }
}
