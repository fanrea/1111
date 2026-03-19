package com.alliance.ssp.ad.w;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;
import com.alliance.ssp.ad.r.i;

/* compiled from: NMInterstitialAdImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d implements i.a {
    public final /* synthetic */ com.alliance.ssp.ad.impl.interstitial.a a;

    public d(com.alliance.ssp.ad.impl.interstitial.a aVar) {
        this.a = aVar;
    }

    @Override // com.alliance.ssp.ad.r.i.a
    public void a(String str, Bitmap bitmap) {
        Bitmap bitmap2;
        ImageView imageView = this.a.N0;
        if (imageView != null) {
            if (bitmap == null) {
                bitmap2 = null;
            } else {
                float f = 80;
                float f2 = 1.0f * f;
                float width = f2 / bitmap.getWidth();
                float height = f2 / bitmap.getHeight();
                Matrix matrix = new Matrix();
                matrix.setScale(width, height);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(80, 80, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint(1);
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                bitmapShader.setLocalMatrix(matrix);
                paint.setShader(bitmapShader);
                float f3 = 16;
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, f, f), f3, f3, paint);
                bitmap2 = bitmapCreateBitmap;
            }
            imageView.setImageBitmap(bitmap2);
        }
    }

    @Override // com.alliance.ssp.ad.r.i.a
    public void a(String str, Exception exc) {
        int i = com.alliance.ssp.ad.o0.l.a;
    }
}
