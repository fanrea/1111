package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class ru extends zw {
    private final Context u;

    ru(Context context) {
        super(true, false);
        this.u = context;
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) throws JSONException, NoSuchAlgorithmException {
        PackageInfo packageInfo;
        Signature signature;
        String strHc = null;
        try {
            packageInfo = this.u.getPackageManager().getPackageInfo(this.u.getPackageName(), 64);
        } catch (Throwable th) {
            um.hc(th);
            packageInfo = null;
        }
        if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0 && (signature = packageInfo.signatures[0]) != null) {
            strHc = ar.hc(signature.toByteArray());
        }
        if (strHc == null) {
            return true;
        }
        jSONObject.put("sig_hash", strHc);
        return true;
    }
}
