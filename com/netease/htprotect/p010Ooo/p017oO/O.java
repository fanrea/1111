package com.netease.htprotect.p010Ooo.p017oO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* renamed from: com.netease.htprotect.〇Ooo.〇oO.〇O, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class O {
    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static String m1053O8oO888(Iterable iterable, String str) {
        Iterator it = iterable.iterator();
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            if (next == null) {
                return null;
            }
            return next.toString();
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            sb.append(str);
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m1054O8oO888(String str, String str2) {
        if (m1057O8oO888(str) || str2 == null) {
            return str;
        }
        if (str2.isEmpty()) {
            return "";
        }
        int iIndexOf = str.indexOf(str2);
        return iIndexOf == -1 ? str : str.substring(0, iIndexOf);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static String m1055O8oO888(Iterator it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            if (next == null) {
                return null;
            }
            return next.toString();
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                sb.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static ZipEntry m1056O8oO888(ZipFile zipFile, String str) {
        return zipFile.getEntry(str);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static boolean m1057O8oO888(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    private static boolean m1058O8oO888(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: O8〇oO8〇88, reason: contains not printable characters */
    public static byte[] m1059O8oO888(InputStream inputStream) throws IOException {
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    try {
                        return byteArrayOutputStream.toByteArray();
                    } finally {
                        byteArrayOutputStream.close();
                    }
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } finally {
            inputStream.close();
        }
    }

    /* renamed from: 〇Ooo, reason: contains not printable characters */
    private static boolean m1060Ooo(CharSequence charSequence) {
        if (m1057O8oO888(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
