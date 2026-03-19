package com.kwad.sdk.glide.load.resource;

import com.kwad.sdk.glide.load.engine.s;
import com.kwad.sdk.utils.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a<T> implements s<T> {
    protected final T data;

    @Override // com.kwad.sdk.glide.load.engine.s
    public final int getSize() {
        return 1;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final void recycle() {
    }

    public a(T t) {
        this.data = (T) ax.checkNotNull(t);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final Class<T> afv() {
        return (Class<T>) this.data.getClass();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public final T get() {
        return this.data;
    }
}
