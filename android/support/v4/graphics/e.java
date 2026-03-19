package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.b.b;
import android.support.v4.content.a.b;
import android.util.Log;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class e extends c {
    protected final Class am;
    protected final Constructor an;
    protected final Method ao;
    protected final Method ap;
    protected final Method aq;
    protected final Method ar;
    protected final Method as;

    public e() throws NoSuchMethodException, SecurityException {
        Method methodF;
        Constructor constructorA;
        Method methodB;
        Method methodC;
        Method methodD;
        Method methodE;
        Class cls = null;
        try {
            Class clsU = u();
            constructorA = a(clsU);
            methodB = b(clsU);
            methodC = c(clsU);
            methodD = d(clsU);
            methodE = e(clsU);
            methodF = f(clsU);
            cls = clsU;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            methodF = null;
            constructorA = null;
            methodB = null;
            methodC = null;
            methodD = null;
            methodE = null;
        }
        this.am = cls;
        this.an = constructorA;
        this.ao = methodB;
        this.ap = methodC;
        this.aq = methodD;
        this.ar = methodE;
        this.as = methodF;
    }

    private boolean t() {
        if (this.ao == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.ao != null;
    }

    private Object s() {
        try {
            return this.an.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.ao.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.ap.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    protected Typeface c(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.am, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.as.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean d(Object obj) {
        try {
            return ((Boolean) this.aq.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private void e(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.ar.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.support.v4.graphics.g
    public final Typeface a(Context context, b.C0007b c0007b, Resources resources, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!t()) {
            return super.a(context, c0007b, resources, i);
        }
        Object objS = s();
        for (b.c cVar : c0007b.n()) {
            if (!a(context, objS, cVar.getFileName(), cVar.getTtcIndex(), cVar.getWeight(), cVar.isItalic() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.o()))) {
                e(objS);
                return null;
            }
        }
        if (d(objS)) {
            return c(objS);
        }
        return null;
    }

    @Override // android.support.v4.graphics.c, android.support.v4.graphics.g
    public final Typeface a(Context context, CancellationSignal cancellationSignal, b.C0004b[] c0004bArr, int i) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (c0004bArr.length <= 0) {
            return null;
        }
        if (!t()) {
            b.C0004b c0004bA = a(c0004bArr, i);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(c0004bA.getUri(), t.k, cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(c0004bA.getWeight()).setItalic(c0004bA.isItalic()).build();
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return typefaceBuild;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        } else {
            Map<Uri, ByteBuffer> mapA = android.support.v4.b.b.a(context, c0004bArr, cancellationSignal);
            Object objS = s();
            boolean z = false;
            for (b.C0004b c0004b : c0004bArr) {
                ByteBuffer byteBuffer = mapA.get(c0004b.getUri());
                if (byteBuffer != null) {
                    if (!a(objS, byteBuffer, c0004b.getTtcIndex(), c0004b.getWeight(), c0004b.isItalic() ? 1 : 0)) {
                        e(objS);
                        return null;
                    }
                    z = true;
                }
            }
            if (!z) {
                e(objS);
                return null;
            }
            if (d(objS)) {
                return Typeface.create(c(objS), i);
            }
            return null;
        }
    }

    @Override // android.support.v4.graphics.g
    public final Typeface a(Context context, Resources resources, int i, String str, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!t()) {
            return super.a(context, resources, i, str, i2);
        }
        Object objS = s();
        if (!a(context, objS, str, 0, -1, -1, null)) {
            e(objS);
            return null;
        }
        if (d(objS)) {
            return c(objS);
        }
        return null;
    }

    private static Class u() {
        return Class.forName("android.graphics.FontFamily");
    }

    private static Constructor a(Class cls) {
        return cls.getConstructor(new Class[0]);
    }

    private static Method b(Class cls) {
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
    }

    private static Method c(Class cls) {
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
    }

    private static Method d(Class cls) {
        return cls.getMethod("freeze", new Class[0]);
    }

    private static Method e(Class cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    protected Method f(Class cls) throws NoSuchMethodException, SecurityException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
