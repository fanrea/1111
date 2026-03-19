package com.bytedance.adsdk.ugeno.swiper.indicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.adsdk.ugeno.swiper.hc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class BaseIndicator extends LinearLayout {
    private int an;
    protected int b;
    private List<View> c;
    protected Context d;
    private boolean gb;
    private int h;
    protected int hc;
    private float mk;
    private String mq;
    private float tc;
    private int tt;
    private int u;

    public abstract Drawable hc(int i);

    public BaseIndicator(Context context) {
        super(context);
        this.u = SupportMenu.CATEGORY_MASK;
        this.an = -16776961;
        this.h = 5;
        this.hc = 40;
        this.b = 20;
        this.mq = "row";
        this.d = context;
        this.c = new ArrayList();
        setOrientation(0);
    }

    public void setIndicatorX(float f) {
        this.tc = f;
    }

    public void setIndicatorY(float f) {
        this.mk = f;
    }

    public void setIndicatorDirection(String str) {
        this.mq = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void setIndicatorWidth(int i) {
        this.hc = i;
    }

    public void setIndicatorHeight(int i) {
        this.b = i;
    }

    public void d(int i, int i2) {
        Iterator<View> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().setBackground(hc(this.an));
        }
        if (i < 0 || i >= this.c.size()) {
            i = 0;
        }
        if (this.c.size() > 0) {
            this.c.get(i).setBackground(hc(this.u));
            this.tt = i2;
        }
    }

    public int getSize() {
        return this.c.size();
    }

    public void setSelectedColor(int i) {
        this.u = i;
    }

    public void setLoop(boolean z) {
        this.gb = z;
    }

    public void setUnSelectedColor(int i) {
        this.an = i;
    }

    public void d(int i) {
        if (this instanceof DotIndicator) {
            this.b = this.hc;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hc, this.b);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.h;
            layoutParams.bottomMargin = this.h;
        } else {
            layoutParams.leftMargin = this.h;
            layoutParams.rightMargin = this.h;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.hc, this.b);
        if (getOrientation() == 1) {
            layoutParams2.topMargin = this.h;
            layoutParams2.bottomMargin = this.h;
        } else {
            layoutParams2.leftMargin = this.h;
            layoutParams2.rightMargin = this.h;
        }
        int iD = hc.d(this.gb, this.tt, this.c.size());
        int iD2 = hc.d(this.gb, i, this.c.size());
        if (this.c.size() == 0) {
            iD2 = 0;
        }
        if (!this.c.isEmpty() && hc.d(iD, this.c) && hc.d(iD2, this.c)) {
            this.c.get(iD).setBackground(hc(this.an));
            this.c.get(iD).setLayoutParams(layoutParams2);
            this.c.get(iD2).setBackground(hc(this.u));
            this.c.get(iD2).setLayoutParams(layoutParams);
            this.tt = i;
        }
    }

    public void d() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof DotIndicator) {
            this.b = this.hc;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hc, this.b);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.h;
            layoutParams.bottomMargin = this.h;
        } else {
            layoutParams.leftMargin = this.h;
            layoutParams.rightMargin = this.h;
        }
        addView(view, layoutParams);
        view.setBackground(hc(this.an));
        this.c.add(view);
    }
}
