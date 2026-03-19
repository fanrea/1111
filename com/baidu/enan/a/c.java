package com.baidu.enan.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static final Object a = new Object();
    private static volatile String b = "";
    private static volatile String c = "";
    private static volatile String d = "";
    private static String e = "";
    private static int f = 24;

    public static String a(Context context) {
        try {
            if (!TextUtils.isEmpty(e)) {
                return e;
            }
            com.baidu.enan.d.a aVarA = com.baidu.enan.d.a.a(context);
            String strB = aVarA.b();
            if (!TextUtils.isEmpty(strB)) {
                e = strB;
                return strB;
            }
            synchronized (c.class) {
                String strA = com.baidu.enan.f.c.a(context);
                if (!TextUtils.isEmpty(strA)) {
                    String[] strArrSplit = strA.split("\\|");
                    if (strArrSplit != null && strArrSplit.length == 2 && !TextUtils.isEmpty(strArrSplit[0]) && !TextUtils.isEmpty(strArrSplit[1])) {
                        byte[] bArrA = com.baidu.enan.b.b.a(strArrSplit[1].getBytes(), strArrSplit[0].getBytes());
                        if (bArrA != null) {
                            String str = strArrSplit[0] + a(bArrA);
                            aVarA.b(str);
                            return str;
                        }
                    }
                    return strA;
                }
                return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
            }
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "74FFB5E615AA72E0B057EE43E3D5A23A8BA34AAC1672FC9B56A7106C57BA03";
        }
    }

    public static String b() {
        return c;
    }

    public static String c() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context) {
        try {
            new com.baidu.enan.c.c(context).b(com.baidu.enan.e.a.a(context));
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
    }

    public static void a(Context context, int i) {
        try {
            if (i > 0) {
                f = i;
            } else {
                f = 24;
            }
            e(context);
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
    }

    public static void b(Context context) {
        try {
            long jD = com.baidu.enan.d.a.a(context).d();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jD > f * 3600000) {
                synchronized (a) {
                    if (jCurrentTimeMillis - com.baidu.enan.d.a.a(context).d() > f * 3600000) {
                        com.baidu.enan.e.d.a.a().a(new d(context));
                    }
                }
            }
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
        }
    }

    private static void e(Context context) {
        try {
            File file = new File(new File(com.baidu.enan.f.b.b(context), "enan_tmp"), ".tmp_enan");
            if (file.exists()) {
                com.baidu.enan.f.b.a(file);
            }
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
    }

    public static void a(int i, String str) {
        try {
            if (i == 1) {
                b = str;
            } else if (i == 2) {
                c = str;
            } else if (i != 3) {
            } else {
                d = str;
            }
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
        }
    }

    private static String a(byte[] bArr) {
        String str = "";
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            str = str + hexString.toUpperCase();
        }
        return str;
    }

    public static String a() {
        return b;
    }
}
