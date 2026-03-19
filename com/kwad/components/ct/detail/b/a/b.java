package com.kwad.components.ct.detail.b.a;

import android.view.View;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.bq;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b extends com.kwad.components.ct.detail.b implements View.OnClickListener {
    private TextView ayH;
    private KsLogoView ek;
    private String hl;
    private Runnable ht = new Runnable() { // from class: com.kwad.components.ct.detail.b.a.b.2
        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.c.a.a.a(b.this.ayH, b.this.hl, KsLogoView.a(b.this.ek));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                b.this.ayH.setText(b.this.hl);
                b.this.ayH.setVisibility(0);
            }
        }
    };

    /* renamed from: if, reason: not valid java name */
    private AdBaseFrameLayout f10if;
    private CtAdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f10if = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.ayH = (TextView) findViewById(R.id.ksad_bottom_content_describe);
    }

    @Override // com.kwad.components.ct.detail.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdTemplate = this.aop.mAdTemplate;
        this.mApkDownloadHelper = this.aop.mApkDownloadHelper;
        this.hl = com.kwad.components.ct.response.a.a.aN(this.mAdTemplate);
        if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            KsLogoView ksLogoView = new KsLogoView(getContext(), true);
            this.ek = ksLogoView;
            ksLogoView.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ct.detail.b.a.b.1
                @Override // com.kwad.components.core.widget.KsLogoView.a
                public final void bJ() {
                    b.this.ayH.post(b.this.ht);
                }
            });
            this.ek.aQ(this.mAdTemplate);
            this.ayH.setVisibility(0);
            this.ayH.setOnClickListener(this);
            return;
        }
        if (bq.isNullString(this.hl) || (com.kwad.components.ct.response.a.a.aW(this.mAdTemplate) && this.aop.aol.mKSTubeParam.hideDetailBottomDesc)) {
            this.ayH.setVisibility(8);
            return;
        }
        this.ayH.setText(this.hl);
        this.ayH.setTextSize(com.kwad.components.ct.response.a.a.aO(this.mAdTemplate));
        this.ayH.setVisibility(0);
        this.ayH.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.ayH.removeCallbacks(this.ht);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            handleAdClick();
        }
    }

    private void handleAdClick() {
        if ((this.aop.aoy instanceof com.kwad.components.ct.detail.ad.a) && com.kwad.components.core.u.d.tu()) {
            com.kwad.components.ct.e.b.JK().b(this.aop.mAdTemplate, 1);
        }
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aG(2).aq(false).aF(25).d(this.f10if.getTouchCoords()).as(true));
    }
}
