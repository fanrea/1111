package com.bytedance.msdk.u.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements d<com.bytedance.msdk.core.gb.h> {
    private Context d;

    public hc(Context context) {
        if (context != null) {
            this.d = context.getApplicationContext();
        }
    }

    @Override // com.bytedance.msdk.u.d.u
    /* renamed from: d, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public synchronized void hc(com.bytedance.msdk.core.gb.h hVar) {
        if (this.d != null && hVar != null) {
            zw zwVarD = zw.d("freqctl_" + hVar.hc(), this.d);
            String strC = hVar.c();
            JSONObject jSONObjectD = d(hVar, true);
            if (jSONObjectD != null) {
                zwVarD.d(strC, jSONObjectD.toString());
            }
        }
    }

    private JSONObject d(com.bytedance.msdk.core.gb.h hVar, boolean z) throws JSONException {
        if (hVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("unity_id", hVar.c());
            if (hVar.d()) {
                jSONObject.put("adn_rit_show_rules_version", hVar.an());
            } else {
                jSONObject.put("waterfall_show_rules_version", hVar.u());
            }
            jSONObject.put("timing_mode", hVar.h());
            jSONObject.put("show_freqctl_rules", z ? hVar.tt() : hVar.tc());
            return jSONObject;
        } catch (JSONException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.bytedance.msdk.u.d.u
    public synchronized com.bytedance.msdk.core.gb.h query(String str) {
        if (this.d == null) {
            return null;
        }
        return d(zw.d("freqctl_".concat(String.valueOf(str)), this.d).hc(str, ""), false);
    }

    @Override // com.bytedance.msdk.u.d.u
    public synchronized com.bytedance.msdk.core.gb.h query(String str, String str2) {
        if (this.d == null) {
            return null;
        }
        return d(zw.d("freqctl_".concat(String.valueOf(str)), this.d).hc(str + Config.replace + str2, ""), true);
    }

    private com.bytedance.msdk.core.gb.h d(String str, boolean z) throws JSONException {
        String string;
        String string2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] strArrSplit = jSONObject.getString("unity_id").split(Config.replace);
            String str2 = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str3 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (z) {
                string2 = jSONObject.getString("adn_rit_show_rules_version");
                string = "";
            } else {
                string = jSONObject.getString("waterfall_show_rules_version");
                string2 = "";
            }
            return new com.bytedance.msdk.core.gb.h(str2, str3, string, string2, jSONObject.getInt("timing_mode"), jSONObject.getString("show_freqctl_rules"));
        } catch (JSONException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.bytedance.msdk.u.d.u
    public synchronized void delete(String str) {
        if (this.d != null && !TextUtils.isEmpty(str)) {
            zw.d("freqctl_".concat(String.valueOf(str)), this.d).an(str);
        }
    }

    @Override // com.bytedance.msdk.u.d.u
    public synchronized void delete(String str, String str2) {
        if (this.d != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            zw.d("freqctl_".concat(String.valueOf(str)), this.d).an(str + Config.replace + str2);
        }
    }

    @Override // com.bytedance.msdk.u.d.d
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public synchronized void d(com.bytedance.msdk.core.gb.h hVar) {
        if (hVar != null) {
            b(hVar);
        }
    }

    private void b(com.bytedance.msdk.core.gb.h hVar) throws JSONException {
        if (this.d == null || hVar == null) {
            return;
        }
        zw zwVarD = zw.d("freqctl_" + hVar.hc(), this.d);
        JSONObject jSONObjectD = d(hVar, false);
        if (jSONObjectD != null) {
            zwVarD.d(hVar.c(), jSONObjectD.toString());
        }
    }
}
