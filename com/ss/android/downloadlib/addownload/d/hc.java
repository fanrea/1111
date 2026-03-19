package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.mq;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class hc {
    hc() {
    }

    CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.hc.d> d(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.hc.d> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = com.bytedance.sdk.openadsdk.ats.b.d(mq.getContext(), str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    com.ss.android.downloadlib.addownload.hc.d dVarD = com.ss.android.downloadlib.addownload.hc.d.d(jSONObject.optJSONObject(itKeys.next()));
                    if (dVarD != null) {
                        copyOnWriteArrayList.add(dVarD);
                    }
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        return copyOnWriteArrayList;
    }

    void d(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.hc.d> copyOnWriteArrayList) throws JSONException {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<com.ss.android.downloadlib.addownload.hc.d> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.ss.android.downloadlib.addownload.hc.d next = it.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.hc), next.d());
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        com.bytedance.sdk.openadsdk.ats.b.d(mq.getContext(), str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }

    void hc(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.bytedance.sdk.openadsdk.ats.b.d(mq.getContext(), str, 0).edit().putString(str2, "").apply();
    }
}
