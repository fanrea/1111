package com.bytedance.sdk.component.b.hc;

import com.bytedance.sdk.component.b.hc.yo;
import java.net.URL;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class he {
    public zw an;
    final yo b;
    final vv c;
    final rf d;
    private volatile c h;
    final String hc;
    final Object u;

    he(d dVar) {
        this.d = dVar.d;
        this.hc = dVar.hc;
        this.b = dVar.b.d();
        this.c = dVar.c;
        this.u = dVar.u != null ? dVar.u : this;
        if (dVar.an != null) {
            this.an = dVar.an;
        } else {
            this.an = new zw();
        }
    }

    public rf d() {
        return this.d;
    }

    public String hc() {
        return this.hc;
    }

    public yo b() {
        return this.b;
    }

    public String d(String str) {
        return this.b.d(str);
    }

    public vv c() {
        return this.c;
    }

    public Object u() {
        return this.u;
    }

    public d an() {
        return new d(this);
    }

    public c h() {
        c cVar = this.h;
        if (cVar != null) {
            return cVar;
        }
        c cVarD = c.d(this.b);
        this.h = cVarD;
        return cVarD;
    }

    public boolean gb() {
        return this.d.c();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Request{method=").append(this.hc).append(", url=").append(this.d).append(", tag=");
        Object obj = this.u;
        if (obj == this) {
            obj = null;
        }
        return sbAppend.append(obj).append('}').toString();
    }

    public static class d {
        zw an;
        yo.d b;
        vv c;
        rf d;
        String hc;
        Object u;

        public d() {
            this.hc = "GET";
            this.b = new yo.d();
        }

        d(he heVar) {
            this.d = heVar.d;
            this.hc = heVar.hc;
            this.c = heVar.c;
            this.u = heVar.u;
            this.b = heVar.b.hc();
            this.an = heVar.an;
        }

        public d d(rf rfVar) {
            if (rfVar == null) {
                throw new NullPointerException("url == null");
            }
            this.d = rfVar;
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
            rf rfVarU = rf.u(str);
            if (rfVarU == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            return d(rfVarU);
        }

        public d d(URL url) {
            if (url == null) {
                throw new NullPointerException("url == null");
            }
            rf rfVarD = rf.d(url);
            if (rfVarD == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(url)));
            }
            return d(rfVarD);
        }

        public d d(String str, String str2) {
            this.b.b(str, str2);
            return this;
        }

        public d hc(String str, String str2) {
            this.b.d(str, str2);
            return this;
        }

        public d hc(String str) {
            this.b.hc(str);
            return this;
        }

        public d d(yo yoVar) {
            this.b = yoVar.hc();
            return this;
        }

        public d d(c cVar) {
            String string = cVar.toString();
            return string.isEmpty() ? hc("Cache-Control") : d("Cache-Control", string);
        }

        public d delete(vv vvVar) {
            return d("DELETE", vvVar);
        }

        public d delete() {
            return delete(com.bytedance.sdk.component.b.hc.d.b.c);
        }

        public d d(String str, vv vvVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (vvVar != null && !com.bytedance.sdk.component.b.hc.d.b.an.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (vvVar == null && com.bytedance.sdk.component.b.hc.d.b.an.hc(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.hc = str;
            this.c = vvVar;
            return this;
        }

        public d d(Object obj) {
            this.u = obj;
            return this;
        }

        public he d() {
            if (this.d == null) {
                throw new IllegalStateException("url == null");
            }
            return new he(this);
        }
    }
}
