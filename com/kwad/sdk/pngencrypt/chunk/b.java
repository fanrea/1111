package com.kwad.sdk.pngencrypt.chunk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.InflaterInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static final byte[] cix = hV("IHDR");
    public static final byte[] ciy = hV("PLTE");
    public static final byte[] ciz = hV("IDAT");
    public static final byte[] ciA = hV("IEND");
    private static byte[] ciB = new byte[4096];
    public static Pattern ciC = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");

    public static byte[] hV(String str) {
        return str.getBytes(com.kwad.sdk.pngencrypt.n.cif);
    }

    public static String q(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.cif);
    }

    public static String d(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.cif);
    }

    public static String r(byte[] bArr) {
        return new String(bArr, com.kwad.sdk.pngencrypt.n.cig);
    }

    public static String e(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, com.kwad.sdk.pngencrypt.n.cig);
    }

    public static boolean hW(String str) {
        return Character.isUpperCase(str.charAt(0));
    }

    public static boolean hX(String str) {
        return Character.isUpperCase(str.charAt(1));
    }

    public static boolean hY(String str) {
        return !Character.isUpperCase(str.charAt(3));
    }

    public static byte[] b(byte[] bArr, int i, int i2, boolean z) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayOutputStream byteArrayOutputStream3;
        InflaterInputStream inflaterInputStream;
        InflaterInputStream inflaterInputStream2 = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (Exception unused) {
                    byteArrayOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = null;
                }
            } catch (Exception unused2) {
                byteArrayOutputStream3 = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                byteArrayOutputStream2 = null;
            }
        } catch (Exception unused3) {
            byteArrayOutputStream3 = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            byteArrayOutputStream2 = null;
            byteArrayInputStream = null;
        }
        try {
            g(inflaterInputStream, byteArrayOutputStream2);
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream);
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
            return byteArray;
        } catch (Exception unused4) {
            inflaterInputStream2 = inflaterInputStream;
            byteArrayOutputStream3 = byteArrayOutputStream2;
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream2);
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream3);
            return new byte[0];
        } catch (Throwable th4) {
            th = th4;
            inflaterInputStream2 = inflaterInputStream;
            byteArrayOutputStream = byteArrayOutputStream2;
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(inflaterInputStream2);
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayInputStream);
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream2);
            com.kwad.sdk.pngencrypt.a.a.closeQuietly(byteArrayOutputStream);
            throw th;
        }
    }

    private static void g(InputStream inputStream, OutputStream outputStream) {
        synchronized (ciB) {
            while (true) {
                int i = inputStream.read(ciB);
                if (i > 0) {
                    outputStream.write(ciB, 0, i);
                }
            }
        }
    }

    public static List<PngChunk> a(List<PngChunk> list, c cVar) {
        ArrayList arrayList = new ArrayList();
        for (PngChunk pngChunk : list) {
            if (cVar.a(pngChunk)) {
                arrayList.add(pngChunk);
            }
        }
        return arrayList;
    }

    public static String k(byte[] bArr, int i) {
        return (bArr == null || bArr.length < 8) ? "?" : d(bArr, 4, 4);
    }
}
