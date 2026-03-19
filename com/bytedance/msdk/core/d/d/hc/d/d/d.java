package com.bytedance.msdk.core.d.d.hc.d.d;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.tt;
import com.bytedance.msdk.d.u.an;
import com.kuaishou.android.live.network.ApiStatus;
import com.style.widget.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends com.bytedance.msdk.core.d.d.hc.d {
    @Override // com.bytedance.msdk.core.d.d.hc.d
    protected void d(final Context context) {
        if (b()) {
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.d.1
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
        if (this.hc != null) {
            if (this.hc.an() == 4) {
                int iTc = this.hc.tc();
                if (iTc == 1) {
                    u(context);
                    return;
                } else if (iTc == 2) {
                    b(context);
                    return;
                } else {
                    h(context);
                    return;
                }
            }
            h(context);
        }
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
        this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(40025).d(50010, map).d(Void.class).hc());
    }

    private void b(Context context) {
        if (this.hc != null) {
            c(context);
            tt();
            tc();
            u();
        }
    }

    private void u() {
        if (this.b == null || this.d == null) {
            return;
        }
        this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(40037).d(10004, new C0239d(this)).d(ad.c, 1).d(Void.class).hc());
    }

    private void c(Context context) {
        if (this.b != null) {
            this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(40036).d(50000, this.hc.yo()).d(10000, context).d(50002, hc()).d(Void.class).hc());
        }
    }

    private void u(Context context) {
        if (this.hc != null) {
            h();
            an(context);
            tt();
            tc();
            gb();
            an();
        }
    }

    private void an() {
        if (this.b == null || this.d == null) {
            return;
        }
        this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(40068).d(10004, new C0239d(this)).d(ad.c, 1).d(Void.class).hc());
    }

    private void h() {
        if (this.b != null) {
            this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(40031).d(50014, Integer.valueOf((int) this.d.k())).d(Void.class).hc());
        }
    }

    private void an(Context context) {
        if (this.b != null) {
            this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(40030).d(50000, this.hc.yo()).d(10000, context).d(50002, hc()).d(Void.class).hc());
        }
    }

    private void gb() {
        if (this.b != null) {
            this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(40018).d(50010, this.d.hv()).d(Void.class).hc());
        }
    }

    private void tt() {
        if (this.b != null) {
            this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(40019).d(50010, this.d.hv()).d(Void.class).hc());
        }
    }

    private void tc() {
        if (this.b != null) {
            this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(40020).d(50010, this.d.hv()).d(Void.class).hc());
        }
    }

    private void h(Context context) {
        gb(context);
        mk();
        mq();
    }

    private void mk() {
        if (this.b != null) {
            this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(40067).d(50022, 0).d(Void.class).hc());
        }
    }

    private void gb(Context context) {
        if (this.b != null) {
            this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(40066).d(50000, this.hc.yo()).d(10000, context).d(Void.class).hc());
        }
    }

    private void mq() {
        if (this.b == null || this.hc == null) {
            return;
        }
        this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(40002).d(10004, new C0239d(this)).d(Void.class).hc());
    }

    /* renamed from: com.bytedance.msdk.core.d.d.hc.d.d.d$d, reason: collision with other inner class name */
    static class C0239d extends com.bytedance.sdk.openadsdk.core.ba.c {
        private c b;
        private com.bytedance.msdk.core.d.d.hc.d d;
        private volatile boolean hc = false;

        public C0239d(com.bytedance.msdk.core.d.d.hc.d dVar) {
            this.d = dVar;
        }

        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            com.bytedance.msdk.core.d.d.hc.d dVar;
            if (i == 60008) {
                if (this.hc) {
                    return null;
                }
                this.hc = true;
                Function function = (Function) pluginValueSet.objectValue(50005, Function.class);
                com.bytedance.msdk.core.d.d.hc.d dVar2 = this.d;
                if (dVar2 == null) {
                    return null;
                }
                if (function != null) {
                    hc hcVar = new hc(this.d, function);
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(hcVar);
                    this.d.d(arrayList);
                    return null;
                }
                dVar2.d(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG, "adn return data is null");
                return null;
            }
            if (i == 60001) {
                if (this.hc) {
                    return null;
                }
                this.hc = true;
                if (this.d == null) {
                    return null;
                }
                com.bytedance.msdk.core.d.d.hc.d.an.hc hcVar2 = new com.bytedance.msdk.core.d.d.hc.d.an.hc((Function) pluginValueSet.objectValue(50006, Function.class));
                this.d.d(hcVar2.d(), hcVar2.hc());
                return null;
            }
            if (i != 60000) {
                if (i != 60017 || (dVar = this.d) == null) {
                    return null;
                }
                if (this.b != null) {
                    ArrayList arrayList2 = new ArrayList(1);
                    arrayList2.add(this.b);
                    this.d.d(arrayList2);
                    return null;
                }
                dVar.d(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG, "adn return data is null");
                return null;
            }
            Function function2 = (Function) pluginValueSet.objectValue(50005, Function.class);
            if (function2 != null) {
                if (this.d.d()) {
                    c cVar = new c(this.d, function2);
                    this.b = cVar;
                    cVar.mk();
                    return null;
                }
                if (this.d == null) {
                    return null;
                }
                b bVar = new b(this.d, function2);
                ArrayList arrayList3 = new ArrayList(1);
                arrayList3.add(bVar);
                this.d.d(arrayList3);
                return null;
            }
            com.bytedance.msdk.core.d.d.hc.d dVar3 = this.d;
            if (dVar3 == null) {
                return null;
            }
            dVar3.d(ApiStatus.SC_RESTRICT_FREQ_BY_KEY_CONFIG, "adn return data is null");
            return null;
        }
    }
}
