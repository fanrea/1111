package com.kwad.components.ct.feed.home.a.b.a;

import android.os.Handler;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.lib.widget.a.e;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.feed.home.a.a.a {
    private String aFJ;
    private Map<String, e.a> aFK;
    private com.kwad.components.core.widget.a.b asB;
    private CtAdTemplate mAdTemplate;
    private Handler mHandler = new Handler();
    private boolean aFL = false;
    private e.a aFM = new e.a() { // from class: com.kwad.components.ct.feed.home.a.b.a.b.1
        @Override // com.kwad.sdk.lib.widget.a.e.a
        public final void v(float f) {
            com.kwad.sdk.core.d.c.d("FeedHomeItemAdPvPresenter", "position=" + ((com.kwad.components.ct.feed.home.a.a.b) b.this.cdN).mCurrentPosition + "--visiblePercent=" + f);
            if (f < 0.3f || b.this.aFL) {
                return;
            }
            b.this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ct.feed.home.a.b.a.b.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.mAdTemplate.mPvReported || !b.this.asB.wO()) {
                        return;
                    }
                    com.kwad.components.core.u.b.tq().a(b.this.mAdTemplate, null, null);
                    if (b.this.aFK != null && b.this.aFM != null) {
                        b.this.aFK.remove(b.this.aFJ);
                    }
                    com.kwad.sdk.core.d.c.d("FeedHomeItemAdPvPresenter", "reportAdPv position=" + ((com.kwad.components.ct.feed.home.a.a.b) b.this.cdN).mCurrentPosition);
                }
            }, 1000L);
            b.a(b.this, true);
        }
    };

    static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.aFL = true;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM;
        this.mAdTemplate = ctAdTemplate;
        this.aFJ = ctAdTemplate.mUniqueId;
        this.asB = ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).aFq.aFs;
        if (this.mAdTemplate.mPvReported) {
            return;
        }
        Map<String, e.a> map = ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).aFq.aFK;
        this.aFK = map;
        map.put(this.aFJ, this.aFM);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        Map<String, e.a> map = this.aFK;
        if (map != null && this.aFM != null) {
            map.remove(this.aFJ);
        }
        this.aFL = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
