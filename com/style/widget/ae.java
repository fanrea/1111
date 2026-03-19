package com.style.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.component.a.d.b;
import com.component.a.d.c;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ae extends com.component.a.d.c {
    private static final int e = 15;
    private double a;
    private Context b;
    private int d;

    public ae(Context context, double d) {
        super(context, null);
        this.d = 5;
        this.b = context;
        this.a = d;
        a();
    }

    private void a() {
        double d = this.a;
        Bitmap bitmapB = null;
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.d; i++) {
            ImageView imageView = new ImageView(this.b);
            d -= 1.0d;
            if (d >= 0.0d) {
                if (!z) {
                    bitmapB = com.component.b.a.a().b("ic_gold_star");
                }
                z = true;
            } else if (d > -1.0d) {
                bitmapB = com.component.b.a.a().b("ic_half_gold_star");
            } else {
                if (!z2) {
                    bitmapB = com.component.b.a.a().b("ic_gray_star");
                }
                z2 = true;
            }
            imageView.setImageBitmap(bitmapB);
            c.a aVar = new c.a(0, 0);
            b.C0314b c0314bA = aVar.a();
            c0314bA.b = 1.0f;
            c0314bA.u = 1.0f;
            int i2 = i + 15;
            imageView.setId(i2);
            if (i > 0) {
                aVar.addRule(1, i2 - 1);
            }
            aVar.addRule(15);
            addView(imageView, aVar);
        }
    }
}
