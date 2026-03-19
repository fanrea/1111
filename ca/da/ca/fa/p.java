package ca.da.ca.fa;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.common.utility.PackageUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PackageLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class p extends c {
    public final Context e;
    public final g f;

    public p(Context context, g gVar) {
        super(false, false);
        this.e = context;
        this.f = gVar;
    }

    @Override // ca.da.ca.fa.c
    public boolean a(JSONObject jSONObject) throws JSONException {
        int i;
        String packageName = this.e.getPackageName();
        if (TextUtils.isEmpty(this.f.b.getZiJieCloudPkg())) {
            jSONObject.put("package", packageName);
        } else {
            ca.da.ca.ja.r.a("has zijie pkg", (Throwable) null);
            jSONObject.put("package", this.f.b.getZiJieCloudPkg());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            int versionCode = PackageUtils.getVersionCode(this.e);
            if (TextUtils.isEmpty(this.f.b.getVersion())) {
                jSONObject.put("app_version", PackageUtils.getVersionName(this.e));
            } else {
                jSONObject.put("app_version", this.f.b.getVersion());
            }
            if (TextUtils.isEmpty(this.f.b.getVersionMinor())) {
                jSONObject.put("app_version_minor", "");
            } else {
                jSONObject.put("app_version_minor", this.f.b.getVersionMinor());
            }
            if (this.f.b.getVersionCode() != 0) {
                jSONObject.put("version_code", this.f.b.getVersionCode());
            } else {
                jSONObject.put("version_code", versionCode);
            }
            if (this.f.b.getUpdateVersionCode() != 0) {
                jSONObject.put("update_version_code", this.f.b.getUpdateVersionCode());
            } else {
                jSONObject.put("update_version_code", versionCode);
            }
            if (this.f.b.getManifestVersionCode() != 0) {
                jSONObject.put("manifest_version_code", this.f.b.getManifestVersionCode());
            } else {
                jSONObject.put("manifest_version_code", versionCode);
            }
            if (!TextUtils.isEmpty(this.f.b.getAppName())) {
                jSONObject.put("app_name", this.f.b.getAppName());
            }
            if (!TextUtils.isEmpty(this.f.j())) {
                jSONObject.put("tweaked_channel", this.f.j());
            }
            if (this.e.getApplicationInfo() != null && (i = this.e.getApplicationInfo().labelRes) > 0) {
                jSONObject.put("display_name", this.e.getString(i));
            }
            return true;
        } catch (Throwable th) {
            ca.da.ca.ja.r.a(th);
            return true;
        }
    }
}
