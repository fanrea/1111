package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import com.kwad.sdk.widget.e;
import com.kwad.sdk.widget.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ActionBarAppLandscape extends LinearLayout implements e {
    private AppScoreView Gh;
    private TextProgressBar Gi;
    private View Gj;
    private a Gk;
    private KsAppDownloadListener fJ;
    private TextView fR;
    private ImageView ik;
    private TextView im;
    private TextView jx;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;

    public interface a {
        void O(boolean z);
    }

    public ActionBarAppLandscape(Context context) {
        this(context, null);
    }

    public ActionBarAppLandscape(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppLandscape(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_video_actionbar_app_landscape, this);
        this.ik = (ImageView) findViewById(R.id.ksad_app_icon);
        this.fR = (TextView) findViewById(R.id.ksad_app_title);
        this.jx = (TextView) findViewById(R.id.ksad_app_desc);
        this.Gh = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.im = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.Gi = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 16.0f));
        this.Gi.setTextColor(-1);
        this.Gj = findViewById(R.id.ksad_download_bar_cover);
    }

    public final void a(AdTemplate adTemplate, c cVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEP = com.kwad.sdk.core.response.b.e.eP(adTemplate);
        this.mAdInfo = adInfoEP;
        this.Gk = aVar;
        this.mApkDownloadHelper = cVar;
        KSImageLoader.loadAppIcon(this.ik, com.kwad.sdk.core.response.b.a.cC(adInfoEP), adTemplate, 12);
        this.fR.setText(com.kwad.sdk.core.response.b.a.cz(this.mAdInfo));
        lu();
        this.Gi.e(com.kwad.sdk.core.response.b.a.aH(this.mAdInfo), 0);
        c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(getAppDownloadListener());
        }
        setClickable(true);
        new j(this, this);
        new j(this.Gj, this);
    }

    private void lu() {
        float fAD = com.kwad.sdk.core.response.b.a.aD(this.mAdInfo);
        boolean z = fAD >= 3.0f;
        if (z) {
            this.Gh.setScore(fAD);
            this.Gh.setVisibility(0);
        }
        String strAC = com.kwad.sdk.core.response.b.a.aC(this.mAdInfo);
        boolean zIsEmpty = true ^ TextUtils.isEmpty(strAC);
        if (zIsEmpty) {
            this.im.setText(strAC);
            this.im.setVisibility(0);
        }
        if (zIsEmpty || z) {
            this.jx.setVisibility(8);
            return;
        }
        this.jx.setText(com.kwad.sdk.core.response.b.a.aw(this.mAdInfo));
        this.Gh.setVisibility(8);
        this.im.setVisibility(8);
        this.jx.setVisibility(0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.fJ == null) {
            this.fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppLandscape.this.Gi.e(com.kwad.sdk.core.response.b.a.aH(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.Gj.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    ActionBarAppLandscape.this.Gi.e(com.kwad.sdk.core.response.b.a.ft(i), i);
                    ActionBarAppLandscape.this.Gj.setVisibility(8);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    ActionBarAppLandscape.this.Gi.e(com.kwad.sdk.core.response.b.a.fv(i), i);
                    ActionBarAppLandscape.this.Gj.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppLandscape.this.Gi.e(com.kwad.sdk.core.response.b.a.cB(ActionBarAppLandscape.this.mAdTemplate), 0);
                    ActionBarAppLandscape.this.Gj.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppLandscape.this.Gi.e(com.kwad.sdk.core.response.b.a.aH(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.Gj.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppLandscape.this.Gi.e(com.kwad.sdk.core.response.b.a.ae(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.Gj.setVisibility(0);
                }
            };
        }
        return this.fJ;
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

    private void d(View view, final boolean z) {
        com.kwad.components.core.e.d.a.a(new a.C0469a(view.getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aq(view == this.Gi).aG(view == this.Gj ? 1 : 2).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarAppLandscape.this.Gk != null) {
                    ActionBarAppLandscape.this.Gk.O(z);
                }
            }
        }));
    }
}
