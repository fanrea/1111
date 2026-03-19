package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.JsonReader;
import com.bytedance.adsdk.lottie.c.v;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    private static final Map<String, uo<an>> d = new HashMap();
    private static final Set<Object> hc = new HashSet();
    private static final byte[] b = {80, 75, 3, 4};

    public static uo<an> d(Context context, String str) {
        return d(context, str, "url_" + str);
    }

    public static uo<an> d(final Context context, final String str, final String str2) {
        return d(str2, new Callable<mq<an>>() { // from class: com.bytedance.adsdk.lottie.h.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public mq<an> call() throws Exception {
                mq<an> mqVarD = u.d(context).d(context, str, str2);
                if (str2 != null && mqVarD.d() != null) {
                    com.bytedance.adsdk.lottie.model.u.d().d(str2, mqVarD.d());
                }
                return mqVarD;
            }
        });
    }

    public static uo<an> hc(Context context, String str) {
        return hc(context, str, "asset_" + str);
    }

    public static uo<an> hc(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return d(str2, new Callable<mq<an>>() { // from class: com.bytedance.adsdk.lottie.h.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public mq<an> call() throws Exception {
                return h.b(applicationContext, str, str2);
            }
        });
    }

    public static mq<an> b(Context context, String str) {
        return b(context, str, "asset_" + str);
    }

    public static mq<an> b(Context context, String str, String str2) {
        try {
            if (!str.endsWith(".zip") && !str.endsWith(".lottie")) {
                return hc(context.getAssets().open(str), str2);
            }
            return d(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e) {
            return new mq<>((Throwable) e);
        }
    }

    public static uo<an> d(Context context, int i) {
        return d(context, i, b(context, i));
    }

    public static uo<an> d(Context context, final int i, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return d(str, new Callable<mq<an>>() { // from class: com.bytedance.adsdk.lottie.h.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public mq<an> call() throws Exception {
                Context context2 = (Context) weakReference.get();
                if (context2 == null) {
                    context2 = applicationContext;
                }
                return h.hc(context2, i, str);
            }
        });
    }

    public static mq<an> hc(Context context, int i) {
        return hc(context, i, b(context, i));
    }

    public static mq<an> hc(Context context, int i, String str) {
        try {
            return hc(context.getResources().openRawResource(i), b(context, i));
        } catch (Resources.NotFoundException e) {
            return new mq<>((Throwable) e);
        }
    }

    private static String b(Context context, int i) {
        return "rawRes" + (d(context) ? "_night_" : "_day_") + i;
    }

    private static boolean d(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static uo<an> d(final InputStream inputStream, final String str) {
        return d(str, new Callable<mq<an>>() { // from class: com.bytedance.adsdk.lottie.h.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public mq<an> call() throws Exception {
                return h.hc(inputStream, str);
            }
        });
    }

    public static mq<an> hc(InputStream inputStream, String str) {
        return d(inputStream, str, true);
    }

    private static mq<an> d(InputStream inputStream, String str, boolean z) throws IOException {
        try {
            return d(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.bytedance.adsdk.lottie.u.tt.d(inputStream);
            }
        }
    }

    public static mq<an> d(JsonReader jsonReader, String str) {
        return d(jsonReader, str, true);
    }

    private static mq<an> d(JsonReader jsonReader, String str, boolean z) throws IOException {
        try {
            try {
                an anVarD = v.d(jsonReader);
                com.bytedance.adsdk.lottie.model.u.d().d(str, anVarD);
                mq<an> mqVar = new mq<>(anVarD);
                if (z) {
                    d(jsonReader);
                }
                return mqVar;
            } catch (Exception e) {
                mq<an> mqVar2 = new mq<>(e);
                if (z) {
                    d(jsonReader);
                }
                return mqVar2;
            }
        } catch (Throwable th) {
            if (z) {
                d(jsonReader);
            }
            throw th;
        }
    }

    public static void d(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static mq<an> d(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return hc(context, zipInputStream, str);
        } finally {
            com.bytedance.adsdk.lottie.u.tt.d(zipInputStream);
        }
    }

    private static mq<an> hc(Context context, ZipInputStream zipInputStream, String str) throws IOException {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            an anVarD = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().endsWith(".json")) {
                    anVarD = d(new JsonReader(new InputStreamReader(zipInputStream)), (String) null, false).d();
                } else if (name.endsWith(PictureMimeType.PNG) || name.endsWith(PictureMimeType.WEBP) || name.endsWith(PictureMimeType.JPG) || name.endsWith(".jpeg")) {
                    if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] strArrSplit = name.split("/");
                        map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                    }
                } else if (name.endsWith(".ttf") || name.endsWith(".otf")) {
                    if (name.contains("../")) {
                        zipInputStream.closeEntry();
                        nextEntry = zipInputStream.getNextEntry();
                    } else {
                        String[] strArrSplit2 = name.split("/");
                        String str2 = strArrSplit2[strArrSplit2.length - 1];
                        String str3 = str2.split("\\.")[0];
                        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.hc.hc(context), str2);
                        new FileOutputStream(file);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int i = zipInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, i);
                                }
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } finally {
                            }
                        } catch (Throwable th) {
                            com.bytedance.adsdk.lottie.u.u.d("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th);
                        }
                        Typeface typefaceCreateFromFile = Typeface.createFromFile(file);
                        if (!file.delete()) {
                            com.bytedance.adsdk.lottie.u.u.hc("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                        }
                        map2.put(str3, typefaceCreateFromFile);
                    }
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (anVarD == null) {
                return new mq<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                tt ttVarD = d(anVarD, (String) entry.getKey());
                if (ttVarD != null) {
                    ttVarD.d(com.bytedance.adsdk.lottie.u.tt.d((Bitmap) entry.getValue(), ttVarD.d(), ttVarD.hc()));
                }
            }
            for (Map.Entry entry2 : map2.entrySet()) {
                boolean z = false;
                for (com.bytedance.adsdk.lottie.model.b bVar : anVarD.cb().values()) {
                    if (bVar.d().equals(entry2.getKey())) {
                        bVar.d((Typeface) entry2.getValue());
                        z = true;
                    }
                }
                if (!z) {
                    com.bytedance.adsdk.lottie.u.u.hc("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (map.isEmpty()) {
                Iterator<Map.Entry<String, tt>> it = anVarD.w().entrySet().iterator();
                while (it.hasNext()) {
                    tt value = it.next().getValue();
                    if (value == null) {
                        return null;
                    }
                    String strMq = value.mq();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (strMq.startsWith("data:") && strMq.indexOf("base64,") > 0) {
                        try {
                            byte[] bArrDecode = Base64.decode(strMq.substring(strMq.indexOf(44) + 1), 0);
                            value.d(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
                        } catch (IllegalArgumentException e) {
                            com.bytedance.adsdk.lottie.u.u.d("data URL did not have correct base64 format.", e);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry<String, tt> entry3 : anVarD.w().entrySet()) {
                if (entry3.getValue().k() == null) {
                    return new mq<>((Throwable) new IllegalStateException("There is no image for " + entry3.getValue().mq()));
                }
            }
            if (str != null) {
                com.bytedance.adsdk.lottie.model.u.d().d(str, anVarD);
            }
            return new mq<>(anVarD);
        } catch (IOException e2) {
            return new mq<>((Throwable) e2);
        }
    }

    private static tt d(an anVar, String str) {
        for (tt ttVar : anVar.w().values()) {
            if (ttVar.mq().equals(str)) {
                return ttVar;
            }
        }
        return null;
    }

    private static uo<an> d(final String str, Callable<mq<an>> callable) {
        final an anVarD = str == null ? null : com.bytedance.adsdk.lottie.model.u.d().d(str);
        if (anVarD != null) {
            return new uo<>(new Callable<mq<an>>() { // from class: com.bytedance.adsdk.lottie.h.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public mq<an> call() throws Exception {
                    return new mq<>(anVarD);
                }
            });
        }
        if (str != null) {
            Map<String, uo<an>> map = d;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        uo<an> uoVar = new uo<>(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            uoVar.d(new tc<an>() { // from class: com.bytedance.adsdk.lottie.h.2
                @Override // com.bytedance.adsdk.lottie.tc
                public void d(an anVar) {
                    h.d.remove(str);
                    atomicBoolean.set(true);
                    if (h.d.size() == 0) {
                        h.hc(true);
                    }
                }
            });
            uoVar.b(new tc<Throwable>() { // from class: com.bytedance.adsdk.lottie.h.3
                @Override // com.bytedance.adsdk.lottie.tc
                public void d(Throwable th) {
                    h.d.remove(str);
                    atomicBoolean.set(true);
                    if (h.d.size() == 0) {
                        h.hc(true);
                    }
                }
            });
            if (!atomicBoolean.get()) {
                Map<String, uo<an>> map2 = d;
                map2.put(str, uoVar);
                if (map2.size() == 1) {
                    hc(false);
                }
            }
        }
        return uoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(boolean z) {
        ArrayList arrayList = new ArrayList(hc);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
    }
}
