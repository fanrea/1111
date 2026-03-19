package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.sigmob.sdk.base.mta.PointParamKey;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ba {
    private static final String[] an = {"channel", "package", "app_version"};
    private final fs b;
    private boolean d;
    private final SharedPreferences h;
    private final Context hc;
    private final ArrayList<zw> u = new ArrayList<>(32);
    private int gb = 0;
    private JSONObject c = new JSONObject();

    public ba(Context context, fs fsVar) {
        this.hc = context;
        this.b = fsVar;
        this.h = fsVar.c();
        if (d.hc) {
            f.d(context);
        }
    }

    public JSONObject d() {
        if (this.d) {
            return k();
        }
        return null;
    }

    public <T> T d(String str, T t) {
        Object objOpt;
        JSONObject jSONObjectK = k();
        if (jSONObjectK == null || (objOpt = jSONObjectK.opt(str)) == null) {
            objOpt = null;
        }
        return objOpt == null ? t : (T) objOpt;
    }

    private JSONObject k() {
        return this.c;
    }

    public int hc() throws JSONException {
        int iOptInt = this.d ? k().optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && iOptInt == -1; i++) {
            an();
            iOptInt = this.d ? k().optInt("version_code", -1) : -1;
        }
        return iOptInt;
    }

    public String b() throws JSONException {
        String strOptString = this.d ? k().optString("app_version", null) : null;
        for (int i = 0; i < 3 && strOptString == null; i++) {
            an();
            strOptString = this.d ? k().optString("app_version", null) : null;
        }
        return strOptString;
    }

    public void c() {
        de.an().tt();
    }

    public void u() {
        try {
            new tr(this.hc, this.b).d(this.c);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.b(Config.OAID, "e:" + e.getMessage(), e);
        }
    }

    public boolean an() throws JSONException {
        synchronized (this.u) {
            if (this.u.size() == 0) {
                this.u.add(new j(this.hc, this.b));
                this.u.add(new us(this.hc));
                this.u.add(new z(this.hc, this.b));
                this.u.add(new mt(this.hc));
                this.u.add(new hv(this.hc));
                this.u.add(new bc(this.hc, this.b));
                this.u.add(new dc(this.hc));
                this.u.add(new nv(this.hc, this.b));
                this.u.add(new y(this.hc, this.b));
                this.u.add(new wl());
                this.u.add(new q(this.b));
                this.u.add(new ru(this.hc));
                this.u.add(new yn(this.hc));
                this.u.add(new l(this.hc, this.b));
                this.u.add(new he(this.hc, this.b));
                this.u.add(new tr(this.hc, this.b));
                this.u.add(new s(this.hc, this.b));
            }
        }
        JSONObject jSONObjectK = k();
        JSONObject jSONObject = new JSONObject();
        fv.hc(jSONObject, jSONObjectK);
        Iterator<zw> it = this.u.iterator();
        int i = 0;
        int i2 = 0;
        boolean z = true;
        while (it.hasNext()) {
            zw next = it.next();
            if (!next.d || next.b || d(next)) {
                try {
                    next.d = next.d(jSONObject);
                } catch (SecurityException e) {
                    if (!next.hc) {
                        i++;
                        um.hc("loadHeader, " + this.gb, e);
                        if (!next.d && this.gb > 10) {
                            next.d = true;
                        }
                    }
                } catch (JSONException e2) {
                    um.hc(e2);
                }
                if (!next.d && !next.hc) {
                    i2++;
                }
            }
            z &= next.d || next.hc;
        }
        if (z) {
            int length = an.length;
            for (int i3 = 0; i3 < length; i3++) {
                z &= !TextUtils.isEmpty(jSONObject.optString(r7[i3]));
            }
            String strOptString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    jSONObject.put("user_unique_id", strOptString);
                } catch (JSONException unused) {
                }
            }
        }
        this.c = jSONObject;
        this.d = z;
        if (um.hc) {
            um.d("loadHeader, " + this.d + ", " + this.gb + ", " + this.c.toString(), null);
        } else {
            um.c("loadHeader, " + this.d + ", " + this.gb, null);
        }
        if (i > 0 && i == i2) {
            this.gb++;
            if (mk() != 0) {
                this.gb += 10;
            }
        }
        if (this.d) {
            d.mk().d(h(), gb(), tt());
        }
        return this.d;
    }

    private boolean d(zw zwVar) {
        boolean z = !this.b.w() && zwVar.c;
        if (um.hc) {
            um.d("needSyncFromSub " + zwVar + " " + z, null);
        }
        return z;
    }

    public void d(JSONObject jSONObject) {
        this.b.b(jSONObject);
        hc(jSONObject);
    }

    private synchronized void hc(JSONObject jSONObject) {
        if (jSONObject == null) {
            um.hc("null abconfig", null);
            return;
        }
        String strOptString = k().optString("ab_version");
        if (!TextUtils.isEmpty(strOptString)) {
            String[] strArrSplit = strOptString.split(",");
            Set<String> hashSet = new HashSet<>();
            for (String str : strArrSplit) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
            Iterator<String> itKeys = jSONObject.keys();
            HashSet hashSet2 = new HashSet();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next instanceof String) {
                    String str2 = next;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            hashSet2.add(jSONObject.getJSONObject(str2).optString(PointParamKey.VID));
                        } catch (JSONException e) {
                            um.hc(e);
                        }
                    }
                }
            }
            hashSet.retainAll(hashSet2);
            hc("ab_version", d(hashSet));
        }
    }

    private String d(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public void d(HashMap<String, Object> map) throws JSONException {
        JSONObject jSONObjectOptJSONObject = null;
        if (map != null && !map.isEmpty()) {
            try {
                jSONObjectOptJSONObject = k().optJSONObject(SchedulerSupport.CUSTOM);
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObjectOptJSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e) {
                um.hc(e);
            }
        }
        if (hc(SchedulerSupport.CUSTOM, jSONObjectOptJSONObject)) {
            this.b.hc(jSONObjectOptJSONObject);
        }
    }

    public String h() {
        return k().optString(com.baidu.mobads.upgrade.remote.gray.c.l, "");
    }

    public String gb() {
        return k().optString("install_id", "");
    }

    public String tt() {
        return k().optString("ssid", "");
    }

    public String tc() {
        return k().optString("user_unique_id", "");
    }

    private boolean hc(String str, Object obj) {
        boolean z;
        Object objOpt = k().opt(str);
        if ((obj == null || obj.equals(objOpt)) && (obj != null || objOpt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.c;
                    JSONObject jSONObject2 = new JSONObject();
                    fv.hc(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.c = jSONObject2;
                } catch (JSONException e) {
                    um.hc(e);
                }
            }
            z = true;
        }
        um.d("updateHeader, " + str + ", " + objOpt + ", " + obj, null);
        return z;
    }

    static void d(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    static boolean d(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && ((cCharAt < 'A' || cCharAt > 'F') && cCharAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean hc(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str) && !"unknown".equalsIgnoreCase(str) && !"Null".equalsIgnoreCase(str)) {
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                }
                if (str.charAt(i) != '0') {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    public int mk() {
        String strOptString = k().optString(com.baidu.mobads.upgrade.remote.gray.c.l, "");
        k().optString("install_id", "");
        if (hc(strOptString)) {
            return this.h.getInt("version_code", 0) == k().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public long mq() {
        return k().optLong("register_time", 0L);
    }

    public boolean d(JSONObject jSONObject, String str, String str2, String str3) throws JSONException {
        boolean z;
        boolean z2;
        if (um.hc) {
            um.d("saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + jSONObject, null);
        }
        boolean zHc = hc(str);
        boolean zHc2 = hc(str2);
        try {
            boolean zHc3 = hc(str3);
            int i = this.h.getInt("version_code", 0);
            int iOptInt = k().optInt("version_code", 0);
            SharedPreferences.Editor editorEdit = this.h.edit();
            if (i != iOptInt) {
                editorEdit.putInt("version_code", iOptInt);
            }
            if (zHc) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                editorEdit.putLong("register_time", jCurrentTimeMillis);
                hc("register_time", Long.valueOf(jCurrentTimeMillis));
            } else if (!zHc) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                d.d("tt_fetch_did_error", jSONObject2);
            }
            String strOptString = k().optString(com.baidu.mobads.upgrade.remote.gray.c.l, "");
            if (zHc && hc(com.baidu.mobads.upgrade.remote.gray.c.l, str)) {
                editorEdit.putString(com.baidu.mobads.upgrade.remote.gray.c.l, str);
                z = true;
            } else {
                z = false;
            }
            String strOptString2 = k().optString("install_id", "");
            if (zHc2 && hc("install_id", str2)) {
                editorEdit.putString("install_id", str2);
                z = true;
            }
            String strOptString3 = k().optString("ssid", "");
            if (zHc3 && hc("ssid", str3)) {
                editorEdit.putString("ssid", str3);
                z2 = true;
            } else {
                z2 = z;
            }
            d.mk().d(z2, strOptString, str, strOptString2, str2, strOptString3, str3);
            editorEdit.apply();
        } catch (JSONException e) {
            um.hc(e);
        }
        return zHc && zHc2;
    }

    public String uo() {
        return k().optString("ab_sdk_version", "");
    }
}
