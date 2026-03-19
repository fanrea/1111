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
public class ActionBarAppPortrait extends LinearLayout implements e {
    private AppScoreView Gh;
    private TextProgressBar Gi;
    private View Gj;
    private a Gm;
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

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    public ActionBarAppPortrait(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionBarAppPortrait(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_video_actionbar_app_portrait, this);
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
        this.Gm = aVar;
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
        String strAC = com.kwad.sdk.core.response.b.a.aC(this.mAdInfo);
        boolean z = !TextUtils.isEmpty(strAC);
        float fAD = com.kwad.sdk.core.response.b.a.aD(this.mAdInfo);
        boolean z2 = fAD >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.fR.getLayoutParams()).bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.Gh.getLayoutParams()).bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
            this.im.setText(strAC);
            this.im.setVisibility(0);
            this.Gh.setVisibility(0);
            this.Gh.setScore(fAD);
            this.jx.setVisibility(8);
            return;
        }
        if (z) {
            this.im.setText(strAC);
            this.im.setVisibility(0);
            this.Gh.setVisibility(8);
            this.jx.setVisibility(8);
            return;
        }
        if (z2) {
            this.im.setVisibility(8);
            this.Gh.setScore(fAD);
            this.Gh.setVisibility(0);
            this.jx.setVisibility(8);
            return;
        }
        this.jx.setText(com.kwad.sdk.core.response.b.a.aw(this.mAdInfo));
        this.im.setVisibility(8);
        this.Gh.setVisibility(8);
        this.jx.setVisibility(0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.fJ == null) {
            this.fJ = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppPortrait.this.Gi.e(com.kwad.sdk.core.response.b.a.aH(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Gj.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    ActionBarAppPortrait.this.Gi.e(com.kwad.sdk.core.response.b.a.ft(i), i);
                    ActionBarAppPortrait.this.Gj.setVisibility(8);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    ActionBarAppPortrait.this.Gi.e(com.kwad.sdk.core.response.b.a.fv(i), i);
                    ActionBarAppPortrait.this.Gj.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppPortrait.this.Gi.e(com.kwad.sdk.core.response.b.a.cB(ActionBarAppPortrait.this.mAdTemplate), 0);
                    ActionBarAppPortrait.this.Gj.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppPortrait.this.Gi.e(com.kwad.sdk.core.response.b.a.aH(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Gj.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppPortrait.this.Gi.e(com.kwad.sdk.core.response.b.a.ae(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Gj.setVisibility(0);
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
        int i = view == this.Gj ? 1 : 2;
        com.kwad.components.core.e.d.a.a(new a.C0469a(view.getContext()).aC(this.mAdTemplate).b(this.mApkDownloadHelper).aE(1).aF(i).aq(view == this.Gi).aG(i).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarAppPortrait.this.Gm != null) {
                    ActionBarAppPortrait.this.Gm.O(z);
                }
            }
        }));
    }
}
