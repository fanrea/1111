package com.kuaishou.weapon.p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.kwai.middleware.azeroth.utils.DeviceIDUtil;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class cm {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i = new StringBuilder().append(System.currentTimeMillis()).toString();
    private String j;
    private String k;
    private String l;

    public cm(String str, String str2) {
        this.c = str;
        this.g = str2;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public String e() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public String f() {
        return this.f;
    }

    public void f(String str) {
        this.f = str;
    }

    public String g() {
        return this.g;
    }

    public void g(String str) {
        this.g = str;
    }

    public String h() {
        return this.h;
    }

    public void h(String str) {
        this.h = str;
    }

    public String i() {
        return this.i;
    }

    public void i(String str) {
        this.i = str;
    }

    public String j() {
        return this.j;
    }

    public void j(String str) {
        this.j = str;
    }

    public String k() {
        return this.k;
    }

    public void k(String str) {
        this.k = str;
    }

    public String l() {
        return this.l;
    }

    public void l(String str) {
        this.l = str;
    }

    private JSONObject n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", this.a);
            jSONObject.put("2", this.b);
            jSONObject.put("3", this.c);
            jSONObject.put("4", this.d);
            jSONObject.put("5", this.e);
            jSONObject.put("6", this.f);
            jSONObject.put("7", this.g);
            jSONObject.put(GlobalSetting.UNIFIED_INTERSTITIAL_HS_AD, this.h);
            jSONObject.put("9", this.i);
            jSONObject.put("11", this.j);
            jSONObject.put("12", this.l);
            jSONObject.put(PointType.SIGMOB_REPORT_TRACKING, "com.kuaishou.weapon");
            jSONObject.put("14", WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a(Context context) {
        try {
            a(b(context));
            b(m());
            d(bh.q(context));
            e(bh.r(context));
            f(bh.s(context));
            h("5.3.9");
            j(bt.a(context));
            l(WeaponHI.sKSAppkey);
            return n();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        try {
            String str = WeaponHI.sKDeviceId;
            if (!TextUtils.isEmpty(str)) {
                bi.v = 1;
                return str;
            }
        } catch (Exception unused) {
        }
        try {
            h hVarA = h.a(context, "re_po_rt");
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if (zE || zE2) {
                String str2 = DeviceIDUtil.DEVICE_ID_PREFIX + Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(str2)) {
                    bi.v = 3;
                    return str2;
                }
            }
        } catch (Exception unused2) {
        }
        bi.v = 4;
        return "";
    }

    public static String m() {
        try {
            return !TextUtils.isEmpty(WeaponHI.skProductName) ? WeaponHI.skProductName : "UNKNOWN_PRODUCT";
        } catch (Exception unused) {
            return "UNKNOWN_PRODUCT";
        }
    }
}
