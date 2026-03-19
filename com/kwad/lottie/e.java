package com.kwad.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.util.JsonReader;
import android.util.Log;
import com.kwad.lottie.c.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private static final Map<String, k<d>> bjU = new HashMap();

    public static k<d> u(Context context, String str) {
        return com.kwad.lottie.network.b.x(context, str);
    }

    public static k<d> v(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return a(str, new Callable<j<d>>() { // from class: com.kwad.lottie.e.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: Ql, reason: merged with bridge method [inline-methods] */
            public j<d> call() {
                return e.w(applicationContext, str);
            }
        });
    }

    public static j<d> w(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                return a(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return a(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new j<>((Throwable) e);
        }
    }

    public static k<d> h(Context context, final int i) {
        final Context applicationContext = context.getApplicationContext();
        return a(dV(i), new Callable<j<d>>() { // from class: com.kwad.lottie.e.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: Ql, reason: merged with bridge method [inline-methods] */
            public j<d> call() {
                return e.i(applicationContext, i);
            }
        });
    }

    public static j<d> i(Context context, int i) {
        try {
            return a(context.getResources().openRawResource(i), dV(i));
        } catch (Resources.NotFoundException e) {
            return new j<>((Throwable) e);
        }
    }

    private static String dV(int i) {
        return "rawRes_" + i;
    }

    public static j<d> a(InputStream inputStream, String str) {
        return a(inputStream, str, true);
    }

    private static j<d> a(InputStream inputStream, String str, boolean z) {
        try {
            return c(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            }
        }
    }

    public static k<d> b(final JsonReader jsonReader, final String str) {
        return a(str, new Callable<j<d>>() { // from class: com.kwad.lottie.e.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: Ql, reason: merged with bridge method [inline-methods] */
            public j<d> call() {
                return e.c(jsonReader, str);
            }
        });
    }

    public static j<d> c(JsonReader jsonReader, String str) {
        try {
            d dVarG = t.g(jsonReader);
            com.kwad.lottie.model.g.Ri().a(str, dVarG);
            return new j<>(dVarG);
        } catch (Exception e) {
            return new j<>((Throwable) e);
        }
    }

    public static j<d> a(ZipInputStream zipInputStream, String str) {
        try {
            return b(zipInputStream, str);
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054 A[Catch: IOException -> 0x00ea, TryCatch #0 {IOException -> 0x00ea, blocks: (B:3:0x0005, B:5:0x000c, B:7:0x0018, B:9:0x0020, B:11:0x0028, B:16:0x0057, B:12:0x0035, B:14:0x003d, B:15:0x0054), top: B:39:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.kwad.lottie.j<com.kwad.lottie.d> b(java.util.zip.ZipInputStream r5, java.lang.String r6) throws java.io.IOException {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.zip.ZipEntry r1 = r5.getNextEntry()     // Catch: java.io.IOException -> Lea
            r2 = 0
        La:
            if (r1 == 0) goto L5c
            java.lang.String r3 = r1.getName()     // Catch: java.io.IOException -> Lea
            java.lang.String r4 = "../"
            boolean r4 = r3.contains(r4)     // Catch: java.io.IOException -> Lea
            if (r4 != 0) goto La
            java.lang.String r4 = "__MACOSX"
            boolean r4 = r3.contains(r4)     // Catch: java.io.IOException -> Lea
            if (r4 != 0) goto L54
            java.lang.String r4 = ".json"
            boolean r4 = r3.contains(r4)     // Catch: java.io.IOException -> Lea
            if (r4 == 0) goto L35
            r1 = 0
            com.kwad.lottie.j r1 = a(r5, r6, r1)     // Catch: java.io.IOException -> Lea
            java.lang.Object r1 = r1.getValue()     // Catch: java.io.IOException -> Lea
            com.kwad.lottie.d r1 = (com.kwad.lottie.d) r1     // Catch: java.io.IOException -> Lea
            r2 = r1
            goto L57
        L35:
            java.lang.String r4 = ".png"
            boolean r3 = r3.contains(r4)     // Catch: java.io.IOException -> Lea
            if (r3 == 0) goto L54
            java.lang.String r1 = r1.getName()     // Catch: java.io.IOException -> Lea
            java.lang.String r3 = "/"
            java.lang.String[] r1 = r1.split(r3)     // Catch: java.io.IOException -> Lea
            int r3 = r1.length     // Catch: java.io.IOException -> Lea
            int r3 = r3 + (-1)
            r1 = r1[r3]     // Catch: java.io.IOException -> Lea
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch: java.io.IOException -> Lea
            r0.put(r1, r3)     // Catch: java.io.IOException -> Lea
            goto L57
        L54:
            r5.closeEntry()     // Catch: java.io.IOException -> Lea
        L57:
            java.util.zip.ZipEntry r1 = r5.getNextEntry()     // Catch: java.io.IOException -> Lea
            goto La
        L5c:
            if (r2 != 0) goto L6b
            com.kwad.lottie.j r5 = new com.kwad.lottie.j
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Unable to parse composition"
            r6.<init>(r0)
            r5.<init>(r6)
            return r5
        L6b:
            java.util.Set r5 = r0.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L73:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L95
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            com.kwad.lottie.g r1 = a(r2, r1)
            if (r1 == 0) goto L73
            java.lang.Object r0 = r0.getValue()
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r1.setBitmap(r0)
            goto L73
        L95:
            java.util.Map r5 = r2.Qj()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        La1:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto Ldd
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getValue()
            com.kwad.lottie.g r1 = (com.kwad.lottie.g) r1
            android.graphics.Bitmap r1 = r1.getBitmap()
            if (r1 != 0) goto La1
            com.kwad.lottie.j r5 = new com.kwad.lottie.j
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "There is no image for "
            r1.<init>(r2)
            java.lang.Object r0 = r0.getValue()
            com.kwad.lottie.g r0 = (com.kwad.lottie.g) r0
            java.lang.String r0 = r0.getFileName()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            r6.<init>(r0)
            r5.<init>(r6)
            return r5
        Ldd:
            com.kwad.lottie.model.g r5 = com.kwad.lottie.model.g.Ri()
            r5.a(r6, r2)
            com.kwad.lottie.j r5 = new com.kwad.lottie.j
            r5.<init>(r2)
            return r5
        Lea:
            r5 = move-exception
            com.kwad.lottie.j r6 = new com.kwad.lottie.j
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.lottie.e.b(java.util.zip.ZipInputStream, java.lang.String):com.kwad.lottie.j");
    }

    private static g a(d dVar, String str) {
        for (g gVar : dVar.Qj().values()) {
            if (gVar.getFileName().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    private static k<d> a(final String str, Callable<j<d>> callable) {
        final d dVarDr = com.kwad.lottie.model.g.Ri().dr(str);
        if (dVarDr != null) {
            return new k<>(new Callable<j<d>>() { // from class: com.kwad.lottie.e.5
                /* JADX INFO: Access modifiers changed from: private */
                @Override // java.util.concurrent.Callable
                /* renamed from: Ql, reason: merged with bridge method [inline-methods] */
                public j<d> call() {
                    Log.d("Gabe", "call\treturning from cache");
                    return new j<>(dVarDr);
                }
            });
        }
        Map<String, k<d>> map = bjU;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        k<d> kVar = new k<>(callable);
        kVar.a(new h<d>() { // from class: com.kwad.lottie.e.6
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.lottie.h
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(d dVar) {
                if (str != null) {
                    com.kwad.lottie.model.g.Ri().a(str, dVar);
                }
                e.bjU.remove(str);
            }
        });
        kVar.c(new h<Throwable>() { // from class: com.kwad.lottie.e.2
            @Override // com.kwad.lottie.h
            public final /* synthetic */ void onResult(Throwable th) {
                Qm();
            }

            private void Qm() {
                e.bjU.remove(str);
            }
        });
        map.put(str, kVar);
        return kVar;
    }
}
