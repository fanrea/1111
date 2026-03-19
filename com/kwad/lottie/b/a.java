package com.kwad.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.component.lottie.c;
import com.kwad.lottie.model.h;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private final AssetManager bmM;
    private com.kwad.lottie.a bmN;
    private final h<String> bmJ = new h<>();
    private final Map<h<String>, Typeface> bmK = new HashMap();
    private final Map<String, Typeface> bmL = new HashMap();
    private String bmO = ".ttf";

    public a(Drawable.Callback callback, com.kwad.lottie.a aVar) {
        this.bmN = aVar;
        if (!(callback instanceof View)) {
            Log.w(c.b, "LottieDrawable must be inside of a view for images to work.");
            this.bmM = null;
        } else {
            this.bmM = ((View) callback).getContext().getAssets();
        }
    }

    public final void a(com.kwad.lottie.a aVar) {
        this.bmN = aVar;
    }

    public final Typeface N(String str, String str2) {
        this.bmJ.set(str, str2);
        Typeface typeface = this.bmK.get(this.bmJ);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceA = a(dn(str), str2);
        this.bmK.put(this.bmJ, typefaceA);
        return typefaceA;
    }

    private Typeface dn(String str) {
        Typeface typeface = this.bmL.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(this.bmM, "fonts/" + str + this.bmO);
        this.bmL.put(str, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private static Typeface a(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
