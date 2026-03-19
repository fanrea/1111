package ca.da.ca.da;

import ca.da.ca.ja.r;
import com.bytedance.apm.common.utility.NetworkUtils;
import org.json.JSONException;

/* compiled from: BaseWorker.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class a {
    public final b a;
    public int b;
    public volatile boolean c;
    public long d;
    public boolean e;

    public a(b bVar) {
        this.a = bVar;
    }

    public final long a() {
        String str;
        long jB = b();
        if (jB > System.currentTimeMillis()) {
            return jB;
        }
        try {
            try {
                boolean zC = c();
                this.d = System.currentTimeMillis();
                if (zC) {
                    this.b = 0;
                } else {
                    this.b++;
                }
                str = d() + " worked:" + zC;
            } catch (Exception e) {
                r.a(e);
                this.d = System.currentTimeMillis();
                this.b++;
                str = d() + " worked:false";
            }
            r.a(str, (Throwable) null);
            return b();
        } catch (Throwable th) {
            this.d = System.currentTimeMillis();
            this.b++;
            r.a(d() + " worked:false", (Throwable) null);
            throw th;
        }
    }

    public final long b() {
        g gVar = this.a.j;
        if (gVar != null && !gVar.b() && f()) {
            return h() + this.d;
        }
        if (g() && !NetworkUtils.isNetworkAvailableFast(this.a.b)) {
            return 15000 + System.currentTimeMillis();
        }
        long jH = 0;
        if (this.c) {
            this.d = 0L;
            this.c = false;
        } else {
            int i = this.b;
            if (i > 0) {
                long[] jArrE = e();
                jH = jArrE[(i - 1) % jArrE.length];
            } else {
                jH = h();
            }
        }
        return this.d + jH;
    }

    public abstract boolean c() throws JSONException;

    public abstract String d();

    public abstract long[] e();

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public abstract long h();

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends a> T i() {
        r.a(ca.ca.ca.ca.a.a("setImmediately, ").append(d()).toString());
        this.c = true;
        return this;
    }

    public a(b bVar, long j) {
        this.a = bVar;
        this.d = j;
    }
}
