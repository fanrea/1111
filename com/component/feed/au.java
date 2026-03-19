package com.component.feed;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.ci;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class au extends a implements ci.b {
    private ImageView a;

    public au(Context context) {
        super(context);
    }

    @Override // com.component.feed.a
    public void c(Object obj) {
        super.c(obj);
        this.r = new com.baidu.mobads.container.a.d(obj);
        t();
        AbstractData.a materialType = this.r.getMaterialType();
        if (materialType == AbstractData.a.NORMAL) {
            if (this.a != null) {
                this.a.setVisibility(8);
            }
            d(this.r);
            if (this.r != null && !this.z) {
                this.z = true;
                this.r.recordImpression(this);
                return;
            }
            return;
        }
        if (materialType == AbstractData.a.VIDEO) {
            e(obj);
            a();
            F();
            k();
        }
    }

    @Override // com.component.feed.a
    protected void b() {
        if (this.a != null) {
            this.a.setVisibility(8);
        }
    }

    @Override // com.component.feed.a
    protected void c() {
    }

    @Override // com.component.feed.a
    protected void d() {
        if (this.a != null) {
            this.a.setVisibility(8);
        }
    }

    @Override // com.component.feed.a
    protected void e() {
    }

    @Override // com.component.feed.a
    protected void f() {
        E();
    }

    @Override // com.component.feed.a
    protected void p() {
    }

    private void a() {
        if (this.a == null) {
            this.a = new ImageView(getContext());
            this.a.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(120, 120);
            layoutParams.addRule(13);
            addView(this.a, layoutParams);
        }
        com.component.b.a.a().a(this.a, "ic_video_play");
        this.a.setVisibility(0);
        this.a.setOnClickListener(new av(this));
    }

    @Override // com.component.feed.a
    protected void a(Object obj) {
        if (this.r == null) {
            this.r = new com.baidu.mobads.container.a.d(obj);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ci.a().a(this.x, this);
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
