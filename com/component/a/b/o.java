package com.component.a.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class o implements Iterable<String> {
    private final JSONObject a = new JSONObject();

    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayNames = this.a.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                arrayList.add(jSONArrayNames.optString(i));
            }
        }
        return arrayList;
    }

    public List<Object> b() {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayNames = this.a.names();
        if (jSONArrayNames != null) {
            for (int i = 0; i < jSONArrayNames.length(); i++) {
                arrayList.add(b(jSONArrayNames.optString(i)));
            }
        }
        return arrayList;
    }

    public boolean a(String str) {
        return this.a.has(str);
    }

    public Object b(String str) {
        return this.a.opt(str);
    }

    public int a(String str, int i) {
        return this.a.optInt(str, i);
    }

    public long a(String str, long j) {
        return this.a.optLong(str, j);
    }

    public double a(String str, double d) {
        return this.a.optDouble(str, d);
    }

    public String a(String str, String str2) {
        return this.a.optString(str, str2);
    }

    public boolean a(String str, boolean z) {
        return this.a.optBoolean(str, z);
    }

    public o b(String str, Object obj) {
        com.component.a.i.n.b(this.a, str, obj);
        return this;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.a.keys();
    }
}
