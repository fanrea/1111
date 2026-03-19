package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.qq.e.comm.plugin.jv;
import com.qq.e.comm.plugin.y50;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class xe<R extends jv, W extends y50> {
    protected final R a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    protected final Rect g = new Rect();
    protected final Rect h = new Rect();

    public abstract Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);

    public xe(R r) {
        this.a = r;
    }
}
