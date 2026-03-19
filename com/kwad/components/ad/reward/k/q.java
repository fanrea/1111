package com.kwad.components.ad.reward.k;

import android.content.DialogInterface;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class q extends z {
    private long AM;
    private WeakReference<com.kwad.components.ad.reward.g> CB;

    public q(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.components.ad.reward.g gVar, long j, com.kwad.sdk.core.webview.d.a.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        super(bVar, cVar, aVar, onDismissListener);
        this.AM = j;
        if (gVar != null) {
            this.CB = new WeakReference<>(gVar);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.z
    public final void kv() {
        super.kv();
        if (this.aen != null) {
            com.kwad.components.ad.reward.c.a.hZ().c(this.aen.getAdTemplate(), com.kwad.components.ad.reward.c.b.STATUS_NONE);
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.z
    public final a.C0469a a(a.C0469a c0469a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.CB;
        long playDuration = 0;
        if (weakReference != null && weakReference.get() != null) {
            playDuration = this.CB.get().tu.getPlayDuration();
        } else {
            long j = this.AM;
            if (j > 0) {
                playDuration = j;
            }
        }
        return super.a(c0469a, aVar, adTemplate).B(playDuration);
    }
}
