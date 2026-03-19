package com.bytedance.msdk.api.c;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.c;
import com.bytedance.msdk.api.c.gb;
import com.bytedance.msdk.api.c.mq;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private mq an;
    private boolean b;
    private String c;
    private boolean cb;
    private String d;
    private PluginValueSet e;
    private c gb;
    private gb h;
    private String hc;
    private Map<String, Object> k;
    private boolean mk;
    private boolean mq;
    private Map<String, Object> tc;
    private an tt;
    private boolean u;
    private JSONObject uo;

    private d(C0212d c0212d) {
        this.d = c0212d.d;
        this.hc = c0212d.hc;
        this.b = c0212d.b;
        this.c = c0212d.c;
        this.u = c0212d.u;
        if (c0212d.an == null) {
            this.an = new mq.d().d();
        } else {
            this.an = c0212d.an;
        }
        if (c0212d.h == null) {
            this.h = new gb.d().d();
        } else {
            this.h = c0212d.h;
        }
        if (c0212d.gb == null) {
            this.gb = new c.d().d();
        } else {
            this.gb = c0212d.gb;
        }
        if (c0212d.tt == null) {
            this.tt = new an();
        } else {
            this.tt = c0212d.tt;
        }
        this.tc = c0212d.tc;
        this.mk = c0212d.mk;
        this.mq = c0212d.mq;
        this.uo = c0212d.uo;
        this.k = c0212d.k;
        this.e = c0212d.e;
        this.cb = c0212d.cb;
    }

    /* renamed from: com.bytedance.msdk.api.c.d$d, reason: collision with other inner class name */
    public static class C0212d {
        private mq an;
        private boolean cb;
        private String d;
        private PluginValueSet e;
        private c gb;
        private gb h;
        private String hc;
        private Map<String, Object> k;
        private Map<String, Object> tc;
        private an tt;
        private JSONObject uo;
        private boolean b = false;
        private String c = "";
        private boolean u = false;
        private boolean mk = false;
        private boolean mq = false;

        public C0212d d(String str) {
            this.d = str;
            return this;
        }

        public C0212d hc(String str) {
            this.hc = str;
            return this;
        }

        public C0212d d(boolean z) {
            this.b = z;
            return this;
        }

        public C0212d b(String str) {
            this.c = str;
            return this;
        }

        public C0212d hc(boolean z) {
            this.u = z;
            return this;
        }

        public C0212d d(mq mqVar) {
            this.an = mqVar;
            return this;
        }

        public C0212d d(gb gbVar) {
            this.h = gbVar;
            return this;
        }

        public C0212d d(an anVar) {
            this.tt = anVar;
            return this;
        }

        public C0212d d(Map<String, Object> map) {
            if (map != null && !map.isEmpty()) {
                if (this.tc == null) {
                    this.tc = new HashMap();
                }
                this.tc.putAll(map);
            }
            return this;
        }

        public C0212d b(boolean z) {
            this.mk = z;
            return this;
        }

        public C0212d d(JSONObject jSONObject) {
            this.uo = jSONObject;
            return this;
        }

        public C0212d d(PluginValueSet pluginValueSet) {
            this.e = pluginValueSet;
            return this;
        }

        public C0212d c(boolean z) {
            this.cb = z;
            return this;
        }

        public d d() {
            return new d(this);
        }
    }

    public String d() {
        return this.d;
    }

    public String hc() {
        return this.hc;
    }

    public boolean b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public boolean u() {
        return this.u;
    }

    public mq an() {
        return this.an;
    }

    public gb h() {
        return this.h;
    }

    public c gb() {
        return this.gb;
    }

    public an tt() {
        return this.tt;
    }

    public Map<String, Object> tc() {
        return this.tc;
    }

    public boolean mk() {
        return this.mk;
    }

    public boolean mq() {
        return this.mq;
    }

    public JSONObject uo() {
        return this.uo;
    }

    public Map<String, Object> k() {
        return this.k;
    }

    public PluginValueSet e() {
        return this.e;
    }

    public boolean cb() {
        return this.cb;
    }
}
