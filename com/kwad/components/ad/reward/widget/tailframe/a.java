package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import com.kwad.sdk.widget.e;
import com.kwad.sdk.widget.j;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class a implements e {
    protected View Gs;
    protected ImageView Gt;
    private com.kwad.components.ad.widget.tailframe.appbar.a Gu;
    private TailFrameBarH5View Gv;
    private b Gw;
    private TextProgressBar Gx;
    private View Gy;
    private int Gz;
    private TextView it;
    protected AdInfo mAdInfo;
    protected AdTemplate mAdTemplate;
    private c mApkDownloadHelper;
    protected KsLogoView mLogoView;
    private JSONObject mReportExtData;
    private g vb;

    public a(int i) {
        this.Gz = i;
    }

    public final void setCallerContext(g gVar) {
        this.vb = gVar;
    }

    public void B(Context context) {
        View viewA = m.a(context, this.Gz, null, false);
        this.Gs = viewA;
        this.Gt = (ImageView) viewA.findViewById(R.id.ksad_video_thumb_img);
        this.mLogoView = (KsLogoView) this.Gs.findViewById(R.id.ksad_video_tf_logo);
        this.Gu = (com.kwad.components.ad.widget.tailframe.appbar.a) this.Gs.findViewById(R.id.ksad_video_app_tail_frame);
        this.Gv = (TailFrameBarH5View) this.Gs.findViewById(R.id.ksad_video_h5_tail_frame);
    }

    public final void f(boolean z, boolean z2) {
        this.Gv.g(z, z2);
    }

    public void a(AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.mReportExtData = jSONObject;
        this.Gw = bVar;
        this.mLogoView.aQ(this.mAdTemplate);
        lx();
        this.Gs.setClickable(true);
        new j(this.Gs, this);
    }

    private void bindDownloadListener() {
        this.mApkDownloadHelper = new c(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.Gu.D(a.this.mAdInfo);
                a.this.Gx.e(com.kwad.sdk.core.response.b.a.aH(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                a.this.Gu.D(a.this.mAdInfo);
                a.this.Gx.e(com.kwad.sdk.core.response.b.a.ft(i), i);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i) {
                a.this.Gu.D(a.this.mAdInfo);
                a.this.Gx.e(com.kwad.sdk.core.response.b.a.fv(i), i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.Gu.D(a.this.mAdInfo);
                a.this.Gx.e(com.kwad.sdk.core.response.b.a.cB(a.this.mAdTemplate), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.Gu.D(a.this.mAdInfo);
                a.this.Gx.e(com.kwad.sdk.core.response.b.a.aH(a.this.mAdInfo), 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.Gu.D(a.this.mAdInfo);
                a.this.Gx.e(com.kwad.sdk.core.response.b.a.ae(a.this.mAdInfo), 0);
            }
        });
    }

    private void lv() {
        this.Gs.setOnClickListener(null);
        this.mApkDownloadHelper = null;
    }

    public final View lw() {
        return this.Gs;
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        d(view, true);
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        if (d.eE(this.mAdTemplate)) {
            d(view, false);
        }
    }

    public final void destroy() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.Gu;
        if (aVar != null) {
            aVar.lz();
            this.Gu.setVisibility(8);
        }
        TailFrameBarH5View tailFrameBarH5View = this.Gv;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.lz();
            this.Gv.setVisibility(8);
        }
        lv();
    }

    public final void le() {
        com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.Gu;
        if (aVar != null) {
            aVar.lz();
        }
        TailFrameBarH5View tailFrameBarH5View = this.Gv;
        if (tailFrameBarH5View != null) {
            tailFrameBarH5View.lz();
        }
    }

    private void lx() {
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo) || com.kwad.sdk.core.response.b.e.P(this.mAdTemplate)) {
            this.Gu.k(this.mAdTemplate);
            this.Gu.setVisibility(0);
            this.Gx = this.Gu.getTextProgressBar();
            if (!com.kwad.sdk.core.response.b.e.P(this.mAdTemplate)) {
                this.Gx.setClickable(true);
                new j(this.Gx, this);
                bindDownloadListener();
                return;
            } else {
                View btnInstallContainer = this.Gu.getBtnInstallContainer();
                this.Gy = btnInstallContainer;
                btnInstallContainer.setClickable(true);
                new j(this.Gy, this);
                return;
            }
        }
        this.Gv.k(this.mAdTemplate);
        TextView h5OpenBtn = this.Gv.getH5OpenBtn();
        this.it = h5OpenBtn;
        h5OpenBtn.setClickable(true);
        this.Gv.setVisibility(0);
        new j(this.it, this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        r1 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(android.view.View r6, final boolean r7) {
        /*
            r5 = this;
            com.kwad.sdk.core.response.model.AdTemplate r0 = r5.mAdTemplate
            boolean r0 = com.kwad.sdk.core.response.b.e.P(r0)
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L21
            if (r7 == 0) goto Le
            r7 = r2
            goto L10
        Le:
            r7 = 153(0x99, float:2.14E-43)
        L10:
            com.kwad.components.ad.reward.g r0 = r5.vb
            android.view.View r3 = r5.Gs
            android.content.Context r3 = r3.getContext()
            android.view.View r4 = r5.Gy
            if (r6 != r4) goto L1d
            r1 = r2
        L1d:
            r0.a(r2, r3, r7, r1)
            return
        L21:
            com.kwad.sdk.core.response.model.AdInfo r0 = r5.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.b.a.aJ(r0)
            if (r0 == 0) goto L2f
            com.kwad.components.core.page.widget.TextProgressBar r0 = r5.Gx
            if (r6 != r0) goto L34
        L2d:
            r1 = r2
            goto L34
        L2f:
            android.widget.TextView r0 = r5.it
            if (r6 != r0) goto L34
            goto L2d
        L34:
            com.kwad.components.core.e.d.a$a r0 = new com.kwad.components.core.e.d.a$a
            android.content.Context r3 = r6.getContext()
            r0.<init>(r3)
            com.kwad.sdk.core.response.model.AdTemplate r3 = r5.mAdTemplate
            com.kwad.components.core.e.d.a$a r0 = r0.aC(r3)
            com.kwad.components.core.e.d.c r3 = r5.mApkDownloadHelper
            com.kwad.components.core.e.d.a$a r0 = r0.b(r3)
            r3 = 0
            if (r1 != r2) goto L4e
            r4 = r2
            goto L4f
        L4e:
            r4 = r3
        L4f:
            com.kwad.components.core.e.d.a$a r0 = r0.aF(r4)
            com.kwad.components.core.e.d.a$a r0 = r0.aE(r2)
            com.kwad.components.core.page.widget.TextProgressBar r4 = r5.Gx
            if (r6 != r4) goto L5c
            goto L5d
        L5c:
            r2 = r3
        L5d:
            com.kwad.components.core.e.d.a$a r6 = r0.aq(r2)
            com.kwad.components.core.e.d.a$a r6 = r6.aG(r1)
            com.kwad.components.ad.reward.widget.tailframe.a$2 r0 = new com.kwad.components.ad.reward.widget.tailframe.a$2
            r0.<init>()
            com.kwad.components.core.e.d.a$a r6 = r6.a(r0)
            com.kwad.components.core.e.d.a.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.widget.tailframe.a.d(android.view.View, boolean):void");
    }
}
