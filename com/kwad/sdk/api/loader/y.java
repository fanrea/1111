package com.kwad.sdk.api.loader;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class y {
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    static String getFileMD5(File file) throws Throwable {
        Throwable th;
        DigestInputStream digestInputStream;
        Exception e;
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            digestInputStream = new DigestInputStream(new FileInputStream(file), messageDigest);
        } catch (Exception e2) {
            e = e2;
            digestInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            digestInputStream = null;
            b(digestInputStream);
            throw th;
        }
        try {
            try {
                byte[] bArr = new byte[1024];
                for (int i = digestInputStream.read(bArr); i != -1; i = digestInputStream.read(bArr)) {
                }
                byte[] bArrDigest = messageDigest.digest();
                StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
                for (byte b : bArrDigest) {
                    int i2 = b & 255;
                    if (i2 < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i2));
                }
                String string = sb.toString();
                b(digestInputStream);
                return string;
            } catch (Throwable th3) {
                th = th3;
                b(digestInputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            b(digestInputStream);
            return "";
        }
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
