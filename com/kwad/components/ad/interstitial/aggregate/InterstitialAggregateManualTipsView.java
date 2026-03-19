package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.kwad.components.ad.interstitial.h.c;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p.m;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class InterstitialAggregateManualTipsView extends LinearLayout implements View.OnClickListener {
    private AdTemplate mAdTemplate;
    private final Context mContext;
    private TransViewPager mT;
    private int mZ;
    private ImageView nf;
    private ImageView ng;
    private ImageView nh;
    private int ni;
    private final ViewPager.OnPageChangeListener nj;

    public InterstitialAggregateManualTipsView(Context context) {
        this(context, null);
    }

    public InterstitialAggregateManualTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InterstitialAggregateManualTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nj = new ViewPager.SimpleOnPageChangeListener() { // from class: com.kwad.components.ad.interstitial.aggregate.InterstitialAggregateManualTipsView.1
            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int i2) {
                InterstitialAggregateManualTipsView.this.ni = i2;
                if (InterstitialAggregateManualTipsView.this.ni == InterstitialAggregateManualTipsView.this.mZ - 1) {
                    InterstitialAggregateManualTipsView.this.nf.setAlpha(0.5f);
                    InterstitialAggregateManualTipsView.this.ng.setAlpha(0.5f);
                } else {
                    InterstitialAggregateManualTipsView.this.nf.setAlpha(1.0f);
                    InterstitialAggregateManualTipsView.this.ng.setAlpha(1.0f);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    private void initView() {
        m.inflate(this.mContext, R.layout.ksad_interstitial_aggregate_manual_tips, this);
        this.nf = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_cut);
        this.ng = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_refresh);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_interstitial_aggregate_convert);
        this.nh = imageView;
        com.kwad.sdk.c.a.a.a(this, this.nf, this.ng, imageView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVarJ;
        if (view.equals(this.nf)) {
            dI();
            com.kwad.sdk.core.adlog.c.r(this.mAdTemplate, 162);
        } else if (view.equals(this.ng)) {
            dI();
            com.kwad.sdk.core.adlog.c.r(this.mAdTemplate, 36);
        } else {
            if (!view.equals(this.nh) || (cVarJ = this.mT.J(this.ni)) == null) {
                return;
            }
            cVarJ.fh();
        }
    }

    private void dI() {
        int i = this.ni;
        if (i < this.mZ - 1) {
            this.mT.setCurrentItem(i + 1, true);
        }
    }
}
