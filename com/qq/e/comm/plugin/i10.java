package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class i10 extends xe<w, x> {
    static final /* synthetic */ boolean i = true;

    public i10(w wVar) {
        super(wVar);
    }

    @Override // com.qq.e.comm.plugin.xe
    public Bitmap a(Canvas canvas, Paint paint, int i2, Bitmap bitmap, x xVar) {
        Bitmap bitmapDecodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i2;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((w) this.a).reset();
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(((w) this.a).a(), null, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i2;
                options2.inMutable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(((w) this.a).a(), null, options2);
            }
            try {
                if (!i && bitmapDecodeStream == null) {
                    throw new AssertionError();
                }
                paint.setXfermode(null);
                canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
                return bitmapDecodeStream;
            } catch (IOException e) {
                e = e;
                bitmap2 = bitmapDecodeStream;
                e.printStackTrace();
                return bitmap2;
            }
        } catch (IOException e2) {
            e = e2;
            e.printStackTrace();
            return bitmap2;
        }
    }
}
