package com.bytedance.adsdk.d.d.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.adsdk.d.d.hc.an;
import com.bytedance.adsdk.d.d.hc.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class gb<R extends com.bytedance.adsdk.d.d.hc.an, W extends com.bytedance.adsdk.d.d.hc.h> {
    public int gb;
    protected final R h;
    public int mk;
    public int mq;
    public int tc;
    public int tt;
    protected final Rect uo = new Rect();
    protected final Rect k = new Rect();

    public abstract Bitmap d(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);

    public gb(R r) {
        this.h = r;
    }
}
