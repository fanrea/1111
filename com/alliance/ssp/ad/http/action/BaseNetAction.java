package com.alliance.ssp.ad.http.action;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.d0.f;
import com.alliance.ssp.ad.deviceinfolib.DeviceInfoManager;
import com.alliance.ssp.ad.manager.SensitiveInfoManager;
import com.alliance.ssp.ad.o0.i;
import com.alliance.ssp.ad.o0.l;
import com.baidu.mobads.container.adrequest.g;
import com.dhylive.app.utils.JumpParam;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class BaseNetAction<T> extends com.alliance.ssp.ad.q.b<T> {
    public int b;
    public Map<String, Object> c;
    public boolean d;
    public Method e;

    public enum Method {
        POST,
        GET
    }

    public BaseNetAction(com.alliance.ssp.ad.p.a<T> aVar, Method method, int i) {
        super(aVar);
        this.b = 3000;
        this.c = new HashMap();
        this.d = false;
        Method method2 = Method.GET;
        this.e = method;
        if (i > 0) {
            this.b = i;
        }
    }

    public void a(Map<String, Object> map) {
        this.c.putAll(map);
    }

    public abstract String b();

    public void b(String str) {
    }

    public HashMap<String, Object> a(SAAllianceAdParams sAAllianceAdParams) throws PackageManager.NameNotFoundException {
        HashMap<String, Object> map = new HashMap<>();
        Context contextA = com.alliance.ssp.ad.d0.b.b().a();
        if (contextA == null) {
            return map;
        }
        map.put("make", i.b());
        map.put("model", i.d());
        map.put("brand", i.a());
        map.put("os", "Android");
        map.put("osv", i.e());
        map.put("resolution", i.j(contextA));
        map.put("ver", i.c(contextA));
        map.put("sdkver", i.f());
        map.put("gid", i.d(contextA));
        map.put("platform", 2);
        map.put("ua", f.b(contextA));
        map.put("startuptime", f.j);
        map.put("boottime", f.k);
        map.put("bootmark", com.alliance.ssp.ad.d0.b.c);
        map.put("updatemark", com.alliance.ssp.ad.d0.b.d);
        map.put("devicetype", f.a(contextA));
        map.put("dpi", f.s);
        map.put("ppi", f.u);
        map.put("density", f.t);
        map.put("orientation", f.v);
        map.put("osupdatetime", f.w);
        map.put("itime", "" + System.currentTimeMillis());
        map.put("ltime", f.m);
        map.put("lgid", i.c());
        map.put("isnew", Integer.valueOf(i.l(contextA)));
        map.put("onetime", i.i(contextA));
        map.put("cookieid", i.e(contextA));
        map.put("sysid", "0");
        map.put("cgid", "0");
        map.put("installTime", f.n);
        map.put("language", f.o);
        map.put("disk", f.p);
        map.put("memory", f.q);
        map.put("timezone", f.r);
        map.put("apppackage", i.a(contextA));
        map.put("appstoreversion", i.b(contextA));
        map.put("devicename", i.f(contextA));
        try {
            PackageInfo packageInfo = contextA.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            if (packageInfo != null) {
                map.put("hmsversion", packageInfo.versionName);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            map.put("hmsversion", "");
        }
        map.put("secondsfromgmt", DeviceInfoManager.a());
        map.put("hwmodel", Build.HARDWARE);
        map.put("fulllanguage", DeviceInfoManager.c(contextA));
        map.put("countrycode", DeviceInfoManager.a(contextA));
        map.put("birthtime", f.x);
        map.put("hmsCoreVer", i.h(contextA));
        map.put("hmsAGVerCode", i.g(contextA));
        map.put(JumpParam.USER_ID, (sAAllianceAdParams.getUserId() == null || sAAllianceAdParams.getUserId().isEmpty()) ? f.B : sAAllianceAdParams.getUserId());
        String str = SensitiveInfoManager.g;
        int i = l.a;
        map.put("ip", str);
        map.put("ipv6", SensitiveInfoManager.h);
        map.put("carrier", SensitiveInfoManager.b());
        map.put("androidid", SensitiveInfoManager.a());
        map.put(g.z, SensitiveInfoManager.c());
        map.put(g.w, SensitiveInfoManager.f);
        map.put("oaid", SensitiveInfoManager.g());
        map.put("enablePersonalized", SensitiveInfoManager.p ? "0" : "1");
        map.put("connectiontype", Integer.valueOf(SensitiveInfoManager.i));
        double[] dArrE = SensitiveInfoManager.e();
        if (dArrE != null && dArrE.length >= 2) {
            map.put("geo", dArrE[0] + "," + dArrE[1]);
        }
        return map;
    }

    public BaseNetAction(boolean z, String str, com.alliance.ssp.ad.p.a<T> aVar, Method method) {
        super(aVar);
        this.b = 3000;
        this.c = new HashMap();
        this.d = false;
        Method method2 = Method.GET;
        this.d = z;
        this.e = method;
    }
}
