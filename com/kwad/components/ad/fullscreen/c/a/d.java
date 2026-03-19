package com.kwad.components.ad.fullscreen.c.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView lZ;
    private TextView ma;
    private View mb = null;
    private com.kwad.components.ad.reward.e.e mc = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.fullscreen.c.a.d.1
        @Override // com.kwad.components.ad.reward.e.e
        public final void dv() {
            d.this.du();
        }
    };
    private o lv = new o() { // from class: com.kwad.components.ad.fullscreen.c.a.d.2
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            d.this.k(j2);
        }
    };

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lZ = (ImageView) findViewById(R.id.ksad_skip_icon);
        this.ma = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (!TextUtils.isEmpty(com.kwad.components.ad.fullscreen.a.b.de())) {
            this.ma.setText(com.kwad.components.ad.fullscreen.a.b.de());
            this.lZ.setVisibility(8);
            this.mb = this.ma;
        } else {
            if (com.kwad.components.ad.fullscreen.a.b.dd() == 0) {
                this.lZ.setImageResource(R.drawable.ksad_page_close);
            } else {
                this.lZ.setImageResource(R.drawable.ksad_video_skip_icon);
            }
            this.ma.setVisibility(8);
            this.mb = this.lZ;
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        dr();
    }

    private void dr() {
        this.vb.tu.a(this.lv);
        this.vb.tE.add(this.mc);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.tE.remove(this.mc);
        this.vb.tu.b(this.lv);
    }

    public final void k(long j) {
        if (j >= com.kwad.sdk.core.response.b.a.an(com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate))) {
            du();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du() {
        if (this.mb.getVisibility() == 0) {
            return;
        }
        this.mb.setAlpha(0.0f);
        this.mb.setVisibility(0);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                d.this.mb.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.start();
        this.mb.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.mb) {
            com.kwad.components.ad.reward.presenter.f.a(this.vb, false);
        }
    }
}
