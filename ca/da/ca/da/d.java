package ca.da.ca.da;

import com.apm.applog.AppLog;
import org.json.JSONObject;

/* compiled from: RangersEventVerifyHeartBeater.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d extends a {
    public final String f;
    public final AppLog g;
    public final b h;
    public int i;

    public d(b bVar, String str) {
        super(bVar);
        this.i = 0;
        this.f = str;
        this.h = bVar;
        this.g = AppLog.getInstance(bVar.f.a());
    }

    @Override // ca.da.ca.da.a
    public boolean c() {
        int i = ca.da.ca.ba.a.a(this.h, (JSONObject) null, this.f) ? 0 : this.i + 1;
        this.i = i;
        if (i > 3) {
            this.g.setRangersEventVerifyEnable(false, this.f);
        }
        return true;
    }

    @Override // ca.da.ca.da.a
    public String d() {
        return "RangersEventVerify";
    }

    @Override // ca.da.ca.da.a
    public long[] e() {
        return new long[]{1000};
    }

    @Override // ca.da.ca.da.a
    public boolean g() {
        return true;
    }

    @Override // ca.da.ca.da.a
    public long h() {
        return 1000L;
    }
}
