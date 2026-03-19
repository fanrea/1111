package com.alliance.ssp.ad.w;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: TextureVideoViewOutlineProvider.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class l extends ViewOutlineProvider {
    public float a;
    public int b;

    public l(float f, int i) {
        this.a = f;
        this.b = i;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0);
        int i = this.b;
        if (i == 1) {
            outline.setRoundRect(rect2, this.a);
            return;
        }
        try {
            if (i == 2) {
                Path path = new Path();
                path.moveTo(rect2.left, rect2.top + this.a);
                float f = rect2.left;
                float f2 = rect2.top;
                path.quadTo(f, f2, this.a + f, f2);
                path.lineTo(rect2.right - this.a, rect2.top);
                float f3 = rect2.right;
                float f4 = rect2.top;
                path.quadTo(f3, f4, f3, this.a + f4);
                path.lineTo(rect2.right, rect2.bottom);
                path.lineTo(rect2.left, rect2.bottom);
                path.close();
                outline.setConvexPath(path);
            } else {
                if (i != 3) {
                    return;
                }
                Path path2 = new Path();
                path2.moveTo(rect2.left, rect2.top + this.a);
                float f5 = rect2.left;
                float f6 = rect2.top;
                path2.quadTo(f5, f6, this.a + f5, f6);
                path2.lineTo(rect2.right, rect2.top);
                path2.lineTo(rect2.right, rect2.bottom);
                path2.lineTo(rect2.left + this.a, rect2.bottom);
                float f7 = rect2.left;
                float f8 = rect2.bottom;
                path2.quadTo(f7, f8, f7, f8 - this.a);
                path2.close();
                outline.setConvexPath(path2);
            }
        } catch (Exception unused) {
        }
    }
}
