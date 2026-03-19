package com.bytedance.sdk.component.adexpress.d.b;

import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.forbes.Config;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private Map<String, d> an = new ConcurrentHashMap();
    private String b;
    private List<C0260d> c;
    private String d;
    private String hc;
    private hc u;

    public Map<String, d> d() {
        return this.an;
    }

    public String hc() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public String b() {
        return this.hc;
    }

    public void hc(String str) {
        this.hc = str;
    }

    public String c() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void d(hc hcVar) {
        this.u = hcVar;
    }

    public hc u() {
        return this.u;
    }

    public List<C0260d> getResources() {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        return this.c;
    }

    public void d(List<C0260d> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.c = list;
    }

    public boolean an() {
        return (TextUtils.isEmpty(c()) || TextUtils.isEmpty(b()) || TextUtils.isEmpty(hc())) ? false : true;
    }

    public JSONObject h() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", hc());
            jSONObject.putOpt(Config.INPUT_DEF_VERSION, b());
            jSONObject.putOpt(LiveConfigKey.MAIN, c());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (C0260d c0260d : getResources()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", c0260d.d());
                    jSONObject2.putOpt(TKDownloadReason.KSAD_TK_MD5, c0260d.hc());
                    jSONObject2.putOpt("level", Integer.valueOf(c0260d.b()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            if (!this.an.isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                boolean z = false;
                for (String str : this.an.keySet()) {
                    d dVar = this.an.get(str);
                    if (dVar != null) {
                        jSONObject3.put(str, dVar.h());
                        z = true;
                    }
                }
                if (z) {
                    jSONObject.put("engines", jSONObject3);
                }
            }
            hc hcVarU = u();
            if (hcVarU != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("url", hcVarU.d);
                jSONObject4.put(TKDownloadReason.KSAD_TK_MD5, hcVarU.hc);
                JSONObject jSONObject5 = new JSONObject();
                List<Pair<String, String>> listHc = hcVarU.hc();
                if (listHc != null) {
                    for (Pair<String, String> pair : listHc) {
                        jSONObject5.put((String) pair.first, pair.second);
                    }
                }
                jSONObject4.put("map", jSONObject5);
                jSONObject.putOpt("resources_archive", jSONObject4);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String gb() {
        JSONObject jSONObjectH;
        if (!an() || (jSONObjectH = h()) == null) {
            return null;
        }
        return jSONObjectH.toString();
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.d.b.d$d, reason: collision with other inner class name */
    public static class C0260d {
        private int b;
        private String d;
        private String hc;

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof C0260d) {
                String str2 = this.d;
                if (str2 != null) {
                    C0260d c0260d = (C0260d) obj;
                    if (str2.equals(c0260d.d()) && (str = this.hc) != null && str.equals(c0260d.hc())) {
                        return true;
                    }
                }
                return false;
            }
            return super.equals(obj);
        }

        public String d() {
            return this.d;
        }

        public void d(String str) {
            this.d = str;
        }

        public String hc() {
            return this.hc;
        }

        public void hc(String str) {
            this.hc = str;
        }

        public int b() {
            return this.b;
        }

        public void d(int i) {
            this.b = i;
        }
    }

    public static class hc {
        private List<Pair<String, String>> b;
        private String d;
        private String hc;

        public String d() {
            return this.d;
        }

        public void d(String str) {
            this.d = str;
        }

        public void hc(String str) {
            this.hc = str;
        }

        public void d(List<Pair<String, String>> list) {
            this.b = list;
        }

        public List<Pair<String, String>> hc() {
            return this.b;
        }
    }

    public static d c(String str) {
        if (str == null) {
            return null;
        }
        try {
            return d(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static d d(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.d(jSONObject.optString("name"));
        dVar.hc(jSONObject.optString(Config.INPUT_DEF_VERSION));
        dVar.b(jSONObject.optString(LiveConfigKey.MAIN));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                C0260d c0260d = new C0260d();
                c0260d.d(jSONObjectOptJSONObject2.optString("url"));
                c0260d.hc(jSONObjectOptJSONObject2.optString(TKDownloadReason.KSAD_TK_MD5));
                c0260d.d(jSONObjectOptJSONObject2.optInt("level"));
                arrayList.add(c0260d);
            }
        }
        dVar.d(arrayList);
        try {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("engines");
            if (jSONObjectOptJSONObject3 != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject3.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    d dVarD = d(jSONObjectOptJSONObject3.optJSONObject(next));
                    if (dVarD != null) {
                        dVar.d().put(next, dVarD);
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (jSONObject.has("resources_archive") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            hc hcVar = new hc();
            hcVar.d(jSONObjectOptJSONObject.optString("url"));
            hcVar.hc(jSONObjectOptJSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("map");
            if (jSONObjectOptJSONObject4 != null) {
                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                ArrayList arrayList2 = new ArrayList();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    arrayList2.add(new Pair<>(next2, jSONObjectOptJSONObject4.optString(next2)));
                }
                hcVar.d(arrayList2);
            }
            dVar.d(hcVar);
        }
        if (dVar.an()) {
            return dVar;
        }
        return null;
    }
}
