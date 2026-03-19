package com.bytedance.sdk.component.an.b.hc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static final ImageView.ScaleType d = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config hc = Bitmap.Config.ARGB_4444;
    private final int an;
    private final Bitmap.Config b;
    private int c;
    private final ImageView.ScaleType gb;
    private final int h;
    private int u;
    private final int tt = 3840;
    private final int tc = 104857600;

    public d(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, int i3, int i4) {
        this.b = config;
        this.c = i;
        this.u = i2;
        this.gb = scaleType;
        this.an = i3;
        this.h = i4;
        d(i, i2);
    }

    static int d(int i, int i2, int i3, int i4, int i5, int i6) {
        double dMin = Math.min(i / i3, i2 / i4);
        if (i5 > 0 && i6 > 0) {
            dMin = Math.max(dMin, Math.min(Math.max(i, i2) / Math.max(i5, i6), Math.min(i, i2) / Math.min(i5, i6)));
        }
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > dMin) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int d(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (i3 * (i2 / i4));
        }
        if (i2 == 0) {
            return i;
        }
        double d2 = i4 / i3;
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d3 = i2;
            return ((double) i) * d2 < d3 ? (int) (d3 / d2) : i;
        }
        double d4 = i2;
        return ((double) i) * d2 > d4 ? (int) (d4 / d2) : i;
    }

    public Bitmap d(byte[] bArr) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.c == 0 && this.u == 0) {
            options.inPreferredConfig = this.b;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int iD = d(this.c, this.u, i, i2, this.gb);
            int iD2 = d(this.u, this.c, i2, i, this.gb);
            options.inJustDecodeBounds = false;
            options.inSampleSize = d(i, i2, iD, iD2, this.an, this.h);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iD || bitmapDecodeByteArray.getHeight() > iD2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iD, iD2, true);
                if (bitmapCreateScaledBitmap != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        if (Build.VERSION.SDK_INT >= 12 && bitmapDecodeByteArray != null && bitmapDecodeByteArray.getByteCount() > 104857600) {
            int width = bitmapDecodeByteArray.getWidth() / 2;
            int height = bitmapDecodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeByteArray, width, height, true);
                if (bitmapCreateScaledBitmap2 != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                return bitmapCreateScaledBitmap2;
            }
        }
        return bitmapDecodeByteArray;
    }

    private void d(int i, int i2) {
        if (i > 3840 && i2 > 3840) {
            if (i > i2) {
                this.c = 3840;
                this.u = (i2 * 3840) / i;
                return;
            } else {
                this.c = (i * 3840) / i2;
                this.u = 3840;
                return;
            }
        }
        if (i > 3840) {
            this.c = 3840;
            this.u = (i2 * 3840) / i;
        } else if (i2 > 3840) {
            this.c = (i * 3840) / i2;
            this.u = 3840;
        }
    }
}
