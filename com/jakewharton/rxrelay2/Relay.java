package com.jakewharton.rxrelay2;

import io.reactivex.Observable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.functions.Consumer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class Relay<T> extends Observable<T> implements Consumer<T> {
    public abstract void accept(T t);

    public abstract boolean hasObservers();

    @CheckReturnValue
    public final Relay<T> toSerialized() {
        return this instanceof SerializedRelay ? this : new SerializedRelay(this);
    }
}
