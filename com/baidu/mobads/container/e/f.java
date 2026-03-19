package com.baidu.mobads.container.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.nativecpu.AbstractData;
import com.baidu.mobads.container.util.ce;
import com.sigmob.sdk.base.mta.PointCategory;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f extends com.component.feed.a {
    private ImageView T;
    private Bitmap U;
    private ImageView V;
    private boolean W;
    e a;
    private boolean aa;
    private boolean ab;
    private List<ImageView> ac;
    private boolean ad;

    public f(Context context) {
        super(context);
        this.W = false;
        this.aa = true;
        this.ad = false;
    }

    public void a(AbstractData abstractData) {
        try {
            d(true);
            c(-7829368);
            d(Color.parseColor("#4A8AFE"));
            e(2);
            c(abstractData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.r = abstractData;
        b(this.r);
        I();
        if (this.x != null) {
            this.x.a(D());
        }
        this.x.setOnClickListener(new g(this));
        if (this.ad) {
            try {
                if (this.x != null && this.x.getBackground() != null) {
                    this.x.getBackground().setAlpha(0);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void I() {
        this.V = new ImageView(this.y);
        com.baidu.mobads.container.util.d.d.a(this.y).a(this.V, this.r.getImageUrl());
        this.V.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.V.setVisibility(8);
    }

    public void a() {
        if (this.x != null) {
            try {
                this.D = false;
                List<String> thirdTrackers = this.r.getThirdTrackers(PointCategory.VCLOSE);
                int i = this.r.isAutoPlay() ? 0 : 1;
                double dG = this.x.g();
                Double.isNaN(dG);
                ce.a(dG / 1000.0d, this.f757K, thirdTrackers, i, 6);
                f();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.x.e();
        }
    }

    public void a(e eVar) {
        this.a = eVar;
    }

    @Override // com.component.feed.a
    protected void b() {
        J();
        this.a.a();
    }

    @Override // com.component.feed.a
    protected void c() {
        K();
        this.a.b();
    }

    @Override // com.component.feed.a
    protected void d() {
        J();
        if (TextUtils.isEmpty(this.r.getImageUrl()) && this.U == null) {
            new Handler().postDelayed(new h(this), 50L);
        }
        this.a.c();
    }

    @Override // com.component.feed.a
    protected void e() {
        this.a.d();
    }

    @Override // com.component.feed.a
    protected void f() {
        J();
        u();
        if (this.V.getParent() != null) {
            ((ViewGroup) this.V.getParent()).removeView(this.V);
        }
        this.V.setVisibility(0);
        this.E.addView(this.V, new ViewGroup.LayoutParams(-1, -1));
        B();
        new Handler().postDelayed(new j(this), 5000L);
        this.a.e();
    }

    @Override // com.component.feed.a
    protected void a(Object obj) {
    }

    public void a(int i) {
        this.R = i;
    }

    @Override // com.component.feed.a
    public void b(Object obj) {
        super.b(obj);
        this.T = new ImageView(this.y);
        com.component.b.a.a().a(this.T, "ic_video_play");
        this.T.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.baidu.mobads.container.util.ab.a(this.y, 36.0f), com.baidu.mobads.container.util.ab.a(this.y, 36.0f));
        layoutParams.addRule(13);
        addView(this.T, layoutParams);
        K();
    }

    private void J() {
        if (this.T != null) {
            this.T.setVisibility(8);
        }
    }

    public void a(List<ImageView> list) {
        this.ac = list;
    }

    private void K() {
        if (this.T != null) {
            this.T.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.V != null && this.V.getVisibility() == 0) {
            if (z && this.W) {
                this.W = false;
                L();
                return;
            }
            return;
        }
        if (!z) {
            if (this.x != null && this.x.a != null) {
                if (this.x.f()) {
                    this.aa = false;
                    m();
                    return;
                } else {
                    this.aa = true;
                    return;
                }
            }
            this.aa = false;
            return;
        }
        if (!this.aa) {
            n();
        }
    }

    @Override // com.component.feed.a
    public boolean g() {
        return this.ab;
    }

    @Override // com.component.feed.a
    public void a(boolean z) {
        this.ab = z;
        super.a(this.ab);
    }

    @Override // com.component.feed.a
    public void b(boolean z) {
        this.ab = z;
        super.b(this.ab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        try {
            a(this.r);
        } catch (Exception e) {
            e.printStackTrace();
        }
        l();
        ce.a(0.0d, 0.0d, this.r.getThirdTrackers("vrepeatedplay"), !this.r.isAutoPlay() ? 1 : 0, 0);
    }

    public View h() {
        return this.V;
    }

    public void c(boolean z) {
        this.ad = z;
    }
}
