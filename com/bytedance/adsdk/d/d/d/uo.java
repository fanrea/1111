package com.bytedance.adsdk.d.d.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo extends gb<com.bytedance.adsdk.d.d.hc.d, com.bytedance.adsdk.d.d.hc.hc> {
    static final /* synthetic */ boolean d = true;

    public uo(com.bytedance.adsdk.d.d.hc.d dVar) {
        super(dVar);
    }

    @Override // com.bytedance.adsdk.d.d.d.gb
    public Bitmap d(Canvas canvas, Paint paint, int i, Bitmap bitmap, com.bytedance.adsdk.d.d.hc.hc hcVar) {
        Bitmap bitmapDecodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;
        options.inSampleSize = i;
        options.inMutable = true;
        options.inBitmap = bitmap;
        Bitmap bitmap2 = null;
        try {
            ((com.bytedance.adsdk.d.d.hc.d) this.h).d_();
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.bytedance.adsdk.d.d.hc.d) this.h).u(), null, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i;
                options2.inMutable = true;
                bitmapDecodeStream = BitmapFactory.decodeStream(((com.bytedance.adsdk.d.d.hc.d) this.h).u(), null, options2);
            }
            try {
                if (!d && bitmapDecodeStream == null) {
                    throw new AssertionError();
                }
                paint.setXfermode(null);
                canvas.drawBitmap(bitmapDecodeStream, 0.0f, 0.0f, paint);
                return bitmapDecodeStream;
            } catch (IOException e) {
                e = e;
                bitmap2 = bitmapDecodeStream;
                com.bytedance.sdk.component.utils.mq.d(e);
                return bitmap2;
            }
        } catch (IOException e2) {
            e = e2;
            com.bytedance.sdk.component.utils.mq.d(e);
            return bitmap2;
        }
    }
}
