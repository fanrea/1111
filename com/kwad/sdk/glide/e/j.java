package com.kwad.sdk.glide.e;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import com.kwad.sdk.glide.load.c.l;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class j {
    private static final char[] car = "0123456789abcdef".toCharArray();
    private static final char[] cas = new char[64];

    private static boolean gs(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static int hashCode(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static String n(byte[] bArr) {
        String strA;
        char[] cArr = cas;
        synchronized (cArr) {
            strA = a(bArr, cArr);
        }
        return strA;
    }

    private static String a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = car;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static int m(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
        }
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static int i(int i, int i2, Bitmap.Config config) {
        return i * i2 * e(config);
    }

    private static int e(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = AnonymousClass1.bVf[config.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 4 : 8;
    }

    /* renamed from: com.kwad.sdk.glide.e.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] bVf;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            bVf = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                bVf[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                bVf[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                bVf[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                bVf[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static boolean Y(int i, int i2) {
        return gs(i) && gs(i2);
    }

    public static void ajB() {
        if (!ajD()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static void ajC() {
        if (!ajE()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    private static boolean ajD() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean ajE() {
        return !ajD();
    }

    public static <T> Queue<T> gt(int i) {
        return new ArrayDeque(i);
    }

    public static <T> List<T> c(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj instanceof l) {
            return ((l) obj).ahE();
        }
        return obj.equals(obj2);
    }

    public static int hashCode(int i) {
        return hashCode(i, 17);
    }

    public static int hashCode(float f) {
        return a(f, 17);
    }

    private static int a(float f, int i) {
        return hashCode(Float.floatToIntBits(f), 17);
    }

    public static int a(Object obj, int i) {
        return hashCode(obj == null ? 0 : obj.hashCode(), i);
    }

    public static int m(boolean z, int i) {
        return hashCode(z ? 1 : 0, i);
    }
}
