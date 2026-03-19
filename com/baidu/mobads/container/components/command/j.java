package com.baidu.mobads.container.components.command;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.container.components.e.b;
import com.baidu.mobads.container.config.PromoteInstallConfig;
import com.baidu.mobads.container.util.ah;
import com.baidu.mobads.container.util.bn;
import com.baidu.mobads.container.util.bq;
import com.sigmob.sdk.base.mta.PointType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j implements Serializable {
    public static final String A = "apopage";
    public static final String B = "asl";
    public static final String C = "coop";
    public static final String D = "codl";
    public static final String E = "dlType";
    public static final String F = "downType";
    public static final String G = "bidlayer";
    public static final String H = "enc_bid_price";
    public static final String I = "publisher";
    public static final String J = "app_version";

    /* renamed from: K, reason: collision with root package name */
    public static final String f724K = "privacy_link";
    public static final String L = "permission_link";
    public static final String M = "function_link";
    public static final String N = "icon";
    public static final String O = "delayOpenTime";
    public static final String P = "detectInstallTime";
    public static final String Q = "apkLinkConfig";
    public static final String a = "XAdRemoteAPKDownloadExtraInfo";
    private static final long aH = -8265147931424177431L;
    public static final String b = "#$#";
    public static final String c = "autoOpen";
    public static final String d = "popNotify";
    public static final String e = "qk";
    public static final String f = "buyer";
    public static final String g = "extras";
    public static final String h = "pk";
    public static final String i = "contentLength";
    public static final String j = "title";
    public static final String k = "url";
    public static final String l = "dl";
    public static final String m = "folder";
    public static final String n = "filename";
    public static final String o = "dlTunnel";
    public static final String p = "turl";
    public static final String q = "mnCfm";
    public static final String r = "dlCnt";
    public static final String s = "ts";
    public static final String t = "cts";
    public static final String u = "clickProcId";
    public static final String v = "appname";
    public static final String w = "adid";
    public static final String x = "placeId";
    public static final String y = "prod";
    public static final String z = "appsid";
    public String R;
    public String S;
    public String T;
    public int W;
    public String Z;
    public long aC;
    public List<String> aE;
    public List<String> aF;
    private String aI;
    private String aJ;
    private String aK;
    private String aL;
    private String aM;
    private String aN;
    private String aO;
    private String aP;
    private long aQ;
    private long aR;
    private boolean aS;
    public String aa;
    public String ab;
    public boolean ac;
    public String ae;
    public String af;
    public String ag;
    public String ah;
    public String ai;
    public String aj;
    public String ak;
    public String al;
    public long ap;
    protected long aq;
    protected long ar;
    public long U = -1;
    public int V = 0;
    public b.a X = b.a.NONE;
    public Object Y = null;
    public boolean ad = true;
    public HashMap<String, String> am = new HashMap<>();
    public int an = 0;
    public boolean ao = false;
    public boolean as = false;
    public String at = null;
    public String au = null;
    public String av = null;
    public String aw = "";
    public boolean ax = false;
    public String ay = "";
    public int az = 0;
    public int aA = 5000;
    public long aB = 120000;
    public String aD = "";
    protected final bq aG = bq.a();

    public j(String str, String str2) {
        this.Z = str;
        this.R = str2;
    }

    public void a(String str, String str2, String str3, boolean z2, String str4) {
        this.ae = str;
        this.af = str4;
        this.ag = str2;
        this.aa = str3;
        this.ac = z2;
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.aI = str;
        this.aJ = str2;
        this.aK = str3;
        this.aL = str4;
        this.aM = str5;
        this.aN = str6;
        this.aO = str7;
    }

    public void a(String str, int i2) {
        this.az = i2;
        this.ay = str;
    }

    public void a(String str, String str2) {
        this.S = str;
        this.T = str2;
    }

    public void a(String str, String str2, String str3) {
        this.ah = str;
        this.ai = str2;
        this.aj = str3;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dl", this.X.b());
            jSONObject.put("filename", this.S);
            jSONObject.put(m, this.T);
            jSONObject.put("title", this.R);
            jSONObject.put(i, this.U);
            jSONObject.put("pk", this.Z);
            jSONObject.put("qk", this.ae);
            jSONObject.put(f, this.af);
            jSONObject.put(c, this.ac);
            jSONObject.put(d, this.ad);
            jSONObject.put(G, this.aI);
            jSONObject.put(H, this.aJ);
            jSONObject.put(I, this.aK);
            jSONObject.put("app_version", this.aL);
            jSONObject.put("privacy_link", this.aM);
            jSONObject.put(L, this.aN);
            jSONObject.put(M, this.aO);
            jSONObject.put("icon", this.al);
            jSONObject.put("adid", this.ag);
            jSONObject.put(x, this.ah);
            jSONObject.put("prod", this.ai);
            jSONObject.put("appsid", this.aj);
            if (!this.ak.isEmpty()) {
                jSONObject.put("appname", this.ak);
            }
            jSONObject.put(g, ah.a(this.am));
            jSONObject.put(o, 4);
            if (this.ab != null && this.ab.length() > 0) {
                jSONObject.put(p, this.ab);
            } else {
                jSONObject.put("url", this.aa);
            }
            jSONObject.put(q, this.ao);
            jSONObject.put(r, this.an);
            jSONObject.put(t, this.ap);
            if (this.an == 1) {
                this.aq = System.currentTimeMillis();
                this.ar = Process.myPid();
            }
            jSONObject.put(s, this.aq);
            jSONObject.put(u, this.ar);
            jSONObject.put(A, this.au);
            jSONObject.put(B, this.av);
            jSONObject.put(C, this.aw);
            jSONObject.put(D, this.ax);
            jSONObject.put(E, this.ay);
            jSONObject.put(F, this.az);
            jSONObject.put(O, this.aA);
            jSONObject.put(P, this.aB);
            jSONObject.put(Q, this.aD);
        } catch (Exception e2) {
            this.aG.a(e2);
        }
        return jSONObject;
    }

    public static String b() {
        return bn.a().a(com.baidu.mobads.container.f.b());
    }

    public static j a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return a(context.getSharedPreferences(com.baidu.mobads.container.util.j.a, 0).getString(str + b + b(), null));
        } catch (Exception e2) {
            bq.a().a(e2);
            return null;
        }
    }

    public static List<j> a(Context context) {
        j jVarA;
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<Map.Entry<String, ?>> it = context.getSharedPreferences(com.baidu.mobads.container.util.j.a, 0).getAll().entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Object value = it.next().getValue();
                    if ((value instanceof String) && (jVarA = a((String) value)) != null) {
                        arrayList.add(jVarA);
                    }
                } catch (Exception e2) {
                    bq.a().a(e2);
                }
            }
        } catch (Exception e3) {
            bq.a().a(e3);
        }
        return arrayList;
    }

    public static String a(JSONObject jSONObject) {
        String str;
        String str2;
        if (jSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("cloud_control");
                if (jSONObjectOptJSONObject == null) {
                    str2 = "";
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    str = "";
                    if (jSONObjectOptJSONObject.has("dl_detain")) {
                        try {
                            jSONObject2.put("dl_detain", jSONObjectOptJSONObject.optString("dl_detain", "0"));
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                            return str;
                        }
                    }
                    if (jSONObjectOptJSONObject.has("u_dl")) {
                        jSONObject2.put("u_dl", jSONObjectOptJSONObject.optString("u_dl", "0"));
                        jSONObject2.put("u_dl_st", jSONObjectOptJSONObject.optString("u_dl_st", "3"));
                    }
                    if (jSONObjectOptJSONObject.has("u_continue_dl")) {
                        jSONObject2.put("u_continue_dl", jSONObjectOptJSONObject.optString("u_continue_dl", "0"));
                        jSONObject2.put("u_continue_dl_st", jSONObjectOptJSONObject.optString("u_continue_dl_st", PointType.SIGMOB_APP));
                    }
                    if (jSONObjectOptJSONObject.has("u_install_type")) {
                        jSONObject2.put("u_install_type", jSONObjectOptJSONObject.optString("u_install_type", "0"));
                        jSONObject2.put("u_install_wt", jSONObjectOptJSONObject.optString("u_install_wt", "60"));
                    }
                    if (jSONObjectOptJSONObject.has("once_acti_win")) {
                        jSONObject2.put("once_acti_win", jSONObjectOptJSONObject.optString("once_acti_win", "0"));
                        jSONObject2.put("once_acti_win_wt", jSONObjectOptJSONObject.optString("once_acti_win_wt", "300"));
                        jSONObject2.put("once_acti_moment_close", jSONObjectOptJSONObject.optString("once_acti_moment_close", "0"));
                    }
                    if (jSONObjectOptJSONObject.has("sec_acti_win")) {
                        jSONObject2.put("sec_acti_win", jSONObjectOptJSONObject.optString("sec_acti_win", "0"));
                        jSONObject2.put("sec_acti_win_wt", jSONObjectOptJSONObject.optString("sec_acti_win_wt", "300"));
                    }
                    return jSONObject2.toString();
                }
            } catch (Throwable th2) {
                th = th2;
                str = "";
            }
        } else {
            str2 = "";
        }
        return str2;
    }

    public static String a(com.baidu.mobads.container.adrequest.j jVar) {
        if (jVar == null) {
            return "";
        }
        try {
            return a(jVar.getOriginJsonObject());
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static j a(String str) throws JSONException {
        j jVar = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("title");
            String strOptString = jSONObject.optString("url", jSONObject.optString(p));
            j jVar2 = new j(jSONObject.optString("pk"), string);
            try {
                jVar2.ak = jSONObject.optString("appname");
                jVar2.al = jSONObject.optString("icon");
                String strOptString2 = jSONObject.optString("qk");
                String strOptString3 = jSONObject.optString(f);
                String strOptString4 = jSONObject.optString("adid");
                String strOptString5 = jSONObject.optString(G);
                String strOptString6 = jSONObject.optString(H);
                String strOptString7 = jSONObject.optString(I);
                String strOptString8 = jSONObject.optString("app_version");
                String strOptString9 = jSONObject.optString("privacy_link");
                String strOptString10 = jSONObject.optString(L);
                String strOptString11 = jSONObject.optString(M);
                HashMap<String, String> mapA = ah.a(jSONObject.optJSONObject(g));
                jVar2.a(strOptString2, strOptString4, strOptString, jSONObject.optBoolean(c), strOptString3);
                jVar2.a(strOptString5, strOptString6, strOptString7, strOptString8, strOptString9, strOptString10, strOptString11);
                jVar2.a(jSONObject.optString(E), jSONObject.optInt(F));
                jVar2.ad = jSONObject.optBoolean(d);
                jVar2.am = mapA;
                jVar2.a(jSONObject.getString("filename"), jSONObject.getString(m));
                jVar2.ab = jSONObject.optString(p);
                jVar2.a(jSONObject.optString(x), jSONObject.optString("prod"), jSONObject.optString("appsid"));
                int i2 = jSONObject.getInt("dl");
                b.a[] aVarArrValues = b.a.values();
                b.a aVar = b.a.NONE;
                for (int i3 = 0; i3 < aVarArrValues.length; i3++) {
                    if (aVarArrValues[i3].b() == i2) {
                        aVar = aVarArrValues[i3];
                    }
                }
                jVar2.X = aVar;
                jVar2.ao = jSONObject.optBoolean(q);
                jVar2.an = jSONObject.getInt(r);
                jVar2.ap = jSONObject.optLong(t);
                jVar2.aq = jSONObject.optLong(s);
                jVar2.ar = jSONObject.optInt(u);
                jVar2.au = jSONObject.optString(A);
                jVar2.av = jSONObject.optString(B);
                jVar2.aw = jSONObject.optString(C);
                jVar2.ax = jSONObject.optBoolean(D);
                jVar2.aA = jSONObject.optInt(O, 5000);
                jVar2.aB = jSONObject.optLong(P, 120000L);
                jVar2.aD = jSONObject.optString(Q);
                return jVar2;
            } catch (Exception e2) {
                e = e2;
                jVar = jVar2;
                bq.a().a(e);
                return jVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static List<String> a(Context context, long j2) {
        int i2;
        ArrayList arrayList = new ArrayList();
        try {
            for (Map.Entry<String, ?> entry : context.getSharedPreferences(com.baidu.mobads.container.util.j.a, 0).getAll().entrySet()) {
                try {
                    String strB = b();
                    String key = entry.getKey();
                    if (key.contains(b + strB)) {
                        JSONObject jSONObject = new JSONObject((String) entry.getValue());
                        if (jSONObject.getLong(t) >= j2 && ((i2 = jSONObject.getInt("dl")) == 0 || i2 == 1 || i2 == 4)) {
                            arrayList.add(key.substring(0, key.indexOf(b)));
                        }
                    }
                } catch (Exception e2) {
                    bq.a().a("XAdDownloaderManager", e2.getMessage());
                }
            }
        } catch (Exception e3) {
            bq.a().a(e3);
        }
        return arrayList;
    }

    public long c() {
        return this.aQ;
    }

    public void a(long j2) {
        this.aQ = j2;
    }

    public String d() {
        return this.Z;
    }

    public void b(String str) {
        this.Z = str;
    }

    public long e() {
        return this.aR;
    }

    public boolean f() {
        return this.aS;
    }

    public void a(boolean z2) {
        this.aS = z2;
    }

    public void b(long j2) {
        this.aR = j2;
    }

    public String g() {
        return this.ak;
    }

    public String b(String str, String str2) {
        if (this.am != null && !TextUtils.isEmpty(this.am.get(str))) {
            return this.am.get(str);
        }
        return str2;
    }

    public void b(Context context) {
        if (!TextUtils.isEmpty(this.Z)) {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(com.baidu.mobads.container.util.j.a, 0).edit();
                editorEdit.putString(this.Z + b + b(), a().toString());
                editorEdit.apply();
                if (PromoteInstallConfig.isInstallPopSwitch()) {
                    if (this.X == b.a.COMPLETED) {
                        try {
                            SharedPreferences.Editor editorEdit2 = context.getSharedPreferences(com.baidu.mobads.container.util.j.c, 0).edit();
                            editorEdit2.putLong(this.Z, System.currentTimeMillis());
                            editorEdit2.apply();
                        } catch (Throwable th) {
                        }
                    }
                }
            } catch (Exception e2) {
                bq.a().a(a, e2);
            }
        }
    }

    public String h() {
        return this.ag;
    }

    public String i() {
        return this.ae;
    }

    public String j() {
        return this.af;
    }

    public void c(String str, String str2) {
        if (this.am == null) {
            this.am = new HashMap<>();
        }
        this.am.put(str, str2);
    }

    public void a(HashMap<String, String> map) {
        if (this.am == null) {
            this.am = new HashMap<>();
        }
        if (map != null) {
            this.am.putAll(map);
        }
    }

    public String k() {
        return this.ai;
    }

    public String l() {
        return this.aj;
    }

    public String m() {
        return this.aP;
    }

    public String n() {
        return this.aI;
    }

    public String o() {
        return this.aJ;
    }

    public String p() {
        return this.aK;
    }

    public String q() {
        return this.aL;
    }

    public String r() {
        return this.aM;
    }

    public String s() {
        return this.aN;
    }

    public String t() {
        return this.aO;
    }
}
