package com.bytedance.sdk.component.hc.d;

import com.bytedance.sdk.component.hc.d.an;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class k {
    public mq d;

    public e an() {
        return null;
    }

    public abstract String b();

    public abstract Map<String, List<String>> c();

    public abstract Object d();

    public abstract h hc();

    public abstract com.bytedance.sdk.component.hc.d.d u();

    public void d(mq mqVar) {
        this.d = mqVar;
    }

    public d h() {
        return new d(this);
    }

    public static class d {
        e an;
        h b;
        String c;
        com.bytedance.sdk.component.hc.d.d d;
        an.d h;
        public Map<String, List<String>> hc;
        Object u;

        public d() {
            this.hc = new HashMap();
            this.h = new an.d();
        }

        public d d(com.bytedance.sdk.component.hc.d.d dVar) {
            this.d = dVar;
            return this;
        }

        d(k kVar) {
            this.b = kVar.hc();
            this.c = kVar.b();
            this.hc = kVar.c();
            this.u = kVar.d();
            this.an = kVar.an();
            this.d = kVar.u();
        }

        public d d(Object obj) {
            this.u = obj;
            return this;
        }

        public d d(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            h hVarB = h.b(str);
            if (hVarB == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            return d(hVarB);
        }

        public d d(h hVar) {
            this.b = hVar;
            return this;
        }

        public d d(String str, String str2) {
            return hc(str, str2);
        }

        public d d(an anVar) {
            if (anVar != null) {
                this.hc = anVar.hc();
            }
            return this;
        }

        public d hc(String str, String str2) {
            if (!this.hc.containsKey(str)) {
                this.hc.put(str, new ArrayList());
            }
            this.hc.get(str).add(str2);
            return this;
        }

        public d d() {
            return d("GET", (e) null);
        }

        public d d(String str, e eVar) {
            this.c = str;
            this.an = eVar;
            return this;
        }

        public d d(e eVar) {
            return d("POST", eVar);
        }

        public k hc() {
            return new k() { // from class: com.bytedance.sdk.component.hc.d.k.d.1
                public String toString() {
                    return "";
                }

                @Override // com.bytedance.sdk.component.hc.d.k
                public Object d() {
                    return d.this.u;
                }

                @Override // com.bytedance.sdk.component.hc.d.k
                public h hc() {
                    return d.this.b;
                }

                @Override // com.bytedance.sdk.component.hc.d.k
                public String b() {
                    return d.this.c;
                }

                @Override // com.bytedance.sdk.component.hc.d.k
                public Map c() {
                    return d.this.hc;
                }

                @Override // com.bytedance.sdk.component.hc.d.k
                public com.bytedance.sdk.component.hc.d.d u() {
                    return d.this.d;
                }

                @Override // com.bytedance.sdk.component.hc.d.k
                public e an() {
                    return d.this.an;
                }
            };
        }
    }
}
