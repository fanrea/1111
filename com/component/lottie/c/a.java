package com.component.lottie.c;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.component.lottie.d.h;
import com.component.lottie.g.c;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    private final AssetManager d;
    private com.component.lottie.a e;
    private final h<String> a = new h<>();
    private final Map<h<String>, Typeface> b = new HashMap();
    private final Map<String, Typeface> c = new HashMap();
    private String f = ".ttf";

    public a(Drawable.Callback callback, com.component.lottie.a aVar) {
        this.e = aVar;
        if (!(callback instanceof View)) {
            c.b("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
        } else {
            this.d = ((View) callback).getContext().getAssets();
        }
    }

    public void a(com.component.lottie.a aVar) {
        this.e = aVar;
    }

    public void a(String str) {
        this.f = str;
    }

    public Typeface a(String str, String str2) {
        this.a.a(str, str2);
        Typeface typeface = this.b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceA = a(b(str), str2);
        this.b.put(this.a, typefaceA);
        return typefaceA;
    }

    private Typeface b(String str) {
        Typeface typefaceCreateFromAsset;
        String strB;
        Typeface typeface = this.c.get(str);
        if (typeface != null) {
            return typeface;
        }
        if (this.e == null) {
            typefaceCreateFromAsset = null;
        } else {
            typefaceCreateFromAsset = this.e.a(str);
        }
        if (this.e != null && typefaceCreateFromAsset == null && (strB = this.e.b(str)) != null) {
            typefaceCreateFromAsset = Typeface.createFromAsset(this.d, strB);
        }
        if (typefaceCreateFromAsset == null) {
            typefaceCreateFromAsset = Typeface.createFromAsset(this.d, "fonts/" + str + this.f);
        }
        this.c.put(str, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface a(Typeface typeface, String str) {
        int i;
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        if (zContains && zContains2) {
            i = 3;
        } else if (zContains) {
            i = 2;
        } else if (!zContains2) {
            i = 0;
        } else {
            i = 1;
        }
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }
}
