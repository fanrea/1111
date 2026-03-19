package com.baidu.mobads.container.r;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.baidu.mobads.cid.DeviceId;
import com.baidu.mobads.container.r.a;
import com.component.player.n;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static final String a = "PluginLoader";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static AtomicInteger f = new AtomicInteger(0);
    private static AtomicInteger g = new AtomicInteger(0);

    public static void a(Context context) {
        com.baidu.mobads.container.h.b bVar = (com.baidu.mobads.container.h.b) a.a().a(a.InterfaceC0131a.a).a();
        if (bVar != null) {
            bVar.startRemoteUpgrade(context);
        }
    }

    public static void b(Context context) {
        com.baidu.mobads.container.m.a aVar = (com.baidu.mobads.container.m.a) a.a().a(a.InterfaceC0131a.d).a();
        if (aVar != null) {
            aVar.initMtj(context);
        }
    }

    public static void a() {
        com.baidu.mobads.container.m.a aVar = (com.baidu.mobads.container.m.a) a.a().a(a.InterfaceC0131a.d).a();
        if (aVar != null) {
            aVar.closeMtj();
        }
    }

    public static void a(JSONObject jSONObject) {
        com.baidu.mobads.container.m.a aVar = (com.baidu.mobads.container.m.a) a.a().a(a.InterfaceC0131a.d).a();
        if (aVar != null) {
            aVar.saveBqtLog(jSONObject);
        }
    }

    public static String a(Context context, String str) {
        com.baidu.mobads.container.k.a aVar = (com.baidu.mobads.container.k.a) a.a().a(a.InterfaceC0131a.e).a();
        if (aVar != null) {
            return aVar.getLocString(context, str);
        }
        return null;
    }

    public static boolean a(SslErrorHandler sslErrorHandler) {
        com.baidu.mobads.container.t.a aVar = (com.baidu.mobads.container.t.a) a.a().a(a.InterfaceC0131a.f).a();
        if (aVar != null) {
            aVar.a(sslErrorHandler);
            return true;
        }
        return false;
    }

    public static n b() {
        n nVar = (n) a.a().a(a.InterfaceC0131a.g).a();
        if (nVar != null) {
            return nVar;
        }
        return null;
    }

    public static void c(Context context) {
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        c = f(context);
        return c;
    }

    private static String f(Context context) {
        if (TextUtils.isEmpty(d) && f.get() == 0) {
            f.set(1);
            String trustChainCUID = DeviceId.getTrustChainCUID(context);
            f.set(2);
            if (!TextUtils.isEmpty(trustChainCUID)) {
                d = trustChainCUID;
            }
        }
        return d;
    }

    private static String g(Context context) {
        if (TextUtils.isEmpty(e) && g.get() == 0) {
            g.set(1);
            String selfCUID = DeviceId.getSelfCUID(context);
            g.set(2);
            if (!TextUtils.isEmpty(selfCUID)) {
                e = selfCUID;
            }
        }
        return e;
    }

    public static String e(Context context) {
        f(context);
        if (f.get() == 2) {
            String strF = f(context);
            if (TextUtils.isEmpty(strF)) {
                return "0";
            }
            return "t_" + strF;
        }
        return "";
    }
}
