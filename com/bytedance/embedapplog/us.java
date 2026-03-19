package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class us extends zw {
    private final Context u;

    us(Context context) {
        super(false, false);
        this.u = context;
    }

    @Override // com.bytedance.embedapplog.zw
    protected boolean d(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesHc = com.bytedance.sdk.openadsdk.api.plugin.hc.hc(this.u, "snssdk_openudid", 0);
        String strHc = hc(sharedPreferencesHc.getString("custom_a", null));
        if (TextUtils.isEmpty(strHc)) {
            strHc = sharedPreferencesHc.getString("clientudid", null);
        }
        if (!ba.d(strHc)) {
            try {
                strHc = UUID.randomUUID().toString();
                strHc = d("clientudid.dat", strHc);
            } catch (Exception unused) {
            }
            String strD = d(strHc);
            SharedPreferences.Editor editorEdit = sharedPreferencesHc.edit();
            editorEdit.putString("custom_a", strD);
            editorEdit.apply();
        }
        jSONObject.put("clientudid", strHc);
        return true;
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 8) {
            try {
                return Base64.encodeToString(str.getBytes("UTF-8"), 0);
            } catch (UnsupportedEncodingException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        return str;
    }

    public static String hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 8) {
            try {
                return new String(Base64.decode(str.getBytes("UTF-8"), 0));
            } catch (UnsupportedEncodingException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        return str;
    }
}
