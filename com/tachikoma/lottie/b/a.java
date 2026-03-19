package com.tachikoma.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.component.lottie.c;
import com.tachikoma.lottie.model.h;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private final AssetManager Kt;
    private com.tachikoma.lottie.a Ku;
    private final h<String> Kq = new h<>();
    private final Map<h<String>, Typeface> Kr = new HashMap();
    private final Map<String, Typeface> Ks = new HashMap();
    private String Kv = ".ttf";

    public a(Drawable.Callback callback, com.tachikoma.lottie.a aVar) {
        this.Ku = aVar;
        if (!(callback instanceof View)) {
            Log.w(c.b, "LottieDrawable must be inside of a view for images to work.");
            this.Kt = null;
        } else {
            this.Kt = ((View) callback).getContext().getAssets();
        }
    }

    public final void a(com.tachikoma.lottie.a aVar) {
        this.Ku = aVar;
    }

    public final Typeface o(String str, String str2) {
        this.Kq.set(str, str2);
        Typeface typeface = this.Kr.get(this.Kq);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceA = a(ab(str), str2);
        this.Kr.put(this.Kq, typefaceA);
        return typefaceA;
    }

    private Typeface ab(String str) {
        Typeface typeface = this.Ks.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(this.Kt, "fonts/" + str + this.Kv);
        this.Ks.put(str, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private static Typeface a(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
