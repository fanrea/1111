package com.kwad.components.ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TailFrameBarH5View extends LinearLayout {
    protected TextView is;
    protected TextView it;
    protected ValueAnimator nA;

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    public TailFrameBarH5View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void f(Context context, int i) {
        m.inflate(context, i, this);
        this.is = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.it = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    public final void g(boolean z, boolean z2) {
        int i;
        if (!z) {
            i = R.layout.ksad_video_tf_bar_h5_landscape;
        } else if (z2) {
            i = R.layout.ksad_video_tf_bar_h5_portrait_vertical;
        } else {
            i = R.layout.ksad_video_tf_bar_h5_portrait_horizontal;
        }
        f(getContext(), i);
    }

    public final void k(AdTemplate adTemplate) {
        AdInfo adInfoEP = e.eP(adTemplate);
        this.is.setText(com.kwad.sdk.core.response.b.a.aw(adInfoEP));
        this.it.setText(com.kwad.sdk.core.response.b.a.aH(adInfoEP));
        ly();
    }

    public TextView getH5OpenBtn() {
        return this.it;
    }

    private void ly() {
        if (this.nA != null) {
            lz();
            this.nA.start();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.nA = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1200L);
        this.nA.setRepeatCount(-1);
        this.nA.setRepeatMode(1);
        this.nA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.it.setScaleY(fFloatValue);
                TailFrameBarH5View.this.it.setScaleX(fFloatValue);
            }
        });
        this.nA.start();
    }

    public final void lz() {
        ValueAnimator valueAnimator = this.nA;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.nA.cancel();
        this.nA.end();
    }
}
