package cn.net.shoot.sharetracesdk.d;

import android.app.Activity;
import android.util.Log;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    public static volatile d c;
    public final CountDownLatch a = new CountDownLatch(1);
    public e b;

    public static d b() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d();
                }
            }
        }
        return c;
    }

    public a a() throws InterruptedException {
        Activity activity;
        cn.net.shoot.sharetracesdk.c.a aVarA = cn.net.shoot.sharetracesdk.c.a.a();
        if (aVarA.c.size() > 0) {
            activity = aVarA.c.get(r0.size() - 1);
        } else {
            activity = null;
        }
        if (activity == null) {
            return null;
        }
        try {
            cn.net.shoot.sharetracesdk.f.a.c().b.post(new b(this, activity));
            this.a.await(1L, TimeUnit.SECONDS);
        } catch (Exception e) {
            Log.e("ShareTrace", "get gpu info error. msg=" + e.getMessage());
        }
        cn.net.shoot.sharetracesdk.f.a.c().b.post(new c(this, activity));
        this.b = null;
        return new a(cn.net.shoot.sharetracesdk.a.a.a("glr"), cn.net.shoot.sharetracesdk.a.a.a("glv"));
    }
}
