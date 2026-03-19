package com.bytedance.msdk.core.d.d.hc.d.hc;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.tt;
import com.bytedance.msdk.d.u.an;
import com.bytedance.sdk.openadsdk.w.c;
import com.kuaishou.android.live.network.ApiStatus;
import com.style.widget.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends com.bytedance.msdk.core.d.d.hc.d {
    @Override // com.bytedance.msdk.core.d.d.hc.d
    protected void d(final Context context) {
        if (b()) {
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.hc.d.1
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
        c(context);
        u();
        an();
        b(context);
    }

    private void c() {
        HashMap map = new HashMap();
        tt ttVarHc = com.bytedance.msdk.core.d.mk().j().hc();
        if (ttVarHc != null) {
            map.put("lng", String.valueOf(ttVarHc.hc()));
            map.put("lat", String.valueOf(ttVarHc.d()));
            map.put("loc_time", String.valueOf(System.currentTimeMillis() / 1000));
        }
        if (map.size() > 0) {
            com.bykv.d.d.d.d.d.d().d(50010, map);
            if (this.b != null) {
                this.b.apply(c.d().d(40025).d(50010, map).d(Void.class).hc());
            }
        }
    }

    private void b(Context context) {
        if (this.b == null || this.d == null) {
            return;
        }
        C0241d c0241d = new C0241d(this);
        c0241d.d(context);
        this.b.apply(c.d().d(40037).d(10004, c0241d).d(ad.c, Integer.valueOf(this.d.vv())).d(Void.class).hc());
    }

    private void c(Context context) {
        if (this.b != null) {
            this.b.apply(c.d().d(40036).d(50000, this.hc.yo()).d(10000, context).d(Void.class).hc());
        }
    }

    private void u() {
        if (this.b != null) {
            this.b.apply(c.d().d(40019).d(50010, this.d.hv()).d(Void.class).hc());
        }
    }

    private void an() {
        if (this.b != null) {
            this.b.apply(c.d().d(40020).d(50010, this.d.hv()).d(Void.class).hc());
        }
    }

    /* renamed from: com.bytedance.msdk.core.d.d.hc.d.hc.d$d, reason: collision with other inner class name */
    static class C0241d extends com.bytedance.sdk.openadsdk.core.ba.c {
        private com.bytedance.msdk.core.d.d.hc.d d;
        private Context hc;

        public void d(Context context) {
            this.hc = context;
        }

        public C0241d(com.bytedance.msdk.core.d.d.hc.d dVar) {
            this.d = dVar;
        }

        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            if (i == 60000) {
                List list = (List) pluginValueSet.objectValue(50015, List.class);
                if (this.d == null) {
                    return null;
                }
                if (list != null && list.size() > 0) {
                    ArrayList arrayList = new ArrayList(list.size());
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new hc(this.hc, this.d, (Function) it.next()));
                    }
                    this.d.d(arrayList);
                    return null;
                }
                this.d.d(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG, "adn return data is null");
                return null;
            }
            if (i != 60001 || this.d == null) {
                return null;
            }
            com.bytedance.msdk.core.d.d.hc.d.an.hc hcVar = new com.bytedance.msdk.core.d.d.hc.d.an.hc((Function) pluginValueSet.objectValue(50006, Function.class));
            this.d.d(hcVar.d(), hcVar.hc());
            return null;
        }
    }
}
