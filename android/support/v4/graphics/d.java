package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.b.b;
import android.support.v4.content.a.b;
import android.support.v4.d.k;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class d extends g {
    private static final Class ai;
    private static final Constructor aj;
    private static final Method ak;
    private static final Method al;

    d() {
    }

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        aj = constructor;
        ai = cls;
        ak = method2;
        al = method;
    }

    public static boolean r() {
        if (ak == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return ak != null;
    }

    private static Object s() {
        try {
            return aj.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) ak.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface c(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) ai, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) al.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.support.v4.graphics.g
    public final Typeface a(Context context, CancellationSignal cancellationSignal, b.C0004b[] c0004bArr, int i) throws IOException {
        Object objS = s();
        k kVar = new k();
        for (b.C0004b c0004b : c0004bArr) {
            Uri uri = c0004b.getUri();
            ByteBuffer byteBufferA = (ByteBuffer) kVar.get(uri);
            if (byteBufferA == null) {
                byteBufferA = h.a(context, cancellationSignal, uri);
                kVar.put(uri, byteBufferA);
            }
            if (!a(objS, byteBufferA, c0004b.getTtcIndex(), c0004b.getWeight(), c0004b.isItalic())) {
                return null;
            }
        }
        return Typeface.create(c(objS), i);
    }

    @Override // android.support.v4.graphics.g
    public final Typeface a(Context context, b.C0007b c0007b, Resources resources, int i) {
        Object objS = s();
        for (b.c cVar : c0007b.n()) {
            ByteBuffer byteBufferA = h.a(context, resources, cVar.getResourceId());
            if (byteBufferA == null || !a(objS, byteBufferA, cVar.getTtcIndex(), cVar.getWeight(), cVar.isItalic())) {
                return null;
            }
        }
        return c(objS);
    }
}
