package com.tachikoma.lottie.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.component.lottie.c;
import com.tachikoma.lottie.d.f;
import com.tachikoma.lottie.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    private static final Object Kw = new Object();
    private final Map<String, h> KA;
    private final Context Kx;
    private String Ky;
    private com.tachikoma.lottie.b Kz;

    public b(Drawable.Callback callback, String str, com.tachikoma.lottie.b bVar, Map<String, h> map) {
        this.Ky = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.Ky.charAt(r4.length() - 1) != '/') {
                this.Ky += '/';
            }
        }
        if (!(callback instanceof View)) {
            Log.w(c.b, "LottieDrawable must be inside of a view for images to work.");
            this.KA = new HashMap();
            this.Kx = null;
        } else {
            this.Kx = ((View) callback).getContext();
            this.KA = map;
            a(bVar);
        }
    }

    public final void a(com.tachikoma.lottie.b bVar) {
        this.Kz = bVar;
    }

    public final Bitmap ac(String str) {
        h hVar = this.KA.get(str);
        if (hVar == null) {
            return null;
        }
        Bitmap bitmap = hVar.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        com.tachikoma.lottie.b bVar = this.Kz;
        if (bVar != null) {
            Bitmap bitmapA = bVar.a(hVar);
            if (bitmapA != null) {
                a(str, bitmapA);
            }
            return bitmapA;
        }
        String fileName = hVar.getFileName();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                return a(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                Log.w(c.b, "data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.Ky)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            return a(str, f.a(BitmapFactory.decodeStream(this.Kx.getAssets().open(this.Ky + fileName), null, options), hVar.getWidth(), hVar.getHeight()));
        } catch (IOException e2) {
            Log.w(c.b, "Unable to open asset.", e2);
            return null;
        }
    }

    public final boolean w(Context context) {
        return (context == null && this.Kx == null) || this.Kx.equals(context);
    }

    private Bitmap a(String str, Bitmap bitmap) {
        synchronized (Kw) {
            this.KA.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }
}
