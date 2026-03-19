package com.kwad.sdk.glide.e;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class i {
    private Class<?> cao;
    private Class<?> cap;
    private Class<?> caq;

    public i() {
    }

    public i(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        g(cls, cls2, cls3);
    }

    public final void g(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.cao = cls;
        this.cap = cls2;
        this.caq = cls3;
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.cao + ", second=" + this.cap + '}';
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.cao.equals(iVar.cao) && this.cap.equals(iVar.cap) && j.c(this.caq, iVar.caq);
    }

    public final int hashCode() {
        int iHashCode = ((this.cao.hashCode() * 31) + this.cap.hashCode()) * 31;
        Class<?> cls = this.caq;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }
}
