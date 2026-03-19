package com.kwad.sdk.glide.request.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class g<Z> extends h<Z> {
    private static final Handler bZT = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.kwad.sdk.glide.request.a.g.1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((g) message.obj).clear();
            return true;
        }
    });
    private final com.kwad.sdk.glide.g bQg;

    public static <Z> g<Z> b(com.kwad.sdk.glide.g gVar, int i, int i2) {
        return new g<>(gVar, i, i2);
    }

    private g(com.kwad.sdk.glide.g gVar, int i, int i2) {
        super(i, i2);
        this.bQg = gVar;
    }

    @Override // com.kwad.sdk.glide.request.a.j
    public final void onResourceReady(Z z, com.kwad.sdk.glide.request.b.b<? super Z> bVar) {
        bZT.obtainMessage(1, this).sendToTarget();
    }

    final void clear() {
        this.bQg.c(this);
    }
}
