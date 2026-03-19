package com.kwad.components.ad.nativead.b;

import android.view.View;
import com.kwad.components.core.video.o;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ad.nativead.a.a {
    private List<Integer> dX;
    private volatile boolean gq = false;

    @Override // com.kwad.components.ad.nativead.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.dX = com.kwad.sdk.core.response.b.a.bv(com.kwad.sdk.core.response.b.e.eP(this.rg.mAdTemplate));
        this.mVideoPlayStateListener = new o() { // from class: com.kwad.components.ad.nativead.b.c.1
            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayStart() {
                c.this.gq = false;
                if (!c.this.rg.mAdTemplate.mPvReported) {
                    c.this.rg.qN.fw();
                }
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                View view = (View) c.this.rg.rb.getParent();
                if (view != null) {
                    bVar.G(view.getHeight(), view.getWidth());
                }
                com.kwad.components.core.u.b.tq().a(c.this.rg.mAdTemplate, null, bVar);
                com.kwad.sdk.core.adlog.c.cm(c.this.rg.mAdTemplate);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlaying() {
                if (c.this.gq) {
                    return;
                }
                c.this.gq = true;
                com.kwad.components.core.q.a.ss().a(c.this.rg.mAdTemplate, System.currentTimeMillis(), 1);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayProgress(long j, long j2) {
                c.this.c(j2);
            }

            @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
            public final void onMediaPlayCompleted() {
                com.kwad.sdk.core.adlog.c.cn(c.this.rg.mAdTemplate);
            }
        };
        this.rg.rh.b(this.mVideoPlayStateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.dX;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Integer num : this.dX) {
            if (iCeil >= num.intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.rg.mAdTemplate, iCeil, (JSONObject) null);
                this.dX.remove(num);
                return;
            }
        }
    }
}
