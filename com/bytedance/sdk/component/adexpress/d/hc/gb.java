package com.bytedance.sdk.component.adexpress.d.hc;

import com.alipay.sdk.m.p.e;
import com.bytedance.sdk.component.utils.mq;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private static com.bytedance.sdk.component.adexpress.d.b.d d;

    public static void d() throws IOException {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(u.h(), "temp_pkg_info.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    com.bytedance.sdk.component.adexpress.d.b.d dVarD = com.bytedance.sdk.component.adexpress.d.b.d.d(new JSONObject(new String(bArr, "utf-8")));
                    if (dVarD != null) {
                        d = dVarD;
                    }
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        mq.b(e.g, "version init error", th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th3;
                    }
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
        }
    }

    public static synchronized com.bytedance.sdk.component.adexpress.d.b.d hc() {
        return d;
    }

    public static synchronized void d(com.bytedance.sdk.component.adexpress.d.b.d dVar) {
        if (dVar != null) {
            if (dVar.an()) {
                d = dVar;
            }
        }
    }

    public static void b() {
        u.d(u.h(), hc(), "temp_pkg_info.json");
    }

    public static boolean d(String str) {
        return u.d(hc(), str);
    }

    public static boolean hc(com.bytedance.sdk.component.adexpress.d.b.d dVar) {
        return u.b(hc(), dVar);
    }

    public static void c() {
        u.hc(u.h(), hc(), "temp_pkg_info.json");
        d = null;
    }
}
