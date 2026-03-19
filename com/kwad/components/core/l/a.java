package com.kwad.components.core.l;

import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private CopyOnWriteArrayList<b> SZ = new CopyOnWriteArrayList<>();
    private volatile boolean Ta;

    public interface c {
        void bK();
    }

    /* renamed from: com.kwad.components.core.l.a$a, reason: collision with other inner class name */
    static final class C0475a {
        private static final a Tb = new a();
    }

    public static a qD() {
        return C0475a.Tb;
    }

    public static class b {
        private final c Tc;
        public boolean Td;

        public b(c cVar) {
            this.Tc = cVar;
        }
    }

    public final void a(b bVar) {
        if (this.SZ.contains(bVar)) {
            return;
        }
        if (!this.Ta) {
            this.Ta = true;
            bVar.Td = true;
        }
        this.SZ.add(bVar);
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.Td;
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.Td) {
            bVar.Td = false;
            this.Ta = false;
        }
        this.SZ.remove(bVar);
        if (this.SZ.size() == 0 || this.Ta) {
            return;
        }
        this.SZ.get(0).Td = true;
        this.Ta = true;
        this.SZ.get(0).Tc.bK();
    }
}
