package com.bytedance.msdk.b.b.hc.d;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.d.u.an;
import com.bytedance.sdk.component.utils.mq;
import com.kwad.sdk.api.model.AdnName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class hc extends com.bytedance.sdk.openadsdk.core.ba.c implements com.bytedance.msdk.b.d.d, com.bytedance.msdk.b.d.hc {
    protected com.bytedance.msdk.b.d.hc d;
    private boolean hc = false;
    private boolean b = false;

    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return null;
    }

    public String d(Context context, com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2) {
        return null;
    }

    public abstract void hc(Context context, com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, Map<String, Object> map);

    public hc(com.bytedance.msdk.b.d.hc hcVar) {
        this.d = hcVar;
    }

    @Override // com.bytedance.msdk.b.d.d
    public final void d(final Context context, final com.bytedance.msdk.b.an.hc.hc hcVar, final com.bytedance.msdk.api.d.hc hcVar2, final Map<String, Object> map) {
        if (hcVar != null && (TextUtils.equals("mintegral", hcVar.uo()) || TextUtils.equals(AdnName.BAIDU, hcVar.uo()) || TextUtils.equals("admob", hcVar.uo()))) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.b.b.hc.d.hc.1
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.b(context, hcVar, hcVar2, map);
                }
            });
        } else {
            b(context, hcVar, hcVar2, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, Map<String, Object> map) {
        this.hc = false;
        this.b = false;
        if (com.bytedance.msdk.core.d.mk().yi()) {
            hc(context, hcVar, hcVar2, map);
            d(hcVar);
            return;
        }
        try {
            hc(context, hcVar, hcVar2, map);
            d(hcVar);
        } catch (Throwable th) {
            d(new com.bytedance.msdk.api.d(com.bytedance.msdk.core.k.hc.d(th)));
            mq.d(th);
        }
    }

    private void d(com.bytedance.msdk.b.an.hc.hc hcVar) {
        if (hcVar != null) {
            com.bytedance.msdk.core.b.b.hc(hcVar.uo(), hcVar.hc(), hcVar.mq());
        }
    }

    public void d(com.bytedance.msdk.hc.b bVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(bVar);
        d(arrayList);
    }

    public void d(List<com.bytedance.msdk.hc.b> list) {
        if (this.hc) {
            return;
        }
        this.hc = true;
        com.bytedance.msdk.b.d.hc hcVar = this.d;
        if (hcVar != null) {
            hcVar.d(list);
        }
    }

    @Override // com.bytedance.msdk.b.d.hc
    public void d(com.bytedance.msdk.api.d dVar) {
        this.b = true;
        if (this.hc) {
            return;
        }
        this.hc = true;
        com.bytedance.msdk.b.d.hc hcVar = this.d;
        if (hcVar != null) {
            hcVar.d(dVar);
        }
    }

    public void d(com.bytedance.msdk.hc.b bVar, com.bytedance.msdk.api.d dVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(bVar);
        d(arrayList, dVar);
    }

    @Override // com.bytedance.msdk.b.d.hc
    public void d(List<com.bytedance.msdk.hc.b> list, com.bytedance.msdk.api.d dVar) {
        com.bytedance.msdk.b.d.hc hcVar;
        if (this.b || (hcVar = this.d) == null) {
            return;
        }
        hcVar.d(list, dVar);
    }

    @Override // com.bytedance.msdk.b.d.hc
    public void d(com.bytedance.msdk.hc.b bVar, String str) {
        com.bytedance.msdk.b.d.hc hcVar = this.d;
        if (hcVar != null) {
            hcVar.d(bVar, str);
        }
    }

    public boolean d() {
        return this.b;
    }

    public boolean hc() {
        return this.hc;
    }
}
