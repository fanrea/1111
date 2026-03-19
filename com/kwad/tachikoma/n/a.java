package com.kwad.tachikoma.n;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8ObjectProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final List<Map<String, Map<String, String>>> a(V8Object v8Object, int i) {
        com.kwad.tachikoma.o.a aVar;
        if (v8Object != null) {
            try {
                if (getJsObj() == null || (aVar = (com.kwad.tachikoma.o.a) getNativeModule(v8Object)) == null) {
                    return null;
                }
                if (aVar.getUrl() != null) {
                    aVar.getIntent().setData(Uri.parse(aVar.getUrl()));
                }
                List<ResolveInfo> listQueryIntentActivities = getContext().getPackageManager().queryIntentActivities(aVar.getIntent(), i);
                if (listQueryIntentActivities.size() == 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                    HashMap map = new HashMap();
                    HashMap map2 = new HashMap();
                    HashMap map3 = new HashMap();
                    map.put("activityInfo", map2);
                    map.put("serviceInfo", map3);
                    if (resolveInfo.activityInfo != null) {
                        map2.put("packageName", resolveInfo.activityInfo.packageName);
                        map2.put("name", resolveInfo.activityInfo.name);
                    }
                    if (resolveInfo.serviceInfo != null) {
                        map3.put("packageName", resolveInfo.serviceInfo.packageName);
                        map3.put("name", resolveInfo.serviceInfo.name);
                    }
                    arrayList.add(map);
                }
                return arrayList;
            } catch (Throwable th) {
                OfflineHostProvider.getApi().log().printStackTraceOnly(th);
            }
        }
        return null;
    }

    public final Map<String, Object> f(String str, int i) {
        try {
            PackageInfo packageInfo = OfflineHostProvider.getApi().getPackageInfo(getContext(), str, i);
            if (packageInfo == null) {
                return null;
            }
            HashMap map = new HashMap();
            map.put("packageName", packageInfo.packageName);
            map.put("versionName", packageInfo.versionName);
            map.put("versionCode", Integer.valueOf(packageInfo.versionCode));
            return map;
        } catch (Exception unused) {
            return null;
        }
    }

    public final V8Object C(String str) {
        Intent launchIntentForPackage;
        try {
            if (getJsObj() == null || (launchIntentForPackage = getContext().getPackageManager().getLaunchIntentForPackage(str)) == null) {
                return null;
            }
            V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(getJsObj().getRuntime(), "KSAdNativeIntent");
            com.kwad.tachikoma.o.a aVar = new com.kwad.tachikoma.o.a(new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).setArgs(new Object[]{Boolean.FALSE}).build());
            v8ObjectProxy.setNativeObject(aVar);
            aVar.b(launchIntentForPackage);
            return v8ObjectProxy;
        } catch (Throwable th) {
            OfflineHostProvider.getApi().log().printStackTraceOnly(th);
            return null;
        }
    }
}
