package com.component.feed;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.by;
import com.component.feed.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ar extends RelativeLayout {
    public am a;
    private Context b;
    private AbstractData c;
    private ImageView d;
    private LinearLayout e;
    private RelativeLayout f;
    private ax g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private Boolean m;
    private float n;
    private AnimatorSet o;

    public ar(Context context) {
        super(context);
        this.n = 0.5614035f;
        this.b = context;
    }

    public ar(Context context, am amVar) {
        super(context);
        this.n = 0.5614035f;
        this.b = context;
        this.a = amVar;
    }

    public void a(AbstractData abstractData) {
        if (abstractData == null) {
            return;
        }
        this.c = abstractData;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        try {
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a() {
        if (this.c == null) {
            return;
        }
        if (this.d == null && !TextUtils.isEmpty(this.c.getImageUrl())) {
            this.d = new ImageView(getContext());
            this.d.setScaleType(ImageView.ScaleType.FIT_CENTER);
            addView(this.d, new FrameLayout.LayoutParams(-1, -1));
            com.baidu.mobads.container.util.d.d.a(this.b).b(this.d, this.c.getImageUrl());
        }
        if (this.e == null) {
            this.e = new LinearLayout(this.b);
            this.e.setOrientation(1);
            this.e.setBackgroundColor(Color.parseColor("#73000000"));
            addView(this.e, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.f == null) {
            this.f = new RelativeLayout(this.b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            addView(this.f, layoutParams);
            if (this.c.getMainPicHeight() > this.c.getMainPicWidth()) {
                this.m = true;
                this.n = 0.5614035f;
                if (this.c.getMainPicWidth() > 0) {
                    this.n = this.c.getMainPicWidth() / this.c.getMainPicHeight();
                }
                layoutParams.height = getHeight();
                layoutParams.width = (int) (getHeight() * this.n);
                b();
            } else {
                this.m = false;
                this.n = 1.78125f;
                if (this.c.getMainPicWidth() > 0) {
                    this.n = this.c.getMainPicWidth() / this.c.getMainPicHeight();
                }
                layoutParams.width = getWidth();
                layoutParams.height = (int) (getWidth() / this.n);
                c();
            }
            this.f.setLayoutParams(layoutParams);
        }
    }

    private void b() {
        if ((this.c instanceof com.baidu.mobads.container.nativecpu.a) && "video".equals(((com.baidu.mobads.container.nativecpu.a) this.c).getType())) {
            return;
        }
        float fE = e();
        int iRound = Math.round(0.3f * fE);
        int iRound2 = Math.round(0.22f * fE);
        int iRound3 = Math.round(0.138f * fE);
        int iRound4 = Math.round(0.08f * fE);
        int iRound5 = Math.round(0.069f * fE);
        int iRound6 = Math.round(0.055f * fE);
        int iRound7 = Math.round(0.048f * fE);
        int iRound8 = Math.round(0.0345f * fE);
        int iRound9 = Math.round(fE * 0.0137f);
        if (this.j == null) {
            this.j = new TextView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, iRound5);
            layoutParams.width = a(e() * 0.75f);
            layoutParams.addRule(13);
            this.j.setId(204);
            if (!TextUtils.isEmpty(this.c.getDesc())) {
                this.j.setText(this.c.getDesc());
            } else {
                this.j.setText(this.c.getTitle());
            }
            this.j.setTextColor(Color.parseColor("#E5E5E5"));
            this.j.setTextSize(0, iRound7);
            this.j.setGravity(17);
            this.f.addView(this.j, layoutParams);
        }
        if (this.h == null) {
            this.h = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iRound, iRound6);
            layoutParams2.bottomMargin = iRound8;
            layoutParams2.addRule(14);
            layoutParams2.addRule(2, this.j.getId());
            this.h.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.h.setId(203);
            com.component.b.a.a().a(this.h, "ic_stars");
            this.f.addView(this.h, layoutParams2);
        }
        if (this.i == null) {
            this.i = new TextView(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, iRound4);
            layoutParams3.width = a(e() * 0.67f);
            layoutParams3.bottomMargin = iRound5;
            layoutParams3.addRule(2, this.h.getId());
            layoutParams3.addRule(14);
            this.i.setId(202);
            if (!TextUtils.isEmpty(this.c.getBrandName())) {
                this.i.setText(this.c.getBrandName());
            } else {
                this.i.setText(this.c.getTitle());
            }
            this.i.setTextColor(-1);
            this.i.setTextSize(0, iRound6);
            this.i.setGravity(17);
            this.f.addView(this.i, layoutParams3);
        }
        if (this.g == null) {
            this.g = new ax.a(getContext()).a(ax.b.RoundRect).a();
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iRound2, iRound2);
            layoutParams4.addRule(14);
            layoutParams4.addRule(2, this.i.getId());
            layoutParams4.bottomMargin = iRound8;
            this.g.setId(201);
            this.f.addView(this.g, layoutParams4);
            if (!TextUtils.isEmpty(this.c.getIconUrl())) {
                com.baidu.mobads.container.util.d.d.a(this.b).b(this.g, this.c.getIconUrl());
            } else {
                com.component.b.a.a().a(this.g, "ic_fallback");
            }
        }
        if (this.k == null) {
            this.k = new TextView(getContext());
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, iRound3);
            layoutParams5.topMargin = iRound8;
            layoutParams5.width = (int) (e() * 0.5f);
            layoutParams5.addRule(3, this.j.getId());
            layoutParams5.addRule(14);
            this.k.setId(205);
            this.k.setLayoutParams(layoutParams5);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(iRound9);
            gradientDrawable.setColor(Color.parseColor("#3388ff"));
            if (com.baidu.mobads.container.util.x.a(this.b).a() < 16) {
                this.k.setBackgroundDrawable(gradientDrawable);
            } else {
                this.k.setBackground(gradientDrawable);
            }
            if (this.c.isDownloadApp()) {
                this.k.setText("立即下载");
            } else {
                this.k.setText("查看详情");
            }
            String actRefinedText = this.c.getActRefinedText();
            if (!TextUtils.isEmpty(actRefinedText)) {
                this.k.setText(actRefinedText);
            }
            this.k.setTextColor(-1);
            this.k.setTextSize(0, iRound7);
            this.k.setGravity(17);
            this.f.addView(this.k, layoutParams5);
            a(this.k, iRound9);
        }
        if (this.l == null) {
            this.l = new TextView(getContext());
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, iRound3);
            layoutParams6.topMargin = iRound6;
            layoutParams6.width = (int) (e() * 0.5f);
            layoutParams6.addRule(3, this.k.getId());
            layoutParams6.addRule(14);
            this.l.setId(206);
            this.l.setLayoutParams(layoutParams6);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(iRound9);
            gradientDrawable2.setShape(0);
            gradientDrawable2.setStroke(1, -1);
            if (com.baidu.mobads.container.util.x.a(this.b).a() < 16) {
                this.l.setBackgroundDrawable(gradientDrawable2);
            } else {
                this.l.setBackground(gradientDrawable2);
            }
            this.l.setText("点击重播");
            this.l.setTextColor(-1);
            this.l.setTextSize(0, iRound7);
            this.l.setGravity(17);
            this.l.setOnClickListener(new as(this));
            this.f.addView(this.l, layoutParams6);
        }
    }

    private void c() {
        if ((this.c instanceof com.baidu.mobads.container.nativecpu.a) && "video".equals(((com.baidu.mobads.container.nativecpu.a) this.c).getType())) {
            return;
        }
        float f = f();
        int iRound = Math.round(0.24f * f);
        int iRound2 = Math.round(0.15f * f);
        int iRound3 = Math.round(0.1f * f);
        int iRound4 = Math.round(0.07f * f);
        int iRound5 = Math.round(0.06f * f);
        int iRound6 = Math.round(0.05f * f);
        int iRound7 = Math.round(f * 0.02f);
        if (this.g == null) {
            this.g = new ax.a(getContext()).a(ax.b.RoundRect).a();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iRound, iRound);
            layoutParams.setMargins(0, iRound3, 0, iRound6);
            layoutParams.addRule(14);
            this.g.setId(101);
            this.f.addView(this.g, layoutParams);
            if (!TextUtils.isEmpty(this.c.getIconUrl())) {
                com.baidu.mobads.container.util.d.d.a(this.b).b(this.g, this.c.getIconUrl());
            } else {
                com.component.b.a.a().a(this.g, "ic_fallback");
            }
        }
        if (this.i == null) {
            this.i = new TextView(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, iRound3);
            layoutParams2.width = a(e() * 0.67f);
            if (this.g != null) {
                layoutParams2.addRule(3, this.g.getId());
            } else {
                layoutParams2.topMargin = iRound3;
            }
            layoutParams2.addRule(14);
            this.i.setId(102);
            if (!TextUtils.isEmpty(this.c.getBrandName())) {
                this.i.setText(this.c.getBrandName());
            } else {
                this.i.setText(this.c.getTitle());
            }
            this.i.setSingleLine();
            this.i.setEllipsize(TextUtils.TruncateAt.END);
            this.i.setTextColor(-1);
            this.i.setTextSize(0, iRound4);
            this.i.setGravity(17);
            this.f.addView(this.i, layoutParams2);
        }
        if (this.j == null) {
            this.j = new TextView(getContext());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, iRound3);
            layoutParams3.topMargin = iRound6;
            layoutParams3.width = a(e() * 0.75f);
            layoutParams3.addRule(3, this.i.getId());
            layoutParams3.addRule(14);
            this.j.setId(103);
            if (!TextUtils.isEmpty(this.c.getDesc())) {
                this.j.setText(this.c.getDesc());
            } else {
                this.j.setText(this.c.getTitle());
            }
            this.j.setSingleLine();
            this.j.setEllipsize(TextUtils.TruncateAt.END);
            this.j.setTextColor(-1);
            this.j.setTextSize(0, iRound5);
            this.j.setGravity(17);
            this.f.addView(this.j, layoutParams3);
        }
        if (this.k == null) {
            this.k = new TextView(getContext());
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, iRound2);
            layoutParams4.topMargin = iRound6;
            layoutParams4.width = (int) (e() * 0.5f);
            layoutParams4.addRule(3, this.j.getId());
            layoutParams4.addRule(14);
            this.k.setId(104);
            this.k.setLayoutParams(layoutParams4);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(iRound7);
            gradientDrawable.setColor(Color.parseColor("#3388ff"));
            if (com.baidu.mobads.container.util.x.a(this.b).a() < 16) {
                this.k.setBackgroundDrawable(gradientDrawable);
            } else {
                this.k.setBackground(gradientDrawable);
            }
            if (this.c.isDownloadApp()) {
                this.k.setText("立即下载");
            } else {
                this.k.setText("查看详情");
            }
            String actRefinedText = this.c.getActRefinedText();
            if (!TextUtils.isEmpty(actRefinedText)) {
                this.k.setText(actRefinedText);
            }
            this.k.setTextColor(-1);
            this.k.setTextSize(0, iRound5);
            this.k.setGravity(17);
            this.f.addView(this.k, layoutParams4);
            a(this.k, iRound7);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    private void a(View view, int i) {
        int[] btnStyleColors;
        com.baidu.mobads.container.adrequest.t adContainerContext;
        int btnStyleType = 0;
        if (!(this.c instanceof com.baidu.mobads.container.a.d)) {
            btnStyleColors = null;
        } else {
            try {
                btnStyleType = ((com.baidu.mobads.container.a.d) this.c).getBtnStyleType();
                btnStyleColors = ((com.baidu.mobads.container.a.d) this.c).getBtnStyleColors();
            } catch (Throwable th) {
                bq.a().a(th);
                btnStyleColors = null;
            }
        }
        this.o = com.baidu.mobads.container.util.animation.j.a(view, i, btnStyleType, btnStyleColors, a.EnumC0133a.BACKGROUND);
        com.baidu.mobads.container.k baseAdContainer = this.c.getBaseAdContainer();
        if (baseAdContainer != null && (adContainerContext = baseAdContainer.getAdContainerContext()) != null) {
            by.a(adContainerContext, this.c, (com.baidu.mobads.container.adrequest.j) null, 1);
        }
    }

    private void d() {
        com.baidu.mobads.container.util.h.a(new at(this));
    }

    private int a(float f) {
        if (this.b instanceof Activity) {
            return b((f * this.b.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return (int) (bv.a(this.b, f) * 0.94f);
    }

    private int b(float f) {
        float width;
        if (getHeight() <= 0) {
            width = 1.0f;
        } else if (this.m.booleanValue()) {
            width = getHeight() / ((Activity) this.b).getWindow().getDecorView().getHeight();
            if (width < 0.8d) {
                width *= 1.2f;
            }
        } else {
            width = getWidth() / ((Activity) this.b).getWindow().getDecorView().getWidth();
        }
        return (int) (f * width);
    }

    private int e() {
        if (this.n < 1.0f) {
            if (getWidth() > getHeight()) {
                return (int) (getHeight() * this.n);
            }
            return getWidth();
        }
        return getWidth();
    }

    private int f() {
        if (this.n > 1.0f) {
            if (getWidth() < getHeight()) {
                return (int) (getWidth() / this.n);
            }
            return getHeight();
        }
        return getHeight();
    }
}
