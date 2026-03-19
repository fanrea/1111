package com.bytedance.msdk.gb;

import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class de {
    private static final MessageDigest hc = d();
    public static final Charset d = Charset.forName("UTF-8");
    private static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private de() {
    }

    private static MessageDigest d() {
        try {
            return MessageDigest.getInstance(TKDownloadReason.KSAD_TK_MD5);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String d(String str) {
        byte[] bArrDigest;
        MessageDigest messageDigest = hc;
        if (str == null) {
            return "";
        }
        byte[] bytes = str.getBytes(d);
        synchronized (de.class) {
            bArrDigest = messageDigest.digest(bytes);
        }
        return d(bArrDigest);
    }

    public static String d(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        char[] cArr = new char[bArr.length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = b;
            cArr[i] = cArr2[(b2 & 240) >> 4];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }
}
