package com.kwad.framework.filedownloader.message;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e {
    private volatile g bgo;
    private volatile b bgp;

    public interface b {
        void r(MessageSnapshot messageSnapshot);
    }

    public static final class a {
        private static final e bgq = new e();
    }

    public static e Op() {
        return a.bgq;
    }

    public final void a(b bVar) {
        this.bgp = bVar;
        if (bVar == null) {
            this.bgo = null;
        } else {
            this.bgo = new g(5, bVar);
        }
    }

    public final void s(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof com.kwad.framework.filedownloader.message.b) {
            if (this.bgp != null) {
                this.bgp.r(messageSnapshot);
            }
        } else if (this.bgo != null) {
            this.bgo.u(messageSnapshot);
        }
    }
}
