package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.um;
import com.bytedance.sdk.openadsdk.zw.an;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class TTEncryptUtils {
    private static native byte[] ttEncrypt(byte[] bArr, int i);

    static {
        try {
            an.d("tobEmbedEncrypt");
        } catch (UnsatisfiedLinkError e) {
            um.hc(e);
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        try {
            return ttEncrypt(bArr, i);
        } catch (Throwable unused) {
            return null;
        }
    }
}
