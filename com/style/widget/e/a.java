package com.style.widget.e;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.ci;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends com.component.feed.a implements ci.b {
    private static final String aa = "BaseVideoView";
    private static final int ac = 16;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public View a;
    private ImageView ab;
    private int ad;
    private JSONObject ae;

    public a(Context context) {
        super(context);
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.ad = -5;
        setBackgroundColor(Color.parseColor("#000000"));
    }

    public void a(AbstractData abstractData) {
        try {
            this.ad = -5;
            c(abstractData);
            this.r = abstractData;
            v();
            b(abstractData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        t();
        a(this.r.getMute());
        L();
        I();
        setOnClickListener(new b(this));
    }

    protected void b(View view, boolean z) {
        if (this.r != null) {
            this.r.handleClick(view, z);
        }
    }

    public void c(boolean z) {
        this.T = z;
    }

    public void h(boolean z) {
        this.U = z;
    }

    public void i(boolean z) {
        this.V = z;
    }

    public void a() {
        if (this.ae == null) {
            try {
                this.ae = new JSONObject();
                this.ae.put("window_focus", true);
                this.ae.put("visible_percent", 50);
            } catch (Throwable th) {
                this.w.a(th);
            }
        }
    }

    private void L() {
        if (this.r == null) {
            return;
        }
        if (this.ab == null) {
            this.ab = new ImageView(getContext());
            com.component.b.a.a().a(this.ab, "ic_video_play");
            this.ab.setScaleType(ImageView.ScaleType.FIT_XY);
            this.ab.setId(16);
            this.ab.setOnClickListener(new c(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(120, 120);
            layoutParams.addRule(13);
            addView(this.ab, layoutParams);
        }
        if (this.a == null) {
            this.a = new ProgressBar(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.a.setLayoutParams(layoutParams2);
            this.a.setVisibility(4);
            addView(this.a);
        }
    }

    public void h() {
        if (M()) {
            h(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i) {
        this.ad = i;
        if (!this.V) {
            d.a().b(this);
        }
        l();
    }

    private boolean M() {
        boolean zIsAutoPlay = this.r.isAutoPlay();
        boolean zIsNonWifiAutoPlay = this.r.isNonWifiAutoPlay();
        Boolean boolI = com.baidu.mobads.container.util.e.a.i(getContext().getApplicationContext());
        return (zIsAutoPlay && boolI.booleanValue()) || (zIsNonWifiAutoPlay && !boolI.booleanValue());
    }

    @Override // com.component.feed.a
    protected void a(Object obj) {
    }

    public void I() {
        u();
        w();
        B();
        if (this.ab != null) {
            this.ab.setVisibility(0);
        }
        if (this.a != null) {
            this.a.setVisibility(4);
        }
    }

    @Override // com.component.feed.a
    protected void b() {
        if (this.ab != null) {
            this.ab.setVisibility(8);
        }
        if (this.a != null) {
            this.a.setVisibility(8);
        }
    }

    @Override // com.component.feed.a
    protected void c() {
    }

    @Override // com.component.feed.a
    protected void d() {
        if (this.ab != null) {
            this.ab.setVisibility(8);
        }
        if (this.a != null) {
            this.a.setVisibility(8);
        }
    }

    @Override // com.component.feed.a
    protected void e() {
    }

    @Override // com.component.feed.a
    protected void f() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h();
        d.a().a(this);
        ci.a().a(this.x, this, this.ae);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d.a().c(this);
        ci.a().b(this.x);
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void J() {
        if (this.x != null) {
            u();
            this.x.e();
        }
        d.a().c(this);
        ci.a().b(this.x);
    }

    public void a(int i) {
        if (i == 0) {
            h();
        }
    }

    public void K() {
        if (!a((View) this, 50)) {
            m();
        }
    }

    private boolean a(View view, int i) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null) {
            return false;
        }
        if (!view.getGlobalVisibleRect(new Rect())) {
            return false;
        }
        long height = view.getHeight() * view.getWidth();
        return height > 0 && (r1.height() * r1.width()) * 100 >= ((long) i) * height;
    }

    public void j(boolean z) {
        f(z);
    }

    public void k(boolean z) {
        this.W = z;
    }

    @Override // com.baidu.mobads.container.util.ci.b
    public void a(View view, boolean z) {
        if (this.ad == -3) {
            return;
        }
        if (z) {
            if (hasWindowFocus() && !this.P && this.Q) {
                g(2);
                return;
            }
            return;
        }
        f(1);
    }

    public void f(int i) {
        m();
        this.ad = i;
    }

    public void g(int i) {
        n();
        this.ad = i;
    }

    private void b(AbstractData abstractData) {
        if (abstractData != null && abstractData.getMaterialType() == AbstractData.a.VIDEO && this.x != null) {
            this.x.a(D());
        }
    }
}
