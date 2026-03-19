package com.kwad.components.ct.profile.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kwad.components.ct.d.a;
import com.kwad.components.ct.widget.KSPageLoadingView;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ao;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class KSProfilePageLoadingView extends FrameLayout implements View.OnClickListener {
    private TextView aRY;
    private TextView aRZ;
    private LottieAnimationView aSa;
    private KSPageLoadingView.a asf;

    public KSProfilePageLoadingView(Context context) {
        this(context, null);
    }

    public KSProfilePageLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KSProfilePageLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Jq();
    }

    private void Jq() {
        inflate(getContext(), R.layout.ksad_profile_page_loading, this);
        TextView textView = (TextView) findViewById(R.id.ksad_error_title);
        this.aRY = textView;
        textView.setOnClickListener(this);
        this.aRZ = (TextView) findViewById(R.id.ksad_error_sub_title);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_loading_anim);
        this.aSa = lottieAnimationView;
        lottieAnimationView.setRepeatMode(1);
        this.aSa.setRepeatCount(-1);
        a.Jd().b(this.aSa, false);
        setOnClickListener(this);
    }

    public void setRetryClickListener(KSPageLoadingView.a aVar) {
        this.asf = aVar;
    }

    public final void hide() {
        setVisibility(8);
    }

    public final void Fi() {
        Js();
        this.aSa.setVisibility(0);
        if (!this.aSa.isAnimating()) {
            this.aSa.PZ();
        }
        setVisibility(0);
    }

    private void Jr() {
        if (this.aSa.isAnimating()) {
            this.aSa.Qa();
        }
        this.aSa.setVisibility(8);
    }

    private void Js() {
        this.aRY.setVisibility(8);
        this.aRZ.setVisibility(8);
    }

    public final void Jt() {
        Jr();
        this.aRY.setText(ae.dv(getContext()));
        this.aRY.setVisibility(0);
        this.aRZ.setText(ae.dw(getContext()));
        this.aRZ.setVisibility(0);
        ac.dm(getContext());
        setVisibility(0);
    }

    public final void Ju() {
        Jr();
        this.aRY.setText(ae.dy(getContext()));
        this.aRY.setVisibility(0);
        this.aRZ.setText(ae.dz(getContext()));
        this.aRZ.setVisibility(0);
        ac.dn(getContext());
        setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ao.isNetworkConnected(getContext())) {
            KSPageLoadingView.a aVar = this.asf;
            if (aVar != null) {
                aVar.zP();
                return;
            }
            return;
        }
        Jt();
    }
}
