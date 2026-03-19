package com.bytedance.msdk.an.d;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.msdk.gb.np;
import com.bytedance.msdk.gb.zw;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class b {
    private com.bytedance.msdk.d.d.b d;
    private final Set<String> hc = new CopyOnWriteArraySet();
    private final AtomicBoolean b = new AtomicBoolean(false);

    protected abstract String b();

    protected abstract Map<String, Object> d();

    protected abstract String hc();

    public final synchronized void c() {
        this.b.set(true);
    }

    public final synchronized boolean u() {
        return this.b.get();
    }

    public void an() {
        hc((com.bytedance.msdk.api.c.mk) null);
    }

    public void d(com.bytedance.msdk.api.c.mk mkVar) {
        hc(mkVar);
    }

    public void d(com.bytedance.msdk.api.c.mk mkVar, com.bytedance.msdk.d.d.b bVar) {
        this.d = bVar;
        hc(mkVar);
    }

    private void hc(com.bytedance.msdk.api.c.mk mkVar) {
        com.bytedance.msdk.core.tc.d dVarD = com.bytedance.msdk.core.hc.hc().d(hc());
        if (mkVar != null || dVarD != null || "pangle_custom".equals(hc()) || "pangle".equals(hc())) {
            b(mkVar);
        }
    }

    private synchronized void b(com.bytedance.msdk.api.c.mk mkVar) {
        try {
            if (u()) {
                return;
            }
            String strB = b();
            if (!TextUtils.isEmpty(strB)) {
                throw new Exception("adn init ".concat(String.valueOf(strB)));
            }
            Map<String, Object> mapD = d();
            if (mapD == null) {
                throw new Exception("adn init getConfig() is null");
            }
            mapD.put("adn_name", hc());
            mapD.put("q_x_c", Integer.valueOf(com.bytedance.msdk.h.d.d.d().c()));
            mapD.put("wf_q_x_c", Integer.valueOf(com.bytedance.msdk.h.d.d.d().u()));
            com.bytedance.msdk.d.d.c cVarD = com.bytedance.msdk.an.hc.hc.d().d(hc(), mkVar);
            if (cVarD == null) {
                throw new Exception("configuration is null");
            }
            d(cVarD, mapD);
            c();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            com.bytedance.msdk.an.hc.d.d(hc(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, th.toString()));
        }
    }

    private synchronized void d(com.bytedance.msdk.d.d.c cVar, Map<String, Object> map) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.bytedance.msdk.d.u.b.d("TMe", "--==--time: start " + hc());
        cVar.d(com.bytedance.msdk.core.hc.getContext(), map, new com.bytedance.msdk.d.d.b() { // from class: com.bytedance.msdk.an.d.b.1
            @Override // com.bytedance.msdk.d.d.b
            public void d() {
                if (b.this.d != null) {
                    b.this.d.d();
                }
                if (TextUtils.equals(b.this.hc(), "pangle")) {
                    np.d();
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                com.bytedance.msdk.d.u.b.d("TMe", "--==--time: " + b.this.hc() + ", ----==----- " + jElapsedRealtime2);
                if (!b.this.hc.contains(b.this.hc())) {
                    b.this.hc.add(b.this.hc());
                    zw.b(b.this.hc(), jElapsedRealtime2);
                }
                com.bytedance.msdk.an.hc.d.d(b.this.hc(), (Pair<Boolean, String>) new Pair(Boolean.TRUE, ""));
            }

            @Override // com.bytedance.msdk.d.d.b
            public void d(com.bytedance.msdk.api.d dVar) {
                if (b.this.d != null) {
                    b.this.d.d(dVar);
                }
                if (dVar != null) {
                    com.bytedance.msdk.an.hc.d.d(b.this.hc(), (Pair<Boolean, String>) new Pair(Boolean.FALSE, "errorCode = " + dVar.d + " errorMessage = " + dVar.hc));
                }
            }
        });
    }

    protected com.bytedance.msdk.core.tc.d h() {
        return com.bytedance.msdk.core.hc.hc().d(hc());
    }

    public synchronized void gb() {
        if (!u()) {
            an();
        }
    }
}
