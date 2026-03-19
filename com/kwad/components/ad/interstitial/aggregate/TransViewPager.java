package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.components.ad.interstitial.h.c;
import com.kwad.sdk.widget.g;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TransViewPager extends g {
    private Map<Integer, c> map;
    private float nl;
    private int nm;

    public TransViewPager(Context context) {
        this(context, null);
    }

    public TransViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.map = new HashMap();
        this.nm = 0;
    }

    @Override // androidx.viewpager.widget.ViewPager
    protected void onPageScrolled(int i, float f, int i2) {
        a(J(i), J(i + 1), f);
        super.onPageScrolled(i, f, i2);
    }

    private void a(View view, View view2, float f) {
        if (this.nm == 0 && f != 0.0f) {
            float f2 = this.nl;
            if (f2 != 0.0f) {
                if (f > f2) {
                    this.nm = 1;
                } else {
                    this.nm = 2;
                }
            }
        }
        if (this.nm == 1 && view2 != null) {
            if (f <= 0.5d && f > 0.0f) {
                view2.setTranslationX(240.0f * f);
            } else {
                view2.setTranslationX((1.0f - f) * 240.0f);
            }
        }
        if (this.nm == 2 && view != null) {
            if (f <= 0.5d && f >= 0.0f) {
                view.setTranslationX((-240.0f) * f);
            } else {
                view.setTranslationX((1.0f - f) * (-240.0f));
            }
        }
        this.nl = f;
        if (f == 0.0f) {
            this.nm = 0;
        }
    }

    public final c J(int i) {
        return this.map.get(Integer.valueOf(i));
    }

    public final void a(int i, c cVar) {
        this.map.put(Integer.valueOf(i), cVar);
    }
}
