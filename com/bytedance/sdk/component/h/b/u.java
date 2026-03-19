package com.bytedance.sdk.component.h.b;

import com.bytedance.sdk.component.utils.mq;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements com.bytedance.sdk.component.h.d, com.bytedance.sdk.component.h.hc {
    private static boolean b = false;
    private static Method d;
    private static Method hc;
    private final com.bytedance.sdk.component.c.d.d c;
    private final boolean u;

    static {
        try {
            Class<?> cls = Class.forName("com.android.internal.util.XmlUtils");
            d = cls.getDeclaredMethod("readMapXml", InputStream.class);
            hc = cls.getDeclaredMethod("writeMapXml", Map.class, OutputStream.class);
            d.setAccessible(true);
            hc.setAccessible(true);
            b = true;
        } catch (Exception unused) {
            b = false;
        }
    }

    public static boolean d() {
        return b;
    }

    public u(com.bytedance.sdk.component.c.d.d dVar) {
        this.c = dVar;
        this.u = false;
    }

    public u(com.bytedance.sdk.component.c.d.d dVar, boolean z) {
        this.c = dVar;
        this.u = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.component.h.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.Object> d(java.io.File r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = com.bytedance.sdk.component.h.b.u.b
            if (r0 == 0) goto L72
            boolean r0 = r7.exists()
            if (r0 == 0) goto L72
            boolean r0 = r7.canRead()
            r1 = 0
            if (r0 != 0) goto L21
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r0 = "can't read file "
            java.lang.String r7 = r0.concat(r7)
            java.lang.String r0 = "PropReaderWriter"
            com.bytedance.sdk.component.utils.mq.hc(r0, r7)
            return r1
        L21:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            r3 = 49152(0xc000, float:6.8877E-41)
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L51
            java.lang.reflect.Method r2 = com.bytedance.sdk.component.h.b.u.d     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L6a
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L6a
            r4 = 0
            r3[r4] = r0     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L6a
            java.lang.Object r1 = r2.invoke(r1, r3)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L6a
            java.util.Map r1 = (java.util.Map) r1     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L6a
            com.bytedance.sdk.component.h.d.hc r2 = new com.bytedance.sdk.component.h.d.hc     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L6a
            r2.<init>()     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L6a
            com.bytedance.sdk.component.c.d.d r3 = r6.c     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L6a
            boolean r4 = r6.u     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L6a
            java.util.Map r7 = r2.d(r1, r3, r4)     // Catch: java.lang.Exception -> L4d java.lang.Throwable -> L6a
            r0.close()     // Catch: java.io.IOException -> L4c
        L4c:
            return r7
        L4d:
            r1 = move-exception
            goto L55
        L4f:
            r7 = move-exception
            goto L6c
        L51:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L55:
            java.lang.String r2 = "XmlReader"
            java.lang.String r3 = "read file exception: "
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r7 = r3.concat(r7)     // Catch: java.lang.Throwable -> L6a
            com.bytedance.sdk.component.utils.mq.hc(r2, r7, r1)     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto L72
            r0.close()     // Catch: java.io.IOException -> L72
            goto L72
        L6a:
            r7 = move-exception
            r1 = r0
        L6c:
            if (r1 == 0) goto L71
            r1.close()     // Catch: java.io.IOException -> L71
        L71:
            throw r7
        L72:
            java.util.Map r7 = java.util.Collections.emptyMap()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.h.b.u.d(java.io.File):java.util.Map");
    }

    @Override // com.bytedance.sdk.component.h.hc
    public void d(Map<String, Object> map, File file) throws Throwable {
        if (!b || file == null) {
            return;
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (file.exists()) {
            file.delete();
        } else {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    hc.invoke(null, new com.bytedance.sdk.component.h.d.hc().d(map, this.c, this.u), fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    mq.hc("XmlReader", "write: to file exception: ".concat(String.valueOf(file)), e);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
