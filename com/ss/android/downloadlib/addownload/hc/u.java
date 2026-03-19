package com.ss.android.downloadlib.addownload.hc;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u implements com.ss.android.hc.d.hc.d {
    public com.ss.android.d.d.b.hc b;
    public com.ss.android.d.d.b.d c;
    public long d;
    public com.ss.android.d.d.b.b hc;
    public com.ss.android.hc.d.hc.hc u;

    @Override // com.ss.android.hc.d.hc.d
    public int rf() {
        return 0;
    }

    public u() {
    }

    public u(long j, com.ss.android.d.d.b.b bVar, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar) {
        this.d = j;
        this.hc = bVar;
        this.b = hcVar;
        this.c = dVar;
    }

    public boolean np() {
        com.ss.android.d.d.b.b bVar;
        if (this.d == 0 || (bVar = this.hc) == null || this.b == null || this.c == null) {
            return true;
        }
        return bVar.np() && this.d <= 0;
    }

    public boolean yi() {
        if (np()) {
            return false;
        }
        if (this.hc.np()) {
            com.ss.android.d.d.b.b bVar = this.hc;
            return (bVar instanceof com.ss.android.hc.d.d.b) && !TextUtils.isEmpty(bVar.yi()) && (this.b instanceof com.ss.android.hc.d.d.hc) && (this.c instanceof com.ss.android.hc.d.d.d);
        }
        return this.hc instanceof com.ss.android.hc.d.d.b;
    }

    @Override // com.ss.android.hc.d.hc.d
    public String d() {
        return this.hc.d();
    }

    @Override // com.ss.android.hc.d.hc.d
    public long hc() {
        return this.hc.c();
    }

    @Override // com.ss.android.hc.d.hc.d
    public boolean b() {
        return this.hc.np();
    }

    @Override // com.ss.android.hc.d.hc.d
    public String c() {
        return this.hc.yi();
    }

    @Override // com.ss.android.hc.d.hc.d
    public String u() {
        return this.hc.he();
    }

    @Override // com.ss.android.hc.d.hc.d
    public String an() {
        if (this.hc.zw() != null) {
            return this.hc.zw().hc();
        }
        return null;
    }

    @Override // com.ss.android.hc.d.hc.d
    public JSONObject h() {
        return this.hc.s();
    }

    @Override // com.ss.android.hc.d.hc.d
    public int gb() {
        if (this.c.hc() == 2) {
            return 2;
        }
        return this.hc.hv();
    }

    @Override // com.ss.android.hc.d.hc.d
    public long mq() {
        return this.hc.h();
    }

    @Override // com.ss.android.hc.d.hc.d
    public List<String> k() {
        return this.hc.j();
    }

    @Override // com.ss.android.hc.d.hc.d
    public String tt() {
        return this.b.d();
    }

    @Override // com.ss.android.hc.d.hc.d
    public String tc() {
        return this.b.hc();
    }

    @Override // com.ss.android.hc.d.hc.d
    public JSONObject mk() {
        return this.b.e();
    }

    @Override // com.ss.android.hc.d.hc.d
    public boolean uo() {
        return this.b.uo();
    }

    @Override // com.ss.android.hc.d.hc.d
    public Object e() {
        return this.b.tc();
    }

    @Override // com.ss.android.hc.d.hc.d
    public JSONObject cb() {
        return this.b.k();
    }

    @Override // com.ss.android.hc.d.hc.d
    public boolean w() {
        return this.c.k();
    }

    @Override // com.ss.android.hc.d.hc.d
    public JSONObject yo() {
        return this.hc.yo();
    }

    @Override // com.ss.android.hc.d.hc.d
    public com.ss.android.d.d.b.b sy() {
        return this.hc;
    }

    @Override // com.ss.android.hc.d.hc.d
    public com.ss.android.d.d.b.hc de() {
        return this.b;
    }

    @Override // com.ss.android.hc.d.hc.d
    public com.ss.android.d.d.b.d v() {
        return this.c;
    }

    @Override // com.ss.android.hc.d.hc.d
    public int jh() {
        return this.b.mk();
    }
}
