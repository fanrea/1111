package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class y extends zw {
    private final fs an;
    private final Context u;

    y(Context context, fs fsVar) {
        super(false, false);
        this.u = context;
        this.an = fsVar;
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) throws JSONException {
        int i;
        int i2;
        String packageName = this.u.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.an.q())) {
            jSONObject.put("package", packageName);
        } else {
            if (um.hc) {
                um.d("has zijie pkg", null);
            }
            jSONObject.put("package", this.an.q());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.u.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th) {
                um.hc(th);
                return false;
            }
        } else {
            i = 0;
        }
        if (!TextUtils.isEmpty(this.an.z())) {
            jSONObject.put("app_version", this.an.z());
        } else {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        }
        if (!TextUtils.isEmpty(this.an.hv())) {
            jSONObject.put("app_version_minor", this.an.hv());
        } else {
            jSONObject.put("app_version_minor", "");
        }
        if (this.an.j() != 0) {
            jSONObject.put("version_code", this.an.j());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.an.s() != 0) {
            jSONObject.put("update_version_code", this.an.s());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.an.us() != 0) {
            jSONObject.put("manifest_version_code", this.an.us());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.an.zw())) {
            jSONObject.put("app_name", this.an.zw());
        }
        if (!TextUtils.isEmpty(this.an.fs())) {
            jSONObject.put("tweaked_channel", this.an.fs());
        }
        if (packageInfo == null || packageInfo.applicationInfo == null || (i2 = packageInfo.applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put("display_name", this.u.getString(i2));
        return true;
    }
}
