package com.kwad.sdk.glide.load;

import com.kwad.sdk.utils.ax;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e<T> {
    private static final a<Object> bRA = new a<Object>() { // from class: com.kwad.sdk.glide.load.e.1
        @Override // com.kwad.sdk.glide.load.e.a
        public final void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };
    private final T bRB;
    private final a<T> bRC;
    private volatile byte[] bRD;
    private final String key;

    public interface a<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    public static <T> e<T> hi(String str) {
        return new e<>(str, null, afS());
    }

    public static <T> e<T> c(String str, T t) {
        return new e<>(str, t, afS());
    }

    public static <T> e<T> a(String str, T t, a<T> aVar) {
        return new e<>(str, t, aVar);
    }

    private e(String str, T t, a<T> aVar) {
        this.key = ax.iA(str);
        this.bRB = t;
        this.bRC = (a) ax.checkNotNull(aVar);
    }

    public final T getDefaultValue() {
        return this.bRB;
    }

    public final void a(T t, MessageDigest messageDigest) {
        this.bRC.a(afR(), t, messageDigest);
    }

    private byte[] afR() {
        if (this.bRD == null) {
            this.bRD = this.key.getBytes(c.bRy);
        }
        return this.bRD;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.key.equals(((e) obj).key);
        }
        return false;
    }

    public final int hashCode() {
        return this.key.hashCode();
    }

    private static <T> a<T> afS() {
        return (a<T>) bRA;
    }

    public final String toString() {
        return "Option{key='" + this.key + "'}";
    }
}
