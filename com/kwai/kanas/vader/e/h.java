package com.kwai.kanas.vader.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class h<V> {

    public enum a {
        VALUE,
        EXCEPTION
    }

    public abstract a a();

    public abstract Exception b();

    public abstract V c();

    public static <V> h<V> a(V v) {
        return com.kwai.kanas.vader.e.a.a(v);
    }

    public static <V> h<V> a(Exception exc) {
        return com.kwai.kanas.vader.e.a.a(exc);
    }
}
