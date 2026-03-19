package com.tachikoma.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.util.JsonReader;
import com.tachikoma.lottie.c.t;
import com.tachikoma.lottie.network.FileExtension;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f {
    private static final Map<String, m<e>> GY = new HashMap();

    static /* synthetic */ l b(JsonReader jsonReader, String str, boolean z) {
        return a(jsonReader, str, false);
    }

    public static m<e> b(final Context context, final String str) {
        return a("url_" + str, new Callable<l<e>>() { // from class: com.tachikoma.lottie.f.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: jB, reason: merged with bridge method [inline-methods] */
            public l<e> call() {
                return com.tachikoma.lottie.network.b.f(context, str);
            }
        });
    }

    public static m<e> c(Context context, final String str) {
        final Context applicationContext = context.getApplicationContext();
        return a(str, new Callable<l<e>>() { // from class: com.tachikoma.lottie.f.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: jB, reason: merged with bridge method [inline-methods] */
            public l<e> call() {
                return f.d(applicationContext, str);
            }
        });
    }

    public static l<e> d(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            if (str.endsWith(".zip")) {
                return b(new ZipInputStream(context.getAssets().open(str)), str2);
            }
            return a(context.getAssets().open(str), str2);
        } catch (IOException e) {
            return new l<>((Throwable) e);
        }
    }

    public static m<e> o(Context context, final int i) {
        final Context applicationContext = context.getApplicationContext();
        return a(cw(i), new Callable<l<e>>() { // from class: com.tachikoma.lottie.f.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: jB, reason: merged with bridge method [inline-methods] */
            public l<e> call() {
                return f.p(applicationContext, i);
            }
        });
    }

    public static l<e> p(Context context, int i) {
        try {
            return a(context.getResources().openRawResource(i), cw(i));
        } catch (Resources.NotFoundException e) {
            return new l<>((Throwable) e);
        }
    }

    private static String cw(int i) {
        return "rawRes_" + i;
    }

    public static l<e> a(InputStream inputStream, String str) {
        return a(inputStream, str, true);
    }

    private static l<e> a(InputStream inputStream, String str, boolean z) throws Throwable {
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
        } catch (Throwable th) {
            th = th;
            inputStreamReader = null;
        }
        try {
            l<e> lVarC = c(new JsonReader(inputStreamReader), str);
            com.tachikoma.lottie.d.f.a(inputStream);
            com.tachikoma.lottie.d.f.a(inputStreamReader);
            return lVarC;
        } catch (Throwable th2) {
            th = th2;
            com.tachikoma.lottie.d.f.a(inputStream);
            com.tachikoma.lottie.d.f.a(inputStreamReader);
            throw th;
        }
    }

    public static m<e> b(final JsonReader jsonReader, final String str) {
        return a(str, new Callable<l<e>>() { // from class: com.tachikoma.lottie.f.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: jB, reason: merged with bridge method [inline-methods] */
            public l<e> call() {
                return f.c(jsonReader, str);
            }
        });
    }

    public static l<e> c(JsonReader jsonReader, String str) {
        return a(jsonReader, str, true);
    }

    private static l<e> a(JsonReader jsonReader, String str, boolean z) throws IOException {
        try {
            try {
                e eVarG = t.g(jsonReader);
                com.tachikoma.lottie.model.f.kA().a(str, eVarG);
                l<e> lVar = new l<>(eVarG);
                if (z) {
                    com.tachikoma.lottie.d.f.a(jsonReader);
                }
                return lVar;
            } catch (Exception e) {
                l<e> lVar2 = new l<>(e);
                if (z) {
                    com.tachikoma.lottie.d.f.a(jsonReader);
                }
                return lVar2;
            }
        } catch (Throwable th) {
            if (z) {
                com.tachikoma.lottie.d.f.a(jsonReader);
            }
            throw th;
        }
    }

    private static m<e> a(final ZipInputStream zipInputStream, final String str) {
        return a(str, new Callable<l<e>>() { // from class: com.tachikoma.lottie.f.6
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: jB, reason: merged with bridge method [inline-methods] */
            public l<e> call() {
                return f.b(zipInputStream, str);
            }
        });
    }

    public static l<e> b(ZipInputStream zipInputStream, String str) {
        try {
            return c(zipInputStream, str);
        } finally {
            com.tachikoma.lottie.d.f.a(zipInputStream);
        }
    }

    public static m<e> W(final String str) {
        m<e> mVarA;
        try {
            final String str2 = "file_" + str;
            if (FileExtension.forFile(str) == FileExtension.ZIP) {
                mVarA = a(new ZipInputStream(new FileInputStream(str)), str2);
            } else {
                mVarA = a(str2, new Callable<l<e>>() { // from class: com.tachikoma.lottie.f.7
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.concurrent.Callable
                    /* renamed from: jB, reason: merged with bridge method [inline-methods] */
                    public l<e> call() throws IOException {
                        InputStreamReader inputStreamReader;
                        JsonReader jsonReader;
                        FileInputStream fileInputStream;
                        FileInputStream fileInputStream2 = null;
                        try {
                            fileInputStream = new FileInputStream(str);
                            try {
                                inputStreamReader = new InputStreamReader(fileInputStream);
                                try {
                                    jsonReader = new JsonReader(inputStreamReader);
                                } catch (Throwable th) {
                                    jsonReader = null;
                                    fileInputStream2 = fileInputStream;
                                    th = th;
                                }
                            } catch (Throwable th2) {
                                jsonReader = null;
                                fileInputStream2 = fileInputStream;
                                th = th2;
                                inputStreamReader = null;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStreamReader = null;
                            jsonReader = null;
                        }
                        try {
                            l<e> lVarB = f.b(jsonReader, str2, false);
                            com.tachikoma.lottie.d.f.a(fileInputStream);
                            com.tachikoma.lottie.d.f.a(inputStreamReader);
                            com.tachikoma.lottie.d.f.a(jsonReader);
                            return lVarB;
                        } catch (Throwable th4) {
                            th = th4;
                            fileInputStream2 = fileInputStream;
                            try {
                                return new l<>(th);
                            } finally {
                                com.tachikoma.lottie.d.f.a(fileInputStream2);
                                com.tachikoma.lottie.d.f.a(inputStreamReader);
                                com.tachikoma.lottie.d.f.a(jsonReader);
                            }
                        }
                    }
                });
            }
            return mVarA;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006b A[Catch: IOException -> 0x010c, TryCatch #0 {IOException -> 0x010c, blocks: (B:3:0x0005, B:5:0x000d, B:7:0x0019, B:9:0x0025, B:16:0x006e, B:10:0x003c, B:12:0x0048, B:14:0x0054, B:15:0x006b), top: B:39:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tachikoma.lottie.l<com.tachikoma.lottie.e> c(java.util.zip.ZipInputStream r6, java.lang.String r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tachikoma.lottie.f.c(java.util.zip.ZipInputStream, java.lang.String):com.tachikoma.lottie.l");
    }

    private static h a(e eVar, String str) {
        for (h hVar : eVar.jz().values()) {
            if (hVar.getFileName().equals(str)) {
                return hVar;
            }
        }
        return null;
    }

    private static m<e> a(final String str, Callable<l<e>> callable) {
        final e eVarAf = str == null ? null : com.tachikoma.lottie.model.f.kA().af(str);
        if (eVarAf != null) {
            return new m<>(new Callable<l<e>>() { // from class: com.tachikoma.lottie.f.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // java.util.concurrent.Callable
                /* renamed from: jB, reason: merged with bridge method [inline-methods] */
                public l<e> call() {
                    return new l<>(eVarAf);
                }
            });
        }
        if (str != null && GY.containsKey(str)) {
            return GY.get(str);
        }
        m<e> mVar = new m<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            mVar.a(new i() { // from class: com.tachikoma.lottie.-$$Lambda$f$8KZMD2LLkJp94bO7emTpXsgxfds
                @Override // com.tachikoma.lottie.i
                public final void onResult(Object obj) {
                    f.a(str, atomicBoolean, (e) obj);
                }
            });
            mVar.c(new i() { // from class: com.tachikoma.lottie.-$$Lambda$f$j7S6TnmjxZHKjKZ3M9NjBUXbQRk
                @Override // com.tachikoma.lottie.i
                public final void onResult(Object obj) {
                    f.a(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                GY.put(str, mVar);
            }
        }
        return mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, AtomicBoolean atomicBoolean, e eVar) {
        com.tachikoma.lottie.model.f.kA().a(str, eVar);
        GY.remove(str);
        atomicBoolean.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, AtomicBoolean atomicBoolean, Throwable th) {
        GY.remove(str);
        atomicBoolean.set(true);
    }
}
