package com.bytedance.sdk.component.adexpress.c;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.mq;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an {
    private static final byte[] d = d("VP8X");

    private static byte[] d(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    private static void b(final ImageView imageView, byte[] bArr, int i, int i2) {
        if (d(bArr)) {
            final com.bytedance.adsdk.d.d.d dVarD = com.bytedance.adsdk.d.d.d.d(ByteBuffer.wrap(bArr));
            com.bytedance.sdk.component.utils.gb.hc().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.c.an.1
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageDrawable(dVarD);
                }
            });
        } else {
            c(imageView, bArr, i, i2);
        }
    }

    public static boolean d(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        return d.d(bArr);
    }

    private static void c(final ImageView imageView, byte[] bArr, int i, int i2) {
        final Bitmap bitmapD = new com.bytedance.sdk.component.an.b.hc.d(i, i2, imageView.getScaleType(), Bitmap.Config.RGB_565, i, i2).d(bArr);
        if (bitmapD != null) {
            com.bytedance.sdk.component.utils.gb.hc().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.c.an.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapD);
                }
            });
        }
    }

    public static void d(final ImageView imageView, byte[] bArr, int i, int i2) throws IOException {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                final Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap));
                com.bytedance.sdk.component.utils.gb.hc().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.c.an.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable drawable = drawableDecodeDrawable;
                        if (drawable instanceof AnimatedImageDrawable) {
                            ((AnimatedImageDrawable) drawable).start();
                        }
                        imageView.setImageDrawable(drawableDecodeDrawable);
                    }
                });
                return;
            } catch (IOException e) {
                mq.d(e);
                return;
            }
        }
        c(imageView, bArr, i, i2);
    }

    public static void hc(ImageView imageView, byte[] bArr, int i, int i2) {
        try {
            if (imageView instanceof GifView) {
                ((GifView) imageView).d(bArr, false);
                return;
            }
            if (TextUtils.equals("png", com.bytedance.sdk.component.utils.tt.d(Arrays.copyOfRange(bArr, 0, com.bytedance.sdk.component.utils.tt.d())))) {
                b(imageView, bArr, i, i2);
            } else if (d(bArr, 0)) {
                d(imageView, bArr, i, i2);
            } else {
                c(imageView, bArr, i, i2);
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static boolean d(byte[] bArr, int i) {
        try {
            boolean zD = d(bArr, i + 12, d);
            int i2 = i + 20;
            if (bArr.length <= i2) {
                return false;
            }
            return zD && ((bArr[i2] & 2) == 2);
        } catch (Throwable th) {
            mq.d(th);
            return false;
        }
    }

    private static boolean d(byte[] bArr, int i, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i > bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if (bArr[i2 + i] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
