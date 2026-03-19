package com.bytedance.adsdk.lottie.hc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.bytedance.adsdk.lottie.c;
import com.bytedance.adsdk.lottie.tt;
import com.bytedance.adsdk.lottie.u.u;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static final Object d = new Object();
    private final String b;
    private c c;
    private final Context hc;
    private final Map<String, tt> u;

    public hc(Drawable.Callback callback, String str, c cVar, Map<String, tt> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.b = str + '/';
        } else {
            this.b = str;
        }
        this.u = map;
        d(cVar);
        if (!(callback instanceof View)) {
            this.hc = null;
        } else {
            this.hc = ((View) callback).getContext().getApplicationContext();
        }
    }

    public void d(c cVar) {
        this.c = cVar;
    }

    public Bitmap d(String str, Bitmap bitmap) {
        if (bitmap == null) {
            tt ttVar = this.u.get(str);
            Bitmap bitmapK = ttVar.k();
            ttVar.d(null);
            return bitmapK;
        }
        return this.u.get(str).k();
    }

    public Bitmap d(String str) {
        tt ttVar = this.u.get(str);
        if (ttVar == null) {
            return null;
        }
        Bitmap bitmapK = ttVar.k();
        if (bitmapK != null) {
            return bitmapK;
        }
        c cVar = this.c;
        if (cVar != null) {
            return cVar.d(ttVar);
        }
        Context context = this.hc;
        if (context == null) {
            return null;
        }
        String strMq = ttVar.mq();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strMq.startsWith("data:") && strMq.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strMq.substring(strMq.indexOf(44) + 1), 0);
                return hc(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                u.d("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.b + strMq), null, options);
                if (bitmapDecodeStream == null) {
                    u.hc("Decoded image `" + str + "` is null.");
                    return null;
                }
                return hc(str, com.bytedance.adsdk.lottie.u.tt.d(bitmapDecodeStream, ttVar.d(), ttVar.hc()));
            } catch (IllegalArgumentException e2) {
                u.d("Unable to decode image `" + str + "`.", e2);
                return null;
            }
        } catch (IOException e3) {
            u.d("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean d(Context context) {
        return (context == null && this.hc == null) || this.hc.equals(context);
    }

    private Bitmap hc(String str, Bitmap bitmap) {
        synchronized (d) {
        }
        return bitmap;
    }
}
