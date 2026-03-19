package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.material.badge.BadgeDrawable;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class ka extends ImageView {
    private static int d;
    private static int e;
    private static float f;
    private int a;
    private byte[] b;
    private boolean c;

    public ka(Context context) {
        super(context);
        if (d == 0) {
            d = yu.a(context, 80);
        }
        if (e == 0) {
            e = yu.a(context, 45);
        }
        if (f == 0.0f) {
            f = (d * 1.0f) / e;
        }
    }

    void a(FrameLayout frameLayout, boolean z, int i, boolean z2) {
        if (frameLayout == null) {
            return;
        }
        Bitmap bitmapA = e5.a(getContext(), this.a);
        if (bitmapA == null && (bitmapA = e5.a(this.b)) == null) {
            return;
        }
        int width = bitmapA.getWidth();
        int height = bitmapA.getHeight();
        float f2 = (width * 1.0f) / height;
        int i2 = d;
        if (width > i2 || height > e) {
            if (f2 >= f) {
                height = (int) (i2 / f2);
                width = i2;
            } else {
                height = e;
                width = (int) (height * f2);
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
        int i3 = pz.g;
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        layoutParams.topMargin = i3;
        layoutParams.bottomMargin = i3;
        setImageBitmap(bitmapA);
        if (z || i == 0 || i == 1) {
            layoutParams.gravity = 48;
            layoutParams.topMargin += (e - height) / 2;
        } else if (i == 2) {
            layoutParams.gravity = BadgeDrawable.TOP_END;
            layoutParams.topMargin += (e - height) / 2;
        } else {
            layoutParams.gravity = 80;
            int i4 = layoutParams.bottomMargin + ((e - height) / 2);
            layoutParams.bottomMargin = i4;
            layoutParams.bottomMargin = i4 + (z2 ? pz.k : 0);
            this.c = true;
        }
        if ((layoutParams.gravity & 48) == 48) {
            ua.a(this, 2);
        }
        frameLayout.addView(this, layoutParams);
    }

    boolean a() {
        return this.c;
    }

    void a(int i) {
        this.a = i;
    }

    void a(byte[] bArr) {
        this.b = bArr;
    }
}
