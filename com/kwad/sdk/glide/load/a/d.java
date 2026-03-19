package com.kwad.sdk.glide.load.a;

import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DataSource;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface d<T> {

    public interface a<T> {
        void g(Exception exc);

        void x(T t);
    }

    void a(Priority priority, a<? super T> aVar);

    Class<T> afT();

    void afU();

    DataSource afV();

    void cancel();
}
