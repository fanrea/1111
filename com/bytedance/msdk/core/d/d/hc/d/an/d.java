package com.bytedance.msdk.core.d.d.hc.d.an;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.tt;
import com.bytedance.msdk.d.u.an;
import com.bytedance.sdk.openadsdk.w.c;
import com.kuaishou.android.live.network.ApiStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends com.bytedance.msdk.core.d.d.hc.d {
    @Override // com.bytedance.msdk.core.d.d.hc.d
    protected void d(final Context context) {
        if (b()) {
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.an.d.1
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
        c();
        b(context);
        u();
        an();
    }

    private void c() {
        HashMap map = new HashMap();
        tt ttVarHc = com.bytedance.msdk.core.d.mk().j().hc();
        if (ttVarHc != null) {
            map.put("lng", String.valueOf(ttVarHc.hc()));
            map.put("lat", String.valueOf(ttVarHc.d()));
            map.put("loc_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (map.isEmpty() || this.b == null) {
            return;
        }
        this.b.apply(c.d().d(40025).d(Void.class).d(50010, map).hc());
    }

    private void b(Context context) {
        if (this.b != null) {
            this.b.apply(c.d().d(40000).d(Void.class).d(50001, Boolean.valueOf(this.d.ba())).d(50002, hc()).d(50000, this.hc.yo()).d(10000, context).hc());
        }
    }

    private void u() {
        if (this.b != null) {
            c cVarD = c.d().d(40001).d(50003, this.d.z()).d(Void.class);
            Map<String, Object> mapHv = this.d.hv();
            if (mapHv != null && mapHv.get("gdt") != null) {
                cVarD.d(50004, String.valueOf(mapHv.get("gdt")));
            }
            this.b.apply(cVarD.hc());
        }
    }

    private void an() {
        if (this.b != null) {
            this.b.apply(c.d().d(40002).d(10004, new C0236d(this)).d(Void.class).hc());
        }
    }

    /* renamed from: com.bytedance.msdk.core.d.d.hc.d.an.d$d, reason: collision with other inner class name */
    static class C0236d extends com.bytedance.sdk.openadsdk.core.ba.c {
        private com.bytedance.msdk.core.d.d.hc.d d;
        private b hc;

        public C0236d(com.bytedance.msdk.core.d.d.hc.d dVar) {
            this.d = dVar;
        }

        private void d(Function<SparseArray<Object>, Object> function) {
            if (this.hc != null || function == null) {
                return;
            }
            this.hc = new b(this.d, function);
        }

        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            if (i == 60000) {
                Function<SparseArray<Object>, Object> function = (Function) pluginValueSet.objectValue(50005, Function.class);
                com.bytedance.msdk.core.d.d.hc.d dVar = this.d;
                if (dVar != null) {
                    if (function != null) {
                        d(function);
                        ArrayList arrayList = new ArrayList(1);
                        arrayList.add(this.hc);
                        this.d.d(arrayList);
                    } else {
                        dVar.d(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG, "adn return data is null");
                    }
                }
            } else if (i == 60001) {
                if (this.d != null) {
                    hc hcVar = new hc((Function) pluginValueSet.objectValue(50006, Function.class));
                    this.d.d(hcVar.d(), hcVar.hc());
                }
            } else if (i == 60003) {
                Function<SparseArray<Object>, Object> function2 = (Function) pluginValueSet.objectValue(50005, Function.class);
                com.bytedance.msdk.core.d.d.hc.d dVar2 = this.d;
                if (dVar2 != null) {
                    if (function2 != null) {
                        d(function2);
                        this.d.d(this.hc, (com.bytedance.msdk.api.d) null);
                    } else {
                        dVar2.d(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG, "adn return data is null");
                    }
                }
            }
            return null;
        }
    }
}
