package com.qq.e.comm.plugin;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class b40 extends ImageView {
    private int a;
    private int b;
    private final n40 c;

    public b40(Context context) {
        super(context);
        this.c = new n40();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.a > 0 && this.b > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            Pair<Integer, Integer> pairA = this.c.a(mode, View.MeasureSpec.getMode(i2), size, View.MeasureSpec.getSize(i2));
            setMeasuredDimension(((Integer) pairA.first).intValue(), ((Integer) pairA.second).intValue());
            return;
        }
        super.onMeasure(i, i2);
    }

    public void a(int i, int i2) {
        this.c.a(i, i2);
        this.a = i;
        this.b = i2;
    }
}
