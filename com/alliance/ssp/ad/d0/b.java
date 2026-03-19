package com.alliance.ssp.ad.d0;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import com.alliance.ssp.ad.api.SAAllianceAdInitParams;
import com.alliance.ssp.ad.api.SAAllianceAdParams;
import com.alliance.ssp.ad.api.YTAdInitSdkListener;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.deviceinfolib.DeviceInfoManager;
import com.alliance.ssp.ad.manager.SensitiveInfoManager;
import com.alliance.ssp.ad.manager.applist.InitConfigManager;
import com.alliance.ssp.ad.manager.applist.bean.RequestConfigBean;
import com.alliance.ssp.ad.o0.g;
import com.alliance.ssp.ad.o0.l;
import com.alliance.ssp.ad.o0.o;
import com.alliance.ssp.ad.o0.q;
import com.alliance.ssp.ad.t.i;
import com.alliance.ssp.ad.utils.jni_interface;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.TimeZone;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdAllianceManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class b {
    public static b b = null;
    public static String c = "";
    public static String d = "";
    public Context a = null;

    public static b b() {
        if (b == null) {
            synchronized (b.class) {
                b = new b();
            }
        }
        return b;
    }

    public Context a() {
        Context context = this.a;
        if (context != null) {
            return context;
        }
        return null;
    }

    public void a(String str, Context context, SAAllianceAdInitParams sAAllianceAdInitParams, YTAdInitSdkListener yTAdInitSdkListener) throws JSONException, PackageManager.NameNotFoundException, IOException {
        i.a = sAAllianceAdInitParams.getDebug();
        String str2 = com.alliance.ssp.ad.o0.i.a;
        if (str2 != null && !str2.isEmpty()) {
            i.a(com.alliance.ssp.ad.a.b.a("sdk已初始化完成，当前appId为\"").append(com.alliance.ssp.ad.o0.i.a).append("\", 不可重复初始化。").toString());
            return;
        }
        context.getPackageName();
        this.a = context;
        if (str != null) {
            com.alliance.ssp.ad.o0.i.a = str;
        }
        SensitiveInfoManager.a = sAAllianceAdInitParams.getAndroidId();
        SensitiveInfoManager.b = sAAllianceAdInitParams.getImei();
        SensitiveInfoManager.c = sAAllianceAdInitParams.getOaid();
        SensitiveInfoManager.f = sAAllianceAdInitParams.getMac();
        SensitiveInfoManager.e = sAAllianceAdInitParams.getLocation();
        SensitiveInfoManager.d = sAAllianceAdInitParams.getCarrier();
        SensitiveInfoManager.j = sAAllianceAdInitParams.isCanUseIMei();
        SensitiveInfoManager.k = sAAllianceAdInitParams.isCanUseOaid();
        SensitiveInfoManager.l = sAAllianceAdInitParams.isCanUseAndroidId();
        SensitiveInfoManager.m = sAAllianceAdInitParams.isCanUseLocation();
        SensitiveInfoManager.n = sAAllianceAdInitParams.isCanUseMac();
        SensitiveInfoManager.o = sAAllianceAdInitParams.isCanUseCarrier();
        SensitiveInfoManager.p = sAAllianceAdInitParams.isEnablePersonalized();
        SensitiveInfoManager.q = sAAllianceAdInitParams.isCanUseWifiState();
        SensitiveInfoManager.t = sAAllianceAdInitParams;
        a(sAAllianceAdInitParams);
        RequestBody requestBodyCreate = null;
        new f().a(0, 0, "", (String) null);
        String str3 = (str == null || str.isEmpty()) ? "sdk初始化失败！请检查传入appId是否为空。" : null;
        if (str3 != null && !str3.isEmpty()) {
            i.a(str3);
            if (yTAdInitSdkListener != null) {
                yTAdInitSdkListener.initResult(false, str3);
            }
            new f().a(0, 2, "", "10001");
            return;
        }
        if (i.a) {
            Log.i("YTAdSDK", "╔═══════════════════════════════════════════════════════════════════\n║ sdk初始化成功，当前应用ID:\"" + str + "\"\n╚═══════════════════════════════════════════════════════════════════\n");
        }
        if (yTAdInitSdkListener != null) {
            yTAdInitSdkListener.initResult(true, "");
        }
        new f().a(0, 1, "", (String) null);
        InitConfigManager initConfigManager = InitConfigManager.g;
        initConfigManager.getClass();
        int i = l.a;
        if (InitConfigManager.a(str)) {
            initConfigManager.c = context;
            HashMap map = new HashMap();
            Context contextA = b().a();
            if (contextA != null) {
                map.put("appid", str);
                map.put("make", com.alliance.ssp.ad.o0.i.b());
                map.put("model", com.alliance.ssp.ad.o0.i.d());
                map.put("brand", com.alliance.ssp.ad.o0.i.a());
                map.put("os", "Android");
                map.put("osv", com.alliance.ssp.ad.o0.i.e());
                map.put("resolution", com.alliance.ssp.ad.o0.i.j(contextA));
                map.put("ver", com.alliance.ssp.ad.o0.i.c(contextA));
                map.put("sdkver", com.alliance.ssp.ad.o0.i.f());
                map.put("gid", com.alliance.ssp.ad.o0.i.d(contextA));
                map.put("platform", 2);
                map.put("ua", f.b(contextA));
                map.put("startuptime", f.j);
                map.put("boottime", f.k);
                map.put("bootmark", c);
                map.put("updatemark", d);
                map.put("devicetype", f.a(contextA));
                map.put("dpi", f.s);
                map.put("ppi", f.u);
                map.put("density", f.t);
                map.put("orientation", f.v);
                map.put("osupdatetime", f.w);
                map.put("itime", "" + System.currentTimeMillis());
                map.put("ltime", f.m);
                map.put("lgid", com.alliance.ssp.ad.o0.i.c());
                map.put("isnew", Integer.valueOf(com.alliance.ssp.ad.o0.i.l(contextA)));
                map.put("onetime", com.alliance.ssp.ad.o0.i.i(contextA));
                map.put("cookieid", com.alliance.ssp.ad.o0.i.e(contextA));
                map.put("sysid", "0");
                map.put("cgid", "0");
                map.put("installTime", f.n);
                map.put("language", f.o);
                map.put("disk", f.p);
                map.put("memory", f.q);
                map.put("timezone", f.r);
                map.put("apppackage", com.alliance.ssp.ad.o0.i.a(contextA));
                map.put("appstoreversion", com.alliance.ssp.ad.o0.i.b(contextA));
                map.put("devicename", com.alliance.ssp.ad.o0.i.f(contextA));
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
                map.put("hmsCoreVer", com.alliance.ssp.ad.o0.i.h(contextA));
                map.put("hmsAGVerCode", com.alliance.ssp.ad.o0.i.g(contextA));
                String str4 = SensitiveInfoManager.g;
                int i2 = l.a;
                map.put("ip", str4);
                map.put("ipv6", SensitiveInfoManager.h);
                map.put("carrier", SensitiveInfoManager.b());
                map.put("androidid", SensitiveInfoManager.a());
                map.put(com.baidu.mobads.container.adrequest.g.z, SensitiveInfoManager.c());
                map.put(com.baidu.mobads.container.adrequest.g.w, SensitiveInfoManager.f);
                map.put("oaid", SensitiveInfoManager.g());
                map.put("enablePersonalized", SensitiveInfoManager.p ? "0" : "1");
                map.put("connectiontype", Integer.valueOf(SensitiveInfoManager.i));
                double[] dArrE = SensitiveInfoManager.e();
                if (dArrE != null && dArrE.length >= 2) {
                    map.put("geo", dArrE[0] + "," + dArrE[1]);
                }
            }
            RequestConfigBean requestConfigBean = new RequestConfigBean(map);
            com.alliance.ssp.ad.e0.d dVar = com.alliance.ssp.ad.e0.d.b;
            com.alliance.ssp.ad.e0.a aVar = new com.alliance.ssp.ad.e0.a(initConfigManager);
            dVar.getClass();
            try {
                String[] strArrB = com.alliance.ssp.ad.o.e.b(new Gson().toJson(requestConfigBean));
                if (strArrB.length >= 2) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("cipher", strArrB[0]);
                    jSONObject.put("encryptParams", strArrB[1]);
                    requestBodyCreate = RequestBody.create(MediaType.parse(MediaTypeUtils.APPLICATION_JSON), jSONObject.toString());
                }
            } catch (Exception unused2) {
            }
            if (requestBodyCreate == null) {
                aVar.a(89757, "request params is null");
            } else {
                new f().a(0, 0, (Integer) null, (String) null, 0);
                dVar.a.newCall(new Request.Builder().url("https://de.ad.gameley.com/delivery/request/getad/config").post(requestBodyCreate).build()).enqueue(new com.alliance.ssp.ad.e0.b(dVar, new int[]{0}, 1, aVar));
            }
        }
    }

    public final String b(long j) {
        long j2 = j / 1000;
        String str = new DecimalFormat("0.000000").format((j % 1000.0f) / 1000.0f);
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            return "" + j2 + str.substring(iLastIndexOf);
        }
        return "" + j2 + ".000000";
    }

    public final void a(SAAllianceAdInitParams sAAllianceAdInitParams) throws JSONException, PackageManager.NameNotFoundException, IOException {
        String str;
        String str2;
        Context contextA = b().a();
        if (contextA != null) {
            try {
                q qVarA = q.a();
                qVarA.getClass();
                SharedPreferences sharedPreferences = contextA.getSharedPreferences("yx_game", 0);
                qVarA.a = sharedPreferences;
                sharedPreferences.edit();
                sAAllianceAdInitParams.getAndroidId();
                sAAllianceAdInitParams.getImei();
                sAAllianceAdInitParams.getMac();
                sAAllianceAdInitParams.isEnablePersonalized();
                sAAllianceAdInitParams.getImei();
                HashMap<String, Integer> map = f.c;
                sAAllianceAdInitParams.getAndroidId();
                sAAllianceAdInitParams.getMac();
                f.B = sAAllianceAdInitParams.getUserId();
                SensitiveInfoManager.i();
                if (sAAllianceAdInitParams.getOaid() != null && !sAAllianceAdInitParams.getOaid().isEmpty()) {
                    com.alliance.ssp.ad.o0.i.b = sAAllianceAdInitParams.getOaid();
                    sAAllianceAdInitParams.getOaid();
                } else {
                    com.alliance.ssp.ad.f0.a.a(contextA, new a(this));
                }
                com.alliance.ssp.ad.o0.i.e(contextA);
                com.alliance.ssp.ad.o0.i.c();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                f.j = b(jElapsedRealtime);
                f.k = b(System.currentTimeMillis() - jElapsedRealtime);
                String strB = f.b(contextA);
                f.l = strB;
                try {
                    SAAllianceAdParams.__LEMON__UA__VALUE = URLEncoder.encode(strB, "UTF-8");
                } catch (Exception e) {
                    new f().a(0, 0, "004", "AdAllianceManager 002: " + e.getMessage(), e);
                }
                com.alliance.ssp.ad.o0.i.i(contextA);
                com.alliance.ssp.ad.o0.i.l(contextA);
                DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
                f.s = "" + displayMetrics.densityDpi;
                f.t = "" + displayMetrics.density;
                f.u = "" + com.alliance.ssp.ad.m.a.a(contextA);
                if (this.a.getResources().getConfiguration().orientation == 1) {
                    f.v = "1";
                } else {
                    f.v = "2";
                }
                f.x = "" + SystemClock.elapsedRealtime();
                f.w = b(Build.TIME);
                o oVar = o.c;
                o.c.a(contextA);
                f.m = "" + System.currentTimeMillis();
                String str3 = DeviceInfoManager.a;
                if (str3 != null && !str3.isEmpty()) {
                    str = DeviceInfoManager.a;
                } else {
                    try {
                        DeviceInfoManager.a = TimeZone.getDefault().getID();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    str = DeviceInfoManager.a;
                }
                f.r = str;
                String str4 = DeviceInfoManager.c;
                if (str4 != null && !str4.isEmpty()) {
                    str2 = DeviceInfoManager.c;
                } else {
                    try {
                        DeviceInfoManager.c = contextA.getResources().getConfiguration().locale.getLanguage();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    str2 = DeviceInfoManager.c;
                }
                f.o = str2;
                try {
                    PackageManager packageManager = contextA.getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(contextA.getPackageName(), 1);
                    if (packageInfo != null) {
                        f.n = "" + new File(packageManager.getApplicationInfo(packageInfo.packageName, 0).sourceDir).lastModified();
                    }
                } catch (PackageManager.NameNotFoundException e4) {
                    int i = l.a;
                    new f().a(0, 0, "004", "AdAllianceManager 003: " + e4.getMessage(), e4);
                }
                try {
                    ActivityManager activityManager = (ActivityManager) contextA.getSystemService("activity");
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    f.q = "" + memoryInfo.totalMem;
                    if (Build.VERSION.SDK_INT >= 18) {
                        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
                        f.p = "" + (statFs.getBlockSizeLong() * statFs.getBlockCountLong());
                    }
                } catch (Exception e5) {
                    new f().a(0, 0, "004", "AdAllianceManager 004: " + e5.getMessage(), e5);
                }
                c = jni_interface.GetBoot();
                d = jni_interface.GetUpdate();
                Application application = (Application) com.alliance.ssp.ad.o0.b.a();
                if (application != null) {
                    com.alliance.ssp.ad.o0.g gVar = new com.alliance.ssp.ad.o0.g();
                    gVar.a = application;
                    g.a aVar = new g.a() { // from class: com.alliance.ssp.ad.d0.b$$ExternalSyntheticLambda0
                        @Override // com.alliance.ssp.ad.o0.g.a
                        public final void a(long j) throws JSONException, PackageManager.NameNotFoundException, IOException {
                            b.a(j);
                        }
                    };
                    Application application2 = gVar.a;
                    if (application2 == null) {
                        return;
                    }
                    application2.registerActivityLifecycleCallbacks(new com.alliance.ssp.ad.o0.f(gVar, aVar));
                }
            } catch (Exception e6) {
                new f().a(0, 2, "", (String) null);
                new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e6, com.alliance.ssp.ad.a.b.a("AdAllianceManager 001: ")), e6);
            }
        }
    }

    public static void a(long j) throws JSONException, PackageManager.NameNotFoundException, IOException {
        f fVar = new f();
        fVar.a(0, 0, String.valueOf(System.currentTimeMillis()), "" + j, (SAAllianceAdData) null);
        try {
            if (fVar.b == null) {
                fVar.b = new JSONObject();
            }
            fVar.b.put("stage", 9);
            JSONObject jSONObject = new JSONObject();
            fVar.a(jSONObject, (String) null);
            fVar.a.put("ext", jSONObject.toString());
        } catch (Exception e) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 015: ")), e);
        }
        try {
            fVar.a();
        } catch (Exception e2) {
            new f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e2, com.alliance.ssp.ad.a.b.a("SAAllianceAdConsoleMessageManager 016: ")), e2);
        }
        int i = l.a;
    }
}
