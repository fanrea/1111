package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class SplashPlayDefaultInfoView extends FrameLayout {
    private KSCornerImageView KQ;
    private ImageView KR;
    private TextView KS;
    private TextView hg;
    private TextView mf;

    public SplashPlayDefaultInfoView(Context context) {
        super(context);
        ni();
    }

    public SplashPlayDefaultInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ni();
    }

    public SplashPlayDefaultInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ni();
    }

    public SplashPlayDefaultInfoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        ni();
    }

    private void ni() {
        inflate(getContext(), R.layout.ksad_play_card_default_info, this);
        this.KQ = (KSCornerImageView) findViewById(R.id.ksad_splash_default_icon);
        this.mf = (TextView) findViewById(R.id.ksad_splash_default_title);
        this.KR = (ImageView) findViewById(R.id.ksad_splash_default_img);
        this.hg = (TextView) findViewById(R.id.ksad_splash_default_desc);
        this.KS = (TextView) findViewById(R.id.ksad_splash_default_tips);
    }

    public final void a(AdTemplate adTemplate, float f) {
        c cVarNg;
        AdInfo adInfoEP = e.eP(adTemplate);
        if (com.kwad.sdk.core.response.b.a.dB(adInfoEP)) {
            cVarNg = c.d(f);
        } else {
            cVarNg = c.ng();
        }
        a(cVarNg);
        this.KQ.setRadius(com.kwad.sdk.c.a.a.a(getContext(), cVarNg.nh()));
        KSImageLoader.loadImage(this.KQ, com.kwad.sdk.core.response.b.a.cC(adInfoEP), adTemplate);
        this.mf.setText(com.kwad.sdk.core.response.b.a.cz(adInfoEP));
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aw(adInfoEP))) {
            this.hg.setVisibility(8);
        } else {
            this.hg.setText(com.kwad.sdk.core.response.b.a.aw(adInfoEP));
        }
    }

    private void a(c cVar) {
        ak.a(this, cVar.W(getContext()));
        ak.a(this.KQ, cVar.X(getContext()));
        ak.a(this.mf, cVar.Y(getContext()));
        ak.a(this.KR, cVar.Z(getContext()));
        ak.a(this.hg, cVar.aa(getContext()));
        ak.a(this.KS, cVar.ab(getContext()));
        this.mf.setTextSize(0, cVar.ac(getContext()));
        this.hg.setTextSize(0, cVar.ad(getContext()));
        this.KS.setTextSize(0, cVar.ae(getContext()));
    }
}
