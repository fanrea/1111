package com.bytedance.d.hc.u;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private Map<String, Object> b;
    private Context d;
    private com.bytedance.d.hc.u hc;

    public d(Context context, com.bytedance.d.hc.u uVar) {
        this.d = context;
        this.hc = uVar;
    }

    public Map<String, Object> d() {
        Map<String, Object> mapD = this.hc.d();
        if (mapD == null) {
            mapD = new HashMap<>(4);
        }
        if (d(mapD)) {
            try {
                PackageInfo packageInfo = this.d.getPackageManager().getPackageInfo(this.d.getPackageName(), 128);
                mapD.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, packageInfo.versionName);
                mapD.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (mapD.get("update_version_code") == null) {
                    Object obj = packageInfo.applicationInfo.metaData != null ? packageInfo.applicationInfo.metaData.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = mapD.get("version_code");
                    }
                    mapD.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                mapD.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, com.bytedance.d.hc.gb.d.u(this.d));
                mapD.put("version_code", Integer.valueOf(com.bytedance.d.hc.gb.d.an(this.d)));
                if (mapD.get("update_version_code") == null) {
                    mapD.put("update_version_code", mapD.get("version_code"));
                }
            }
        }
        return mapD;
    }

    public Map<String, Object> hc() {
        if (this.b == null) {
            this.b = this.hc.h();
        }
        return this.b;
    }

    public static boolean d(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        return ((map.containsKey("app_version") || map.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) && map.containsKey("version_code") && map.containsKey("update_version_code")) ? false : true;
    }

    public com.bytedance.d.hc.u b() {
        return this.hc;
    }

    public String c() {
        return com.bytedance.d.hc.gb.d.c(this.d);
    }

    public String u() {
        return this.hc.hc();
    }
}
