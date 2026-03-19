package com.bytedance.adsdk.lottie.hc;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.adsdk.lottie.b;
import com.bytedance.adsdk.lottie.model.h;
import com.bytedance.adsdk.lottie.u.u;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private final AssetManager c;
    private b u;
    private final h<String> d = new h<>();
    private final Map<h<String>, Typeface> hc = new HashMap();
    private final Map<String, Typeface> b = new HashMap();
    private String an = ".ttf";

    public d(Drawable.Callback callback, b bVar) {
        this.u = bVar;
        if (!(callback instanceof View)) {
            u.hc("LottieDrawable must be inside of a view for images to work.");
            this.c = null;
        } else {
            this.c = ((View) callback).getContext().getAssets();
        }
    }

    public void d(b bVar) {
        this.u = bVar;
    }

    public void d(String str) {
        this.an = str;
    }

    public Typeface d(com.bytedance.adsdk.lottie.model.b bVar) {
        this.d.d(bVar.d(), bVar.b());
        Typeface typeface = this.hc.get(this.d);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceD = d(hc(bVar), bVar.b());
        this.hc.put(this.d, typefaceD);
        return typefaceD;
    }

    private Typeface hc(com.bytedance.adsdk.lottie.model.b bVar) {
        String strD = bVar.d();
        Typeface typeface = this.b.get(strD);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceCreateFromAsset = null;
        String strB = bVar.b();
        String strHc = bVar.hc();
        b bVar2 = this.u;
        if (bVar2 != null && (typefaceCreateFromAsset = bVar2.d(strD, strB, strHc)) == null) {
            typefaceCreateFromAsset = this.u.d(strD);
        }
        b bVar3 = this.u;
        if (bVar3 != null && typefaceCreateFromAsset == null) {
            String strHc2 = bVar3.hc(strD, strB, strHc);
            if (strHc2 == null) {
                strHc2 = this.u.hc(strD);
            }
            if (strHc2 != null) {
                try {
                    typefaceCreateFromAsset = Typeface.createFromAsset(this.c, strHc2);
                } catch (Throwable unused) {
                    typefaceCreateFromAsset = Typeface.DEFAULT;
                }
            }
        }
        if (bVar.c() != null) {
            return bVar.c();
        }
        if (typefaceCreateFromAsset == null) {
            try {
                typefaceCreateFromAsset = Typeface.createFromAsset(this.c, "fonts/" + strD + this.an);
            } catch (Throwable unused2) {
                typefaceCreateFromAsset = Typeface.DEFAULT;
            }
        }
        this.b.put(strD, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface d(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
