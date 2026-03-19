package com.component.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.luck.picture.lib.config.PictureMimeType;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class u {
    private static final Map<String, bc<t>> a = new HashMap();
    private static final byte[] b = {80, 75, 3, 4};

    private u() {
    }

    public static void a(Context context) {
        a.clear();
    }

    public static bc<t> a(Context context, int i) {
        return a(context, i, c(context, i));
    }

    public static bc<t> a(Context context, int i, String str) {
        return a(str, new v(new WeakReference(context), context.getApplicationContext(), i, str));
    }

    public static bb<t> b(Context context, int i) {
        return b(context, i, c(context, i));
    }

    public static bb<t> b(Context context, int i, String str) {
        try {
            com.component.lottie.e.i iVarA = com.component.lottie.e.l.a(com.component.lottie.e.l.a(context.getResources().openRawResource(i)));
            if (a(iVarA).booleanValue()) {
                return b(new ZipInputStream(iVarA.j()), str);
            }
            return b(iVarA.j(), str);
        } catch (Resources.NotFoundException e) {
            return new bb<>((Throwable) e);
        }
    }

    private static String c(Context context, int i) {
        return "rawRes" + (b(context) ? "_night_" : "_day_") + i;
    }

    private static boolean b(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static bc<t> a(InputStream inputStream, String str) {
        return a(str, new w(inputStream, str));
    }

    public static bb<t> b(InputStream inputStream, String str) {
        return a(inputStream, str, true);
    }

    private static bb<t> a(InputStream inputStream, String str, boolean z) throws IOException {
        try {
            return b(com.component.lottie.f.a.c.a(com.component.lottie.e.l.a(com.component.lottie.e.l.a(inputStream))), str);
        } finally {
            if (z) {
                com.component.lottie.g.g.a(inputStream);
            }
        }
    }

    @Deprecated
    public static bc<t> a(JSONObject jSONObject, String str) {
        return a(str, new x(jSONObject, str));
    }

    @Deprecated
    public static bb<t> b(JSONObject jSONObject, String str) {
        return b(jSONObject.toString(), str);
    }

    public static bc<t> a(String str, String str2) {
        return a(str2, new y(str, str2));
    }

    public static bb<t> b(String str, String str2) {
        return b(com.component.lottie.f.a.c.a(com.component.lottie.e.l.a(com.component.lottie.e.l.a(new ByteArrayInputStream(str.getBytes())))), str2);
    }

    public static bc<t> a(com.component.lottie.f.a.c cVar, String str) {
        return a(str, new z(cVar, str));
    }

    public static bb<t> b(com.component.lottie.f.a.c cVar, String str) {
        return a(cVar, str, true);
    }

    private static bb<t> a(com.component.lottie.f.a.c cVar, String str, boolean z) throws IOException {
        try {
            try {
                bb<t> bbVar = new bb<>(com.component.lottie.f.y.a(cVar));
                if (z) {
                    com.component.lottie.g.g.a(cVar);
                }
                return bbVar;
            } catch (Exception e) {
                bb<t> bbVar2 = new bb<>(e);
                if (z) {
                    com.component.lottie.g.g.a(cVar);
                }
                return bbVar2;
            }
        } catch (Throwable th) {
            if (z) {
                com.component.lottie.g.g.a(cVar);
            }
            throw th;
        }
    }

    public static bc<t> a(ZipInputStream zipInputStream, String str) {
        return a(str, new aa(zipInputStream, str));
    }

    public static bb<t> b(ZipInputStream zipInputStream, String str) throws IOException {
        try {
            return c(zipInputStream, str);
        } finally {
            com.component.lottie.g.g.a(zipInputStream);
        }
    }

    private static bb<t> c(ZipInputStream zipInputStream, String str) throws IOException {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            t tVarA = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    tVarA = a(com.component.lottie.f.a.c.a(com.component.lottie.e.l.a(com.component.lottie.e.l.a(zipInputStream))), (String) null, false).a();
                } else if (name.contains(PictureMimeType.PNG) || name.contains(PictureMimeType.WEBP) || name.contains(PictureMimeType.JPG) || name.contains(".jpeg")) {
                    map.put(name.split("/")[r0.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (tVarA == null) {
                return new bb<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                ax axVarA = a(tVarA, (String) entry.getKey());
                if (axVarA != null) {
                    axVarA.a(com.component.lottie.g.g.a((Bitmap) entry.getValue(), axVarA.a(), axVarA.b()));
                }
            }
            for (Map.Entry<String, ax> entry2 : tVarA.o().entrySet()) {
                if (entry2.getValue().f() == null) {
                    return new bb<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().d()));
                }
            }
            return new bb<>(tVarA);
        } catch (IOException e) {
            return new bb<>((Throwable) e);
        }
    }

    private static Boolean a(com.component.lottie.e.i iVar) {
        try {
            com.component.lottie.e.i iVarI = iVar.i();
            for (byte b2 : b) {
                if (iVarI.l() != b2) {
                    return false;
                }
            }
            iVarI.close();
            return true;
        } catch (Exception e) {
            com.component.lottie.g.c.c("Failed to check zip file header", e);
            return false;
        } catch (NoSuchMethodError e2) {
            return false;
        }
    }

    private static ax a(t tVar, String str) {
        for (ax axVar : tVar.o().values()) {
            if (axVar.d().equals(str)) {
                return axVar;
            }
        }
        return null;
    }

    private static bc<t> a(String str, Callable<bb<t>> callable) {
        if (str != null && a.containsKey(str)) {
            return a.get(str);
        }
        bc<t> bcVar = new bc<>(callable);
        if (str != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            bcVar.a(new ab(str, atomicBoolean));
            bcVar.c(new ac(str, atomicBoolean));
            if (!atomicBoolean.get()) {
                a.put(str, bcVar);
            }
        }
        return bcVar;
    }
}
