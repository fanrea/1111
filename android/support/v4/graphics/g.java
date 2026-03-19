package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.v4.b.b;
import android.support.v4.content.a.b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class g {

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    interface a<T> {
        boolean f(T t);

        int g(T t);
    }

    g() {
    }

    private static <T> T a(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int iAbs = (Math.abs(aVar.g(t2) - i2) * 2) + (aVar.f(t2) == z ? 0 : 1);
            if (t == null || i3 > iAbs) {
                t = t2;
                i3 = iAbs;
            }
        }
        return t;
    }

    protected final b.C0004b a(b.C0004b[] c0004bArr, int i) {
        return (b.C0004b) a(c0004bArr, i, new a<b.C0004b>() { // from class: android.support.v4.graphics.g.1
            @Override // android.support.v4.graphics.g.a
            public final /* synthetic */ boolean f(b.C0004b c0004b) {
                return b(c0004b);
            }

            @Override // android.support.v4.graphics.g.a
            public final /* synthetic */ int g(b.C0004b c0004b) {
                return a(c0004b);
            }

            private static int a(b.C0004b c0004b) {
                return c0004b.getWeight();
            }

            private static boolean b(b.C0004b c0004b) {
                return c0004b.isItalic();
            }
        });
    }

    protected static Typeface a(Context context, InputStream inputStream) {
        File fileB = h.b(context);
        if (fileB == null) {
            return null;
        }
        try {
            if (h.a(fileB, inputStream)) {
                return Typeface.createFromFile(fileB.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileB.delete();
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, b.C0004b[] c0004bArr, int i) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (c0004bArr.length <= 0) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(a(c0004bArr, i).getUri());
            try {
                Typeface typefaceA = a(context, inputStreamOpenInputStream);
                h.closeQuietly(inputStreamOpenInputStream);
                return typefaceA;
            } catch (IOException unused) {
                h.closeQuietly(inputStreamOpenInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream = inputStreamOpenInputStream;
                h.closeQuietly(inputStream);
                throw th;
            }
        } catch (IOException unused2) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private b.c a(b.C0007b c0007b, int i) {
        return (b.c) a(c0007b.n(), i, new a<b.c>() { // from class: android.support.v4.graphics.g.2
            @Override // android.support.v4.graphics.g.a
            public final /* synthetic */ boolean f(b.c cVar) {
                return b(cVar);
            }

            @Override // android.support.v4.graphics.g.a
            public final /* synthetic */ int g(b.c cVar) {
                return a(cVar);
            }

            private static int a(b.c cVar) {
                return cVar.getWeight();
            }

            private static boolean b(b.c cVar) {
                return cVar.isItalic();
            }
        });
    }

    public Typeface a(Context context, b.C0007b c0007b, Resources resources, int i) {
        b.c cVarA = a(c0007b, i);
        if (cVarA == null) {
            return null;
        }
        return b.a(context, resources, cVarA.getResourceId(), cVarA.getFileName(), i);
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        File fileB = h.b(context);
        if (fileB == null) {
            return null;
        }
        try {
            if (h.a(fileB, resources, i)) {
                return Typeface.createFromFile(fileB.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileB.delete();
        }
    }
}
