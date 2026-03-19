package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.presenter.f;
import com.kwad.components.core.video.o;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener {
    private ImageView Ax;
    private TextView Ay;
    private AdInfo mAdInfo;
    private boolean Az = false;
    private View AA = null;
    private long AB = -1;
    private final o lv = new o() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.1
        @Override // com.kwad.components.core.video.o, com.kwad.components.core.video.k
        public final void onMediaPlayProgress(long j, long j2) {
            if (c.this.AB >= 0) {
                if (j2 > Math.min(Math.min(c.this.AB, com.kwad.sdk.core.response.b.a.ai(c.this.mAdInfo)), j)) {
                    c.this.jC();
                }
            }
        }
    };
    private final com.kwad.components.ad.reward.e.e mc = new com.kwad.components.ad.reward.e.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.2
        @Override // com.kwad.components.ad.reward.e.e
        public final void dv() {
            c.a(c.this, true);
            c.this.jC();
        }
    };

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.Az = true;
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Ax = (ImageView) findViewById(R.id.ksad_detail_close_btn);
        this.Ay = (TextView) findViewById(R.id.ksad_top_toolbar_close_tip);
        if (!TextUtils.isEmpty(com.kwad.components.ad.reward.a.b.hE())) {
            this.Ay.setText(com.kwad.components.ad.reward.a.b.hE());
            this.AA = this.Ay;
        } else {
            if (com.kwad.components.ad.reward.a.b.hD() == 0) {
                this.Ax.setImageResource(R.drawable.ksad_page_close);
            } else {
                this.Ax.setImageResource(R.drawable.ksad_video_skip_icon);
            }
            this.AA = this.Ax;
        }
        this.AA.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        dr();
    }

    private void dr() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eP(this.mAdTemplate);
        this.vb.tu.a(this.lv);
        this.vb.tE.add(this.mc);
        long jAh = com.kwad.sdk.core.response.b.a.ah(this.mAdInfo);
        this.AB = jAh;
        if (jAh == 0) {
            this.AA.setVisibility(0);
        } else {
            this.AA.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vb.tu.b(this.lv);
        this.vb.tE.remove(this.mc);
        this.AA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jC() {
        if (this.AA.getVisibility() == 0) {
            return;
        }
        this.AA.setAlpha(0.0f);
        this.AA.setVisibility(0);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                c.this.AA.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.start();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.AA) {
            f.a(this.vb, this.Az);
        }
    }
}
