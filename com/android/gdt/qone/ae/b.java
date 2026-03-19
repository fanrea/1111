package com.android.gdt.qone.ae;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Random;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class b {
    public static final /* synthetic */ int a = 0;

    static {
        new Random();
    }

    public static String b(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(str.getBytes(Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append(0);
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (Exception e) {
            com.android.gdt.qone.af.c.a(e);
            return str;
        }
    }

    public static String a(int i, String str) throws Throwable {
        String strReplace = "";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                byte[] bArr = new byte[1024];
                do {
                    int i2 = fileInputStream2.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                } while (byteArrayOutputStream.size() < i);
                strReplace = byteArrayOutputStream.toString("UTF-8").trim().replace("\t", "").replace("\r", "").replace("\n", "");
                a(fileInputStream2);
                a(byteArrayOutputStream);
            } catch (Exception unused) {
                fileInputStream = fileInputStream2;
                a(fileInputStream);
                a(byteArrayOutputStream);
                return strReplace;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                a(fileInputStream);
                a(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return strReplace;
    }

    public static String a(String str) {
        String strB = b(str);
        if (strB == null) {
            return strB;
        }
        try {
            return strB.substring(8, 24);
        } catch (Exception e) {
            com.android.gdt.qone.af.c.a(e);
            return strB;
        }
    }

    public static String a() {
        byte[] bArr = {119, com.sigmob.sdk.archives.tar.e.S, com.sigmob.sdk.archives.tar.e.T, 97, 73, 107, 115, com.sigmob.sdk.archives.tar.e.I, 115, 109, com.sigmob.sdk.archives.tar.e.P, 104, 122, 80, 65, 100};
        byte[] bArr2 = {27, 87, 19, 34, com.sigmob.sdk.archives.tar.e.S, 13};
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i % 6]);
        }
        for (int i2 = 0; i2 < 16; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2 % 6]);
        }
        return new String(bArr, Charset.forName("UTF-8"));
    }

    public static void a(Closeable... closeableArr) throws IOException {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
