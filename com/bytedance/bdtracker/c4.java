package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.event.AutoTrackEventType;
import com.bytedance.bdtracker.l0;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c4 extends t3 {
    public int A;
    public String B;
    public List<a4> s;
    public List<w3> t;
    public List<d4> u;
    public List<b4> v;
    public List<g4> w;
    public List<h4> x;
    public JSONObject y;
    public byte[] z;

    @Override // com.bytedance.bdtracker.t3
    public int a(Cursor cursor) {
        this.b = cursor.getLong(0);
        this.c = cursor.getLong(1);
        this.z = cursor.getBlob(2);
        this.A = cursor.getInt(3);
        this.l = cursor.getInt(4);
        this.m = cursor.getString(5);
        this.B = cursor.getString(6);
        this.e = "";
        return 7;
    }

    @Override // com.bytedance.bdtracker.t3
    public t3 a(JSONObject jSONObject) {
        d().error(4, this.a, "Not allowed", new Object[0]);
        return null;
    }

    public final JSONArray a(Set<String> set) {
        d dVarA = b.a(this.m);
        JSONArray jSONArray = new JSONArray();
        if (dVarA == null || !dVarA.isBavEnabled()) {
            List<d4> list = this.u;
            if (list != null) {
                for (d4 d4Var : list) {
                    if (d4Var.C) {
                        jSONArray.put(d4Var.h());
                        if (set != null) {
                            set.add(d4Var.p);
                        }
                    }
                }
            }
        } else if (this.u != null) {
            if (!((dVarA.getInitConfig() == null || AutoTrackEventType.a(dVarA.getInitConfig().getAutoTrackEventType(), 2)) ? false : true)) {
                for (d4 d4Var2 : this.u) {
                    jSONArray.put(d4Var2.h());
                    if (set != null) {
                        set.add(d4Var2.p);
                    }
                }
            }
        }
        List<a4> list2 = this.s;
        if (list2 != null && !list2.isEmpty()) {
            for (a4 a4Var : this.s) {
                jSONArray.put(a4Var.h());
                if (set != null) {
                    set.add(a4Var.p);
                }
            }
        }
        List<h4> list3 = this.x;
        if (list3 != null && !list3.isEmpty()) {
            for (h4 h4Var : this.x) {
                jSONArray.put(h4Var.h());
                if (set != null) {
                    set.add(h4Var.p);
                }
            }
        }
        return jSONArray;
    }

    @Override // com.bytedance.bdtracker.t3
    public List<String> b() {
        return Arrays.asList("_id", "integer primary key autoincrement", "local_time_ms", TypedValues.Custom.S_INT, "_data", "blob", "_fail", TypedValues.Custom.S_INT, ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, TypedValues.Custom.S_INT, "_app_id", "varchar", "e_ids", "varchar");
    }

    @Override // com.bytedance.bdtracker.t3
    public void b(ContentValues contentValues) {
        contentValues.put("local_time_ms", Long.valueOf(this.c));
        contentValues.put("_data", o());
        contentValues.put(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, Integer.valueOf(this.l));
        contentValues.put("_app_id", this.m);
        contentValues.put("e_ids", this.B);
    }

    @Override // com.bytedance.bdtracker.t3
    public void b(JSONObject jSONObject) {
        d().error(4, this.a, "Not allowed", new Object[0]);
    }

    @Override // com.bytedance.bdtracker.t3
    public String c() {
        return String.valueOf(this.b);
    }

    @Override // com.bytedance.bdtracker.t3
    public String f() {
        return "packV2";
    }

    @Override // com.bytedance.bdtracker.t3
    public JSONObject i() throws JSONException {
        int i;
        d dVarA = b.a(this.m);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", this.y);
        jSONObject.put("time_sync", o3.d);
        HashSet hashSet = new HashSet();
        List<b4> list = this.v;
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (b4 b4Var : this.v) {
                jSONArray.put(b4Var.h());
                hashSet.add(b4Var.p);
            }
            jSONObject.put(Config.LAUNCH, jSONArray);
        }
        List<g4> list2 = this.w;
        int i2 = 0;
        if (list2 != null && !list2.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            Iterator<g4> it = this.w.iterator();
            while (it.hasNext()) {
                g4 next = it.next();
                JSONObject jSONObjectH = next.h();
                if (dVarA != null && (i = dVarA.l) > 0) {
                    jSONObjectH.put("launch_from", i);
                    dVarA.l = i2;
                }
                if (this.u != null) {
                    ArrayList arrayList = new ArrayList();
                    for (d4 d4Var : this.u) {
                        if (l0.b.a(d4Var.e, next.e)) {
                            arrayList.add(d4Var);
                        }
                    }
                    if (arrayList.size() != 0) {
                        int size = arrayList.size();
                        JSONArray jSONArray3 = new JSONArray();
                        long j = 0;
                        int i3 = i2;
                        while (i3 < size) {
                            d4 d4Var2 = (d4) arrayList.get(i3);
                            JSONArray jSONArray4 = new JSONArray();
                            d dVar = dVarA;
                            Iterator<g4> it2 = it;
                            jSONArray4.put(0, d4Var2.u);
                            ArrayList arrayList2 = arrayList;
                            int i4 = size;
                            jSONArray4.put(1, (d4Var2.s + 999) / 1000);
                            jSONArray3.put(jSONArray4);
                            long j2 = d4Var2.c;
                            if (j2 > j) {
                                jSONObjectH.put("$page_title", l0.b.a((Object) d4Var2.v));
                                jSONObjectH.put("$page_key", l0.b.a((Object) d4Var2.u));
                                j = j2;
                            }
                            i3++;
                            size = i4;
                            dVarA = dVar;
                            it = it2;
                            arrayList = arrayList2;
                        }
                        jSONObjectH.put("activites", jSONArray3);
                        jSONArray2.put(jSONObjectH);
                        hashSet.add(next.p);
                        dVarA = dVarA;
                        i2 = 0;
                    }
                }
            }
            jSONObject.put("terminate", jSONArray2);
        }
        JSONArray jSONArrayA = a(hashSet);
        if (jSONArrayA.length() > 0) {
            jSONObject.put("event_v3", jSONArrayA);
        }
        List<w3> list3 = this.t;
        if (list3 != null && !list3.isEmpty()) {
            HashMap map = new HashMap();
            for (w3 w3Var : this.t) {
                JSONArray jSONArray5 = (JSONArray) map.get(w3Var.s);
                if (jSONArray5 == null) {
                    jSONArray5 = new JSONArray();
                    map.put(w3Var.s, jSONArray5);
                }
                jSONArray5.put(w3Var.h());
                hashSet.add(w3Var.p);
            }
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        }
        this.B = TextUtils.join(",", hashSet);
        d().debug(4, this.a, "Pack success ts:{}", Long.valueOf(this.c));
        return jSONObject;
    }

    public int k() {
        List<d4> list;
        List<b4> list2 = this.v;
        int size = list2 != null ? 200 - list2.size() : 200;
        List<g4> list3 = this.w;
        if (list3 != null) {
            size -= list3.size();
        }
        d dVarA = b.a(this.m);
        return (dVarA == null || !dVarA.isBavEnabled() || (list = this.u) == null) ? size : size - list.size();
    }

    public Set<String> l() {
        HashSet hashSet = new HashSet();
        if (TextUtils.isEmpty(this.B)) {
            return hashSet;
        }
        hashSet.addAll(Arrays.asList(this.B.split(",")));
        return hashSet;
    }

    public void m() {
        JSONObject jSONObject = this.y;
        if (jSONObject == null) {
            return;
        }
        jSONObject.remove("ssid");
        try {
            List<b4> list = this.v;
            if (list != null) {
                for (b4 b4Var : list) {
                    if (l0.b.d(b4Var.i)) {
                        this.y.put("ssid", b4Var.i);
                        return;
                    }
                }
            }
            List<d4> list2 = this.u;
            if (list2 != null) {
                for (d4 d4Var : list2) {
                    if (l0.b.d(d4Var.i)) {
                        this.y.put("ssid", d4Var.i);
                        return;
                    }
                }
            }
            List<w3> list3 = this.t;
            if (list3 != null) {
                for (w3 w3Var : list3) {
                    if (l0.b.d(w3Var.i)) {
                        this.y.put("ssid", w3Var.i);
                        return;
                    }
                }
            }
            List<a4> list4 = this.s;
            if (list4 != null) {
                for (a4 a4Var : list4) {
                    if (l0.b.d(a4Var.i)) {
                        this.y.put("ssid", a4Var.i);
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            d().error(4, this.a, "Reload ssid from event failed", th, new Object[0]);
        }
    }

    public void n() {
        JSONObject jSONObject = this.y;
        if (jSONObject == null) {
            return;
        }
        jSONObject.remove("user_unique_id_type");
        try {
            List<b4> list = this.v;
            if (list != null) {
                for (b4 b4Var : list) {
                    if (l0.b.d(b4Var.h)) {
                        this.y.put("user_unique_id_type", b4Var.h);
                        return;
                    }
                }
            }
            List<d4> list2 = this.u;
            if (list2 != null) {
                for (d4 d4Var : list2) {
                    if (l0.b.d(d4Var.h)) {
                        this.y.put("user_unique_id_type", d4Var.h);
                        return;
                    }
                }
            }
            List<w3> list3 = this.t;
            if (list3 != null) {
                for (w3 w3Var : list3) {
                    if (l0.b.d(w3Var.h)) {
                        this.y.put("user_unique_id_type", w3Var.h);
                        return;
                    }
                }
            }
            List<a4> list4 = this.s;
            if (list4 != null) {
                for (a4 a4Var : list4) {
                    if (l0.b.d(a4Var.h)) {
                        this.y.put("user_unique_id_type", a4Var.h);
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            d().error(4, this.a, "Reload uuid type from event failed", th, new Object[0]);
        }
    }

    public final byte[] o() {
        try {
            return h().toString().getBytes("UTF-8");
        } catch (Throwable th) {
            d().error(4, this.a, "Convert json to bytes failed", th, new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.bdtracker.t3
    public String toString() {
        StringBuilder sb = new StringBuilder("Pack detail:");
        List<a4> list = this.s;
        int size = list != null ? 0 + list.size() : 0;
        List<w3> list2 = this.t;
        if (list2 != null) {
            size += list2.size();
        }
        if (size > 0) {
            sb.append("\teventCount=").append(size);
        }
        List<d4> list3 = this.u;
        if (list3 != null && !list3.isEmpty()) {
            sb.append("\tpageCount=").append(this.u.size());
        }
        List<b4> list4 = this.v;
        if (list4 != null && !list4.isEmpty()) {
            sb.append("\tlaunchCount=").append(this.v.size());
        }
        List<g4> list5 = this.w;
        if (list5 != null && !list5.isEmpty()) {
            sb.append("\tterminateCount=").append(this.w.size());
        }
        List<h4> list6 = this.x;
        if (list6 != null && !list6.isEmpty()) {
            sb.append("\ttraceCount=").append(this.x.size());
        }
        if (this.A > 0) {
            sb.append("\tfailCount=").append(this.A);
        }
        return sb.toString();
    }
}
