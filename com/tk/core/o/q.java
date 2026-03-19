package com.tk.core.o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.kuaishou.tk.api.export.sdk.UriUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class q {
    public static void a(Context context, String str, String str2, int i, int i2, com.tk.core.a.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("https://") || str.startsWith("http://")) {
            a(str, i, i2, aVar);
        } else {
            b(context, str, str2, i, i2, aVar);
        }
    }

    public static void a(String str, int i, int i2, final com.tk.core.a.a aVar) {
        com.tk.core.a.l lVarOQ = com.tk.core.a.oP().oQ();
        if (lVarOQ == null) {
            return;
        }
        lVarOQ.a(str, i, i2, new com.tk.core.a.a() { // from class: com.tk.core.o.q.1
            @Override // com.tk.core.a.a
            public final void a(Bitmap bitmap) {
                com.tk.core.a.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(bitmap);
                }
            }
        });
    }

    private static void b(final Context context, final String str, final String str2, final int i, final int i2, final com.tk.core.a.a aVar) {
        p.execute(new Runnable() { // from class: com.tk.core.o.q.2
            @Override // java.lang.Runnable
            public final void run() {
                Bitmap bitmapC = q.c(context, str, str2, i, i2);
                com.tk.core.a.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(bitmapC);
                }
            }
        });
    }

    public static Bitmap c(Context context, String str, String str2, int i, int i2) {
        return d(context, str, str2, i, i2);
    }

    private static Bitmap d(Context context, String str, String str2, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (str.startsWith(UriUtils.ASSET_PREFIX)) {
                return j(context, str);
            }
            if (str.startsWith(UriUtils.FILE_PREFIX)) {
                return d(str, i, i2);
            }
            if (str.startsWith(UriUtils.BUNDLE_PREFIX)) {
                return a(str, str2, i, i2);
            }
            return a(str, str2, i, i2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Bitmap j(Context context, String str) {
        Drawable drawable;
        Bitmap bitmapC;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            drawable = resources.getDrawable(z.b(getResName(str), "drawable", null));
        } catch (Throwable th) {
            com.tk.core.i.a.b("getDrawableFromDrawable", th);
            drawable = null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            bitmapC = b.c(context.getAssets().open(UriUtils.getMappedPath(str, UriUtils.ASSET_PREFIX)));
        } catch (Throwable th2) {
            com.tk.core.i.a.b("getDrawableFromRes", th2);
            bitmapC = null;
        }
        if (bitmapC != null) {
            return bitmapC;
        }
        try {
            return b.c(resources.openRawResource(z.b(getResName(str), "raw", null)));
        } catch (Throwable th3) {
            com.tk.core.i.a.b("getDrawableFromRaw", th3);
            return bitmapC;
        }
    }

    private static String getResName(String str) {
        int iLastIndexOf;
        String mappedPath = UriUtils.getMappedPath(str, UriUtils.ASSET_PREFIX);
        return (mappedPath == null || mappedPath.length() <= 0 || -1 == (iLastIndexOf = mappedPath.lastIndexOf("."))) ? mappedPath : mappedPath.substring(0, iLastIndexOf);
    }

    private static Bitmap a(String str, String str2, int i, int i2) {
        String mappedPath = UriUtils.getMappedPath(str, UriUtils.BUNDLE_PREFIX);
        if (TextUtils.isEmpty(mappedPath)) {
            return null;
        }
        if (!TextUtils.isEmpty(str2)) {
            mappedPath = str2.concat(mappedPath);
        }
        if (f.cS(mappedPath)) {
            return b.a(mappedPath, i, i2, true);
        }
        return null;
    }

    private static Bitmap d(String str, int i, int i2) {
        if (f.cS(str)) {
            return null;
        }
        String mappedPath = UriUtils.getMappedPath(str, UriUtils.FILE_PREFIX);
        if (f.cS(mappedPath)) {
            return b.a(mappedPath, i, i2, true);
        }
        return null;
    }
}
