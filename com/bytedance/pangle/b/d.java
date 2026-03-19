package com.bytedance.pangle.b;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.tc;
import com.bytedance.pangle.util.an;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private JSONObject an;
    private JSONObject b;
    private List<File> c;
    private String d;
    private String h;
    private String hc;
    private File u;

    public static d d(JSONObject jSONObject, File file, List<File> list) {
        d dVar = new d();
        dVar.d = jSONObject.optString(Config.INPUT_DEF_VERSION);
        dVar.hc = jSONObject.optString(n.p);
        dVar.b = jSONObject.optJSONObject("adn_adapter_md5");
        dVar.h = jSONObject.optString("alias_package_name");
        dVar.c = list;
        dVar.u = file;
        dVar.an = jSONObject;
        return dVar;
    }

    public boolean d() {
        return gb() && tt();
    }

    private boolean gb() {
        JSONObject jSONObject;
        Map<String, JSONObject> mapU = tc.d().u();
        if (mapU != null && mapU.size() > 0 && (jSONObject = mapU.get(this.hc)) != null && jSONObject.has("packageName") && TextUtils.equals(jSONObject.optString("packageName"), this.hc)) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName success , packageName=" + this.hc);
            return true;
        }
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName fail, packageName=" + this.hc + ", packageManager=" + mapU);
        return false;
    }

    private boolean tt() throws NoSuchAlgorithmException, IOException {
        JSONObject jSONObject;
        List<File> list = this.c;
        boolean z = false;
        if (list != null && list.size() != 0 && (jSONObject = this.b) != null && jSONObject.length() != 0) {
            int size = this.c.size();
            int length = this.b.length();
            for (File file : this.c) {
                String strD = an.d(file);
                if (strD != null) {
                    strD = strD.toLowerCase();
                }
                String strD2 = d(file.getName());
                if (TextUtils.equals(strD2, strD)) {
                    size--;
                    length--;
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 fail, packageName=" + this.hc + "downloadFileMd5=" + strD + " configMd5=" + strD2);
                }
            }
            if (size == 0 && length == 0) {
                z = true;
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 " + (z ? "success" : "fail") + ", packageName=" + this.hc + " fileSize=" + size + " configFileSize=" + length);
            return z;
        }
        StringBuilder sbAppend = new StringBuilder("DexPluginConfig check md5 fail, packageName=").append(this.hc).append(" dexlist is ").append(this.c).append(" dexlist size is ");
        List<File> list2 = this.c;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, sbAppend.append(list2 == null ? -1 : list2.size()).toString());
        return false;
    }

    public String d(String str) {
        JSONObject jSONObject;
        return (TextUtils.isEmpty(str) || (jSONObject = this.b) == null || !jSONObject.has(str)) ? "" : this.b.optString(str);
    }

    public String hc() {
        return this.hc;
    }

    public int b() {
        if (TextUtils.isEmpty(this.d)) {
            return -1;
        }
        String strReplace = this.d.replace(".", "");
        if (TextUtils.isEmpty(strReplace)) {
            return -1;
        }
        try {
            return Integer.valueOf(strReplace).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public List<File> c() {
        return this.c;
    }

    public File u() {
        return this.u;
    }

    public JSONObject an() {
        return this.an;
    }

    public String h() {
        return this.h;
    }

    public String toString() {
        return "DexPluginConfig{mVersion='" + this.d + "', mPackageName='" + this.hc + "'}";
    }
}
