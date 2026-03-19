package com.ss.android.socialbase.downloader.tt.d;

import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.downloader.e.an;
import com.ss.android.socialbase.downloader.h.u;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private final Map<String, c> b;
    protected int d;
    private final Map<String, b> hc;

    void d(String str, b bVar) {
        synchronized (this.hc) {
            this.hc.put(str, bVar);
        }
    }

    void d(int i) {
        this.d = i;
    }

    public b d(String str, List<u> list) {
        b bVarRemove;
        synchronized (this.hc) {
            bVarRemove = this.hc.remove(str);
        }
        if (bVarRemove == null) {
            return null;
        }
        if (an.d(bVarRemove.gb(), list)) {
            try {
                bVarRemove.c();
            } catch (InterruptedException e) {
                mq.d(e);
            }
            if (bVarRemove.an() && bVarRemove.u()) {
                return bVarRemove;
            }
        }
        try {
            bVarRemove.b();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean d(String str) {
        b bVar = this.hc.get(str);
        if (bVar != null) {
            if (bVar.h()) {
                return true;
            }
            if (bVar.an() && bVar.u()) {
                return true;
            }
        }
        return false;
    }

    public c hc(String str, List<u> list) {
        c cVarRemove;
        synchronized (this.b) {
            cVarRemove = this.b.remove(str);
        }
        if (cVarRemove == null) {
            return null;
        }
        if (an.d(cVarRemove.an(), list)) {
            try {
                cVarRemove.u();
            } catch (InterruptedException e) {
                mq.d(e);
            }
            if (cVarRemove.gb() && cVarRemove.h()) {
                return cVarRemove;
            }
        }
        try {
            cVarRemove.c();
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: com.ss.android.socialbase.downloader.tt.d.d$d, reason: collision with other inner class name */
    private static final class C0795d {
        private static final d d = new d();
    }

    public static d d() {
        return C0795d.d;
    }

    private d() {
        this.hc = new HashMap();
        this.b = new LinkedHashMap(3);
        this.d = 3;
    }
}
