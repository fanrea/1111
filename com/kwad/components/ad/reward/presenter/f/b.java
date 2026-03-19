package com.kwad.components.ad.reward.presenter.f;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b extends d {
    private FrameLayout Bt;
    private boolean Bu = false;

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_live_video";
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d
    protected final boolean ka() {
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Bt = (FrameLayout) findViewById(dz());
    }

    protected int dz() {
        return R.id.ksad_js_reward_card;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.Bu) {
            return;
        }
        U(true);
    }

    public final BackPressHandleResult hB() {
        if (this.Bx == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        return this.Bx.hB();
    }

    private com.kwad.components.core.webview.tachikoma.c eI() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.reward.presenter.f.b.1
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.c cVar2 = new com.kwad.components.core.webview.tachikoma.c.c();
                cVar2.aiV = com.kwad.components.ad.reward.model.b.dV();
                cVar.a(cVar2);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(eI());
        tVar.c(new com.kwad.components.core.webview.tachikoma.b(new b.a() { // from class: com.kwad.components.ad.reward.presenter.f.b.2
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eS() {
                com.kwad.components.ad.reward.model.b.L(b.this.vb.mContext);
            }
        }));
        tVar.c(new x() { // from class: com.kwad.components.ad.reward.presenter.f.b.3
            @Override // com.kwad.components.core.webview.jshandler.x
            public final void b(y yVar) {
                super.b(yVar);
                b.this.vb.tt.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.c.b(b.this.vb.tI, b.this.vb.mAdTemplate, b.this.vb.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void c(y yVar) {
                super.c(yVar);
                b.this.vb.tt.onVideoPlayEnd();
                b.this.vb.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.u(b.this.vb);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void d(y yVar) {
                super.d(yVar);
                b.this.vb.mAdTemplate.setmCurPlayTime(yVar.sp);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void a(y yVar) {
                super.a(yVar);
                long jWg = yVar.wg();
                b.this.vb.tt.onVideoPlayError(yVar.errorCode, (int) jWg);
                com.kwad.components.ad.reward.monitor.c.a(b.this.vb.tI, b.this.vb.mAdTemplate, b.this.vb.uh, yVar.errorCode, jWg);
                com.kwad.components.ad.reward.monitor.b.c(b.this.vb.tI, b.this.mAdTemplate);
            }
        });
    }

    private void U(boolean z) {
        this.Bt.setVisibility(z ? 0 : 8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.ef(this.vb.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(final u uVar) {
        com.kwad.sdk.core.d.c.d("TKLivePresenter", "onSkipClick: " + uVar.adZ);
        bx.postOnUiThread(new bh() { // from class: com.kwad.components.ad.reward.presenter.f.b.4
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (b.this.vb != null && b.this.vb.tt != null) {
                    b.this.vb.tt.onVideoSkipToEnd(uVar.adZ * 1000);
                }
                com.kwad.components.ad.reward.presenter.f.u(b.this.vb);
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public FrameLayout getTKContainer() {
        return this.Bt;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        this.Bu = true;
        U(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float screenHeight;
        float screenWidth;
        float fBv = com.kwad.sdk.c.a.a.bv(getContext());
        FrameLayout frameLayout = this.Bt;
        if (frameLayout != null) {
            screenHeight = frameLayout.getHeight();
            screenWidth = this.Bt.getWidth();
        } else {
            screenHeight = 0.0f;
            screenWidth = 0.0f;
        }
        if (screenHeight == 0.0f || screenWidth == 0.0f) {
            screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
            screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(getContext());
        }
        aVar.width = (int) ((screenWidth / fBv) + 0.5f);
        aVar.height = (int) ((screenHeight / fBv) + 0.5f);
    }
}
