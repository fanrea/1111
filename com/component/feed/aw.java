package com.component.feed;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.ci;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class aw extends a implements ci.b {
    public View T;
    public ImageView a;

    public aw(Context context) {
        super(context);
    }

    @Override // com.component.feed.a
    public void c(Object obj) {
        super.c(obj);
        this.r = new com.baidu.mobads.container.a.d(obj);
        t();
        AbstractData.a materialType = this.r.getMaterialType();
        if (materialType == AbstractData.a.NORMAL) {
            g(obj);
            d(this.r);
            if (this.r != null && !this.z) {
                this.z = true;
                this.r.recordImpression(this);
                return;
            }
            return;
        }
        if (materialType == AbstractData.a.VIDEO) {
            F();
            e(obj);
            h();
            G();
            H();
            k();
        }
    }

    @Override // com.component.feed.a
    protected void b() {
        g(this.r);
    }

    @Override // com.component.feed.a
    protected void c() {
        if (this.P) {
            h(this.r);
        }
    }

    @Override // com.component.feed.a
    protected void d() {
        g(this.r);
        if (this.T != null) {
            this.T.setVisibility(4);
        }
    }

    @Override // com.component.feed.a
    protected void e() {
    }

    @Override // com.component.feed.a
    protected void f() {
        E();
        q();
    }

    private void h() {
        if (this.a == null) {
            this.a = new ImageView(getContext());
            this.a.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(120, 120);
            layoutParams.addRule(13);
            addView(this.a, layoutParams);
        }
        if (this.T == null) {
            this.T = new ProgressBar(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.T.setLayoutParams(layoutParams2);
            this.T.setVisibility(4);
            addView(this.T);
        }
        com.component.b.a.a().a(this.a, "ic_video_play");
        this.a.setVisibility(0);
        if (this.T != null) {
            this.T.setVisibility(4);
        }
    }

    @Override // com.component.feed.a
    protected void a(Object obj) {
        if (this.r == null) {
            this.r = new com.baidu.mobads.container.a.d(obj);
        }
    }

    @Override // com.component.feed.a
    public void g(Object obj) {
        super.g(obj);
        if (this.a != null) {
            this.a.setVisibility(8);
        }
    }

    @Override // com.component.feed.a
    public void h(Object obj) {
        super.h(obj);
        if (this.a != null && (obj instanceof AbstractData) && ((AbstractData) obj).getMaterialType() == AbstractData.a.VIDEO) {
            this.a.setVisibility(0);
        }
    }

    @Override // com.component.feed.a
    public void b(Object obj) {
        super.b(obj);
        h(obj);
    }

    public void a() {
        B();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("window_focus", true);
        } catch (Throwable th) {
        }
        ci.a().a(this.x, this, jSONObject);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ci.a().b(this.x);
    }

    @Override // com.baidu.mobads.container.util.ci.b
    public void a(View view, boolean z) {
        if (z) {
            if (hasWindowFocus() && !this.P && this.Q) {
                n();
                return;
            }
            return;
        }
        m();
    }
}
