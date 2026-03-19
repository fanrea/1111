package com.bytedance.sdk.component.d;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class c<P, R> extends com.bytedance.sdk.component.d.hc<P, R> {
    private an b;
    private boolean d = true;
    private d hc;

    interface d {
        void d(Object obj);

        void d(Throwable th);
    }

    public interface hc {
        c d();
    }

    protected abstract void c();

    protected abstract void d(P p, an anVar) throws Exception;

    @Override // com.bytedance.sdk.component.d.hc
    public /* bridge */ /* synthetic */ String d() {
        return super.d();
    }

    protected final void d(R r) {
        if (h()) {
            this.hc.d(r);
            u();
        }
    }

    protected final void d(Throwable th) {
        if (h()) {
            this.hc.d(th);
            u();
        }
    }

    protected final void b() {
        d((Throwable) null);
    }

    protected void u() {
        this.d = false;
        this.b = null;
    }

    void d(P p, an anVar, d dVar) throws Exception {
        this.b = anVar;
        this.hc = dVar;
        d(p, anVar);
    }

    void an() {
        c();
        u();
    }

    private boolean h() {
        if (this.d) {
            return true;
        }
        tt.d(new IllegalStateException("Jsb async call already finished: " + d() + ", hashcode: " + hashCode()));
        return false;
    }
}
