package com.baidu.mobads.container.j;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bv;
import com.baidu.mobads.container.util.bw;
import com.baidu.mobads.container.util.f.z;
import com.baidu.mobads.container.util.o;
import com.baidu.mobads.container.util.x;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    static final String a = "BANNER_CLOSE";
    static final String b = "PAUSE";
    static final String c = "UNLIMITED_BANNER_SIZE";
    protected static final String d = "RM";
    protected static final String e = "MAP";
    protected static final String f = "MAI";
    protected static final String g = "SMS";
    protected static final String h = "DL";
    protected static final String i = "LP";
    protected static final String j = "PH";
    protected static final String k = "VD";
    protected static final String l = "APO2";
    protected t m;
    public bq n = bq.a();

    public a(t tVar) {
        this.m = tVar;
    }

    public JSONObject a() throws JSONException {
        Context contextT = this.m.t();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("PACK", com.baidu.mobads.container.util.t.f(contextT));
            jSONObject.putOpt("CS", "");
            jSONObject.putOpt("WRAPPER_VER", "9.40");
            try {
                jSONObject.putOpt("DENSITY", Float.valueOf(bv.e(contextT)));
            } catch (Exception e2) {
                this.n.a(e2);
            }
            jSONObject.putOpt("MODEL", x.a(contextT).d());
            jSONObject.putOpt("BRAND", DeviceUtils.getInstance().b());
            jSONObject.putOpt("OS", 1);
            jSONObject.putOpt("BDR", DeviceUtils.getInstance().a());
            jSONObject.putOpt("OSV", x.a(this.m.t()).c());
            jSONObject.putOpt("AP", Boolean.valueOf(this.m.w().optBoolean("AP", false)));
            jSONObject.putOpt("MAC", "");
            jSONObject.putOpt("SN", DeviceUtils.getInstance().b(contextT));
            try {
                jSONObject.putOpt("ISP", com.baidu.mobads.container.util.e.a.a(contextT));
            } catch (Throwable th) {
            }
            try {
                jSONObject.putOpt("IMSI", DeviceUtils.getInstance().k(contextT));
            } catch (Throwable th2) {
            }
            try {
                jSONObject.putOpt("IMEI", IDManager.getInstance().c(contextT));
            } catch (Throwable th3) {
            }
            try {
                jSONObject.putOpt("CUID", IDManager.getInstance().a(this.m.t()));
            } catch (Throwable th4) {
            }
            try {
                jSONObject.putOpt("OAID", z.a(this.m.t()));
            } catch (Throwable th5) {
            }
            jSONObject.putOpt("SMS", true);
            jSONObject.putOpt(f, false);
            jSONObject.putOpt("MAP", true);
            jSONObject.putOpt("DL", Boolean.valueOf(com.baidu.mobads.container.util.t.b(contextT)));
            jSONObject.putOpt("LP", true);
            jSONObject.putOpt(j, true);
            jSONObject.putOpt(k, false);
            jSONObject.putOpt("RM", false);
            jSONObject.putOpt(l, true);
            jSONObject.putOpt("APP_VER", Integer.valueOf(com.baidu.mobads.container.util.t.d(contextT)));
            jSONObject.putOpt("TAB", Boolean.valueOf(DeviceUtils.getInstance().a(contextT)));
            try {
                jSONObject.putOpt("CPU", 0);
            } catch (Exception e3) {
                this.n.a(e3);
            }
            try {
                jSONObject.putOpt("SDC", bw.a(contextT) + "," + bw.b(contextT));
            } catch (Exception e4) {
                this.n.a(e4);
            }
            jSONObject.putOpt("MEM", "0,0");
            jSONObject.putOpt("P_VER", com.baidu.mobads.container.config.b.a().j());
            jSONObject.putOpt("PS", b());
            jSONObject.putOpt("CHID", DeviceUtils.getInstance().c());
            jSONObject.putOpt("FET", new JSONObject());
            jSONObject.putOpt("APPSID", this.m.z());
            jSONObject.putOpt("APPSEC", this.m.A());
            jSONObject.putOpt("N", 1);
            jSONObject.putOpt("APID", this.m.l());
            jSONObject.putOpt("PROD", this.m.k());
        } catch (Exception e5) {
            this.n.a("JsInterface.doGetConfs: static Confs not Complete!!");
        }
        try {
            if (this.m.u() != null) {
                String uri = this.m.u().getIntent().toUri(0);
                if (uri.length() > 500) {
                    String[] strArrSplit = uri.split(i.b);
                    if (strArrSplit[0] != null && strArrSplit[1] != null) {
                        uri = strArrSplit[0] + i.b + strArrSplit[1] + ";ignoreparameters;end";
                    } else {
                        uri = null;
                    }
                }
                this.n.a("res is " + uri);
                if (uri != null) {
                    jSONObject.putOpt("INTENT", o.k(uri));
                }
            } else {
                this.n.a("can not obtain intent info");
            }
        } catch (Exception e6) {
            this.n.a(e6);
        }
        try {
            Rect rectA = bv.a(contextT);
            jSONObject.putOpt("SW", Integer.valueOf(rectA.width()));
            jSONObject.putOpt("SH", Integer.valueOf(rectA.height()));
            jSONObject.putOpt("LW", Integer.valueOf(bv.a(contextT, this.m.m())));
            jSONObject.putOpt("LH", Integer.valueOf(bv.a(contextT, this.m.n())));
            jSONObject.putOpt("NT", com.baidu.mobads.container.util.e.a.g(contextT));
            jSONObject.putOpt("NET", Integer.valueOf(com.baidu.mobads.container.util.e.a.h(contextT)));
            jSONObject.putOpt("SWI", Boolean.valueOf(com.baidu.mobads.container.util.e.a.i(contextT).booleanValue()));
            try {
                jSONObject.putOpt("WIFI", DeviceUtils.getInstance().i(contextT));
                jSONObject.putOpt("CSSID", "");
            } catch (Exception e7) {
                this.n.a(e7);
            }
            try {
                jSONObject.putOpt("GPS", DeviceUtils.getInstance().d(contextT));
            } catch (Exception e8) {
                this.n.a(e8);
            }
            try {
                jSONObject.putOpt("REQ_ID", DeviceUtils.getInstance().a(contextT, this.m.l()));
            } catch (Exception e9) {
            }
            jSONObject.putOpt("APINFO", DeviceUtils.getInstance().n(contextT));
            jSONObject.putOpt("APT", Integer.valueOf(this.m.w().optInt("APT")));
        } catch (Exception e10) {
            this.n.a(e10);
        }
        return jSONObject;
    }

    protected void a(JSONObject jSONObject) throws JSONException {
        try {
            JSONObject jSONObjectW = this.m.w();
            if (jSONObjectW != null) {
                String strOptString = jSONObjectW.optString("ABILITY");
                if (!TextUtils.isEmpty(strOptString)) {
                    ArrayList arrayList = new ArrayList(Arrays.asList(strOptString.split(",")));
                    if (arrayList.contains(a)) {
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ABILITY");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = new JSONObject();
                        }
                        jSONObjectOptJSONObject.put(a, true);
                        jSONObject.put("ABILITY", jSONObjectOptJSONObject);
                    }
                    if (arrayList.contains(b)) {
                        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("ABILITY");
                        if (jSONObjectOptJSONObject2 == null) {
                            jSONObjectOptJSONObject2 = new JSONObject();
                        }
                        jSONObjectOptJSONObject2.put(b, true);
                        jSONObject.put("ABILITY", jSONObjectOptJSONObject2);
                    }
                    if (arrayList.contains(c)) {
                        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("ABILITY");
                        if (jSONObjectOptJSONObject3 == null) {
                            jSONObjectOptJSONObject3 = new JSONObject();
                        }
                        jSONObjectOptJSONObject3.put(c, true);
                        jSONObject.put("ABILITY", jSONObjectOptJSONObject3);
                    }
                }
            }
        } catch (Exception e2) {
            this.n.a(e2);
        }
    }

    private JSONObject b() throws JSONException {
        String strOptString;
        JSONObject jSONObjectW = this.m.w();
        if (jSONObjectW == null) {
            strOptString = "";
        } else {
            strOptString = jSONObjectW.optString("ABILITY");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("KEY", new JSONArray());
            jSONObject.putOpt("RPT", Integer.valueOf(com.baidu.mobads.container.h.a.a().e() ? 2 : 1));
            jSONObject.put("ABILITY", strOptString);
        } catch (Exception e2) {
        }
        return jSONObject;
    }
}
