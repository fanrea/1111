package com.qq.e.comm.plugin;

import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class lx {
    private static final int a = r1.d().f().a("spa", 0);
    private static final byte[] b = {91, -62};
    private static final ThreadLocal<Cipher> c = new a();
    private static final ThreadLocal<Cipher> d = new c(null);
    public static final String e = String.format("AES/%s/PKCS7Padding", "ECB");
    public static final byte[] f = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);

    public static String a(String str) throws d {
        return (String) pro.getobjresult(30, 1, str);
    }

    static /* synthetic */ void a(boolean z, int i, Exception exc) {
        pro.getVresult(31, 1, Boolean.valueOf(z), Integer.valueOf(i), exc);
    }

    static /* synthetic */ byte[] a() {
        return (byte[]) pro.getobjresult(32, 1, new Object[0]);
    }

    private static byte[] a(byte[] bArr) throws b {
        return (byte[]) pro.getobjresult(33, 1, bArr);
    }

    public static String b(String str) throws d {
        return (String) pro.getobjresult(34, 1, str);
    }

    private static void b(boolean z, int i, Exception exc) {
        pro.getVresult(35, 1, Boolean.valueOf(z), Integer.valueOf(i), exc);
    }

    private static byte[] b() {
        return (byte[]) pro.getobjresult(36, 1, new Object[0]);
    }

    private static byte[] b(byte[] bArr) throws b {
        return (byte[]) pro.getobjresult(37, 1, bArr);
    }

    public static byte[] c(byte[] bArr) throws d {
        return (byte[]) pro.getobjresult(38, 1, bArr);
    }

    public static byte[] d(byte[] bArr) throws d {
        return (byte[]) pro.getobjresult(39, 1, bArr);
    }

    private static byte[] e(byte[] bArr) {
        return (byte[]) pro.getobjresult(40, 1, bArr);
    }

    private static byte[] f(byte[] bArr) {
        return (byte[]) pro.getobjresult(41, 1, bArr);
    }

    /* compiled from: A */
    class a extends ThreadLocal<Cipher> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
            try {
                Cipher cipher = Cipher.getInstance(lx.e);
                cipher.init(1, new SecretKeySpec(lx.a(), "AES"));
                return cipher;
            } catch (Exception e) {
                lx.a(true, 1, e);
                return null;
            }
        }
    }

    /* compiled from: A */
    private static class c extends ThreadLocal<Cipher> {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public Cipher initialValue() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
            try {
                Cipher cipher = Cipher.getInstance(lx.e);
                cipher.init(2, new SecretKeySpec(lx.a(), "AES"));
                return cipher;
            } catch (Exception e) {
                lx.a(false, 1, e);
                return null;
            }
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* compiled from: A */
    private static class b extends Exception {
        public b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: A */
    public static class d extends Exception {
        public d(String str, Throwable th) {
            super(str, th);
        }
    }
}
