package com.qq.e.comm.plugin;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.simulate.SimulateLaunchActivity;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.managers.status.SDKStatus;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class jd extends q0<com.qq.e.comm.plugin.w.b> {
    private static volatile jd v;
    private JSONObject u;

    public static jd l() {
        if (v == null) {
            synchronized (jd.class) {
                if (v == null) {
                    v = new jd();
                }
            }
        }
        return v;
    }

    @Override // com.qq.e.comm.plugin.q0
    protected kc d() {
        return kc.EYES;
    }

    @Override // com.qq.e.comm.plugin.q0
    protected boolean i() {
        return true;
    }

    private jd() {
    }

    public void a(Context context) {
        super.a(context, "e_qq_com_eyes");
    }

    private boolean m() {
        if (this.u != null) {
            return true;
        }
        try {
            String strB = n3.a() ? lx.b(GlobalSetting.getExtraUserData().get(SimulateLaunchActivity.DEBUG_LOG)) : null;
            if (TextUtils.isEmpty(strB)) {
                strB = r1.d().f().c("ecigs");
            }
            if (TextUtils.isEmpty(strB)) {
                return false;
            }
            this.u = new JSONObject(strB);
            this.a = strB;
            return true;
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }

    @Override // com.qq.e.comm.plugin.q0
    protected boolean e() {
        String strOptString;
        int length;
        if (!m()) {
            return false;
        }
        JSONObject jSONObject = this.u;
        if (jSONObject.optLong("dl") <= System.currentTimeMillis() || !a(jSONObject)) {
            return false;
        }
        String[] strArrSplit = this.b.split(Config.replace);
        if (strArrSplit.length < 2) {
            return false;
        }
        this.d = strArrSplit[strArrSplit.length - 1];
        this.f = jSONObject.optInt("dgs", 3);
        int pluginVersion = SDKStatus.getPluginVersion();
        int iOptInt = jSONObject.optInt("psv");
        int iOptInt2 = jSONObject.optInt("pev");
        if (pluginVersion >= iOptInt && pluginVersion <= iOptInt2) {
            String strOptString2 = jSONObject.optString("man");
            this.e = strOptString2;
            if (TextUtils.isEmpty(strOptString2) || (length = (strOptString = jSONObject.optString("is")).length()) == 0) {
                return false;
            }
            if (length == 1 && strOptString.charAt(0) == '*') {
                return true;
            }
            int iOptInt3 = jSONObject.optInt("it");
            if (iOptInt3 == 0) {
                return false;
            }
            HashSet hashSet = new HashSet(Arrays.asList(strOptString.split(",")));
            Context contextA = r1.d().a();
            if ((iOptInt3 & 1) == 1) {
                String strB = ma.ANDROIDID.c().b(contextA);
                if (!TextUtils.isEmpty(strB) && hashSet.contains(strB)) {
                    return true;
                }
            }
            if ((iOptInt3 & 2) == 2) {
                try {
                    String string = Settings.Secure.getString(contextA.getContentResolver(), m10.a("Ymx1ZXRvb3RoX25hbWU="));
                    if (!TextUtils.isEmpty(string)) {
                        if (hashSet.contains(gp.a(string))) {
                            return true;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.q0
    protected boolean g() {
        int i;
        if (!super.g() && (i = Build.VERSION.SDK_INT) >= 19 && i <= 33) {
            return i == 23 && !lz.c();
        }
        return true;
    }

    public void a(Context context, JSONObject jSONObject) throws JSONException {
        if (this.n) {
            return;
        }
        this.u = jSONObject;
        this.a = jSONObject.toString();
        super.a(context, "e_qq_com_eyes");
    }
}
