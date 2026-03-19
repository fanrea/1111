package com.kwad.components.ad.interstitial.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.j;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends KSFrameLayout implements com.kwad.sdk.widget.e {
    private KSFrameLayout hn;
    private ImageView ik;
    private ImageView jF;
    private TextView jx;
    private AdTemplate mAdTemplate;
    private KsLogoView mLogoView;
    private KSFrameLayout oF;
    private String pS;
    private View pT;
    private ImageView pU;
    private TextProgressBar pV;
    private ViewGroup pW;
    private ViewGroup pX;
    private ImageView pY;
    private View pZ;
    private View qa;
    private TextView qb;
    private ImageView qc;
    private TextView qd;
    private TextView qe;
    private TextView qf;
    private TextProgressBar qg;
    private TextView qh;
    private e qi;
    private final a qj;
    private boolean qk;

    public d(Context context, a aVar) {
        int i;
        super(context);
        this.pS = "%s秒后进入试玩页";
        this.qk = false;
        this.qj = aVar;
        if (aVar.fq()) {
            i = R.layout.ksad_interstitial_native_above;
        } else {
            i = R.layout.ksad_interstitial_native;
        }
        m.inflate(context, i, this);
        t(aVar.qm);
    }

    private void t(boolean z) {
        setClickable(true);
        this.oF = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_container);
        this.hn = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_video_container);
        this.pT = findViewById(R.id.ksad_interstitial_full_bg);
        this.pU = (ImageView) findViewById(R.id.ksad_interstitial_tail_frame);
        this.jF = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_interstitial_logo);
        this.pW = (ViewGroup) findViewById(R.id.ksad_interstitial_playing);
        this.pX = (ViewGroup) findViewById(R.id.ksad_interstitial_play_end);
        this.pV = (TextProgressBar) findViewById(R.id.ksad_interstitial_download_btn);
        this.pZ = findViewById(R.id.ksad_interstitial_close_outer);
        TextProgressBar textProgressBar = this.pV;
        if (textProgressBar != null) {
            textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 10.0f));
            this.pV.setTextColor(-1);
        }
        this.pY = (ImageView) findViewById(R.id.ksad_interstitial_mute);
        this.qb = (TextView) findViewById(R.id.ksad_interstitial_count_down);
        this.qc = (ImageView) findViewById(R.id.ksad_interstitial_logo);
        this.qe = (TextView) findViewById(R.id.ksad_interstitial_name);
        this.qf = (TextView) findViewById(R.id.ksad_interstitial_desc);
        this.qg = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.qa = findViewById(R.id.ksad_ad_download_container);
        this.ik = (ImageView) findViewById(R.id.ksad_app_icon);
        this.qd = (TextView) findViewById(R.id.ksad_app_title);
        this.jx = (TextView) findViewById(R.id.ksad_app_desc);
        new j(this, this);
        new j(this.jF, this);
        new j(this.pV, this);
        new j(this.qg, this);
        new j(this.pZ, this);
        new j(this.pX, this);
        new j(this.qb, this);
        new j(this.qa, this);
        new j(this.ik, this);
        new j(this.qd, this);
        new j(this.jx, this);
        new j(this.qc, this);
        new j(this.qe, this);
        new j(this.qf, this);
        this.pY.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.h.d.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.pY.setSelected(!d.this.pY.isSelected());
                if (d.this.qi != null) {
                    d.this.qi.p(d.this.pY.isSelected());
                }
            }
        });
        this.qh = (TextView) findViewById(R.id.ksad_interstitial_playable_timer);
        a(this.hn, z);
        if (aq.isOrientationPortrait()) {
            return;
        }
        fj();
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setClickable(true);
        new j(kSFrameLayout, this);
        this.hn.setWidthBasedRatio(!z);
    }

    public final void setViewListener(e eVar) {
        this.qi = eVar;
    }

    public final void c(String str, AdTemplate adTemplate) {
        if (bq.isNullString(str)) {
            return;
        }
        this.jF.setImageDrawable(null);
        KSImageLoader.loadImage(this.jF, str, adTemplate);
    }

    public final void I(AdTemplate adTemplate) {
        this.mLogoView.aQ(adTemplate);
    }

    public final void c(boolean z, boolean z2) {
        ImageView imageView = this.jF;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
            this.jF.setClickable(z2);
        }
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    private void fj() {
        a(this.qc, 40, 40);
        a(this.qg, 130, 30);
        this.qe.setTextSize(14.0f);
        e(this.qg, 11);
        e(this.qe, 7);
        e(this.qf, 7);
    }

    private void a(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = com.kwad.sdk.c.a.a.a(getContext(), i);
        layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), i2);
        view.setLayoutParams(layoutParams);
    }

    private void e(View view, int i) {
        com.kwad.sdk.c.a.a.b(view, 0, com.kwad.sdk.c.a.a.a(getContext(), i), 0, 0);
    }

    public final void a(AdTemplate adTemplate, AdInfo adInfo) {
        this.qc.setImageResource(R.drawable.ksad_default_app_icon);
        if (com.kwad.sdk.core.response.b.a.cs(adInfo) == 2) {
            KSImageLoader.loadCircleIcon(this.qc, com.kwad.sdk.core.response.b.a.dc(adInfo), getContext().getResources().getDrawable(R.drawable.ksad_default_app_icon));
            this.qe.setText(com.kwad.sdk.core.response.b.a.cB(adInfo));
            this.qf.setText(com.kwad.sdk.core.response.b.a.aw(adInfo));
            if (com.kwad.sdk.core.response.b.a.cY(adInfo)) {
                this.qg.e(com.kwad.components.ad.e.b.aH(), 0);
                return;
            } else {
                this.qg.e(com.kwad.components.ad.e.b.aK(), 0);
                return;
            }
        }
        if (com.kwad.components.ad.interstitial.b.b.dS() && com.kwad.sdk.core.response.b.a.cs(adInfo) == 3) {
            AdProductInfo adProductInfoDj = com.kwad.sdk.core.response.b.a.dj(adInfo);
            KSImageLoader.loadWithRadius(this.qc, adProductInfoDj.icon, adTemplate, 4);
            this.qe.setText(adProductInfoDj.name);
            this.qf.setVisibility(8);
            this.qg.e(com.kwad.components.ad.e.b.aI(), 0);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aJ(adInfo)) {
            KSImageLoader.loadWithRadius(this.qc, com.kwad.sdk.core.response.b.a.cC(adInfo), adTemplate, 4);
            this.qe.setText(com.kwad.sdk.core.response.b.a.ay(adInfo));
            this.qf.setText(com.kwad.sdk.core.response.b.a.aw(adInfo));
            this.qg.e(com.kwad.sdk.core.response.b.a.aH(adInfo), 0);
            return;
        }
        KSImageLoader.loadWithRadius(this.qc, com.kwad.sdk.core.response.b.e.bf(adTemplate), adTemplate, 4);
        this.qe.setText(com.kwad.sdk.core.response.b.a.cz(adInfo));
        this.qf.setText(com.kwad.sdk.core.response.b.a.aw(adInfo));
        this.qg.e(com.kwad.sdk.core.response.b.a.aH(adInfo), 0);
    }

    public final void u(boolean z) {
        ViewGroup viewGroup = this.pW;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public final void v(boolean z) {
        ImageView imageView = this.pY;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }

    public final void C(String str) {
        TextView textView = this.qb;
        if (textView == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.qj.qn || this.qk || this.qb.getVisibility() == 0) {
            return;
        }
        this.qb.setVisibility(0);
    }

    public final void fk() {
        TextView textView = this.qb;
        if (textView != null) {
            textView.setVisibility(8);
            this.qk = true;
        }
    }

    public final void fl() {
        View view = this.pZ;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void f(String str, int i) {
        TextProgressBar textProgressBar = this.pV;
        if (textProgressBar != null) {
            textProgressBar.e(str, 0);
        }
        TextProgressBar textProgressBar2 = this.qg;
        if (textProgressBar2 != null) {
            textProgressBar2.e(str, 0);
        }
    }

    public final void b(boolean z, int i) {
        TextView textView = this.qh;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        if (i >= 0) {
            this.qh.setText(String.format(this.pS, String.valueOf(i)));
        }
    }

    public final void a(float f, com.kwad.sdk.core.video.videoview.a aVar) {
        this.hn.setRatio(f);
        this.hn.addView(aVar);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        aVar.setLayoutParams(layoutParams);
    }

    public final void fm() {
        u(false);
        this.pX.setVisibility(0);
        this.pU.setVisibility(0);
    }

    public final void fn() {
        this.pX.setVisibility(8);
        this.pU.setVisibility(8);
        u(true);
    }

    public final boolean fo() {
        ViewGroup viewGroup = this.pX;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    public final View getBlurBgView() {
        return this.pT;
    }

    public final ImageView getTailFrameView() {
        return this.pU;
    }

    public final void g(int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        setLayoutParams(marginLayoutParams);
    }

    private void d(View view, boolean z) {
        e eVar;
        e eVar2;
        e eVar3 = this.qi;
        if (eVar3 != null) {
            eVar3.q(z);
            this.qi.a(this.oF);
        }
        if (view.equals(this)) {
            e eVar4 = this.qi;
            if (eVar4 != null) {
                eVar4.en();
                return;
            }
            return;
        }
        if (view.equals(this.pZ)) {
            if (!(1 == this.qj.fp()) || (eVar2 = this.qi) == null) {
                return;
            }
            eVar2.em();
            return;
        }
        if (view.equals(this.qg)) {
            e eVar5 = this.qi;
            if (eVar5 != null) {
                eVar5.eo();
                return;
            }
            return;
        }
        if (view.equals(this.pX)) {
            e eVar6 = this.qi;
            if (eVar6 != null) {
                eVar6.ez();
                return;
            }
            return;
        }
        if (view.equals(this.pV)) {
            e eVar7 = this.qi;
            if (eVar7 != null) {
                eVar7.ep();
                return;
            }
            return;
        }
        if (view.equals(this.qa)) {
            e eVar8 = this.qi;
            if (eVar8 != null) {
                eVar8.es();
                return;
            }
            return;
        }
        if (view.equals(this.hn)) {
            e eVar9 = this.qi;
            if (eVar9 != null) {
                eVar9.eq();
                return;
            }
            return;
        }
        if (view.equals(this.jF)) {
            e eVar10 = this.qi;
            if (eVar10 != null) {
                eVar10.er();
                return;
            }
            return;
        }
        if (view.equals(this.ik)) {
            e eVar11 = this.qi;
            if (eVar11 != null) {
                eVar11.et();
                return;
            }
            return;
        }
        if (view.equals(this.qd)) {
            e eVar12 = this.qi;
            if (eVar12 != null) {
                eVar12.eu();
                return;
            }
            return;
        }
        if (view.equals(this.jx)) {
            e eVar13 = this.qi;
            if (eVar13 != null) {
                eVar13.ev();
                return;
            }
            return;
        }
        if (view.equals(this.qc)) {
            e eVar14 = this.qi;
            if (eVar14 != null) {
                eVar14.ew();
                return;
            }
            return;
        }
        if (view.equals(this.qe)) {
            e eVar15 = this.qi;
            if (eVar15 != null) {
                eVar15.ex();
                return;
            }
            return;
        }
        if (!view.equals(this.qf) || (eVar = this.qi) == null) {
            return;
        }
        eVar.ey();
    }

    @Override // com.kwad.sdk.widget.e
    public final void a(View view) {
        d(view, true);
    }

    @Override // com.kwad.sdk.widget.e
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.eE(this.mAdTemplate)) {
            d(view, false);
        }
    }

    public static class a {
        private boolean qm = false;
        private boolean qn = false;
        private int qo = 0;
        private boolean qp = true;

        public final void w(boolean z) {
            this.qm = z;
        }

        public final void x(boolean z) {
            this.qn = z;
        }

        public final int fp() {
            return this.qo;
        }

        public final void R(int i) {
            this.qo = i;
        }

        public final boolean fq() {
            return this.qp;
        }

        public final void y(boolean z) {
            this.qp = z;
        }
    }
}
