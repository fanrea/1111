package com.baidu.mobads.cid;

import android.content.Context;
import android.os.SystemClock;
import com.baidu.mobads.cid.cesium.c;
import com.baidu.mobads.cid.cesium.e;
import com.baidu.mobads.cid.cesium.e.a;
import com.baidu.mobads.cid.cesium.f;
import com.baidu.mobads.cid.cesium.g;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class DeviceId {
    private static g.a b;
    private static g.a c;
    private static volatile DeviceId f;
    public static boolean sDataCuidInfoShable = true;
    private final Context a;
    private g d;
    private f e;
    private c g = new c();

    private DeviceId(Context context) {
        this.a = context.getApplicationContext();
        this.d = new g(this.a, new a(this.a), this.g);
        this.e = new f(this.a, this.g);
    }

    static DeviceId a(Context context) {
        DeviceId deviceId;
        synchronized (e.class) {
            if (f == null) {
                f = new DeviceId(context);
            }
            deviceId = f;
        }
        return deviceId;
    }

    private g.a a() {
        g.a aVarA = a((String) null);
        return aVarA == null ? this.d.a() : aVarA;
    }

    private g.a a(String str) {
        g.a aVarB = this.d.b();
        return aVarB == null ? b(str) : aVarB;
    }

    private static g.a b(Context context) {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    SystemClock.uptimeMillis();
                    b = a(context).a();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return b;
    }

    private g.a b(String str) {
        e eVarA = this.e.a(str);
        if (eVarA != null) {
            return this.d.a(eVarA);
        }
        return null;
    }

    private static g.a c(Context context) {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    SystemClock.uptimeMillis();
                    c = a(context).d.c();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return c;
    }

    public static String getSelfCUID(Context context) {
        return c(context).c();
    }

    public static String getTrustChainCUID(Context context) {
        return b(context).c();
    }

    public static String getTrustChainDeviceID(Context context) {
        return b(context).a();
    }
}
