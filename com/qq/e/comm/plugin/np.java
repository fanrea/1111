package com.qq.e.comm.plugin;

import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class np {
    private String a;
    private String b;
    private int c;
    private List<yn> d;
    private HashMap<String, String> e;

    public np(JSONObject jSONObject) {
        this.c = 30000;
        if (jSONObject != null) {
            this.a = jSONObject.optString(Config.INPUT_DEF_VERSION);
            this.b = jSONObject.optString("suid");
            this.c = jSONObject.optInt("update_interval");
            this.e = new HashMap<>();
            this.d = new ArrayList();
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("mediation_list");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                yn ynVar = new yn(jSONArrayOptJSONArray.optJSONObject(i));
                this.d.add(ynVar);
                this.e.putAll(ynVar.k());
            }
        }
    }

    public String a() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public List<yn> b() {
        return this.d;
    }

    public HashMap<String, String> e() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("version: " + this.a + ", updateInterval: " + this.c + ", mediation_list:");
        for (yn ynVar : this.d) {
            sb.append("\n");
            sb.append(ynVar);
        }
        return sb.toString();
    }
}
