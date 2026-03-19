package com.bytedance.sdk.component.b.hc;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class yi implements u {
    private boolean an;
    final he b;
    final boolean c;
    final v d;
    final com.bytedance.sdk.component.b.hc.d.b.tc hc;
    private cb u;

    private yi(v vVar, he heVar, boolean z) {
        this.d = vVar;
        this.b = heVar;
        this.c = z;
        this.hc = new com.bytedance.sdk.component.b.hc.d.b.tc(vVar, z);
    }

    static yi d(v vVar, he heVar, boolean z) {
        yi yiVar = new yi(vVar, heVar, z);
        yiVar.u = vVar.np().d(yiVar);
        return yiVar;
    }

    @Override // com.bytedance.sdk.component.b.hc.u
    public he d() {
        return this.b;
    }

    @Override // com.bytedance.sdk.component.b.hc.u
    public j hc() throws IOException {
        synchronized (this) {
            if (this.an) {
                throw new IllegalStateException("Already Executed");
            }
            this.an = true;
        }
        tc();
        try {
            try {
                if (this.b.an != null) {
                    this.b.an.d();
                }
                this.d.rf().d(this);
                j jVarTt = tt();
                if (jVarTt == null) {
                    throw new IOException("Canceled");
                }
                if (jVarTt.b != 0) {
                    return jVarTt;
                }
                throw new IOException(jVarTt.c);
            } catch (IOException e) {
                this.u.d(this, e);
                return null;
            } catch (Exception e2) {
                this.u.d(this, new IOException(e2));
                return null;
            }
        } finally {
            this.d.rf().hc(this);
        }
    }

    private void tc() {
        this.hc.d(com.bytedance.sdk.component.b.hc.d.h.u.hc().d("response.body().close()"));
    }

    @Override // com.bytedance.sdk.component.b.hc.u
    public void d(an anVar) {
        try {
            synchronized (this) {
                if (this.an) {
                    throw new IllegalStateException("Already Executed");
                }
                this.an = true;
            }
            tc();
            this.d.rf().d(new d(anVar));
        } catch (Throwable th) {
            if (anVar != null) {
                anVar.d(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.hc.u
    public void b() {
        this.hc.d();
    }

    @Override // com.bytedance.sdk.component.b.hc.u
    public boolean c() {
        return this.hc.hc();
    }

    @Override // com.bytedance.sdk.component.b.hc.u
    /* renamed from: an, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public yi u() {
        return d(this.d, this.b, this.c);
    }

    final class d extends com.bytedance.sdk.component.b.hc.d.hc {
        private final an b;

        d(an anVar) {
            super("OkHttp %s", yi.this.gb());
            this.b = anVar;
        }

        String d() {
            return yi.this.b.d().h();
        }

        public void hc() {
            if (yi.this.b == null || yi.this.b.an == null) {
                return;
            }
            yi.this.b.an.mk();
        }

        @Override // com.bytedance.sdk.component.b.hc.d.hc
        protected void b() {
            j jVarTt;
            boolean z = false;
            try {
                try {
                    try {
                        if (yi.this.b != null && yi.this.b.an != null) {
                            yi.this.b.an.d();
                        }
                        jVarTt = yi.this.tt();
                    } catch (IOException e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    yi.this.u.d(yi.this, new IOException(e2));
                    this.b.d(yi.this, new IOException(e2));
                }
                try {
                    if (yi.this.hc.hc()) {
                        this.b.d(yi.this, new IOException("Canceled"));
                    } else {
                        this.b.d(yi.this, jVarTt);
                    }
                    if (jVarTt.b == 0) {
                        throw new IOException(jVarTt.c);
                    }
                } catch (IOException e3) {
                    z = true;
                    e = e3;
                    if (!z) {
                        yi.this.u.d(yi.this, e);
                        this.b.d(yi.this, e);
                    } else {
                        com.bytedance.sdk.component.b.hc.d.h.u.hc().d(4, "Callback failure for " + yi.this.h(), e);
                    }
                }
            } finally {
                yi.this.d.rf().hc(this);
            }
        }
    }

    String h() {
        return (c() ? "canceled " : "") + (this.c ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + gb();
    }

    String gb() {
        return this.b.d().uo();
    }

    j tt() throws IOException {
        ArrayList arrayList = new ArrayList(this.d.de());
        arrayList.add(this.hc);
        arrayList.add(new com.bytedance.sdk.component.b.hc.d.b.d(this.d.an()));
        arrayList.add(new com.bytedance.sdk.component.b.hc.d.d.d(this.d.h()));
        arrayList.add(new com.bytedance.sdk.component.b.hc.d.hc.d(this.d));
        if (!this.c) {
            arrayList.addAll(this.d.v());
        }
        arrayList.add(new com.bytedance.sdk.component.b.hc.d.b.hc(this.c));
        return new com.bytedance.sdk.component.b.hc.d.b.h(arrayList, null, null, null, 0, this.b, this, this.u, this.d.d(), this.d.hc(), this.d.b()).d(this.b);
    }
}
