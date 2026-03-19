package com.android.gdt.qone.uin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.android.gdt.qone.ae.b;
import com.android.gdt.qone.af.c;
import com.android.gdt.qone.aw.a;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class U {
    public static volatile boolean a;

    public static boolean a(Context context, String str, String str2, boolean z, boolean z2) {
        if (z2) {
            a = true;
        } else {
            synchronized (U.class) {
                if (!a) {
                    if (TextUtils.isEmpty(str2)) {
                        int i = 0;
                        do {
                            try {
                                int i2 = b.a;
                                System.loadLibrary("gdtqone");
                                a = true;
                            } catch (Throwable th) {
                                c.a("so load fail,error info :%s", th.toString(), new Object[0]);
                            }
                            i++;
                            if (a) {
                                break;
                            }
                        } while (i < 2);
                    } else {
                        try {
                            System.load(str2);
                            a = true;
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }
            }
        }
        if (a) {
            try {
                n2(context, str, a.a(), z);
                return true;
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private static native byte[] a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3);

    private static native boolean b();

    public static byte[] b(String str) {
        if (!a) {
            return null;
        }
        try {
            return d(str);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c() {
        if (!a) {
            return "";
        }
        try {
            return u();
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String d() {
        if (!a) {
            return "";
        }
        try {
            return o();
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }

    private static native byte[] d(String str);

    private static native byte e(String str, String str2);

    public static boolean e() {
        if (!a) {
            return false;
        }
        try {
            return b();
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return false;
        }
    }

    private static native void k(String str, int i);

    private static native String m(int i);

    private static int mnav() {
        return 250530;
    }

    private static native void n(Context context, String str, Object[] objArr, boolean z);

    private static native void n2(Context context, String str, String str2, boolean z);

    private static native String o();

    private static native String p();

    private static native String r(boolean z, int i, int i2, String str, int i3, String[] strArr, String str2);

    private static native byte[] r4(byte[] bArr, int i, byte[] bArr2, int i2);

    private static native boolean s(String str);

    private static native String tvc();

    private static native String tvd();

    private static native String tvm(String str);

    private static native String tvs();

    private static native String u();

    private static native boolean w(String str);

    private static native String x(String str);

    private static native void y(String str);

    private static native String z(Context context);

    private static native String z2(Context context, int i);

    public static byte[] b(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (!a) {
            return null;
        }
        try {
            return a(i, bArr, bArr2, bArr3);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean e(String str) {
        if (!a) {
            return false;
        }
        try {
            return w(str);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c(String str) {
        if (!a) {
            return false;
        }
        try {
            return s(str);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String b(Context context) {
        if (!a) {
            return "";
        }
        try {
            return z2(context, Build.VERSION.SDK_INT);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a() {
        if (!a) {
            return "";
        }
        try {
            return m(Build.VERSION.SDK_INT);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2, int i, int i2) {
        if (!a) {
            return null;
        }
        try {
            return r(false, Build.VERSION.SDK_INT, i, str2, i2, com.android.gdt.qone.aw.b.a(str).b(), "");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(String str, int i, String str2, int i2, String str3) {
        if (!a) {
            return null;
        }
        try {
            return r(true, Build.VERSION.SDK_INT, i, str2, i2, com.android.gdt.qone.aw.b.a(str).b(), str3);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte a(String str, String str2) {
        if (!a) {
            return (byte) -1;
        }
        try {
            return e(str, str2);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
            return (byte) -1;
        }
    }

    public static String a(Context context) {
        if (!a) {
            return "";
        }
        try {
            return z(context);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str) {
        if (a) {
            try {
                String strX = x(str);
                return TextUtils.isEmpty(strX) ? "" : strX;
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
