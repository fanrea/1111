package com.component.lottie.f.a;

import com.component.lottie.e.j;
import com.component.lottie.e.q;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class c implements Closeable {
    private static final String[] g = new String[128];
    int a;
    int[] b = new int[32];
    String[] c = new String[32];
    int[] d = new int[32];
    boolean e;
    boolean f;

    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public abstract int a(a aVar);

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract boolean e();

    public abstract b f();

    public abstract String g();

    public abstract void h();

    public abstract String i();

    public abstract boolean j();

    public abstract double k();

    public abstract int l();

    public abstract void m();

    static {
        for (int i = 0; i <= 31; i++) {
            g[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        g[34] = "\\\"";
        g[92] = "\\\\";
        g[9] = "\\t";
        g[8] = "\\b";
        g[10] = "\\n";
        g[13] = "\\r";
        g[12] = "\\f";
    }

    public static c a(com.component.lottie.e.i iVar) {
        return new e(iVar);
    }

    c() {
    }

    final void a(int i) {
        if (this.a == this.b.length) {
            if (this.a == 256) {
                throw new com.component.lottie.f.a.a("Nesting too deep at " + n());
            }
            this.b = Arrays.copyOf(this.b, this.b.length * 2);
            this.c = (String[]) Arrays.copyOf(this.c, this.c.length * 2);
            this.d = Arrays.copyOf(this.d, this.d.length * 2);
        }
        int[] iArr = this.b;
        int i2 = this.a;
        this.a = i2 + 1;
        iArr[i2] = i;
    }

    final com.component.lottie.f.a.b a(String str) throws com.component.lottie.f.a.b {
        throw new com.component.lottie.f.a.b(str + " at path " + n());
    }

    public final String n() {
        return d.a(this.a, this.b, this.c, this.d);
    }

    public static final class a {
        final String[] a;
        final q b;

        private a(String[] strArr, q qVar) {
            this.a = strArr;
            this.b = qVar;
        }

        public static a a(String... strArr) {
            try {
                j[] jVarArr = new j[strArr.length];
                com.component.lottie.e.e eVar = new com.component.lottie.e.e();
                for (int i = 0; i < strArr.length; i++) {
                    c.b(eVar, strArr[i]);
                    eVar.l();
                    jVarArr[i] = eVar.u();
                }
                return new a((String[]) strArr.clone(), q.a(jVarArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(com.component.lottie.e.h r7, java.lang.String r8) {
        /*
            java.lang.String[] r0 = com.component.lottie.f.a.c.g
            r1 = 34
            r7.m(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = 0
        Le:
            if (r3 >= r2) goto L37
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1d
            r5 = r0[r5]
            if (r5 != 0) goto L2a
            goto L34
        L1d:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L24
            java.lang.String r5 = "\\u2028"
            goto L2a
        L24:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L34
            java.lang.String r5 = "\\u2029"
        L2a:
            if (r4 >= r3) goto L2f
            r7.b(r8, r4, r3)
        L2f:
            r7.b(r5)
            int r4 = r3 + 1
        L34:
            int r3 = r3 + 1
            goto Le
        L37:
            if (r4 >= r2) goto L3c
            r7.b(r8, r4, r2)
        L3c:
            r7.m(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.lottie.f.a.c.b(com.component.lottie.e.h, java.lang.String):void");
    }
}
