package com.component.lottie.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.component.lottie.ax;
import com.component.lottie.g.c;
import com.component.lottie.g.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    private static final Object a = new Object();
    private final Context b;
    private final String c;
    private com.component.lottie.b d;
    private final Map<String, ax> e;

    public b(Drawable.Callback callback, String str, com.component.lottie.b bVar, Map<String, ax> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.c = str + '/';
        } else {
            this.c = str;
        }
        if (!(callback instanceof View)) {
            c.b("LottieDrawable must be inside of a view for images to work.");
            this.e = new HashMap();
            this.b = null;
        } else {
            this.b = ((View) callback).getContext();
            this.e = map;
            a(bVar);
        }
    }

    public void a(com.component.lottie.b bVar) {
        this.d = bVar;
    }

    public Bitmap a(String str, Bitmap bitmap) {
        if (bitmap == null) {
            ax axVar = this.e.get(str);
            Bitmap bitmapF = axVar.f();
            axVar.a(null);
            return bitmapF;
        }
        Bitmap bitmapF2 = this.e.get(str).f();
        b(str, bitmap);
        return bitmapF2;
    }

    public ax a(String str) {
        return this.e.get(str);
    }

    public Bitmap b(String str) {
        ax axVar = this.e.get(str);
        if (axVar == null) {
            return null;
        }
        Bitmap bitmapF = axVar.f();
        if (bitmapF != null) {
            return bitmapF;
        }
        if (this.d != null) {
            Bitmap bitmapA = this.d.a(axVar);
            if (bitmapA != null) {
                b(str, bitmapA);
            }
            return bitmapA;
        }
        String strD = axVar.d();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strD.startsWith("data:") && strD.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strD.substring(strD.indexOf(44) + 1), 0);
                return b(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e) {
                c.b("data URL did not have correct base64 format.", e);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.c)) {
                return null;
            }
            try {
                return b(str, g.a(BitmapFactory.decodeStream(this.b.getAssets().open(this.c + strD), null, options), axVar.a(), axVar.b()));
            } catch (IllegalArgumentException e2) {
                c.b("Unable to decode image.", e2);
                return null;
            }
        } catch (IOException e3) {
            c.b("Unable to open asset.", e3);
            return null;
        }
    }

    public boolean a(Context context) {
        return (context == null && this.b == null) || this.b.equals(context);
    }

    private Bitmap b(String str, Bitmap bitmap) {
        synchronized (a) {
            this.e.get(str).a(bitmap);
        }
        return bitmap;
    }
}
