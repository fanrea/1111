package ca.da.ca.fa;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.apm.applog.AppLog;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeviceManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class h {
    public volatile boolean a;
    public final Context b;
    public final g c;
    public final SharedPreferences f;
    public ca.da.ca.ja.k g;
    public boolean i;
    public final ArrayList<c> e = new ArrayList<>(32);
    public int h = 0;
    public volatile JSONObject d = new JSONObject();

    static {
        new String[]{"channel", "package", "app_version"};
    }

    public h(Context context, g gVar) throws JSONException {
        JSONObject jSONObject;
        this.b = context;
        this.c = gVar;
        this.f = gVar.e;
        this.g = j.a(context, gVar);
        Map<String, String> commonHeader = gVar.b.getCommonHeader();
        if (commonHeader == null || commonHeader.isEmpty()) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            JSONObject jSONObjectC = c();
            if (jSONObjectC != null) {
                ca.da.ca.ja.t.a(jSONObject, jSONObjectC);
            }
            try {
                for (Map.Entry<String, String> entry : commonHeader.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception e) {
                ca.da.ca.ja.r.a("", e);
            }
        }
        a(jSONObject);
    }

    public void a(Account account) {
        ca.da.ca.ia.a aVar;
        j.d = account;
        for (j jVar : j.c.values()) {
            if ((jVar.a instanceof ca.da.ca.ja.f) && (aVar = ((ca.da.ca.ja.f) jVar.a).c) != null) {
                aVar.a(account);
            }
        }
        ca.da.ca.ha.b.a = account;
    }

    public String b() {
        return this.d.optString("bd_did", "");
    }

    public void c(String str) {
        JSONObject jSONObjectC;
        if (TextUtils.isEmpty(str) || (jSONObjectC = c()) == null || !jSONObjectC.has(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        ca.da.ca.ja.t.a(jSONObject, jSONObjectC);
        jSONObject.remove(str);
        a(jSONObject);
    }

    public JSONObject d() {
        if (this.a) {
            return this.d;
        }
        return null;
    }

    public int e() {
        String strOptString = this.d.optString(com.baidu.mobads.upgrade.remote.gray.c.l, "");
        String strOptString2 = this.d.optString("install_id", "");
        String strOptString3 = this.d.optString("bd_did", "");
        if ((ca.da.ca.ja.t.a(strOptString) || ca.da.ca.ja.t.a(strOptString3)) && ca.da.ca.ja.t.a(strOptString2)) {
            return this.f.getInt("version_code", 0) == this.d.optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public String f() {
        return this.d.optString("ssid", "");
    }

    public String g() {
        if (this.a) {
            return this.d.optString("user_unique_id", "");
        }
        g gVar = this.c;
        return gVar != null ? gVar.c.getString("user_unique_id", null) : "";
    }

    public int h() throws JSONException {
        int iOptInt = this.a ? this.d.optInt("version_code", -1) : -1;
        for (int i = 0; i < 3 && iOptInt == -1; i++) {
            j();
            iOptInt = this.a ? this.d.optInt("version_code", -1) : -1;
        }
        return iOptInt;
    }

    public String i() throws JSONException {
        String strOptString = this.a ? this.d.optString("app_version", null) : null;
        for (int i = 0; i < 3 && strOptString == null; i++) {
            j();
            strOptString = this.a ? this.d.optString("app_version", null) : null;
        }
        return strOptString;
    }

    public boolean j() throws JSONException {
        synchronized (this.e) {
            if (this.e.size() == 0) {
                this.e.add(new d(this.b));
                this.e.add(new f(this.b, this.c));
                this.e.add(new k(this.b));
                this.e.add(new l(this.b));
                this.e.add(new r(this.b, this.c, this));
                this.e.add(new m(this.b));
                this.e.add(new p(this.b, this.c));
                this.e.add(new q());
                this.e.add(new s(this.b, this.c, this));
                this.e.add(new t(this.b));
                this.e.add(new u(this.b));
                this.e.add(new i(this.b, this));
                this.e.add(new n(this.b));
                if (AppLog.isOAIdEnabled()) {
                    this.e.add(new o(this.b, this.c));
                }
                this.e.add(new e(this.c));
                this.e.add(new a(this.b));
            }
        }
        JSONObject jSONObject = this.d;
        JSONObject jSONObject2 = new JSONObject();
        ca.da.ca.ja.t.a(jSONObject2, jSONObject);
        Iterator<c> it = this.e.iterator();
        int i = 0;
        int i2 = 0;
        boolean z = true;
        while (it.hasNext()) {
            c next = it.next();
            if (!next.a || next.c || a(next)) {
                try {
                    next.a = next.a(jSONObject2);
                } catch (SecurityException e) {
                    if (!next.b) {
                        i++;
                        ca.da.ca.ja.r.a(ca.ca.ca.ca.a.a("loadHeader, ").append(this.h).toString(), e);
                        if (!next.a && this.h > 10) {
                            next.a = true;
                        }
                    }
                } catch (JSONException e2) {
                    ca.da.ca.ja.r.a(e2);
                }
                if (!next.a && !next.b) {
                    i2++;
                }
            }
            z &= next.a || next.b;
        }
        JSONObject jSONObject3 = this.d;
        this.d = jSONObject2;
        Iterator<String> itKeys = jSONObject3.keys();
        while (itKeys.hasNext()) {
            String next2 = itKeys.next();
            a(next2, jSONObject3.opt(next2));
        }
        this.a = z;
        if (ca.da.ca.ja.r.b) {
            ca.da.ca.ja.r.a(ca.ca.ca.ca.a.a("loadHeader, ").append(this.a).append(", ").append(this.h).append(", ").append(this.d.toString()).toString(), (Throwable) null);
        } else {
            ca.da.ca.ja.r.a(ca.ca.ca.ca.a.a("loadHeader, ").append(this.a).append(", ").append(this.h).toString(), (Throwable) null);
        }
        if (i > 0 && i == i2) {
            this.h++;
            if (e() != 0) {
                this.h += 10;
            }
        }
        if (this.a) {
            ca.da.ca.ja.b.a(a()).onIdLoaded(AppLog.getInstance(this.c.c()).getDid(), this.d.optString("install_id", ""), f());
        }
        return this.a;
    }

    public final Set<String> b(String str) {
        String[] strArrSplit;
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(str) && (strArrSplit = str.split(",")) != null && strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                if (!TextUtils.isEmpty(str2)) {
                    hashSet.add(str2);
                }
            }
        }
        return hashSet;
    }

    public void d(String str) {
        if (a("ab_sdk_version", str)) {
            ca.ca.ca.ca.a.a(this.c.c, "ab_sdk_version", str);
        }
    }

    public final synchronized void a(String str) {
        String strOptString = this.d.optString("ab_sdk_version");
        if (!TextUtils.isEmpty(strOptString)) {
            for (String str2 : strOptString.split(",")) {
                if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                    if (ca.da.ca.ja.r.b) {
                        ca.da.ca.ja.r.a("addExposedVid ready added " + strOptString, (Throwable) null);
                    }
                    return;
                }
            }
            str = strOptString + "," + str;
        }
        d(str);
        String strF = this.c.f();
        if (this.c.e.getBoolean("bav_ab_config", false) && this.c.b.isAbEnable()) {
            Set<String> setB = b(str);
            setB.removeAll(b(strF));
            ca.da.ca.ja.b.a(a()).onAbVidsChange(a(setB), strF);
        }
    }

    public final JSONObject c() {
        if (this.a) {
            return this.d.optJSONObject(SchedulerSupport.CUSTOM);
        }
        g gVar = this.c;
        if (gVar == null) {
            return null;
        }
        try {
            return new JSONObject(gVar.c.getString("header_custom_info", null));
        } catch (Exception unused) {
            return null;
        }
    }

    public synchronized void e(String str) {
        Set<String> setB = b(this.c.f());
        Set<String> setB2 = b(this.d.optString("ab_sdk_version"));
        setB2.removeAll(setB);
        setB2.addAll(b(str));
        this.c.a(str);
        d(a(setB2));
    }

    public String a() {
        return this.d.optString("aid", this.c.c());
    }

    public final boolean a(String str, Object obj) {
        boolean z;
        Object objOpt = this.d.opt(str);
        if ((obj == null || obj.equals(objOpt)) && (obj != null || objOpt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.d;
                    JSONObject jSONObject2 = new JSONObject();
                    ca.da.ca.ja.t.a(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.d = jSONObject2;
                } catch (JSONException e) {
                    ca.da.ca.ja.r.a(e);
                }
            }
            z = true;
        }
        ca.da.ca.ja.r.a("updateHeader, " + str + ", " + objOpt + ", " + obj, (Throwable) null);
        return z;
    }

    public final boolean a(c cVar) {
        boolean z = !this.c.k() && cVar.d;
        ca.da.ca.ja.r.a("needSyncFromSub " + cVar + " " + z, (Throwable) null);
        return z;
    }

    public final String a(Set<String> set) {
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

    public void a(HashMap<String, Object> map) {
        JSONObject jSONObject;
        if (map == null || map.isEmpty()) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            JSONObject jSONObjectC = c();
            if (jSONObjectC != null) {
                ca.da.ca.ja.t.a(jSONObject, jSONObjectC);
            }
            try {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (Exception e) {
                ca.da.ca.ja.r.a("", e);
            }
        }
        a(jSONObject);
    }

    public final void a(JSONObject jSONObject) {
        if (a(SchedulerSupport.CUSTOM, jSONObject)) {
            this.c.c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }
}
