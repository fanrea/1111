package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.applog.ISensitiveInfoProvider;
import com.bytedance.applog.util.SensitiveUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d2 extends l1 {
    public final ISensitiveInfoProvider e;
    public final Context f;
    public final q1 g;
    public final s1 h;

    public d2(Context context, q1 q1Var, s1 s1Var, ISensitiveInfoProvider iSensitiveInfoProvider) {
        super(true, false);
        this.e = iSensitiveInfoProvider;
        this.f = context;
        this.g = q1Var;
        this.h = s1Var;
    }

    @Override // com.bytedance.bdtracker.l1
    public String a() {
        return "SensitiveLoader";
    }

    @Override // com.bytedance.bdtracker.l1
    public boolean a(JSONObject jSONObject) throws JSONException {
        String[] strArrE;
        s1.a(jSONObject, SensitiveUtils.KEY_ALIYUN_UUID, this.g.c.getAliyunUdid());
        q1 q1Var = this.g;
        if (q1Var.c.isMacEnable() && !q1Var.a(com.baidu.mobads.container.adrequest.g.w)) {
            String macAddress = SensitiveUtils.getMacAddress(this.e, this.f);
            SharedPreferences sharedPreferences = this.g.f;
            String string = sharedPreferences.getString(SensitiveUtils.KEY_MAC, null);
            if (!TextUtils.isEmpty(macAddress)) {
                if (!TextUtils.equals(string, macAddress)) {
                    a.a(sharedPreferences, SensitiveUtils.KEY_MAC, macAddress);
                }
                jSONObject.put("mc", macAddress);
            } else if (!TextUtils.isEmpty(string)) {
                jSONObject.put("mc", string);
            }
        }
        s1.a(jSONObject, "udid", ((m4) this.h.h).f());
        JSONArray jSONArrayG = ((m4) this.h.h).g();
        if (SensitiveUtils.validMultiImei(jSONArrayG)) {
            jSONObject.put("udid_list", jSONArrayG);
        }
        if (this.g.c.isSerialNumberEnable()) {
            jSONObject.put(SensitiveUtils.KEY_BUILD_SERIAL, SensitiveUtils.getSerialNumber(this.f));
            s1.a(jSONObject, "serial_number", ((m4) this.h.h).d());
        }
        q1 q1Var2 = this.g;
        if ((q1Var2.c.isIccIdEnabled() && !q1Var2.a("ICCID")) && this.h.r() && (strArrE = ((m4) this.h.h).e()) != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : strArrE) {
                jSONArray.put(new JSONObject().put("sim_serial_number", str));
            }
            jSONObject.put("sim_serial_number", jSONArray);
        }
        return true;
    }
}
