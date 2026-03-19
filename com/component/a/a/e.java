package com.component.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.baidu.mobads.container.util.d.d;
import com.baidu.mobads.container.util.x;
import com.component.a.f.c;
import com.component.a.f.e;
import com.component.feed.ax;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    public ImageView a(Context context, com.component.a.f.e eVar) {
        int i;
        int i2;
        String strO = eVar.o("");
        e.f fVarH = eVar.h();
        String strA = fVarH.a(e.f.a);
        float[] fArrA = fVarH.a(new float[8]);
        float f = fVarH.f(-2.0f);
        com.component.a.i.n.a(context, fArrA);
        ax.a aVarB = new ax.a(context).a(e.f.a.equals(strA) ? ax.b.RoundRect : ax.b.Circle).a(f).a(fArrA).a(com.component.a.i.a.a(context, fVarH.f(0))).b(com.component.a.i.r.a(fVarH.e(-1), fVarH.e(1.0f)));
        try {
            int iOptInt = fVarH.a().optInt("blur", 0);
            if (iOptInt == 1) {
                aVarB.b(true);
                aVarB.b(9.5f);
            } else if (iOptInt == 2) {
                aVarB.a(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ax axVarA = aVarB.a();
        axVarA.setLifeCycle(new com.component.a.i.f(eVar));
        Drawable drawableA = com.component.a.i.r.a(context, fVarH);
        if (x.a(context).a() > 16) {
            axVarA.setBackground(drawableA);
        } else {
            axVarA.setBackgroundDrawable(drawableA);
        }
        String strP = eVar.p("");
        if (com.baidu.mobads.container.util.animation.j.g.equals(strP)) {
            axVarA.a(ax.c.MATRIX_KEEP_BOTTOM);
        } else if (com.baidu.mobads.container.util.animation.j.f.equals(strP)) {
            axVarA.a(ax.c.MATRIX_KEEP_TOP);
        } else {
            axVarA.setScaleType(a(strP));
        }
        if (!TextUtils.isEmpty(strO)) {
            if (com.component.a.i.n.a(strO)) {
                Bitmap bitmapA = eVar.a(strO);
                if (bitmapA != null) {
                    axVarA.setImageBitmap(bitmapA);
                }
            } else {
                c.a aVarD = eVar.d();
                if (aVarD == null) {
                    i = 10000;
                    i2 = 10000;
                } else {
                    i = aVarD.a;
                    i2 = aVarD.b;
                }
                com.baidu.mobads.container.util.d.d.a(context, strO).a.a(d.e.PICTURE).b.a(axVarA, true).c.a(i, i2).a((d.InterfaceC0136d) axVarA.getLifeCycle());
            }
        }
        return axVarA;
    }

    public static ImageView.ScaleType a(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        if (!TextUtils.isEmpty(str)) {
            if ("matrix".equalsIgnoreCase(str)) {
                return ImageView.ScaleType.MATRIX;
            }
            if ("fit_xy".equalsIgnoreCase(str)) {
                return ImageView.ScaleType.FIT_XY;
            }
            if ("center".equalsIgnoreCase(str)) {
                return ImageView.ScaleType.CENTER;
            }
            if ("center_crop".equalsIgnoreCase(str)) {
                return ImageView.ScaleType.CENTER_CROP;
            }
            if ("center_inside".equalsIgnoreCase(str)) {
                return ImageView.ScaleType.CENTER_INSIDE;
            }
            return scaleType;
        }
        return scaleType;
    }
}
