package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AppScoreView extends LinearLayout {
    private ImageView On;
    private ImageView Oo;

    public AppScoreView(Context context) {
        this(context, null);
    }

    public AppScoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppScoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.layout.ksad_app_score, this);
        this.On = (ImageView) findViewById(R.id.ksad_score_fourth);
        this.Oo = (ImageView) findViewById(R.id.ksad_score_fifth);
    }

    public void setScore(float f) {
        double d = f;
        if (d > 4.5d) {
            this.On.setImageResource(R.drawable.ksad_star_checked);
            this.Oo.setImageResource(R.drawable.ksad_star_checked);
            return;
        }
        if (d > 4.0d) {
            this.On.setImageResource(R.drawable.ksad_star_checked);
            this.Oo.setImageResource(R.drawable.ksad_star_half);
            return;
        }
        if (d > 3.5d) {
            this.On.setImageResource(R.drawable.ksad_star_checked);
            this.Oo.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d > 3.0d) {
            this.On.setImageResource(R.drawable.ksad_star_half);
            this.Oo.setImageResource(R.drawable.ksad_star_unchecked);
        } else if (d == 3.0d) {
            this.On.setImageResource(R.drawable.ksad_star_unchecked);
            this.Oo.setImageResource(R.drawable.ksad_star_unchecked);
        }
    }
}
