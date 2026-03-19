package com.kwad.lottie.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.component.lottie.c;
import com.kwad.lottie.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static final Object bmP = new Object();
    private String bmQ;
    private com.kwad.lottie.b bmR;
    private final Map<String, g> bmS;
    private final Context dR;

    public b(Drawable.Callback callback, String str, com.kwad.lottie.b bVar, Map<String, g> map) {
        this.bmQ = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.bmQ.charAt(r4.length() - 1) != '/') {
                this.bmQ += '/';
            }
        }
        if (!(callback instanceof View)) {
            Log.w(c.b, "LottieDrawable must be inside of a view for images to work.");
            this.bmS = new HashMap();
            this.dR = null;
        } else {
            this.dR = ((View) callback).getContext();
            this.bmS = map;
            a(bVar);
        }
    }

    public final void a(com.kwad.lottie.b bVar) {
        this.bmR = bVar;
    }

    /* renamed from: do, reason: not valid java name */
    public final Bitmap m455do(String str) {
        g gVar = this.bmS.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap bitmap = gVar.getBitmap();
        if (bitmap != null) {
            return bitmap;
        }
        com.kwad.lottie.b bVar = this.bmR;
        if (bVar != null) {
            Bitmap bitmapPW = bVar.PW();
            if (bitmapPW != null) {
                a(str, bitmapPW);
            }
            return bitmapPW;
        }
        String fileName = gVar.getFileName();
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
            if (TextUtils.isEmpty(this.bmQ)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            return a(str, BitmapFactory.decodeStream(this.dR.getAssets().open(this.bmQ + fileName), null, options));
        } catch (IOException e2) {
            Log.w(c.b, "Unable to open asset.", e2);
            return null;
        }
    }

    public final void PX() {
        synchronized (bmP) {
            Iterator<Map.Entry<String, g>> it = this.bmS.entrySet().iterator();
            while (it.hasNext()) {
                g value = it.next().getValue();
                Bitmap bitmap = value.getBitmap();
                if (bitmap != null) {
                    bitmap.recycle();
                    value.setBitmap(null);
                }
            }
        }
    }

    public final boolean aZ(Context context) {
        return (context == null && this.dR == null) || this.dR.equals(context);
    }

    private Bitmap a(String str, Bitmap bitmap) {
        synchronized (bmP) {
            this.bmS.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }
}
