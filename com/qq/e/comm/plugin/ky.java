package com.qq.e.comm.plugin;

import android.util.Pair;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ky {

    /* compiled from: A */
    private static class c {
        static byte a() {
            return pro.getBresult(695, 1, new Object[0]);
        }

        static Pair<Long, byte[]> a(byte[] bArr) throws a {
            return (Pair) pro.getobjresult(696, 1, bArr);
        }

        static byte[] a(String str, long j, byte[] bArr) throws a {
            return (byte[]) pro.getobjresult(697, 1, str, Long.valueOf(j), bArr);
        }

        static byte b() {
            return pro.getBresult(698, 1, new Object[0]);
        }

        static Pair<Long, byte[]> b(byte[] bArr) throws a {
            return (Pair) pro.getobjresult(699, 1, bArr);
        }

        static byte c() {
            return pro.getBresult(700, 1, new Object[0]);
        }

        static int d() {
            return pro.getIresult(701, 1, new Object[0]);
        }

        static int e() {
            return pro.getIresult(702, 1, new Object[0]);
        }

        static byte f() {
            return pro.getBresult(703, 1, new Object[0]);
        }

        static int g() {
            return pro.getIresult(704, 1, new Object[0]);
        }

        static int h() {
            return pro.getIresult(705, 1, new Object[0]);
        }
    }

    private static String a() {
        return (String) pro.getobjresult(679, 1, new Object[0]);
    }

    public static JSONObject a(int i) {
        return (JSONObject) pro.getobjresult(680, 1, Integer.valueOf(i));
    }

    public static native byte[] a(byte[] bArr);

    public static native byte[] a(byte[] bArr, long j);

    private static long b() {
        return pro.getJresult(681, 1, new Object[0]);
    }

    public static byte[] b(byte[] bArr) throws b {
        return (byte[]) pro.getobjresult(682, 1, bArr);
    }

    public static byte[] c(byte[] bArr) throws b {
        return (byte[]) pro.getobjresult(683, 1, bArr);
    }

    public static byte[] d(byte[] bArr) throws b {
        return (byte[]) pro.getobjresult(684, 1, bArr);
    }

    /* compiled from: A */
    public static class b extends Exception {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: A */
    private static class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a(String str, Throwable th) {
            super(str, th);
        }
    }
}
