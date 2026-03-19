package com.kwad.components.ct.feed.home.a.b.a;

import android.view.View;
import android.view.ViewGroup;
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
public final class a extends com.kwad.components.ct.feed.home.a.a.a implements View.OnClickListener, com.kwad.components.ct.f.b {
    private ImageView EZ;
    private TextView Fa;
    private f aDL;
    private KSFrameLayout aFE;
    private TextView aFF;
    private volatile boolean aFG;
    private TextView aFx;
    private KsAppDownloadListener fJ;
    private AdInfo mAdInfo;
    private CtAdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    static /* synthetic */ com.kwad.components.ct.feed.b.a b(a aVar) {
        return EZ();
    }

    static /* synthetic */ com.kwad.components.ct.feed.b.a c(a aVar) {
        return EZ();
    }

    static /* synthetic */ com.kwad.components.ct.feed.b.a e(a aVar) {
        return EZ();
    }

    static /* synthetic */ com.kwad.components.ct.feed.b.a f(a aVar) {
        return EZ();
    }

    static /* synthetic */ com.kwad.components.ct.feed.b.a j(a aVar) {
        return EZ();
    }

    static /* synthetic */ com.kwad.components.ct.feed.b.a k(a aVar) {
        return EZ();
    }

    static /* synthetic */ com.kwad.components.ct.feed.b.a m(a aVar) {
        return EZ();
    }

    static /* synthetic */ com.kwad.components.ct.feed.b.a n(a aVar) {
        return EZ();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.aFE = (KSFrameLayout) findViewById(R.id.ksad_feed_item_root);
        this.aFx = (TextView) findViewById(R.id.ksad_feed_item_photo_desc);
        this.aFF = (TextView) findViewById(R.id.ksad_ad_convert_btn);
        this.EZ = (ImageView) findViewById(R.id.ksad_feed_item_author_icon);
        this.Fa = (TextView) findViewById(R.id.ksad_feed_item_author_name);
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
        String strAQ = com.kwad.components.ct.response.a.a.aQ(this.mAdTemplate);
        if (bq.isNullString(strAQ)) {
            this.aFx.setVisibility(8);
        } else {
            this.aFx.setText(strAQ);
            g.a(this.aFx, EZ().aDt);
            this.aFx.setVisibility(0);
        }
        com.kwad.sdk.glide.c.h(((com.kwad.components.ct.feed.home.a.a.b) this.cdN).alG).hh(com.kwad.components.ct.response.a.a.bf(this.mAdTemplate)).d(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).f(getContext().getResources().getDrawable(R.drawable.ksad_photo_default_author_icon)).a(new com.kwad.components.ct.widget.b.a()).b(this.EZ);
        String strAL = com.kwad.components.ct.response.a.a.aL(this.mAdTemplate);
        if (bq.isNullString(strAL) && com.kwad.components.ct.response.a.a.eH(this.mAdTemplate)) {
            strAL = getContext().getString(R.string.ksad_ad_default_username_normal);
        }
        g.a(this.Fa, EZ().asm);
        this.Fa.setText(strAL);
        g.a(this.aFF, EZ().aGc);
        this.aFF.setText(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo));
        g.r(this.aFF, EZ().aGd);
        ViewGroup.LayoutParams layoutParams = this.aFF.getLayoutParams();
        layoutParams.width = -2;
        this.aFF.setLayoutParams(layoutParams);
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
            this.fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ct.feed.home.a.b.a.a.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    g.a(a.this.aFF, a.b(a.this).aGc);
                    g.r(a.this.aFF, a.c(a.this).aGd);
                    a.this.aFG = false;
                    a.this.aFF.setText(com.kwad.sdk.core.response.b.a.aH(a.this.mAdInfo));
                    ViewGroup.LayoutParams layoutParams = a.this.aFF.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.aFF.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    g.a(a.this.aFF, a.e(a.this).aGc);
                    g.r(a.this.aFF, a.f(a.this).aGd);
                    a.this.aFG = false;
                    a.this.aFF.setText("下载中..." + i + "%");
                    ViewGroup.LayoutParams layoutParams = a.this.aFF.getLayoutParams();
                    layoutParams.width = com.kwad.sdk.c.a.a.a(a.this.getContext(), 76.0f);
                    a.this.aFF.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    a.this.aFF.setTextColor(a.this.getContext().getResources().getColor(R.color.ksad_feed_covert_finish));
                    a.this.aFF.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_finish_bg);
                    a.this.aFG = true;
                    a.this.aFF.setText(com.kwad.sdk.core.response.b.a.cB(a.this.mAdTemplate));
                    ViewGroup.LayoutParams layoutParams = a.this.aFF.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.aFF.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    g.a(a.this.aFF, a.j(a.this).aGc);
                    g.r(a.this.aFF, a.k(a.this).aGd);
                    a.this.aFG = false;
                    a.this.aFF.setText(com.kwad.sdk.core.response.b.a.aH(a.this.mAdInfo));
                    ViewGroup.LayoutParams layoutParams = a.this.aFF.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.aFF.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    a.this.aFF.setTextColor(a.this.getContext().getResources().getColor(R.color.ksad_feed_covert_finish));
                    a.this.aFF.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_finish_bg);
                    a.this.aFG = true;
                    a.this.aFF.setText(com.kwad.sdk.core.response.b.a.ae(a.this.mAdInfo));
                    ViewGroup.LayoutParams layoutParams = a.this.aFF.getLayoutParams();
                    layoutParams.width = -2;
                    a.this.aFF.setLayoutParams(layoutParams);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    super.onPaused(i);
                    g.a(a.this.aFF, a.m(a.this).aGc);
                    g.r(a.this.aFF, a.n(a.this).aGd);
                    a.this.aFG = false;
                    a.this.aFF.setText(com.kwad.sdk.core.response.b.a.fv(i));
                    ViewGroup.LayoutParams layoutParams = a.this.aFF.getLayoutParams();
                    layoutParams.width = com.kwad.sdk.c.a.a.a(a.this.getContext(), 76.0f);
                    a.this.aFF.setLayoutParams(layoutParams);
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
        com.kwad.components.core.e.d.a.a(new a.C0469a(view.getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aq(view == this.aFF).a(new a.b() { // from class: com.kwad.components.ct.feed.home.a.b.a.a.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                a.this.cm(i);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(int i) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, this.aFE.getTouchCoords());
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        com.kwad.sdk.core.d.c.d("[ThemeMode]", "FeedHomeItemAdBottomPresenter onThemeModeChanged themeMode=" + i);
        g.c(this.aFE, EZ().aDq);
        g.a(this.aFx, EZ().aDt);
        g.a(this.Fa, EZ().asm);
        if (this.aFG) {
            this.aFF.setTextColor(getContext().getResources().getColor(R.color.ksad_feed_covert_finish));
            this.aFF.setBackgroundResource(R.drawable.ksad_feed_item_covert_btn_finish_bg);
        } else {
            g.a(this.aFF, EZ().aGc);
            g.r(this.aFF, EZ().aGd);
        }
    }
}
