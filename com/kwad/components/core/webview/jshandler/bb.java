package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class bb implements com.kwad.sdk.core.webview.c.a {
    private final Handler aeI = new Handler(Looper.getMainLooper());
    private com.kwad.sdk.core.webview.c.c aeb;
    private final c aga;

    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int likeUserCount;
        public long liveDuration;
        public int status;
        public long totalWatchingDuration;
        public int watchingUserCount;
        public String displayWatchingUserCount = "0";
        public String displayLikeUserCount = "0";
    }

    public interface c {
        void a(b bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerLiveListener";
    }

    public bb(c cVar) {
        this.aga = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aeb = cVar;
        this.aeI.post(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.bb.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                bb.this.aga.a(new b(bb.this.aeb));
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aeb = null;
        this.aeI.removeCallbacksAndMessages(null);
    }

    public static final class b {
        WeakReference<com.kwad.sdk.core.webview.c.c> agc;

        public b(com.kwad.sdk.core.webview.c.c cVar) {
            this.agc = new WeakReference<>(cVar);
        }

        public final void a(a aVar) {
            com.kwad.sdk.core.webview.c.c cVar = this.agc.get();
            if (cVar != null) {
                cVar.a(aVar);
            }
        }
    }
}
