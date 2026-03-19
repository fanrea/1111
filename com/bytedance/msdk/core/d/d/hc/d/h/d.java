package com.bytedance.msdk.core.d.d.hc.d.h;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.tt;
import com.bytedance.msdk.d.u.an;
import com.bytedance.sdk.openadsdk.w.c;
import com.kuaishou.android.live.network.ApiStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends com.bytedance.msdk.core.d.d.hc.d {
    @Override // com.bytedance.msdk.core.d.d.hc.d
    protected void d(final Context context) {
        if (b()) {
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.h.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hc(context);
                }
            });
        } else {
            hc(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(Context context) {
        u();
        b(context);
        c();
        an();
    }

    private void c() {
        if (this.d.jh() || this.b == null) {
            return;
        }
        this.b.apply(c.d().d(40026).d(Void.class).hc());
    }

    private void u() {
        HashMap map = new HashMap();
        tt ttVarHc = com.bytedance.msdk.core.d.mk().j().hc();
        if (ttVarHc != null) {
            map.put("lng", String.valueOf(ttVarHc.hc()));
            map.put("lat", String.valueOf(ttVarHc.d()));
            map.put("loc_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (!this.d.rf()) {
            map.put("shakable", "0");
        }
        if (map.size() > 0) {
            com.bykv.d.d.d.d.d.d().d(50010, map);
            if (this.b != null) {
                this.b.apply(c.d().d(40025).d(Void.class).hc());
            }
        }
    }

    private void b(Context context) {
        if (this.b != null) {
            int iW = this.d.w();
            if (iW < 0) {
                iW = 3000;
            } else if (iW > 5000) {
                iW = 5000;
            }
            this.b.apply(c.d().d(40024).d(50000, this.hc.yo()).d(50011, Integer.valueOf(iW)).d(10000, context).d(Void.class).hc());
        }
    }

    private void an() {
        if (this.b == null || this.hc == null) {
            return;
        }
        int iTc = this.hc.tc();
        if (iTc == 2) {
            this.b.apply(c.d().d(40027).d(10004, new C0240d(this)).d(Void.class).hc());
        } else if (iTc == 0 || iTc == 1) {
            this.b.apply(c.d().d(40028).d(10004, new C0240d(this)).d(Void.class).hc());
        }
    }

    /* renamed from: com.bytedance.msdk.core.d.d.hc.d.h.d$d, reason: collision with other inner class name */
    static class C0240d extends com.bytedance.sdk.openadsdk.core.ba.c {
        private com.bytedance.msdk.core.d.d.hc.d d;
        private hc hc;

        public C0240d(com.bytedance.msdk.core.d.d.hc.d dVar) {
            this.d = dVar;
        }

        private void d(Function<SparseArray<Object>, Object> function) {
            if (this.hc != null || function == null) {
                return;
            }
            this.hc = new hc(this.d, function);
        }

        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            if (i == 60000) {
                Function<SparseArray<Object>, Object> function = (Function) pluginValueSet.objectValue(50005, Function.class);
                long jLongValue = pluginValueSet.longValue(50012) - SystemClock.elapsedRealtime();
                com.bytedance.msdk.core.d.d.hc.d dVar = this.d;
                if (dVar == null || jLongValue <= 1000) {
                    return null;
                }
                if (function != null) {
                    d(function);
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(this.hc);
                    this.d.d(arrayList);
                    return null;
                }
                dVar.d(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG, "adn return data is null");
                return null;
            }
            if (i != 60001 || this.d == null) {
                return null;
            }
            com.bytedance.msdk.core.d.d.hc.d.an.hc hcVar = new com.bytedance.msdk.core.d.d.hc.d.an.hc((Function) pluginValueSet.objectValue(50006, Function.class));
            if (hcVar.d() == 4004 || hcVar.d() == 4005) {
                hc hcVar2 = this.hc;
                if (hcVar2 == null) {
                    return null;
                }
                hcVar2.d(hcVar);
                return null;
            }
            this.d.d(hcVar.d(), hcVar.hc());
            return null;
        }
    }
}
