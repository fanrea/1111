package com.bykv.vk.openvk.component.video.api.b;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements Serializable {
    private String an;
    private b c;
    private long cb;
    public String d;
    private String e;
    private int h;
    public int hc;
    private int jh;
    private List<String> k;
    private String mk;
    private int mq;
    private int rf;
    private b u;
    private int uo;
    private boolean w;
    private boolean yo;
    private int gb = 204800;
    private int tt = 0;
    private int tc = 0;
    public final HashMap<String, Object> b = new HashMap<>();
    private int sy = 10000;
    private int de = 10000;
    private int v = 10000;
    private int np = 0;
    private JSONObject yi = new JSONObject();

    public c(String str, b bVar, b bVar2, int i, int i2) {
        this.rf = 0;
        this.jh = 0;
        this.an = str;
        this.c = bVar;
        this.u = bVar2;
        this.rf = i;
        this.jh = i2;
    }

    public JSONObject d() {
        return this.yi;
    }

    public int hc() {
        return this.yi.optInt("pitaya_cache_size", 0);
    }

    public int b() {
        return this.yi.optInt("pitaya_code", 0);
    }

    public String c() {
        return this.yi.optString("pitaya_msg");
    }

    public String u() {
        return this.an;
    }

    public void d(String str) {
        this.an = str;
    }

    public void d(int i) {
        this.h = i;
    }

    public int an() {
        if (k()) {
            return this.u.cb();
        }
        b bVar = this.c;
        if (bVar != null) {
            return bVar.cb();
        }
        return 0;
    }

    public boolean h() {
        return this.yo;
    }

    public void d(boolean z) {
        this.yo = z;
    }

    public void hc(String str) {
        this.mk = str;
    }

    public int gb() {
        return this.mq;
    }

    public void hc(int i) {
        this.mq = i;
    }

    public int tt() {
        return this.uo;
    }

    public void b(int i) {
        this.uo = i;
    }

    public void d(List<String> list) {
        this.k = list;
    }

    public void b(String str) {
        this.e = str;
    }

    public long tc() {
        return this.cb;
    }

    public void d(long j) {
        this.cb = j;
    }

    public boolean mk() {
        return this.w;
    }

    public void hc(boolean z) {
        this.w = z;
    }

    public long mq() {
        if (k()) {
            return this.u.u();
        }
        b bVar = this.c;
        if (bVar != null) {
            return bVar.u();
        }
        return 0L;
    }

    public boolean uo() {
        if (k()) {
            return this.u.v();
        }
        b bVar = this.c;
        if (bVar != null) {
            return bVar.v();
        }
        return true;
    }

    public void c(String str) {
        this.d = str;
    }

    public void c(int i) {
        this.hc = i;
    }

    public boolean k() {
        b bVar;
        if (this.jh == 1 && (bVar = this.u) != null && !TextUtils.isEmpty(bVar.mq())) {
            if (com.bykv.vk.openvk.component.video.api.b.u() == 2) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
            } else if (this.rf == 1) {
                return true;
            }
        }
        return false;
    }

    public float e() {
        if (k()) {
            return this.u.gb();
        }
        b bVar = this.c;
        if (bVar != null) {
            return bVar.gb();
        }
        return -1.0f;
    }

    public String cb() {
        if (k()) {
            return this.u.mq();
        }
        b bVar = this.c;
        if (bVar != null) {
            return bVar.mq();
        }
        return null;
    }

    public String w() {
        if (k()) {
            return this.u.e();
        }
        b bVar = this.c;
        if (bVar != null) {
            return bVar.e();
        }
        return null;
    }

    public int yo() {
        return this.rf;
    }

    public void u(int i) {
        this.rf = i;
    }

    public synchronized void d(String str, Object obj) {
        this.b.put(str, obj);
    }

    public synchronized Object u(String str) {
        return this.b.get(str);
    }

    public int rf() {
        return this.sy;
    }

    public void an(int i) {
        this.sy = i;
    }

    public int jh() {
        return this.de;
    }

    public void h(int i) {
        this.de = i;
    }

    public int sy() {
        return this.v;
    }

    public void gb(int i) {
        this.v = i;
    }

    public int de() {
        return this.np;
    }

    public void tt(int i) {
        this.np = i;
    }

    public b v() {
        return this.c;
    }

    public b np() {
        return this.u;
    }

    public b yi() {
        if (k()) {
            return this.u;
        }
        b bVar = this.c;
        if (bVar != null) {
            return bVar;
        }
        return null;
    }
}
