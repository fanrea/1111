package com.qq.e.comm.plugin;

import android.os.Build;
import android.text.TextUtils;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class pw extends h4 implements lk {
    String I1;
    private rw J1;
    String K1;
    int L1;
    private boolean M1;

    public pw(String str, String str2, String str3, JSONObject jSONObject, mb mbVar) throws JSONException {
        super(str, str2, str3, e2.REWARDVIDEOAD, jSONObject, mbVar);
        this.M1 = false;
        qw.a(this, jSONObject);
        this.L1 = dx.b(this);
        try {
            if (TextUtils.isEmpty(this.f)) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("img_list");
                if (!ln.b(jSONArrayOptJSONArray)) {
                    String strOptString = jSONArrayOptJSONArray.optString(0);
                    this.f = strOptString;
                    jSONObject.putOpt("img", strOptString);
                }
            }
            jSONObject.putOpt("card_show_time", Integer.valueOf(this.L1));
        } catch (JSONException unused) {
        }
    }

    public boolean N1() {
        return !TextUtils.isEmpty(this.U0) && J1();
    }

    private boolean J1() {
        String strB = r1.d().f().b("rpblkl", "https://100000189777.retail.n.weimob.com/saas/retail/100000189777/21036777/goods/detail,https://46a79741.fyeds3.com/");
        if (TextUtils.isEmpty(strB)) {
            return true;
        }
        try {
            if (!strB.contains(new URL(this.U0).getHost()) || Build.VERSION.SDK_INT > 25) {
                return true;
            }
            String str = this.U0;
            return false;
        } catch (Exception e) {
            e.getMessage();
            return true;
        }
    }

    public final void c(String str) {
        this.I1 = str;
    }

    @Override // com.qq.e.comm.plugin.lk
    public final String a() {
        return this.I1;
    }

    public final void d(boolean z) {
        this.M1 = z;
    }

    @Override // com.qq.e.comm.plugin.lk
    public final boolean b() {
        return this.M1 || d1.a(g0());
    }

    public final rw L1() {
        return this.J1;
    }

    public final int K1() {
        return this.L1;
    }

    public String M1() {
        return this.K1;
    }

    public final void a(rw rwVar) {
        this.J1 = rwVar;
    }
}
