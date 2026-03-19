package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.b.b;
import android.support.v4.content.a.b;
import android.support.v4.content.a.d;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class b {
    private static final g ag;
    private static final android.support.v4.d.f<String, Typeface> ah;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            ag = new f();
        } else if (Build.VERSION.SDK_INT >= 26) {
            ag = new e();
        } else if (Build.VERSION.SDK_INT >= 24 && d.r()) {
            ag = new d();
        } else if (Build.VERSION.SDK_INT >= 21) {
            ag = new c();
        } else {
            ag = new g();
        }
        ah = new android.support.v4.d.f<>(16);
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return ah.get(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface a(Context context, b.a aVar, Resources resources, int i, int i2, d.a aVar2, Handler handler, boolean z) {
        Typeface typefaceA;
        if (aVar instanceof b.d) {
            b.d dVar = (b.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.q() == 0) {
                z2 = true;
            }
            typefaceA = android.support.v4.b.b.a(context, dVar.p(), aVar2, handler, z2, z ? dVar.getTimeout() : -1, i2);
        } else {
            typefaceA = ag.a(context, (b.C0007b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typefaceA != null) {
                    aVar2.a(typefaceA, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            ah.put(b(resources, i, i2), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typefaceA = ag.a(context, resources, i, str, i2);
        if (typefaceA != null) {
            ah.put(b(resources, i, i2), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.C0004b[] c0004bArr, int i) {
        return ag.a(context, (CancellationSignal) null, c0004bArr, i);
    }
}
