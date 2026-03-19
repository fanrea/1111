package com.baidu.mobstat.forbes;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class HeadObject {
    String A;
    int B;
    String D;
    String b;
    String c;
    String h;
    String i;
    int j;
    int k;
    String m;
    String n;
    String o;
    String p;
    String q;
    String r;
    String s;
    String t;
    String u;
    String v;
    String w;
    String x;
    JSONObject y;
    JSONObject z;
    boolean a = false;
    String d = "0";
    String e = null;
    String f = null;
    int g = -1;
    String l = null;
    String C = "";
    String E = "";

    public synchronized void installHeader(Context context, JSONObject jSONObject) {
        a(context);
        if (jSONObject.length() > 10) {
            return;
        }
        updateHeader(context, jSONObject);
    }

    private synchronized void a(Context context) {
        if (this.a) {
            return;
        }
        aj.e(context, "android.permission.READ_PHONE_STATE");
        aj.e(context, com.kuaishou.weapon.p0.g.a);
        aj.e(context, com.kuaishou.weapon.p0.g.b);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.b = CooperService.instance().getOSVersion();
        this.c = CooperService.instance().getOSSysVersion();
        this.n = CooperService.instance().getPhoneModel();
        this.o = CooperService.instance().getManufacturer();
        this.x = CooperService.instance().getUUID();
        this.y = CooperService.instance().getHeaderExt(context);
        this.z = CooperService.instance().getPushId(context);
        this.f = CooperService.instance().getCUID(context, true);
        this.i = CooperService.instance().getDeviceId(telephonyManager, context);
        this.d = al.a().h(context) ? "1" : "0";
        if (ar.n(context)) {
            this.d = "2";
        }
        this.d += "-25";
        if (ap.a().e()) {
            try {
                this.q = CooperService.instance().getPhoneAddress(context, CooperService.instance().isDeviceMacEnabled(context));
            } catch (Exception e) {
            }
            try {
                this.s = ar.k(2, context);
            } catch (Exception e2) {
            }
        }
        try {
            this.t = ar.a(context, 2);
        } catch (Exception e3) {
        }
        try {
            this.m = CooperService.instance().getOperator(telephonyManager);
        } catch (Exception e4) {
        }
        try {
            this.j = ar.b(context);
            this.k = ar.c(context);
            if (context.getResources().getConfiguration().orientation == 2) {
                this.j ^= this.k;
                this.k = this.j ^ this.k;
                this.j ^= this.k;
            }
        } catch (Exception e5) {
        }
        this.l = CooperService.instance().getAppChannel(context);
        this.e = CooperService.instance().getAppKey(context);
        try {
            this.g = CooperService.instance().getAppVersionCode(context);
            this.h = CooperService.instance().getAppVersionName(context);
        } catch (Exception e6) {
        }
        try {
            this.p = CooperService.instance().getLinkedWay(context);
        } catch (Exception e7) {
        }
        this.u = ar.b();
        this.v = android.os.Build.BOARD;
        this.w = android.os.Build.BRAND;
        this.A = CooperService.instance().getUserId(context);
        this.a = true;
        this.C = al.a().s(context);
    }

    public synchronized void updateHeader(Context context, JSONObject jSONObject) {
        Object objM;
        JSONObject jSONObject2;
        try {
            jSONObject.put(Config.OS, "Android");
            int i = 0;
            jSONObject.put(Config.STAT_SDK_TYPE, 0);
            jSONObject.put("s", this.b == null ? "" : this.b);
            jSONObject.put("sv", this.c == null ? "" : this.c);
            jSONObject.put("k", this.e == null ? "" : this.e);
            jSONObject.put(Config.PLATFORM_TYPE, this.d == null ? "0" : this.d);
            jSONObject.put("i", "");
            jSONObject.put("v", "4.1.0.9");
            jSONObject.put(Config.STAT_SDK_CHANNEL, 25);
            jSONObject.put("a", this.g);
            jSONObject.put("n", this.h == null ? "" : this.h);
            jSONObject.put("d", "");
            jSONObject.put("mc", this.q == null ? "" : this.q);
            jSONObject.put(Config.DEVICE_BLUETOOTH_MAC, this.s == null ? "" : this.s);
            jSONObject.put(Config.DEVICE_ID_SEC, this.i == null ? "" : this.i);
            jSONObject.put(Config.OTHER_ID, ap.a().b());
            jSONObject.put(Config.CUID_SEC, ap.a().c());
            jSONObject.put(Config.SID, ap.a().a(context));
            jSONObject.put(Config.SDK_TAG, 2);
            jSONObject.put("w", this.j);
            jSONObject.put("h", this.k);
            jSONObject.put(Config.DEVICE_NAME, this.t == null ? "" : this.t);
            jSONObject.put("c", this.l == null ? "" : this.l);
            jSONObject.put(Config.OPERATOR, this.m == null ? "" : this.m);
            jSONObject.put("m", this.n == null ? "" : this.n);
            jSONObject.put(Config.MANUFACTURER, this.o == null ? "" : this.o);
            jSONObject.put("l", this.p == null ? "" : this.p);
            jSONObject.put("t", System.currentTimeMillis());
            jSONObject.put(Config.PACKAGE_NAME, ar.m(2, context));
            jSONObject.put(Config.ROM, this.u == null ? "" : this.u);
            jSONObject.put(Config.DEVICE_BOARD, this.v == null ? "" : this.v);
            jSONObject.put(Config.DEVICE_BRAND, this.w == null ? "" : this.w);
            jSONObject.put("td", ar.a(context));
            if (context != null && context.getApplicationInfo() != null) {
                i = context.getApplicationInfo().targetSdkVersion;
            }
            jSONObject.put(Config.TARGET_SDK_VERSION, i);
            jSONObject.put(Config.USER_PROPERTY, this.C);
            jSONObject.put(Config.OAID, ar.a(2, context));
            jSONObject.put(Config.OUT_OAID, ar.b(2, context));
            jSONObject.put("from", "1");
            jSONObject.put(Config.GAID, ar.d(2, context));
            jSONObject.put(Config.IID, ar.c(2, context));
            jSONObject.put(Config.CUID3, ar.e(2, context));
            jSONObject.put(Config.SSAID, ar.f(2, context));
            jSONObject.put(Config.PY, this.E);
            jSONObject.put(Config.PLT, CooperService.instance().getPlatformType());
            if (!TextUtils.isEmpty(this.A)) {
                if (!TextUtils.isEmpty(this.C)) {
                    jSONObject2 = new JSONObject(this.C);
                } else {
                    jSONObject2 = new JSONObject();
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.A);
                jSONArray.put("1");
                jSONObject2.put("uid_", jSONArray);
                jSONObject.put(Config.USER_PROPERTY, jSONObject2.toString());
            }
            jSONObject.put(Config.UID_CHANGE, "");
            jSONObject.put("at", "0");
            String strL = ar.l(context);
            jSONObject.put(Config.PROCESS_LABEL, strL);
            if (TextUtils.isEmpty(strL)) {
                objM = null;
            } else {
                objM = ar.m(context);
            }
            if (objM == null) {
                objM = "";
            }
            jSONObject.put(Config.PROCESS_CLASS, objM);
            jSONObject.put("sign", this.x == null ? "" : this.x);
            if (this.y != null && this.y.length() != 0) {
                jSONObject.put("ext", this.y);
            } else {
                jSONObject.remove("ext");
            }
            if (this.z == null) {
                this.z = new JSONObject();
            }
            jSONObject.put(Config.PUSH, this.z);
            jSONObject.put(Config.CUSTOM_USER_ID, this.A);
            jSONObject.put(Config.START_TYPE, String.valueOf(this.B));
        } catch (Exception e) {
        }
    }

    public void setHeaderExt(JSONObject jSONObject) {
        this.y = jSONObject;
    }

    public void setPushInfo(JSONObject jSONObject) {
        this.z = jSONObject;
    }

    public void setUserId(String str) {
        this.A = str;
    }

    public void setUserProperty(String str) {
        this.C = str;
    }

    public void setZid(String str) {
        this.D = str;
    }

    public void setStartType(boolean z) {
        if (z) {
            this.B = 1;
        } else {
            this.B = 0;
        }
    }

    public void setHeaderPy(String str) {
        this.E = str;
    }
}
