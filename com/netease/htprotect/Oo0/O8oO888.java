package com.netease.htprotect.Oo0;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.netease.htprotect.Oo0.O8〇oO8〇88, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O8oO888 {
    /* JADX WARN: Removed duplicated region for block: B:19:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m511O8oO888(java.io.InputStream r5, java.lang.String r6) {
        /*
            r0 = 0
            if (r5 == 0) goto L29
            r1 = 0
            if (r6 == 0) goto L1b
            int r2 = r6.length()
            r3 = r1
        Lb:
            if (r3 >= r2) goto L1b
            char r4 = r6.charAt(r3)
            boolean r4 = java.lang.Character.isWhitespace(r4)
            if (r4 != 0) goto L18
            goto L1c
        L18:
            int r3 = r3 + 1
            goto Lb
        L1b:
            r1 = 1
        L1c:
            if (r1 == 0) goto L1f
            goto L29
        L1f:
            java.lang.String r1 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L29
            byte[] r5 = m514O8oO888(r5)     // Catch: java.io.UnsupportedEncodingException -> L29
            r1.<init>(r5, r6)     // Catch: java.io.UnsupportedEncodingException -> L29
            return r1
        L29:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netease.htprotect.Oo0.O8oO888.m511O8oO888(java.io.InputStream, java.lang.String):java.lang.String");
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static void m512O8oO888(Closeable... closeableArr) throws IOException {
        for (int i = 0; i <= 0; i++) {
            Closeable closeable = closeableArr[0];
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static boolean m513O8oO888(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static byte[] m514O8oO888(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return m515Ooo(inputStream).toByteArray();
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static ByteArrayOutputStream m515Ooo(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr, 0, 1024);
                if (i == -1) {
                    m512O8oO888(inputStream);
                    return byteArrayOutputStream;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (IOException unused) {
            m512O8oO888(inputStream);
            return null;
        } catch (Throwable th) {
            m512O8oO888(inputStream);
            throw th;
        }
    }
}
