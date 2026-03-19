package com.kwad.components.ct.tube.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.kwad.components.ct.refreshview.d;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TubeRefreshView extends FrameLayout implements d {
    private LottieAnimationView anA;

    @Override // com.kwad.components.ct.refreshview.d
    public final int GV() {
        return 0;
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final void x(float f) {
    }

    public TubeRefreshView(Context context) {
        super(context);
    }

    public TubeRefreshView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TubeRefreshView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.ksad_tube_refresh_lottie);
        this.anA = lottieAnimationView;
        lottieAnimationView.setVisibility(0);
        com.kwad.components.ct.d.a.Jd().b(this.anA, true);
        this.anA.setRepeatMode(1);
        this.anA.setRepeatCount(-1);
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final void reset() {
        this.anA.Qa();
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final void GT() {
        if (this.anA.isAnimating()) {
            return;
        }
        this.anA.PZ();
    }

    @Override // com.kwad.components.ct.refreshview.d
    public final void GU() {
        this.anA.Qa();
    }
}
