package com.ss.android.socialbase.downloader.uo;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.e.gb;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private static boolean an;
    private static JSONObject b;
    private static JSONObject c;
    private static d h;
    private static Boolean u;
    private final JSONObject gb;
    private int mk;
    private final Boolean tc;
    private final JSONObject tt;
    private static final gb<Integer, d> d = new gb<>(16, 16);
    private static final d hc = new d(null);

    static {
        d();
    }

    public static void d() {
        JSONObject jSONObjectUs = b.us();
        an = jSONObjectUs.optInt("disable_task_setting", 0) == 1;
        b = jSONObjectUs.optJSONObject("disabled_task_keys");
        JSONObject jSONObjectOptJSONObject = jSONObjectUs.optJSONObject("bugfix");
        Boolean boolValueOf = null;
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(ILogConst.PLAY_SOURCE_DEFAULT)) {
            boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt(ILogConst.PLAY_SOURCE_DEFAULT, 0) == 1);
        }
        c = jSONObjectOptJSONObject;
        u = boolValueOf;
    }

    private d(JSONObject jSONObject) {
        Boolean bool;
        this.gb = jSONObject;
        JSONObject jSONObject2 = null;
        boolValueOf = null;
        boolValueOf = null;
        Boolean boolValueOf = null;
        if (jSONObject == null || an("bugfix")) {
            bool = null;
        } else {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("bugfix");
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(ILogConst.PLAY_SOURCE_DEFAULT) && !an(ILogConst.PLAY_SOURCE_DEFAULT)) {
                boolValueOf = Boolean.valueOf(jSONObjectOptJSONObject.optInt(ILogConst.PLAY_SOURCE_DEFAULT, 0) == 1);
            }
            Boolean bool2 = boolValueOf;
            jSONObject2 = jSONObjectOptJSONObject;
            bool = bool2;
        }
        this.tt = jSONObject2;
        this.tc = bool;
    }

    public static JSONObject hc() {
        return b.us();
    }

    public static void d(String str, boolean z) throws JSONException {
        try {
            if (c == null) {
                c = new JSONObject();
            }
            c.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    public static d b() {
        return hc;
    }

    public static d d(int i) {
        return d(i, (com.ss.android.socialbase.downloader.h.b) null);
    }

    public static d d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null) {
            return hc;
        }
        return d(bVar.h(), bVar);
    }

    private static d d(int i, com.ss.android.socialbase.downloader.h.b bVar) {
        d dVarB;
        d dVar = h;
        if (dVar != null && dVar.mk == i) {
            return dVar;
        }
        gb<Integer, d> gbVar = d;
        synchronized (gbVar) {
            dVarB = gbVar.get(Integer.valueOf(i));
        }
        if (dVarB == null) {
            dVarB = bVar == null ? b(i) : hc(bVar);
            synchronized (gbVar) {
                gbVar.put(Integer.valueOf(i), dVarB);
            }
        }
        dVarB.mk = i;
        h = dVarB;
        return dVarB;
    }

    public boolean d(String str) {
        return hc(str, false);
    }

    public boolean hc(String str, boolean z) {
        if (this.tt != null && !an(str)) {
            if (this.tt.has(str)) {
                return this.tt.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.tc;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = c;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return c.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = u;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public int hc(String str) {
        return d(str, 0);
    }

    public int d(String str, int i) {
        JSONObject jSONObject = this.gb;
        if (jSONObject != null && jSONObject.has(str) && !an(str)) {
            return this.gb.optInt(str, i);
        }
        return hc().optInt(str, i);
    }

    public long d(String str, long j) {
        JSONObject jSONObject = this.gb;
        if (jSONObject != null && jSONObject.has(str) && !an(str)) {
            return this.gb.optLong(str, j);
        }
        return hc().optLong(str, j);
    }

    public double d(String str, double d2) {
        JSONObject jSONObject = this.gb;
        if (jSONObject != null && jSONObject.has(str) && !an(str)) {
            return this.gb.optDouble(str, d2);
        }
        return hc().optDouble(str, d2);
    }

    public String b(String str) {
        return d(str, "");
    }

    public String d(String str, String str2) {
        JSONObject jSONObject = this.gb;
        if (jSONObject != null && jSONObject.has(str) && !an(str)) {
            return this.gb.optString(str, str2);
        }
        return hc().optString(str, str2);
    }

    public JSONObject c(String str) {
        JSONObject jSONObject = this.gb;
        if (jSONObject != null && jSONObject.has(str) && !an(str)) {
            return this.gb.optJSONObject(str);
        }
        return hc().optJSONObject(str);
    }

    public JSONArray u(String str) {
        JSONObject jSONObject = this.gb;
        if (jSONObject != null && jSONObject.has(str) && !an(str)) {
            return this.gb.optJSONArray(str);
        }
        return hc().optJSONArray(str);
    }

    public static boolean an(String str) {
        JSONObject jSONObject = b;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public static d d(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == hc() || an) {
            return hc;
        }
        d dVar = h;
        if (dVar != null && dVar.gb == jSONObject) {
            return dVar;
        }
        gb<Integer, d> gbVar = d;
        synchronized (gbVar) {
            for (d dVar2 : gbVar.values()) {
                if (dVar2.gb == jSONObject) {
                    h = dVar2;
                    return dVar2;
                }
            }
            d dVar3 = new d(jSONObject);
            h = dVar3;
            return dVar3;
        }
    }

    public static void d(int i, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == hc() || an) {
            return;
        }
        gb<Integer, d> gbVar = d;
        synchronized (gbVar) {
            d dVar = h;
            if (dVar != null && dVar.gb == jSONObject) {
                dVar.mk = i;
            } else {
                dVar = null;
                Iterator<d> it = gbVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d next = it.next();
                    if (next.gb == jSONObject) {
                        next.mk = i;
                        dVar = next;
                        break;
                    }
                }
                if (dVar == null) {
                    dVar = new d(jSONObject);
                    dVar.mk = i;
                }
                h = dVar;
            }
            d.put(Integer.valueOf(i), dVar);
        }
    }

    public static void hc(int i) {
        d dVar = h;
        if (dVar != null && dVar.mk == i) {
            h = null;
        }
        gb<Integer, d> gbVar = d;
        synchronized (gbVar) {
            gbVar.remove(Integer.valueOf(i));
        }
    }

    private static d b(int i) {
        com.ss.android.socialbase.downloader.h.b bVarGb;
        if (an) {
            return hc;
        }
        Context contextTr = b.tr();
        if (contextTr != null && (bVarGb = h.hc(contextTr).gb(i)) != null) {
            return hc(bVarGb);
        }
        return hc;
    }

    private static d hc(com.ss.android.socialbase.downloader.h.b bVar) {
        if (an) {
            return hc;
        }
        try {
            String strRu = bVar.ru();
            if (!TextUtils.isEmpty(strRu)) {
                return new d(new JSONObject(strRu));
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        return hc;
    }
}
