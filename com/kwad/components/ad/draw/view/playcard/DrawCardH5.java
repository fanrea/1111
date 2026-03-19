package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.u.r;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    private ValueAnimator hX;
    private a hZ;
    private ImageView ia;
    private TextView ib;
    private TextView ic;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private int mHeight;
    private KsLogoView mLogoView;

    public interface a {
        void bf();

        void bg();
    }

    public DrawCardH5(Context context) {
        super(context);
        B(context);
    }

    public DrawCardH5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawCardH5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }

    private void B(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.ia = (ImageView) findViewById(R.id.ksad_card_close);
        this.ib = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.ic = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    public final void a(AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEP = e.eP(adTemplate);
        this.hZ = aVar;
        this.ib.setText(com.kwad.sdk.core.response.b.a.aw(adInfoEP));
        this.ic.setText(com.kwad.sdk.core.response.b.a.aH(adInfoEP));
        this.ia.setOnClickListener(this);
        this.ic.setOnClickListener(this);
        this.mLogoView.aQ(adTemplate);
        setOnClickListener(this);
        this.ib.measure(View.MeasureSpec.makeMeasureSpec((com.kwad.sdk.utils.m.getScreenWidth(this.mContext) - (com.kwad.sdk.c.a.a.a(this.mContext, 16.0f) * 2)) - (com.kwad.sdk.c.a.a.a(this.mContext, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mHeight = com.kwad.sdk.c.a.a.a(this.mContext, 100.0f) + this.ib.getMeasuredHeight();
    }

    public final void release() {
        bq();
    }

    public final void bY() {
        e(0, this.mHeight);
    }

    private void ca() {
        e(this.mHeight, 0);
    }

    private void e(int i, int i2) {
        bq();
        ValueAnimator valueAnimatorB = r.b(this, i, i2);
        this.hX = valueAnimatorB;
        valueAnimatorB.setInterpolator(new DecelerateInterpolator(2.0f));
        this.hX.setDuration(300L);
        this.hX.start();
    }

    private void bq() {
        ValueAnimator valueAnimator = this.hX;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.hX.cancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ia) {
            ca();
            a aVar = this.hZ;
            if (aVar != null) {
                aVar.bf();
                return;
            }
            return;
        }
        com.kwad.components.core.e.d.a.a(new a.C0469a(getContext()).aC(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardH5.1
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawCardH5.this.hZ != null) {
                    DrawCardH5.this.hZ.bg();
                }
            }
        }));
    }
}
