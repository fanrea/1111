package com.qq.e.comm.plugin;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class gx {
    public static ShapeDrawable a(float f, float f2, float f3, float f4, int i, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{f, f, f2, f2, f3, f3, f4, f4}, null, null));
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setAlpha(i2);
        return shapeDrawable;
    }

    public static ShapeDrawable a(float f, int i, int i2) {
        return a(f, f, f, f, i, i2);
    }
}
