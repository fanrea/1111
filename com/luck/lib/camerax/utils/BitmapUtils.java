package com.luck.lib.camerax.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.kuaishou.socket.nano.SocketMessages;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class BitmapUtils {
    public static Bitmap toHorizontalMirror(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        matrix.postRotate(width > height ? 90.0f : 0.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static int computeSize(int i, int i2) {
        if (i % 2 == 1) {
            i++;
        }
        if (i2 % 2 == 1) {
            i2++;
        }
        int iMax = Math.max(i, i2);
        float fMin = Math.min(i, i2) / iMax;
        if (fMin > 1.0f || fMin <= 0.5625d) {
            double d = fMin;
            if (d <= 0.5625d && d > 0.5d) {
                int i3 = iMax / SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE;
                if (i3 == 0) {
                    return 1;
                }
                return i3;
            }
            return (int) Math.ceil(iMax / (1280.0d / d));
        }
        if (iMax < 1664) {
            return 1;
        }
        if (iMax < 4990) {
            return 2;
        }
        if (iMax <= 4990 || iMax >= 10240) {
            return iMax / SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE;
        }
        return 4;
    }
}
