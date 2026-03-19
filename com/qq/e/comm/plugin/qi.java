package com.qq.e.comm.plugin;

import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class qi {
    private static final Map<Character, Byte> a = new a();
    private static final HashMap<String, Cipher> b = new HashMap<>();
    private static final HashMap<String, Cipher> c = new HashMap<>();

    static String a(String str, String str2) throws Exception {
        return (String) pro.getobjresult(92, 1, str, str2);
    }

    static String b(String str, String str2) throws Exception {
        return (String) pro.getobjresult(93, 1, str, str2);
    }

    /* compiled from: A */
    class a extends HashMap<Character, Byte> {
        a() {
            put('0', (byte) 0);
            put('1', (byte) 1);
            put('2', (byte) 2);
            put('3', (byte) 3);
            put('4', (byte) 4);
            put('5', (byte) 5);
            put('6', (byte) 6);
            put('7', (byte) 7);
            put('8', (byte) 8);
            put('9', (byte) 9);
            put('A', (byte) 10);
            put('B', (byte) 11);
            put('C', (byte) 12);
            put('D', (byte) 13);
            put('E', (byte) 14);
            put('F', (byte) 15);
            put('a', (byte) 10);
            put('b', (byte) 11);
            put('c', (byte) 12);
            put('d', (byte) 13);
            put('e', (byte) 14);
            put('f', (byte) 15);
        }
    }

    private static byte[] b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                Map<Character, Byte> map = a;
                byte bByteValue = map.get(Character.valueOf(str.charAt(i2))).byteValue();
                bArr[i] = (byte) ((map.get(Character.valueOf(str.charAt(i2 + 1))).byteValue() & 15) | (bByteValue << 4));
                i++;
                i2 += 2;
            }
            return bArr;
        }
        throw new IllegalArgumentException("invalid hex encoded string");
    }

    private static byte[] a(String str) {
        return str.getBytes(d6.a);
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append("0123456789ABCDEF".charAt((b2 >> 4) & 15));
            sb.append("0123456789ABCDEF".charAt(b2 & 15));
        }
        return sb.toString();
    }
}
