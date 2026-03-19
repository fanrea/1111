package com.bytedance.sdk.djx.core.business.view.like;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class Utils {
    Utils() {
    }

    public static Drawable resizeDrawable(Context context, Drawable drawable, int i, int i2) {
        return new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(getBitmap(drawable, i, i2), i, i2, true));
    }

    public static Bitmap getBitmap(Drawable drawable, int i, int i2) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (Build.VERSION.SDK_INT >= 21 && (drawable instanceof VectorDrawable)) {
            return getBitmap((VectorDrawable) drawable, i, i2);
        }
        return Bitmap.createBitmap(20, 20, Bitmap.Config.ARGB_8888);
    }

    private static Bitmap getBitmap(VectorDrawable vectorDrawable, int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
