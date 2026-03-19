package com.kwad.components.ct.tube.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.TextView;
import com.kwad.components.ct.f.b;
import com.kwad.components.ct.f.d;
import com.kwad.components.ct.f.f;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a extends KSFrameLayout implements b {
    private f<a> aDL;
    private boolean aZB;
    private String aZC;
    private TextView aZD;
    private LottieAnimationView ayp;

    public a(Context context, boolean z, String str) {
        super(context);
        this.aZB = z;
        this.aZC = str;
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.ksad_content_page_load_more, this);
        this.aZD = (TextView) findViewById(R.id.ksad_loading_tip);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_loading_lottie);
        this.ayp = lottieAnimationView;
        lottieAnimationView.setRepeatMode(1);
        this.ayp.setRepeatCount(-1);
        Ke();
    }

    @Override // android.view.View
    protected final void onFinishInflate() {
        super.onFinishInflate();
        this.aDL = new f<>(this);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        d.Kb().a(this.aDL);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        d.Kb().b(this.aDL);
        super.af();
    }

    public final void Cu() {
        if (!this.ayp.isAnimating()) {
            this.ayp.PZ();
        }
        this.ayp.setVisibility(0);
        this.aZD.setVisibility(8);
    }

    private void Ci() {
        if (this.ayp.isAnimating()) {
            this.ayp.Qa();
        }
        this.ayp.setVisibility(8);
    }

    public final void ce(boolean z) {
        String strDr;
        Ci();
        if (!z && !e.isShowTips() && TextUtils.isEmpty(this.aZC)) {
            this.aZD.setVisibility(8);
            return;
        }
        TextView textView = this.aZD;
        if (z) {
            strDr = getContext().getString(R.string.ksad_page_load_more_tip);
        } else if (TextUtils.isEmpty(this.aZC)) {
            strDr = ae.dr(getContext());
        } else {
            strDr = this.aZC;
        }
        textView.setText(strDr);
        this.aZD.setVisibility(0);
    }

    @Override // com.kwad.components.ct.f.b
    public final void cg(int i) {
        this.aZB = d.Kb().wR() != 1;
        Ke();
    }

    private void Ke() {
        int i;
        TextView textView = this.aZD;
        Resources resources = getContext().getResources();
        if (this.aZB) {
            i = R.color.ksad_hale_page_loading_error_title_light_color;
        } else {
            i = R.color.ksad_hale_page_loading_error_title_dark_color;
        }
        textView.setTextColor(resources.getColor(i));
        com.kwad.components.ct.d.a.Jd().b(this.ayp, this.aZB);
    }
}
