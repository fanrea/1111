package com.baidu.mobads.container.q;

import android.content.Context;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b {
    static b f = new b();
    private static final String g = "SecurityLoader";
    public int a = 1;
    public int b = 2;
    public int c = 3;
    public Boolean d = null;
    public String e;

    public static b a() {
        return f;
    }

    public void a(Context context) {
        try {
            if (b()) {
                com.baidu.mobads.container.d.b.a().a(new c(this, context), 5L, TimeUnit.SECONDS);
            }
        } catch (Throwable th) {
        }
    }

    public boolean b() {
        if (this.d == null) {
            this.d = Boolean.valueOf(com.baidu.mobads.container.h.a.a().d());
        }
        return this.d.booleanValue();
    }

    public String c() {
        if (b()) {
            try {
                return com.baidu.enan.a.a();
            } catch (Throwable th) {
                th.printStackTrace();
                return "";
            }
        }
        return "-1";
    }

    public void b(Context context) {
        String str;
        if (!com.baidu.mobads.container.util.e.a.j(context)) {
            com.baidu.enan.a.a(this.a, "0");
            return;
        }
        switch (com.baidu.mobads.container.util.e.a.h(context)) {
            case 2:
                str = "2";
                break;
            case 3:
                str = "3";
                break;
            case 4:
                str = "4";
                break;
            case 5:
                str = "5";
                break;
            case 100:
                str = "1";
                break;
            default:
                str = "6";
                break;
        }
        com.baidu.enan.a.a(this.a, str);
    }
}
