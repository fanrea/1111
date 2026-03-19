package com.kwad.components.ct.feed.home.a.b.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.ct.f.f;
import com.kwad.components.ct.f.g;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ct.feed.home.a.a.a implements View.OnClickListener, com.kwad.components.ct.f.b {
    private ImageView EZ;
    private TextView Fa;
    private f aDL;
    private KSFrameLayout aFE;
    private TextView aFF;
    private TextView aFx;
    private KsAppDownloadListener fJ;
    private AdInfo mAdInfo;
    private CtAdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFE = (KSFrameLayout) findViewById(R.id.ksad_feed_item_root);
        this.EZ = (ImageView) findViewById(R.id.ksad_feed_item_author_icon);
        this.Fa = (TextView) findViewById(R.id.ksad_feed_item_author_name);
        this.aFx = (TextView) findViewById(R.id.ksad_feed_item_photo_desc);
        this.aFF = (TextView) findViewById(R.id.ksad_ad_convert_btn);
        g.c(this.aFE, EZ().aDq);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.lib.widget.a.b.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        com.kwad.components.core.e.d.c cVar;
        super.ay();
        CtAdTemplate ctAdTemplate = (CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM;
        this.mAdTemplate = ctAdTemplate;
        this.mAdInfo = com.kwad.components.ct.response.a.a.eP(ctAdTemplate);
        this.mApkDownloadHelper = ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).mApkDownloadHelper;
        this.aDL = new f(this);
        com.kwad.components.ct.f.d.Kb().a(this.aDL);
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.feed.home.a.a.b) this.cdN).alG).hh(com.kwad.components.ct.response.a.a.bf(this.mAdTemplate)).d(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).f(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a(new com.kwad.components.ct.widget.b.a()).b(this.EZ);
        String strAL = com.kwad.components.ct.response.a.a.aL(this.mAdTemplate);
        if (bq.isNullString(strAL) && com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            strAL = getContext().getString(R.string.ksad_ad_default_username_normal);
        }
        g.a(this.Fa, EZ().asm);
        this.Fa.setText(strAL);
        String strAQ = com.kwad.components.ct.response.a.a.aQ((CtAdTemplate) ((com.kwad.components.ct.feed.home.a.a.b) this.cdN).cdM);
        if (bq.isNullString(strAQ)) {
            this.aFx.setVisibility(8);
        } else {
            this.aFx.setText(strAQ);
            g.a(this.aFx, EZ().aDt);
            this.aFx.setVisibility(0);
        }
        this.aFF.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
        if (com.kwad.sdk.core.response.b.a.aJ(this.mAdInfo) && (cVar = this.mApkDownloadHelper) != null) {
            cVar.b(getAppDownloadListener());
        }
        this.EZ.setOnClickListener(this);
        this.Fa.setOnClickListener(this);
        this.aFF.setOnClickListener(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.fJ);
        }
        com.kwad.components.ct.f.d.Kb().b(this.aDL);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.fJ == null) {
            this.fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ct.feed.home.a.b.a.d.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    d.this.aFF.setText(com.kwad.sdk.core.response.b.a.aH(d.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    d.this.aFF.setText("下载中..." + i + "%");
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    super.onPaused(i);
                    d.this.aFF.setText(com.kwad.sdk.core.response.b.a.fv(i));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    d.this.aFF.setText(com.kwad.sdk.core.response.b.a.cB(d.this.mAdTemplate));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    d.this.aFF.setText(com.kwad.sdk.core.response.b.a.aH(d.this.mAdInfo));
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    d.this.aFF.setText(com.kwad.sdk.core.response.b.a.ae(d.this.mAdInfo));
                }
            };
        }
        return this.fJ;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        final int i;
        if (view == this.EZ) {
            i = 55;
        } else if (view == this.Fa) {
            i = 82;
        } else {
            i = view == this.aFF ? 83 : 0;
        }
        com.kwad.components.core.e.d.a.a(new a.C0469a(view.getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aq(view == this.aFF).a(new a.b() { // from class: com.kwad.components.ct.feed.home.a.b.a.d.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                d.this.cm(i);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(int i) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, this.aFE.getTouchCoords());
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        com.kwad.sdk.core.d.c.d("[ThemeMode]", "FeedSingleSmallAdAuthorPresenter onThemeModeChanged themeMode=" + i);
        g.c(this.aFE, EZ().aDq);
        g.a(this.aFx, EZ().aDt);
        g.a(this.Fa, EZ().asm);
    }
}
