package com.bytedance.msdk.u.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.n;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.msdk.core.gb.tt;
import com.bytedance.msdk.gb.zw;
import com.bytedance.sdk.component.utils.mq;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements b<tt> {
    private Context d;

    public c(Context context) {
        if (context != null) {
            this.d = context.getApplicationContext();
        }
    }

    @Override // com.bytedance.msdk.u.d.u
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public synchronized void hc(tt ttVar) {
        if (this.d != null && ttVar != null) {
            zw zwVarD = zw.d("pacing_" + ttVar.hc(), this.d);
            String strC = ttVar.c();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("unity_id", ttVar.c());
                if (!ttVar.d()) {
                    jSONObject.put("waterfall_show_rules_version", ttVar.u());
                    jSONObject.put("adn_rit_show_rules_version", ttVar.an());
                }
                jSONObject.put("timing_mode", ttVar.h());
                jSONObject.put("show_pacing", new StringBuilder().append(ttVar.tt()).toString());
                jSONObject.put("show_pacing_rule_id", ttVar.tc());
                jSONObject.put(n.m, new StringBuilder().append(ttVar.mk()).toString());
                zwVarD.d(strC, jSONObject.toString());
            } catch (JSONException e) {
                mq.d(e);
            }
        }
    }

    @Override // com.bytedance.msdk.u.d.u
    public synchronized tt query(String str) {
        if (str.contains(Config.replace)) {
            throw new RuntimeException(" has slotId");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d(zw.d("pacing_".concat(String.valueOf(str)), this.d).hc(str, ""), false);
    }

    @Override // com.bytedance.msdk.u.d.u
    public synchronized tt query(String str, String str2) {
        if (str.contains(Config.replace)) {
            throw new RuntimeException(" has slotId");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return d(zw.d("pacing_".concat(String.valueOf(str)), this.d).hc(str + Config.replace + str2, ""), true);
    }

    private tt d(String str, boolean z) throws JSONException {
        String str2;
        String string;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] strArrSplit = jSONObject.getString("unity_id").split(Config.replace);
            String str3 = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str4 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (z) {
                str2 = "";
                string = str2;
            } else {
                String string2 = jSONObject.getString("waterfall_show_rules_version");
                string = jSONObject.getString("adn_rit_show_rules_version");
                str2 = string2;
            }
            return new tt(str3, str4, str2, string, jSONObject.getInt("timing_mode"), jSONObject.getString("show_pacing"), jSONObject.getString("show_pacing_rule_id"), jSONObject.getString(n.m));
        } catch (JSONException e) {
            mq.d(e);
            return null;
        }
    }

    @Override // com.bytedance.msdk.u.d.u
    public synchronized void delete(String str) {
        if (str.contains(Config.replace)) {
            throw new RuntimeException(" has slotId");
        }
        if (this.d != null && !TextUtils.isEmpty(str)) {
            zw.d("pacing_".concat(String.valueOf(str)), this.d).an(str);
        }
    }

    @Override // com.bytedance.msdk.u.d.u
    public synchronized void delete(String str, String str2) {
        if (str.contains(Config.replace)) {
            throw new RuntimeException(" has slotId");
        }
        if (this.d != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            zw.d("pacing_".concat(String.valueOf(str)), this.d).an(str + Config.replace + str2);
        }
    }

    @Override // com.bytedance.msdk.u.d.b
    public synchronized void d(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        tt ttVarQuery = query(str);
        if (ttVarQuery != null) {
            ttVarQuery.d(j);
            hc(ttVarQuery);
        }
    }

    @Override // com.bytedance.msdk.u.d.b
    public synchronized void d(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            tt ttVarQuery = query(str, str2);
            if (ttVarQuery != null) {
                ttVarQuery.d(j);
                hc(ttVarQuery);
            }
        }
    }
}
