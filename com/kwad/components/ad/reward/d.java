package com.kwad.components.ad.reward;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ad.l.b {
    private List<AdTemplate> tl;
    private boolean tm;
    private List<com.kwad.components.core.e.d.c> tn;
    private y.b to;

    @Override // com.kwad.components.ad.l.b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    @Override // com.kwad.components.ad.l.b
    public final boolean gy() {
        return false;
    }

    public d(List<AdTemplate> list, JSONObject jSONObject, y.b bVar) {
        super(jSONObject, null);
        this.tm = false;
        this.tn = new ArrayList();
        this.tl = list;
        this.to = bVar;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AdTemplate> it = this.tl.iterator();
        while (it.hasNext()) {
            this.tn.add(new com.kwad.components.core.e.d.c(it.next()));
        }
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar, int i) {
        super.a(frameLayout, adBaseFrameLayout, this.tl, this.tn);
    }

    @Override // com.kwad.components.ad.l.b
    public final void gx() {
        super.gx();
        this.gz.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.d.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
    }

    public final void gz() {
        if (this.gE != null) {
            this.gE.ve();
        }
    }

    @Override // com.kwad.components.ad.l.b
    public final String L(AdTemplate adTemplate) {
        List<AdTemplate> list = this.tl;
        if (list == null || list.size() < 2) {
            return super.L(adTemplate);
        }
        String strCW = com.kwad.sdk.core.response.b.b.cW(this.tl.get(1));
        new StringBuilder("getUrl: ").append(strCW);
        return strCW;
    }

    public final void setShowLandingPage(boolean z) {
        this.tm = z;
    }

    @Override // com.kwad.components.ad.l.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplateList(this.tl);
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        List<AdTemplate> list = this.tl;
        y yVar = new y(new ArrayList(list.subList(1, list.size() - 1)));
        yVar.a(this.to);
        aVar.a(yVar);
    }

    @Override // com.kwad.components.ad.l.b
    public final void gA() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card");
    }

    @Override // com.kwad.components.ad.l.b
    public final void gB() {
        com.kwad.components.ad.reward.monitor.c.a(this.mAdTemplate, true, "middle_play_end_card", L(this.mAdTemplate));
    }

    @Override // com.kwad.components.ad.l.b
    public final void gC() {
        com.kwad.components.ad.reward.monitor.c.a(true, "middle_play_end_card", L(this.mAdTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.l.b
    public final boolean cM() {
        if (this.tm) {
            return this.Og;
        }
        return super.cM();
    }
}
