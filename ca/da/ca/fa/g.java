package ca.da.ca.fa;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.apm.applog.InitConfig;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.apm.common.utility.ToolUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ConfigManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class g {
    public final Context a;
    public final InitConfig b;
    public final SharedPreferences c;
    public final SharedPreferences d;
    public final SharedPreferences e;
    public volatile JSONObject f;
    public volatile String g;
    public volatile HashSet<String> j;
    public String p;
    public boolean q;
    public int k = 0;
    public int l = 27;
    public long m = 0;
    public int n = 0;
    public long o = 0;
    public final HashSet<String> h = new HashSet<>();
    public final HashSet<String> i = new HashSet<>();

    public g(Context context, InitConfig initConfig) {
        this.p = null;
        this.a = context;
        this.b = initConfig;
        this.e = context.getSharedPreferences(initConfig.getSpName(), 0);
        this.c = context.getSharedPreferences(ca.ca.ca.ca.a.a("header_custom_").append(initConfig.getAid()).toString(), 0);
        this.d = context.getSharedPreferences(ca.ca.ca.ca.a.a("last_sp_session_").append(initConfig.getAid()).toString(), 0);
        this.p = initConfig.getDid();
        this.q = initConfig.isCustomLaunch();
    }

    public JSONObject a() {
        JSONObject jSONObject = this.f;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    jSONObject = new JSONObject(this.c.getString("ab_configure", ""));
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.f = jSONObject;
            }
        }
        return jSONObject;
    }

    public void a(boolean z) {
    }

    public String b() {
        return this.c.getString("ab_sdk_version", "");
    }

    public String c() {
        return this.b.getAid();
    }

    public String d() {
        String channel = this.b.getChannel();
        if (TextUtils.isEmpty(channel)) {
            channel = j();
        }
        if (!TextUtils.isEmpty(channel)) {
            return channel;
        }
        try {
            return this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");
        } catch (Throwable th) {
            ca.da.ca.ja.r.a("getChannel", th);
            return channel;
        }
    }

    public long e() {
        long j = this.o;
        return (j > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT ? 1 : (j == ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT ? 0 : -1)) >= 0 && (j > 300000L ? 1 : (j == 300000L ? 0 : -1)) <= 0 ? j : this.e.getLong("batch_event_interval", 60000L);
    }

    public String f() {
        String string = this.g;
        if (TextUtils.isEmpty(string)) {
            synchronized (this) {
                string = this.c.getString("external_ab_version", "");
                this.g = string;
            }
        }
        return string;
    }

    public int g() {
        return 0;
    }

    public long h() {
        return this.e.getLong("session_interval", 30000L);
    }

    public String i() {
        return ca.ca.ca.ca.a.a("ssid_").append(this.b.getAid()).toString();
    }

    public String j() {
        return this.b.getTweakedChannel();
    }

    public boolean k() {
        if (this.b.getProcess() == 0) {
            String str = ca.da.ca.ja.t.a;
            if (TextUtils.isEmpty(str)) {
                ca.da.ca.ja.t.a = ToolUtils.getCurrentProcessName();
                if (ca.da.ca.ja.r.b) {
                    ca.da.ca.ja.r.a(ca.ca.ca.ca.a.a("getProcessName, ").append(ca.da.ca.ja.t.a).toString(), (Throwable) null);
                }
                str = ca.da.ca.ja.t.a;
            }
            if (TextUtils.isEmpty(str)) {
                this.b.setProcess(0);
            } else {
                this.b.setProcess(str.contains(":") ? 2 : 1);
            }
        }
        return this.b.getProcess() == 1;
    }

    public void l() {
    }

    public ArrayList<ca.da.ca.ia.b> b(ArrayList<ca.da.ca.ia.b> arrayList) {
        String str;
        Iterator<ca.da.ca.ia.b> it = arrayList.iterator();
        ArrayList<ca.da.ca.ia.b> arrayList2 = null;
        while (it.hasNext()) {
            ca.da.ca.ia.b next = it.next();
            if (next instanceof ca.da.ca.ia.e) {
                ca.da.ca.ia.e eVar = (ca.da.ca.ia.e) next;
                str = eVar.m + (!TextUtils.isEmpty(eVar.n) ? eVar.n : "");
            } else {
                str = next instanceof ca.da.ca.ia.g ? ((ca.da.ca.ia.g) next).n : "!_NO_NAME_!";
            }
            HashSet<String> hashSet = this.j;
            if (hashSet == null) {
                try {
                    JSONArray jSONArray = new JSONArray(this.e.getString("real_time_events", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                    int length = jSONArray.length();
                    HashSet<String> hashSet2 = new HashSet<>();
                    for (int i = 0; i < length; i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            hashSet2.add(string);
                        }
                    }
                    hashSet = hashSet2;
                } catch (Throwable th) {
                    ca.da.ca.ja.r.a(th);
                    hashSet = new HashSet<>();
                }
            }
            if (hashSet.contains(str)) {
                it.remove();
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public void a(String str) {
        ca.da.ca.ja.r.a("setExternalAbVersion, " + str, (Throwable) null);
        ca.ca.ca.ca.a.a(this.c, "external_ab_version", str);
        this.g = null;
    }

    public boolean a(ArrayList<ca.da.ca.ia.b> arrayList) {
        if (arrayList == null || arrayList.size() == 0 || (this.h.size() == 0 && this.i.size() == 0)) {
            return true;
        }
        Iterator<ca.da.ca.ia.b> it = arrayList.iterator();
        while (it.hasNext()) {
            ca.da.ca.ia.b next = it.next();
            if (next instanceof ca.da.ca.ia.e) {
                ca.da.ca.ia.e eVar = (ca.da.ca.ia.e) next;
                if (this.h.contains(eVar.m + (!TextUtils.isEmpty(eVar.n) ? eVar.n : ""))) {
                    it.remove();
                }
            } else if ((next instanceof ca.da.ca.ia.g) && this.i.contains(((ca.da.ca.ia.g) next).n)) {
                it.remove();
            }
        }
        return true;
    }
}
