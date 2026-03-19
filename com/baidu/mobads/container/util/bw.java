package com.baidu.mobads.container.util;

import android.content.Context;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class bw {
    private static final String a = "sysSdc";
    private static final String b = "sysMem";
    private static final String c = "/mnt/sdcard";
    private static final String d = "/bddownload/";
    private static String e = "";
    private static String f = "";
    private static long g = 0;
    private static AtomicInteger h = new AtomicInteger(0);
    private static final long i = 600000;

    public static String a(Context context) {
        SPUtils sPUtils = new SPUtils(context);
        try {
            c(context);
            if (TextUtils.isEmpty(e)) {
                String string = sPUtils.getString(a, "");
                if (!TextUtils.isEmpty(string)) {
                    e = string;
                } else {
                    e = "0,0";
                }
            }
            return e;
        } catch (Throwable th) {
            e = "0,0";
            return e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(Context context) {
        try {
            SPUtils sPUtils = new SPUtils(context);
            if (com.component.c.c.a()) {
                e = f(context) + "," + d(context);
                sPUtils.putString(a, e);
            } else {
                e = "0,0";
            }
        } catch (Throwable th) {
            e = "0,0";
        }
    }

    public static String b(Context context) {
        SPUtils sPUtils = new SPUtils(context);
        try {
            if (TextUtils.isEmpty(f)) {
                String string = sPUtils.getString(b, "");
                if (!TextUtils.isEmpty(string)) {
                    f = string;
                } else {
                    f = "0,0";
                }
            }
            return f;
        } catch (Throwable th) {
            f = "0,0";
            return f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Context context) {
        try {
            SPUtils sPUtils = new SPUtils(context);
            f = g(context) + "," + e(context);
            sPUtils.putString(b, f);
        } catch (Throwable th) {
            f = "0,0";
        }
    }

    public static void c(Context context) {
        if ((g != 0 && System.currentTimeMillis() - g < i) || h.getAndSet(1) != 0) {
            return;
        }
        com.baidu.mobads.container.d.b.a().a(new bx(context));
    }

    public static long d(Context context) {
        try {
            return a(l(context));
        } catch (Exception e2) {
            return -1L;
        }
    }

    public static long e(Context context) {
        try {
            return a(m(context));
        } catch (Exception e2) {
            return -1L;
        }
    }

    public static long f(Context context) {
        try {
            return b(l(context));
        } catch (Exception e2) {
            return -1L;
        }
    }

    public static long g(Context context) {
        try {
            return b(m(context));
        } catch (Exception e2) {
            return -1L;
        }
    }

    private static long a(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((statFs.getBlockCount() * statFs.getBlockSize()) / 1024) / 1024;
        } catch (Exception e2) {
            return -1L;
        }
    }

    private static long b(File file) {
        try {
            StatFs statFs = new StatFs(file.getPath());
            return ((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024) / 1024;
        } catch (Exception e2) {
            return -1L;
        }
    }

    public static boolean h(Context context) {
        try {
            if (x.a(context).a() <= 28 && !bl.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (a()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean a() {
        return x.a(null).a() < 23;
    }

    public static String i(Context context) {
        try {
            if (!t.a(context)) {
                return a(context, c);
            }
            if (t.c(context)) {
                return a(context, c);
            }
            return a(context.getExternalFilesDir(null).getPath());
        } catch (Throwable th) {
            return "";
        }
    }

    public static String j(Context context) {
        return a(context, c);
    }

    public static String a(Context context, String str) {
        try {
            return a(k(context).getPath());
        } catch (Throwable th) {
            return a(str);
        }
    }

    public static String a(String str) {
        return str + d;
    }

    public static File k(Context context) {
        try {
            if (x.a(context).a() > 28) {
                return context.getExternalFilesDir(null);
            }
            if (com.component.c.c.a()) {
                if (bl.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && bl.a("permission_storage")) {
                    return com.component.c.c.c();
                }
                if (x.a(context).a() >= 19) {
                    return context.getExternalFilesDir(null);
                }
                return context.getFilesDir();
            }
            return context.getFilesDir();
        } catch (Exception e2) {
            bq.a().c("TAG", e2.getMessage());
            return null;
        }
    }

    public static File l(Context context) {
        try {
        } catch (Exception e2) {
            bq.a().c("TAG", e2.getMessage());
        }
        if (x.a(context).a() > 28) {
            return context.getExternalFilesDir(null);
        }
        if (com.component.c.c.a()) {
            if (bl.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && bl.a("permission_storage")) {
                return com.component.c.c.c();
            }
            if (x.a(context).a() >= 19) {
                return context.getExternalFilesDir(null);
            }
        }
        return null;
    }

    public static File m(Context context) {
        if (bl.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && bl.a("permission_storage")) {
            return com.component.c.c.d();
        }
        return context.getFilesDir();
    }
}
