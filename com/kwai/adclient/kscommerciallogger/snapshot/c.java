package com.kwai.adclient.kscommerciallogger.snapshot;

import com.baidu.mobstat.forbes.Config;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private final String crJ;
    private final LinkedList<d> crK;
    private int crL;
    private final int crM;
    private long crN;

    c(String str) {
        this(str, 10);
    }

    c(String str, int i) {
        this.crJ = str == null ? "" : str;
        this.crK = new LinkedList<>();
        this.crM = Math.min(i, 30);
        this.crN = System.currentTimeMillis();
    }

    final String getName() {
        return this.crJ;
    }

    synchronized JSONObject jl(String str) {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<d> it = this.crK.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().arB());
            }
            jSONObject.put("session_id", str);
            jSONObject.put("segment_name", this.crJ);
            jSONObject.put("spans", jSONArray);
            this.crN = System.currentTimeMillis();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public synchronized d jk(String str) {
        d dVar;
        if (this.crK.size() >= this.crM) {
            this.crK.removeFirst();
        }
        StringBuilder sbAppend = new StringBuilder().append(str).append(Config.replace);
        int i = this.crL;
        this.crL = i + 1;
        dVar = new d(sbAppend.append(i).toString());
        this.crK.addLast(dVar);
        this.crN = System.currentTimeMillis();
        return dVar;
    }

    public final synchronized long arC() {
        return this.crN;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.crJ.equals(((c) obj).crJ);
    }

    public int hashCode() {
        return Objects.hash(this.crJ);
    }
}
