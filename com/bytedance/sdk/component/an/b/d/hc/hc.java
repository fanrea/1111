package com.bytedance.sdk.component.an.b.d.hc;

import android.graphics.Bitmap;
import android.os.Build;
import com.bytedance.sdk.component.an.yo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements yo {
    private com.bytedance.sdk.component.an.b.d.b<String, Bitmap> b;
    private int d;
    private int hc;

    public hc(int i, int i2) {
        this.hc = i;
        this.d = i2;
        this.b = new com.bytedance.sdk.component.an.b.d.b<String, Bitmap>(i) { // from class: com.bytedance.sdk.component.an.b.d.hc.hc.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.an.b.d.b
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public int hc(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return hc.d(bitmap);
            }
        };
    }

    @Override // com.bytedance.sdk.component.an.d
    public boolean d(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.b.d(str, bitmap);
        return true;
    }

    @Override // com.bytedance.sdk.component.an.d
    public Bitmap d(String str) {
        return this.b.d((com.bytedance.sdk.component.an.b.d.b<String, Bitmap>) str);
    }

    @Override // com.bytedance.sdk.component.an.d
    public boolean hc(String str) {
        return this.b.d((com.bytedance.sdk.component.an.b.d.b<String, Bitmap>) str) != null;
    }

    @Override // com.bytedance.sdk.component.an.d
    public void d(double d) {
        if (Build.VERSION.SDK_INT >= 17) {
            this.b.d((int) (this.hc * d));
        } else {
            this.b.d();
        }
    }

    public static int d(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return bitmap.getAllocationByteCount();
        }
        if (Build.VERSION.SDK_INT >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }
}
