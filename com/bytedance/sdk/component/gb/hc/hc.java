package com.bytedance.sdk.component.gb.hc;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.gb.d.an;
import com.bytedance.sdk.component.gb.d.c;
import com.bytedance.sdk.component.gb.d.h;
import com.bytedance.sdk.component.gb.d.tt;
import com.bytedance.sdk.component.gb.d.u;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.component.utils.w;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements h {
    private static volatile com.bytedance.sdk.component.gb.d.d.d c;
    private tt b;
    private u d;
    private Context hc;

    public hc(com.bytedance.sdk.component.gb.d.d dVar) {
        d(dVar);
    }

    public hc() {
    }

    public static com.bytedance.sdk.component.gb.d.d.d an() {
        if (c == null) {
            synchronized (hc.class) {
                if (c == null) {
                    c = new com.bytedance.sdk.component.gb.hc.u.d();
                }
            }
        }
        return c;
    }

    public void d(u uVar) {
        hc(uVar);
    }

    @Override // com.bytedance.sdk.component.gb.d.h
    public tt c() {
        return this.b;
    }

    public void hc(u uVar) {
        this.d = uVar;
        this.hc = uVar.getContext();
        this.b = new com.bytedance.sdk.component.gb.hc.hc.hc(this.d);
    }

    @Override // com.bytedance.sdk.component.gb.d.h
    public c u() {
        u uVar = this.d;
        if (uVar == null) {
            return null;
        }
        return uVar.c();
    }

    @Override // com.bytedance.sdk.component.gb.d.h
    public u b() {
        u uVar = this.d;
        if (uVar == null) {
            return null;
        }
        return uVar;
    }

    @Override // com.bytedance.sdk.component.gb.d.h
    public void d(an anVar) {
        u uVar = this.d;
        if (uVar != null) {
            if (anVar == null) {
                anVar = com.bytedance.sdk.component.gb.hc.d.d.d.hc.d;
            }
            uVar.d(anVar);
        }
    }

    @Override // com.bytedance.sdk.component.gb.d.h
    public void d(boolean z) {
        u uVar = this.d;
        if (uVar != null) {
            uVar.d(z);
        }
    }

    private boolean d(Context context, c cVar) {
        if (context == null || cVar == null) {
            return false;
        }
        if (cVar.tc() == 1) {
            return cVar.uo();
        }
        try {
            return w.d(context);
        } catch (Throwable th) {
            mq.d(th);
            return true;
        }
    }

    @Override // com.bytedance.sdk.component.gb.d.h
    public void d() {
        final c cVarC;
        u uVar = this.d;
        if (uVar == null || (cVarC = uVar.c()) == null || this.d.getContext() == null || cVarC.gb() == null) {
            return;
        }
        if (this.d.mk()) {
            if (d(this.d.getContext(), cVarC)) {
                tt ttVar = this.b;
                if (ttVar != null) {
                    ttVar.d();
                    return;
                }
                return;
            }
            if (h()) {
                cVarC.gb().execute(new com.bytedance.sdk.component.gb.hc.u.hc("start") { // from class: com.bytedance.sdk.component.gb.hc.hc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u unused = hc.this.d;
                        hc.this.d(cVarC.tc());
                    }
                });
                return;
            } else {
                d(cVarC.tc());
                return;
            }
        }
        tt ttVar2 = this.b;
        if (ttVar2 != null) {
            ttVar2.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i) {
        if (i == 0 || i == 2) {
            com.bytedance.sdk.component.gb.hc.hc.hc.d.d(this.d);
        } else if (i == 1) {
            com.bytedance.sdk.component.gb.hc.hc.hc.hc.hc(this.d);
        }
    }

    @Override // com.bytedance.sdk.component.gb.d.h
    public void d(com.bytedance.sdk.component.gb.d.hc hcVar) {
        hc(hcVar);
    }

    private boolean h() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    private void hc(final com.bytedance.sdk.component.gb.d.hc hcVar) {
        u uVar = this.d;
        if (uVar == null || this.b == null) {
            mq.c("log_error", "dispatch event configManager is null");
            return;
        }
        final c cVarC = uVar.c();
        if (hcVar == null || cVarC == null || this.d.getContext() == null || cVarC.gb() == null) {
            return;
        }
        if (this.d.mk()) {
            if (d(this.d.getContext(), cVarC)) {
                this.b.d(hcVar);
                return;
            }
            h();
            if (h()) {
                cVarC.gb().execute(new com.bytedance.sdk.component.gb.hc.u.hc("dispatchEvent") { // from class: com.bytedance.sdk.component.gb.hc.hc.2
                    @Override // java.lang.Runnable
                    public void run() {
                        hc.this.d(hcVar, cVarC.tc());
                    }
                });
                return;
            } else {
                d(hcVar, cVarC.tc());
                return;
            }
        }
        this.b.d(hcVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.bytedance.sdk.component.gb.d.hc hcVar, int i) {
        if (i == 0 || i == 2) {
            com.bytedance.sdk.component.gb.hc.hc.hc.d.d(hcVar, this.d);
        } else if (i == 1) {
            com.bytedance.sdk.component.gb.hc.hc.hc.hc.d(hcVar, this.d);
        }
    }

    @Override // com.bytedance.sdk.component.gb.d.h
    public void d(final String str, final List<String> list, final boolean z, Map<String, String> map, final JSONObject jSONObject) {
        u uVar = this.d;
        if (uVar == null) {
            mq.c("log_error", "track configManager is null");
            return;
        }
        final c cVarC = uVar.c();
        if (cVarC == null || this.d.getContext() == null || cVarC.gb() == null || !cVarC.an()) {
            return;
        }
        if (cVarC.tc() == 1) {
            if (list == null || list.isEmpty()) {
                return;
            }
        } else if (cVarC.tc() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
            return;
        }
        if (!this.d.mk() || d(this.d.getContext(), cVarC)) {
            com.bytedance.sdk.component.gb.hc.an.d.d(this.d).d(str, list, z, map, jSONObject);
        } else if (h()) {
            cVarC.gb().execute(new com.bytedance.sdk.component.gb.hc.u.hc("trackFailed") { // from class: com.bytedance.sdk.component.gb.hc.hc.3
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.d(str, (List<String>) list, z, cVarC.tc(), jSONObject);
                }
            });
        } else {
            d(str, list, z, cVarC.tc(), jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, List<String> list, boolean z, int i, JSONObject jSONObject) {
        if (i == 0) {
            com.bytedance.sdk.component.gb.hc.hc.hc.d.d(str, list, z, this.d, jSONObject);
        } else if (i == 1) {
            com.bytedance.sdk.component.gb.hc.hc.hc.hc.d(str, list, z, this.d);
        }
    }

    @Override // com.bytedance.sdk.component.gb.d.h
    public void d(final String str) {
        u uVar = this.d;
        if (uVar == null) {
            com.bytedance.sdk.component.gb.hc.b.b.b("log_error", "trackFailedUrls configManager is null", uVar);
            return;
        }
        final c cVarC = uVar.c();
        if (cVarC == null || this.d.getContext() == null || cVarC.gb() == null || !cVarC.an()) {
            return;
        }
        if (cVarC.tc() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.d.mk() || d(this.d.getContext(), cVarC)) {
            com.bytedance.sdk.component.gb.hc.an.d.d(this.d).d(str);
        } else if (h()) {
            cVarC.gb().execute(new com.bytedance.sdk.component.gb.hc.u.hc("trackFailed") { // from class: com.bytedance.sdk.component.gb.hc.hc.4
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.d(str, cVarC.tc());
                }
            });
        } else {
            d(str, cVarC.tc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, int i) {
        if (i == 0) {
            com.bytedance.sdk.component.gb.hc.hc.hc.d.d(str, this.d);
        } else if (i == 1) {
            com.bytedance.sdk.component.gb.hc.hc.hc.hc.d(str, this.d);
        }
    }

    @Override // com.bytedance.sdk.component.gb.d.h
    public void hc() {
        tt ttVar = this.b;
        if (ttVar != null) {
            ttVar.hc();
        }
    }
}
