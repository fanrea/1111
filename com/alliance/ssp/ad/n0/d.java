package com.alliance.ssp.ad.n0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.core.view.MotionEventCompat;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;

/* compiled from: SAFastBlurBitmap.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    public static Bitmap a(Bitmap bitmap, float f) {
        Bitmap bitmapCreateBitmap;
        if (bitmap == null) {
            return null;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.25f, 0.25f);
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            Bitmap bitmapB = b(bitmapCreateBitmap2, f);
            if (bitmapB == null) {
                bitmapCreateBitmap = null;
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapB.getWidth(), bitmapB.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawBitmap(bitmapB, 0.0f, 0.0f, (Paint) null);
                canvas.drawColor(Math.round(0.0f) | (Math.round(51.0f) << 24) | (Math.round(0.0f) << 16) | (Math.round(0.0f) << 8));
                canvas.save();
                canvas.restore();
            }
            WeakReference weakReference = new WeakReference(bitmapCreateBitmap);
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
            if (bitmapCreateBitmap2 != null && !bitmapCreateBitmap2.isRecycled()) {
                bitmapCreateBitmap2.recycle();
            }
            if (bitmapB != null && !bitmapB.isRecycled()) {
                bitmapB.recycle();
            }
            return (Bitmap) weakReference.get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap b(Bitmap bitmap, float f) {
        int i;
        int[] iArr;
        if (bitmap == null || (i = (int) f) < 1) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int[] iArr2 = new int[i2];
        bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int i5 = i + i + 1;
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[i2];
        int[] iArr6 = new int[Math.max(width, height)];
        int i6 = (i5 + 1) >> 1;
        int i7 = i6 * i6;
        int i8 = i7 * 256;
        int[] iArr7 = new int[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            iArr7[i9] = i9 / i7;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i5, 3);
        int i10 = i + 1;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < height) {
            int i14 = height;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = -i;
            int i24 = 0;
            while (i23 <= i) {
                int i25 = i4;
                int[] iArr9 = iArr6;
                int i26 = iArr2[Math.min(i3, Math.max(i23, 0)) + i12];
                int[] iArr10 = iArr8[i23 + i];
                iArr10[0] = (i26 & 16711680) >> 16;
                iArr10[1] = (i26 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i26 & 255;
                int iAbs = i10 - Math.abs(i23);
                int i27 = iArr10[0];
                i24 += i27 * iAbs;
                int i28 = iArr10[1];
                i15 = (i28 * iAbs) + i15;
                int i29 = iArr10[2];
                i16 = (iAbs * i29) + i16;
                if (i23 > 0) {
                    i22 += i27;
                    i21 += i28;
                    i20 += i29;
                } else {
                    i19 += i27;
                    i18 += i28;
                    i17 += i29;
                }
                i23++;
                i4 = i25;
                iArr6 = iArr9;
            }
            int i30 = i4;
            int[] iArr11 = iArr6;
            int i31 = i;
            int i32 = 0;
            while (i32 < width) {
                iArr3[i12] = iArr7[i24];
                iArr4[i12] = iArr7[i15];
                iArr5[i12] = iArr7[i16];
                int i33 = i24 - i19;
                int i34 = i15 - i18;
                int i35 = i16 - i17;
                int[] iArr12 = iArr8[((i31 - i) + i5) % i5];
                int i36 = i19 - iArr12[0];
                int i37 = i18 - iArr12[1];
                int i38 = i17 - iArr12[2];
                if (i11 == 0) {
                    iArr = iArr7;
                    iArr11[i32] = Math.min(i32 + i + 1, i3);
                } else {
                    iArr = iArr7;
                }
                int i39 = iArr2[i13 + iArr11[i32]];
                int i40 = (i39 & 16711680) >> 16;
                iArr12[0] = i40;
                int i41 = (i39 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[1] = i41;
                int i42 = i39 & 255;
                iArr12[2] = i42;
                int i43 = i22 + i40;
                int i44 = i21 + i41;
                int i45 = i20 + i42;
                i24 = i33 + i43;
                i15 = i34 + i44;
                i16 = i35 + i45;
                i31 = (i31 + 1) % i5;
                int[] iArr13 = iArr8[i31 % i5];
                int i46 = iArr13[0];
                i19 = i36 + i46;
                int i47 = iArr13[1];
                i18 = i37 + i47;
                int i48 = iArr13[2];
                i17 = i38 + i48;
                i22 = i43 - i46;
                i21 = i44 - i47;
                i20 = i45 - i48;
                i12++;
                i32++;
                iArr7 = iArr;
            }
            i13 += width;
            i11++;
            height = i14;
            i4 = i30;
            iArr6 = iArr11;
        }
        int i49 = i4;
        int[] iArr14 = iArr6;
        int i50 = height;
        int[] iArr15 = iArr7;
        int i51 = 0;
        while (i51 < width) {
            int i52 = -i;
            int i53 = i5;
            int[] iArr16 = iArr2;
            int i54 = 0;
            int i55 = 0;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = i52;
            int i62 = i52 * width;
            int i63 = 0;
            int i64 = 0;
            while (i61 <= i) {
                int i65 = width;
                int iMax = Math.max(0, i62) + i51;
                int[] iArr17 = iArr8[i61 + i];
                iArr17[0] = iArr3[iMax];
                iArr17[1] = iArr4[iMax];
                iArr17[2] = iArr5[iMax];
                int iAbs2 = i10 - Math.abs(i61);
                i63 = (iArr3[iMax] * iAbs2) + i63;
                i64 = (iArr4[iMax] * iAbs2) + i64;
                i54 = (iArr5[iMax] * iAbs2) + i54;
                if (i61 > 0) {
                    i60 += iArr17[0];
                    i59 += iArr17[1];
                    i58 += iArr17[2];
                } else {
                    i57 += iArr17[0];
                    i56 += iArr17[1];
                    i55 += iArr17[2];
                }
                int i66 = i49;
                if (i61 < i66) {
                    i62 += i65;
                }
                i61++;
                i49 = i66;
                width = i65;
            }
            int i67 = width;
            int i68 = i49;
            int i69 = i51;
            int i70 = i;
            int i71 = i50;
            int i72 = 0;
            while (i72 < i71) {
                iArr16[i69] = (iArr16[i69] & (-16777216)) | (iArr15[i63] << 16) | (iArr15[i64] << 8) | iArr15[i54];
                int i73 = i63 - i57;
                int i74 = i64 - i56;
                int i75 = i54 - i55;
                int[] iArr18 = iArr8[((i70 - i) + i53) % i53];
                int i76 = i57 - iArr18[0];
                int i77 = i56 - iArr18[1];
                int i78 = i55 - iArr18[2];
                int i79 = i;
                if (i51 == 0) {
                    iArr14[i72] = Math.min(i72 + i10, i68) * i67;
                }
                int i80 = iArr14[i72] + i51;
                int i81 = iArr3[i80];
                iArr18[0] = i81;
                int i82 = iArr4[i80];
                iArr18[1] = i82;
                int i83 = iArr5[i80];
                iArr18[2] = i83;
                int i84 = i60 + i81;
                int i85 = i59 + i82;
                int i86 = i58 + i83;
                i63 = i73 + i84;
                i64 = i74 + i85;
                i54 = i75 + i86;
                i70 = (i70 + 1) % i53;
                int[] iArr19 = iArr8[i70];
                int i87 = iArr19[0];
                i57 = i76 + i87;
                int i88 = iArr19[1];
                i56 = i77 + i88;
                int i89 = iArr19[2];
                i55 = i78 + i89;
                i60 = i84 - i87;
                i59 = i85 - i88;
                i58 = i86 - i89;
                i69 += i67;
                i72++;
                i = i79;
            }
            i51++;
            i49 = i68;
            i50 = i71;
            i5 = i53;
            iArr2 = iArr16;
            width = i67;
        }
        int i90 = width;
        bitmap.setPixels(iArr2, 0, i90, 0, 0, i90, i50);
        return bitmap;
    }
}
