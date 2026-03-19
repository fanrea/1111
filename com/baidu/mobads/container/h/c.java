package com.baidu.mobads.container.h;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.jar.JarFile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static volatile c e = null;
    private String a = "baidu_sdk_remote";
    private String b = "__xadsdk__remote__final__";
    private String c = this.b + "downloaded__.jar";
    private String d = this.b + "running__.jar";
    private String f = null;
    private Context g;

    private c(Context context) {
        this.g = context;
        c();
    }

    public static c a(Context context) {
        if (e == null) {
            synchronized (c.class) {
                if (e == null) {
                    e = new c(context);
                }
            }
        }
        return e;
    }

    private void c() {
        try {
            if (TextUtils.isEmpty(this.f)) {
                this.f = this.g.getDir(this.a, 0).getAbsolutePath() + "/";
            }
        } catch (Throwable th) {
        }
    }

    private String d() {
        return this.f + this.c;
    }

    private String e() {
        return this.f + this.d;
    }

    public double a() {
        return a(d());
    }

    public double b() {
        return a(e());
    }

    private double a(String str) {
        JarFile jarFile = null;
        try {
            try {
                File file = new File(str);
                if (a(file)) {
                    JarFile jarFile2 = new JarFile(file);
                    try {
                        double d = Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                        jarFile2.close();
                        if (d <= 0.0d) {
                            jarFile = jarFile2;
                        } else {
                            try {
                                jarFile2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            return d;
                        }
                    } catch (Throwable th) {
                        jarFile = jarFile2;
                        if (jarFile != null) {
                            jarFile.close();
                        }
                        return 0.0d;
                    }
                }
            } catch (Throwable th2) {
            }
            if (jarFile != null) {
                jarFile.close();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return 0.0d;
    }

    private boolean a(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.canRead()) {
                    return file.length() > 0;
                }
                return false;
            } catch (Throwable th) {
                return false;
            }
        }
        return false;
    }
}
