package com.kwad.components.ad.g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static AppPackageInfo a(PackageInfo packageInfo, PackageManager packageManager) {
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = packageInfo.packageName;
        if (packageInfo.applicationInfo != null) {
            appPackageInfo.isSystemApp = a(packageInfo.applicationInfo) || b(packageInfo.applicationInfo);
        }
        appPackageInfo.versionName = packageInfo.versionName;
        appPackageInfo.firstInstallTime = packageInfo.firstInstallTime;
        appPackageInfo.lastUpdateTime = packageInfo.lastUpdateTime;
        if (packageManager != null && packageInfo.applicationInfo != null && as.aE(ServiceProvider.getContext(), packageInfo.packageName)) {
            try {
                appPackageInfo.appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable th) {
                c.printStackTraceOnly(th);
            }
        }
        return appPackageInfo;
    }

    public static void a(final Context context, final com.kwad.sdk.g.a<JSONArray> aVar) {
        h.execute(new bh() { // from class: com.kwad.components.ad.g.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                aVar.accept(a.c(a.P(context)));
            }
        });
    }

    public static JSONArray[] b(Context context, List<String> list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (context == null || list == null || list.isEmpty() || hVar == null || !s.aob()) {
            return jSONArrayArr;
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (String str : list) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = y.getPackageInfo(context, str, 0);
                if (packageInfo != null) {
                    AppPackageInfo appPackageInfoA = a(packageInfo, packageManager);
                    map.put(appPackageInfoA.packageName, appPackageInfoA);
                } else {
                    AppPackageInfo appPackageInfo = new AppPackageInfo();
                    appPackageInfo.packageName = str;
                    map2.put(appPackageInfo.packageName, appPackageInfo);
                }
            } catch (Exception unused) {
                AppPackageInfo appPackageInfo2 = new AppPackageInfo();
                appPackageInfo2.packageName = str;
                map2.put(appPackageInfo2.packageName, appPackageInfo2);
            }
        }
        jSONArrayArr[0] = c(map);
        jSONArrayArr[1] = c(map2);
        return jSONArrayArr;
    }

    private static Map<String, AppPackageInfo> c(Context context, List<String> list) {
        HashMap map = new HashMap();
        if (context != null && list != null) {
            for (String str : list) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = y.getPackageInfo(context, str, 0);
                    if (packageInfo != null) {
                        AppPackageInfo appPackageInfoA = a(packageInfo, packageManager);
                        map.put(appPackageInfoA.packageName, appPackageInfoA);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return map;
    }

    public static Map<String, AppPackageInfo> P(Context context) {
        HashMap map = new HashMap();
        if (context == null) {
            return map;
        }
        PackageManager packageManager = context.getPackageManager();
        if (bd.readInstalledPackagesDisable()) {
            try {
                List<String> devInstalledPackages = bd.getDevInstalledPackages();
                if (devInstalledPackages != null && !devInstalledPackages.isEmpty()) {
                    Iterator it = new ArrayList(devInstalledPackages).iterator();
                    while (it.hasNext()) {
                        try {
                            PackageInfo packageInfo = y.getPackageInfo(context, (String) it.next(), 0);
                            if (packageInfo != null) {
                                AppPackageInfo appPackageInfoA = a(packageInfo, packageManager);
                                appPackageInfoA.reportMethod = 3;
                                map.put(appPackageInfoA.packageName, appPackageInfoA);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            return map;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar != null && s.aob()) {
            try {
                List<String> listEU = bs.eU(context);
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 32)) {
                    if (resolveInfo != null && resolveInfo.activityInfo != null && !TextUtils.isEmpty(resolveInfo.activityInfo.packageName)) {
                        String str = resolveInfo.activityInfo.packageName;
                        if (listEU != null && !listEU.isEmpty()) {
                            listEU.remove(str);
                        }
                        PackageInfo packageInfo2 = y.getPackageInfo(context, str, 0);
                        if (packageInfo2 != null) {
                            AppPackageInfo appPackageInfoA2 = a(packageInfo2, packageManager);
                            appPackageInfoA2.reportMethod = 1;
                            map.put(appPackageInfoA2.packageName, appPackageInfoA2);
                        }
                    }
                }
                if (listEU != null && !listEU.isEmpty()) {
                    Iterator<String> it2 = listEU.iterator();
                    while (it2.hasNext()) {
                        try {
                            PackageInfo packageInfo3 = y.getPackageInfo(context, it2.next(), 0);
                            if (packageInfo3 != null) {
                                AppPackageInfo appPackageInfoA3 = a(packageInfo3, packageManager);
                                appPackageInfoA3.reportMethod = 2;
                                map.put(appPackageInfoA3.packageName, appPackageInfoA3);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Exception unused4) {
            }
            map.putAll(c(context, hVar.Uh()));
        }
        return map;
    }

    public static JSONArray c(Map<String, AppPackageInfo> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                AppPackageInfo appPackageInfo = map.get(it.next());
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                    aa.a(jSONArray, a(appPackageInfo));
                }
            }
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return jSONArray;
    }

    public static JSONObject a(AppPackageInfo appPackageInfo) {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "pkgName", appPackageInfo.packageName);
        aa.putValue(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
        aa.putValue(jSONObject, "appVersion", appPackageInfo.versionName);
        aa.putValue(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
        aa.putValue(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
        aa.putValue(jSONObject, "reportMethod", appPackageInfo.reportMethod);
        aa.putValue(jSONObject, "appName", appPackageInfo.appName);
        return jSONObject;
    }

    private static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    private static boolean b(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }
}
