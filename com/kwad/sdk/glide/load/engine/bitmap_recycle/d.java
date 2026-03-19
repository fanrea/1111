package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import com.kwad.sdk.glide.load.engine.bitmap_recycle.m;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
abstract class d<T extends m> {
    private final Queue<T> bUB = com.kwad.sdk.glide.e.j.gt(20);

    abstract T agV();

    d() {
    }

    final T agW() {
        T tPoll = this.bUB.poll();
        return tPoll == null ? (T) agV() : tPoll;
    }

    public final void a(T t) {
        if (this.bUB.size() < 20) {
            this.bUB.offer(t);
        }
    }
}
