package com.kwad.sdk.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class l {
    private static final com.kwad.sdk.glide.load.engine.bitmap_recycle.e bXA = new com.kwad.sdk.glide.load.engine.bitmap_recycle.f() { // from class: com.kwad.sdk.glide.load.resource.bitmap.l.1
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.f, com.kwad.sdk.glide.load.engine.bitmap_recycle.e
        public final void e(Bitmap bitmap) {
        }
    };

    static com.kwad.sdk.glide.load.engine.s<Bitmap> a(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i, int i2) {
        Bitmap bitmapB;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmapB = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmapB = null;
        } else {
            bitmapB = b(eVar, current, i, i2);
            z = true;
        }
        if (!z) {
            eVar = bXA;
        }
        return d.a(bitmapB, eVar);
    }

    private static Bitmap b(com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i2 = drawable.getIntrinsicHeight();
        }
        Lock lockAhU = v.ahU();
        lockAhU.lock();
        Bitmap bitmapB = eVar.b(i, i2, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapB);
            drawable.setBounds(0, 0, i, i2);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmapB;
        } finally {
            lockAhU.unlock();
        }
    }
}
