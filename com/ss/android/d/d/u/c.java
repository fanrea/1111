package com.ss.android.d.d.u;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.mq;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private final String an;
    private final String b;
    private final boolean c;
    private final JSONObject cb;
    private String d;
    private final String e;
    private final JSONObject gb;
    private final long h;
    private final String hc;
    private final boolean k;
    private final int mk;
    private final Object mq;
    private final List<String> tc;
    private final JSONObject tt;
    private final long u;
    private final String uo;

    c(d dVar) {
        this.d = dVar.d;
        this.hc = dVar.hc;
        this.b = dVar.b;
        this.c = dVar.c;
        this.u = dVar.u;
        this.an = dVar.an;
        this.h = dVar.h;
        this.gb = dVar.gb;
        this.tt = dVar.tt;
        this.tc = dVar.mk;
        this.mk = dVar.mq;
        this.mq = dVar.uo;
        this.k = dVar.e;
        this.e = dVar.cb;
        this.cb = dVar.w;
        this.uo = dVar.k;
    }

    public static class d {
        private String an;
        private String b;
        private String cb;
        private String d;
        private JSONObject gb;
        private long h;
        private String hc;
        private String k;
        private List<String> mk;
        private int mq;
        private Map<String, Object> tc;
        private JSONObject tt;
        private long u;
        private Object uo;
        private JSONObject w;
        private boolean c = false;
        private boolean e = false;

        public d d(boolean z) {
            this.e = z;
            return this;
        }

        public d d(String str) {
            this.hc = str;
            return this;
        }

        public d hc(String str) {
            this.b = str;
            return this;
        }

        public d d(long j) {
            this.u = j;
            return this;
        }

        public d hc(long j) {
            this.h = j;
            return this;
        }

        public d b(String str) {
            this.an = str;
            return this;
        }

        public d hc(boolean z) {
            this.c = z;
            return this;
        }

        public d d(JSONObject jSONObject) {
            this.gb = jSONObject;
            return this;
        }

        public d hc(JSONObject jSONObject) {
            this.tt = jSONObject;
            return this;
        }

        public d d(List<String> list) {
            this.mk = list;
            return this;
        }

        public d d(int i) {
            this.mq = i;
            return this;
        }

        public d d(Object obj) {
            this.uo = obj;
            return this;
        }

        public d c(String str) {
            this.k = str;
            return this;
        }

        public c d() throws JSONException {
            if (TextUtils.isEmpty(this.d)) {
                this.d = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.gb == null) {
                this.gb = new JSONObject();
            }
            try {
                Map<String, Object> map = this.tc;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.tc.entrySet()) {
                        if (!this.gb.has(entry.getKey())) {
                            this.gb.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.e) {
                    this.cb = this.b;
                    JSONObject jSONObject2 = new JSONObject();
                    this.w = jSONObject2;
                    if (this.c) {
                        jSONObject2.put("ad_extra_data", this.gb.toString());
                    } else {
                        Iterator<String> itKeys = this.gb.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            this.w.put(next, this.gb.get(next));
                        }
                    }
                    this.w.put("category", this.d);
                    this.w.put("tag", this.hc);
                    this.w.put(com.alipay.sdk.m.p0.b.d, this.u);
                    this.w.put("ext_value", this.h);
                    if (!TextUtils.isEmpty(this.k)) {
                        this.w.put("refer", this.k);
                    }
                    JSONObject jSONObject3 = this.tt;
                    if (jSONObject3 != null) {
                        this.w = com.ss.android.d.d.an.hc.d(jSONObject3, this.w);
                    }
                    if (this.c) {
                        if (!this.w.has("log_extra") && !TextUtils.isEmpty(this.an)) {
                            this.w.put("log_extra", this.an);
                        }
                        this.w.put("is_ad_event", "1");
                    }
                }
                if (this.c) {
                    jSONObject.put("ad_extra_data", this.gb.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.an)) {
                        jSONObject.put("log_extra", this.an);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.gb);
                }
                if (!TextUtils.isEmpty(this.k)) {
                    jSONObject.putOpt("refer", this.k);
                }
                JSONObject jSONObject4 = this.tt;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.d.d.an.hc.d(jSONObject4, jSONObject);
                }
                this.gb = jSONObject;
            } catch (Exception e) {
                mq.jh().d(e, "DownloadEventModel build");
            }
            return new c(this);
        }
    }

    public String d() {
        return this.d;
    }

    public String hc() {
        return this.hc;
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }

    public long u() {
        return this.u;
    }

    public String an() {
        return this.an;
    }

    public long h() {
        return this.h;
    }

    public JSONObject gb() {
        return this.gb;
    }

    public JSONObject tt() {
        return this.tt;
    }

    public List<String> tc() {
        return this.tc;
    }

    public int mk() {
        return this.mk;
    }

    public Object mq() {
        return this.mq;
    }

    public boolean uo() {
        return this.k;
    }

    public String k() {
        return this.e;
    }

    public JSONObject e() {
        return this.cb;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("category: ").append(this.d).append("\ttag: ").append(this.hc).append("\tlabel: ").append(this.b).append("\nisAd: ").append(this.c).append("\tadId: ").append(this.u).append("\tlogExtra: ").append(this.an).append("\textValue: ").append(this.h).append("\nextJson: ").append(this.gb).append("\nparamsJson: ").append(this.tt).append("\nclickTrackUrl: ");
        List<String> list = this.tc;
        StringBuilder sbAppend2 = sbAppend.append(list != null ? list.toString() : "").append("\teventSource: ").append(this.mk).append("\textraObject: ");
        Object obj = this.mq;
        StringBuilder sbAppend3 = sbAppend2.append(obj != null ? obj.toString() : "").append("\nisV3: ").append(this.k).append("\tV3EventName: ").append(this.e).append("\tV3EventParams: ");
        JSONObject jSONObject = this.cb;
        return sbAppend3.append(jSONObject != null ? jSONObject.toString() : "").toString();
    }
}
