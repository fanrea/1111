package com.tk.core.o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.kuaishou.tk.api.export.sdk.Callback;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class h {
    /* JADX INFO: Access modifiers changed from: private */
    public static String cT(String str) {
        return str == null ? "" : str;
    }

    public static void a(Context context, String str, String str2, String str3, int i, int i2, final Callback<Bitmap> callback) {
        if (TextUtils.isEmpty(str)) {
            callback.error(new Throwable("uri is empty"));
            return;
        }
        Bitmap bitmapCZ = w.sR().cZ(str);
        if (bitmapCZ != null && !bitmapCZ.isRecycled()) {
            com.tk.core.i.a.z("ImageLoadModule", "loadbitmap from cache, uri is " + cT(str));
            callback.callback(bitmapCZ);
            return;
        }
        a(context, str, str3, 0, 0, new Callback<Bitmap>() { // from class: com.tk.core.o.h.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kuaishou.tk.api.export.sdk.Callback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void callback(Bitmap bitmap) {
                h.a((Callback<Bitmap>) callback, bitmap);
            }

            @Override // com.kuaishou.tk.api.export.sdk.Callback
            public final void error(Throwable th) {
                h.a((Callback<?>) callback, th.toString());
            }
        });
    }

    public static void b(final Context context, String str, String str2, String str3, int i, int i2, final Callback<BitmapDrawable> callback) {
        if (TextUtils.isEmpty(str)) {
            a((Callback<?>) callback, "uri is empty");
            return;
        }
        Bitmap bitmapCZ = w.sR().cZ(str);
        if (bitmapCZ != null && !bitmapCZ.isRecycled()) {
            com.tk.core.i.a.z("ImageLoadModule", "loadbitmap from cache, uri is " + cT(str));
            a(callback, new BitmapDrawable(context.getResources(), bitmapCZ));
            return;
        }
        a(context, str, str3, i, i2, new Callback<Bitmap>() { // from class: com.tk.core.o.h.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kuaishou.tk.api.export.sdk.Callback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void callback(Bitmap bitmap) {
                h.a((Callback<BitmapDrawable>) callback, new BitmapDrawable(context.getResources(), bitmap));
            }

            @Override // com.kuaishou.tk.api.export.sdk.Callback
            public final void error(Throwable th) {
                h.a((Callback<?>) callback, th.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final Callback<?> callback, final String str) {
        if (callback == null) {
            return;
        }
        if (ac.sX()) {
            callback.error(new Throwable(str));
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.core.o.h.3
                @Override // java.lang.Runnable
                public final void run() {
                    callback.error(new Throwable(str));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void a(final Callback<T> callback, final T t) {
        if (callback == null) {
            return;
        }
        if (ac.sX()) {
            callback.callback(t);
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.core.o.h.4
                @Override // java.lang.Runnable
                public final void run() {
                    callback.callback(t);
                }
            });
        }
    }

    public static void a(final Context context, final List<String> list, String str, String str2, int i, int i2, final Callback<List<BitmapDrawable>> callback) {
        if (list == null || list.isEmpty()) {
            callback.error(new Throwable("urilist is null or empty"));
            return;
        }
        final ArrayList arrayList = new ArrayList();
        final int[] iArr = {0};
        for (int i3 = 0; i3 < list.size(); i3++) {
            a(context, list.get(i3), str2, 0, 0, new Callback<Bitmap>() { // from class: com.tk.core.o.h.5
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kuaishou.tk.api.export.sdk.Callback
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void callback(Bitmap bitmap) {
                    arrayList.add(new BitmapDrawable(context.getResources(), bitmap));
                    if (arrayList.size() == list.size() - iArr[0]) {
                        callback.callback(arrayList);
                    }
                }

                @Override // com.kuaishou.tk.api.export.sdk.Callback
                public final void error(Throwable th) {
                    callback.error(th);
                    int[] iArr2 = iArr;
                    iArr2[0] = iArr2[0] + 1;
                }
            });
        }
    }

    private static void a(Context context, final String str, String str2, int i, int i2, final Callback<Bitmap> callback) {
        if (TextUtils.isEmpty(str)) {
            callback.error(new Throwable("uri is empty"));
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            q.a(str, i, i2, new com.tk.core.a.a() { // from class: com.tk.core.o.h.6
                @Override // com.tk.core.a.a
                public final void a(Bitmap bitmap) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        w.sR().b(str, bitmap);
                        Callback callback2 = callback;
                        if (callback2 != null) {
                            callback2.callback(bitmap);
                            return;
                        }
                        return;
                    }
                    Callback callback3 = callback;
                    if (callback3 != null) {
                        callback3.error(new Throwable("bitmap is recycled " + h.cT(str)));
                    }
                    com.tk.core.i.a.a("ImageLoadModule", "load bitmap fail, uri is " + h.cT(str), null);
                }
            });
        } else {
            b(context, str, str2, i, i2, callback);
        }
    }

    private static void b(final Context context, final String str, final String str2, final int i, final int i2, final Callback<Bitmap> callback) {
        Bitmap bitmapCZ = w.sR().cZ(str);
        if (bitmapCZ != null && !bitmapCZ.isRecycled()) {
            a(callback, bitmapCZ);
        } else {
            p.execute(new Runnable() { // from class: com.tk.core.o.h.7
                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmapA = h.a(context, str, str2, i, i2);
                    if (bitmapA == null) {
                        com.tk.core.i.a.a("ImageLoadModule", "getLocalBitmap null for " + str, null);
                        h.a((Callback<?>) callback, "getPresetBitmapInner is null, uri is " + h.cT(str));
                        return;
                    }
                    if (!bitmapA.isRecycled()) {
                        w.sR().b(str, bitmapA);
                        h.a((Callback<Bitmap>) callback, bitmapA);
                    } else {
                        com.tk.core.i.a.a("ImageLoadModule", "getLocalBitmap bitmap is recycled for " + str, null);
                        h.a((Callback<?>) callback, "bitmap is recycled");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap a(Context context, String str, String str2, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            int iIndexOf = str.indexOf(58);
            char c = 65535;
            if (iIndexOf == -1) {
                return a(str, str2, i, i2);
            }
            String str3 = str.substring(0, iIndexOf) + "://";
            int iHashCode = str3.hashCode();
            if (iHashCode != -855037794) {
                if (iHashCode != -373240150) {
                    if (iHashCode == 1443157936 && str3.equals("data://")) {
                        c = 2;
                    }
                } else if (str3.equals(UriUtils.ASSET_PREFIX)) {
                    c = 0;
                }
            } else if (str3.equals(UriUtils.FILE_PREFIX)) {
                c = 1;
            }
            if (c == 0) {
                return j(context, str);
            }
            if (c == 1) {
                return d(str, i, i2);
            }
            if (c == 2) {
                return b.cR(str);
            }
            return a(str, str2, i, i2);
        } catch (Throwable th) {
            com.tk.core.i.a.a("ImageLoadModule", "getPresetBitmapInner fail", th);
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
        } catch (Throwable unused) {
            drawable = null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            bitmapC = b.c(context.getAssets().open(y.getMappedPath(str, UriUtils.ASSET_PREFIX)));
        } catch (Throwable unused2) {
            bitmapC = null;
        }
        if (bitmapC != null) {
            return bitmapC;
        }
        try {
            return b.c(resources.openRawResource(z.b(getResName(str), "raw", null)));
        } catch (Throwable unused3) {
            return bitmapC;
        }
    }

    private static String getResName(String str) {
        int iLastIndexOf;
        String mappedPath = y.getMappedPath(str, UriUtils.ASSET_PREFIX);
        return (mappedPath == null || mappedPath.length() <= 0 || -1 == (iLastIndexOf = mappedPath.lastIndexOf("."))) ? mappedPath : mappedPath.substring(0, iLastIndexOf);
    }

    private static Bitmap a(String str, String str2, int i, int i2) {
        String mappedPath = y.getMappedPath(str, UriUtils.BUNDLE_PREFIX);
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
        String mappedPath = y.getMappedPath(str, UriUtils.FILE_PREFIX);
        if (f.cS(mappedPath)) {
            return b.a(mappedPath, i, i2, true);
        }
        return null;
    }

    public static void c(Context context, final String str, String str2, String str3, int i, int i2, final Callback<a> callback) {
        if (TextUtils.isEmpty(str)) {
            a((Callback<?>) callback, "uri is empty");
        }
        final Bitmap bitmapCZ = w.sR().cZ(str);
        if (bitmapCZ != null && !bitmapCZ.isRecycled()) {
            com.tk.core.i.a.z("ImageLoadModule", "loadBitmapData from cache, uri is " + cT(str));
            a(callback, new a(str, bitmapCZ));
        }
        a(context, str, str3, 0, 0, new Callback<Bitmap>() { // from class: com.tk.core.o.h.8
            @Override // com.kuaishou.tk.api.export.sdk.Callback
            public final /* synthetic */ void callback(Bitmap bitmap) {
                sF();
            }

            private void sF() {
                h.a((Callback<a>) callback, new a(str, bitmapCZ));
            }

            @Override // com.kuaishou.tk.api.export.sdk.Callback
            public final void error(Throwable th) {
                h.a((Callback<?>) callback, "loadBitmapData error ");
            }
        });
    }

    public static class a {
        public Bitmap HI;
        public String QJ;

        public a(String str, Bitmap bitmap) {
            this.QJ = str;
            this.HI = bitmap;
        }
    }
}
