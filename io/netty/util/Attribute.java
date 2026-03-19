package io.netty.util;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface Attribute<T> {
    boolean compareAndSet(T t, T t2);

    T get();

    T getAndRemove();

    T getAndSet(T t);

    AttributeKey<T> key();

    void remove();

    void set(T t);

    T setIfAbsent(T t);
}
