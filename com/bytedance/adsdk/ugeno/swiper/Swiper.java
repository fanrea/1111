package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.hc.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Swiper extends BaseSwiper<b> {
    private com.bytedance.adsdk.ugeno.b c;

    public Swiper(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View h(int i) {
        return ((b) this.d.get(i)).tt();
    }

    public void d(com.bytedance.adsdk.ugeno.b bVar) {
        this.c = bVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.b bVar = this.c;
        if (bVar != null) {
            int[] iArrD = bVar.d(i, i2);
            super.onMeasure(iArrD[0], iArrD[1]);
        } else {
            super.onMeasure(i, i2);
        }
        com.bytedance.adsdk.ugeno.b bVar2 = this.c;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.b bVar = this.c;
        if (bVar != null) {
            bVar.c();
        }
        super.onLayout(z, i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.b bVar2 = this.c;
        if (bVar2 != null) {
            bVar2.d(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.b bVar = this.c;
        if (bVar != null) {
            bVar.u();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.b bVar = this.c;
        if (bVar != null) {
            bVar.an();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.b bVar = this.c;
        if (bVar != null) {
            bVar.hc(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.adsdk.ugeno.b bVar = this.c;
        if (bVar != null) {
            bVar.d(z);
        }
    }
}
