package cn.net.shoot.sharetracesdk.f;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static volatile a i;
    public Application a;
    public String c;
    public boolean d;
    public String g;
    public final Handler b = new Handler(Looper.getMainLooper());
    public int e = 10000;
    public int f = 1500;
    public boolean h = true;

    public static a c() {
        if (i == null) {
            synchronized (a.class) {
                if (i == null) {
                    i = new a();
                }
            }
        }
        return i;
    }

    public Application a() {
        return this.a;
    }

    public boolean b() {
        String strA = cn.net.shoot.sharetracesdk.a.a.a("share_trace_init");
        String str = "cache trade init data is " + strA;
        return TextUtils.isEmpty(strA);
    }
}
