package com.bytedance.sdk.djx.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.djx.utils.LG;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BitmapUtils {
    public static final String TAG = "BitmapUtils";

    public static String bitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        String strEncodeToString = null;
        if (bitmap == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (Throwable unused) {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                }
                return strEncodeToString;
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
        }
        try {
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (Throwable unused3) {
        }
        return strEncodeToString;
    }

    public static Bitmap base64ToBitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getByteCount());
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.isRecycled()) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        LG.i(TAG, width + " originWidth");
        LG.i(TAG, height + " originHeight");
        if (width < i && height < i2) {
            return bitmap;
        }
        if (width > i) {
            height = (int) Math.floor(height / ((width * 1.0d) / i));
            if (i > 0 && height > 0 && !bitmap.isRecycled()) {
                bitmap = Bitmap.createScaledBitmap(bitmap, i, height, false);
            }
        } else {
            i = width;
        }
        if (height <= i2) {
            i2 = height;
        } else if (i > 0 && i2 > 0 && !bitmap.isRecycled()) {
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, i, i2);
        }
        LG.i(TAG, i + " width");
        LG.i(TAG, i2 + " height");
        return bitmap;
    }

    public static Bitmap compressBitmap(Bitmap bitmap, int i) {
        if (bitmap == null || bitmap.getRowBytes() * bitmap.getHeight() < i) {
            return bitmap;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        int i2 = 90;
        while (byteArrayOutputStream.toByteArray().length > i) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.PNG, i2, byteArrayOutputStream);
            i2 -= 10;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    public static Bitmap getResizeBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            return bitmap;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i < width && i2 < height) {
                Matrix matrix = new Matrix();
                matrix.postScale(i / width, i2 / height);
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            }
            return bitmap;
        } catch (Throwable th) {
            LG.d(th.getMessage());
            return null;
        }
    }
}
