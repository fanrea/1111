package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class mu extends h4 {
    int I1;
    boolean J1;
    boolean K1;
    String L1;
    int M1;
    int N1;
    private List<kz> O1;
    String P1;
    String Q1;
    String R1;
    private mu S1;
    private Boolean T1;
    private boolean U1;

    public mu(String str, String str2, String str3, JSONObject jSONObject, mb mbVar) {
        super(str, str2, str3, e2.SPLASH, jSONObject, mbVar);
        nu.a(this, jSONObject);
        a(kz.a(jSONObject.optJSONArray("slot")));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("open_mini_program");
        this.T1 = Boolean.valueOf(jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optInt("enable") == 1);
        if (TextUtils.isEmpty(this.L1)) {
            return;
        }
        c(true);
    }

    public final int J1() {
        return this.I1;
    }

    public final boolean Q1() {
        return this.J1;
    }

    public final boolean P1() {
        return this.K1;
    }

    public final String O1() {
        return this.L1;
    }

    public final List<kz> N1() {
        return this.O1;
    }

    public final String M1() {
        return this.Q1;
    }

    public final String K1() {
        return this.R1;
    }

    public final mu L1() {
        return this.S1;
    }

    public final void a(mu muVar) {
        this.S1 = muVar;
    }

    public boolean R1() {
        return this.U1;
    }

    public void d(boolean z) {
        this.U1 = z;
    }

    public void b(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString("apurl");
                if (!TextUtils.isEmpty(strOptString)) {
                    this.j = strOptString;
                    this.M.put("apurl", strOptString);
                }
                String strOptString2 = jSONObject.optString("rl");
                if (!TextUtils.isEmpty(strOptString2)) {
                    this.l = strOptString2;
                    this.M.put("rl", strOptString2);
                }
                this.M1 = jSONObject.optInt("rot_index", -1);
                List<String> listB = nt.b(jSONObject.optJSONArray("click_mo_url"));
                if (listB != null && listB.size() > 0) {
                    this.Y = listB;
                }
                List<String> listB2 = nt.b(jSONObject.optJSONArray("click_mo_url_sdk"));
                if (listB2 == null || listB2.size() <= 0) {
                    return;
                }
                this.Z = listB2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(List<kz> list) {
        this.O1 = list;
    }
}
