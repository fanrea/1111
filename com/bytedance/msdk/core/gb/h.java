package com.bytedance.msdk.core.gb;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h extends c {
    private List<u> an;
    private final String gb;
    private String h;
    private d tc;
    private final String tt;

    private static class d {
        public String b;
        public String d;
        public String hc;

        public d(String str, String str2, String str3) {
            this.d = str;
            this.hc = str2;
            this.b = str3;
        }
    }

    public h(String str, String str2, String str3, String str4, int i, String str5) {
        super(str, str2, str3, str4, i);
        this.gb = "count";
        this.tt = "effective_time";
        this.h = str5;
        if (!TextUtils.isEmpty(str2)) {
            this.tc = new d("freq", "span", "rule_id");
        } else {
            this.tc = new d("waterfall_show_freq", "waterfall_show_span", "waterfall_show_rule_id");
        }
    }

    public String tt() throws JSONException {
        try {
            JSONArray jSONArray = new JSONArray(this.h);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                jSONObject.put("count", 0);
                jSONObject.put("effective_time", an.d(jSONObject.getLong(this.tc.hc)));
            }
            this.h = jSONArray.toString();
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        return this.h;
    }

    public String tc() throws JSONException {
        try {
            JSONArray jSONArray = new JSONArray();
            for (u uVar : mk()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(this.tc.d, uVar.d());
                jSONObject.put(this.tc.hc, uVar.hc());
                jSONObject.put(this.tc.b, uVar.b());
                jSONObject.put("count", uVar.u());
                jSONObject.put("effective_time", uVar.c());
                jSONArray.put(jSONObject);
            }
            this.h = jSONArray.toString();
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        return this.h;
    }

    public synchronized List<u> mk() {
        h hVarTc;
        List<u> list = this.an;
        if (list != null && list.size() != 0) {
            return this.an;
        }
        this.an = new ArrayList();
        if (this.h == null && (hVarTc = uo.d().tc(this.d)) != null) {
            this.h = hVarTc.h;
        }
        if (TextUtils.isEmpty(this.h)) {
            return this.an;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.h);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                u uVar = new u();
                String string = jSONObject.getString(this.tc.b);
                if (jSONObject != null && !TextUtils.isEmpty(string)) {
                    uVar.d(jSONObject.optInt(this.tc.d));
                    uVar.d(jSONObject.optLong(this.tc.hc));
                    uVar.d(string);
                    if (jSONObject.has("count")) {
                        uVar.hc(jSONObject.optInt("count"));
                    }
                    if (jSONObject.has("effective_time")) {
                        uVar.hc(jSONObject.optLong("effective_time"));
                    }
                    this.an.add(uVar);
                }
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        if (this.an.size() > 0) {
            Collections.sort(this.an, new Comparator<u>() { // from class: com.bytedance.msdk.core.gb.h.1
                @Override // java.util.Comparator
                /* renamed from: d, reason: merged with bridge method [inline-methods] */
                public int compare(u uVar2, u uVar3) {
                    long jHc = uVar2.hc() - uVar3.hc();
                    if (jHc == 0) {
                        return 0;
                    }
                    return jHc > 0 ? 1 : -1;
                }
            });
        }
        return this.an;
    }

    public void d(String str, int i) {
        for (u uVar : mk()) {
            if (TextUtils.equals(uVar.b(), str)) {
                uVar.hc(i);
                return;
            }
        }
    }

    public void d(String str, long j) {
        for (u uVar : mk()) {
            if (TextUtils.equals(uVar.b(), str)) {
                uVar.hc(j);
                return;
            }
        }
    }

    @Override // com.bytedance.msdk.core.gb.c
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.d + "', showRulesVersion='" + this.b + "', timingMode=" + this.u + "}IntervalFreqctlBean{freqctlRules=" + this.an + ", freqctlRulesJson='" + this.h + "'}";
    }
}
