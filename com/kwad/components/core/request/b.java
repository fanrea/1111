package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private final List<a> YI;

    public interface a {
        void sz();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    /* renamed from: com.kwad.components.core.request.b$b, reason: collision with other inner class name */
    static class C0486b {
        private static final b YJ = new b(0);
    }

    public static b sx() {
        return C0486b.YJ;
    }

    private b() {
        this.YI = new CopyOnWriteArrayList();
    }

    public final void a(a aVar) {
        this.YI.add(aVar);
    }

    public final void b(a aVar) {
        this.YI.remove(aVar);
    }

    public final void sy() {
        for (a aVar : this.YI) {
            if (aVar != null) {
                try {
                    aVar.sz();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }
}
