package com.bytedance.msdk.api.d;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u implements c {
    private Map<String, Object> b;
    private int c;
    private com.bytedance.sdk.openadsdk.mediation.hc.hc.d d;
    private com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hc;
    private PluginValueSet u;
    private int an = -1;
    private String h = "";

    public u(int i, PluginValueSet pluginValueSet) {
        if (pluginValueSet != null) {
            this.u = pluginValueSet;
            this.c = i;
            com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = new com.bytedance.sdk.openadsdk.mediation.hc.hc.d(pluginValueSet.sparseArray());
            this.d = dVar;
            this.hc = dVar.zw();
            return;
        }
        com.bytedance.msdk.d.u.b.hc("AdLinkInfo", "valueset is null");
    }

    @Override // com.bytedance.msdk.api.d.c
    public com.bytedance.sdk.openadsdk.mediation.hc.hc.d sy() {
        return this.d;
    }

    @Override // com.bytedance.msdk.api.d.c
    public float k() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        if (dVar != null) {
            return dVar.gb();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.d.c
    public float e() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        if (dVar != null) {
            return dVar.tt();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean cb() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        if (dVar != null) {
            return dVar.mk();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public void gb(int i) {
        this.an = i;
    }

    @Override // com.bytedance.msdk.api.d.c
    public int w() {
        return this.an;
    }

    @Override // com.bytedance.msdk.api.d.c
    public int de() {
        return this.c;
    }

    @Override // com.bytedance.msdk.api.d.c
    public String v() {
        if (!TextUtils.isEmpty(this.h)) {
            return this.h;
        }
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        return dVar != null ? dVar.c() : "";
    }

    @Override // com.bytedance.msdk.api.d.c
    public void c(String str) {
        this.h = str;
    }

    @Override // com.bytedance.msdk.api.d.c
    public int yi() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        if (dVar != null) {
            return dVar.an();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.c
    public int he() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        if (dVar != null) {
            return dVar.h();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.c
    public int vv() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        if (dVar != null) {
            return dVar.mq();
        }
        return 1;
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean zw() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        if (dVar != null) {
            return dVar.tc();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public String us() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        return dVar != null ? dVar.uo() : "";
    }

    @Override // com.bytedance.msdk.api.d.c
    public String z() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        return dVar != null ? dVar.k() : "";
    }

    @Override // com.bytedance.msdk.api.d.c
    public int fs() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        if (dVar != null) {
            return dVar.e();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.c
    public String j() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVar;
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        String strNp = dVar != null ? dVar.np() : "";
        return (!TextUtils.isEmpty(strNp) || (hcVar = this.hc) == null) ? strNp : hcVar.k();
    }

    @Override // com.bytedance.msdk.api.d.c
    public int s() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVar;
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        int iYi = dVar != null ? dVar.yi() : 0;
        return (iYi != 0 || (hcVar = this.hc) == null) ? iYi : hcVar.e();
    }

    @Override // com.bytedance.msdk.api.d.c
    public String np() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVar = this.hc;
        return hcVar != null ? hcVar.gb() : "";
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean ba() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVar = this.hc;
        if (hcVar != null) {
            return hcVar.b();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public String mt() {
        Map mapAn;
        com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVar = this.hc;
        if (hcVar == null || (mapAn = hcVar.an()) == null) {
            return "";
        }
        Object obj = mapAn.get("testToolSlotId");
        return obj instanceof String ? (String) obj : "";
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean r() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVar = this.hc;
        if (hcVar != null) {
            return hcVar.h();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.msdk.api.d.c
    public Map<String, Object> hv() {
        Map<String, Object> map = this.b;
        if (map != null) {
            return map;
        }
        if (this.hc != null) {
            this.b = new ConcurrentHashMap();
            Map mapAn = this.hc.an();
            if (mapAn != null && mapAn.size() > 0) {
                for (Map.Entry entry : mapAn.entrySet()) {
                    if (entry.getKey() != null && entry.getValue() != null) {
                        this.b.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        if (this.b == null) {
            this.b = new ConcurrentHashMap();
        }
        return this.b;
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean yo() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVar = this.hc;
        if (hcVar != null) {
            return hcVar.tt();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public void tt(int i) {
        this.c = i;
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean rf() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVar = this.hc;
        if (hcVar != null) {
            return hcVar.d();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean jh() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.hc hcVar = this.hc;
        if (hcVar != null) {
            return hcVar.hc();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public String tr() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        if (dVar != null) {
            return dVar.j();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean nv() {
        com.bytedance.sdk.openadsdk.mediation.hc.hc.d dVar = this.d;
        if (dVar != null) {
            return dVar.vv();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public SparseArray<Object> bc() {
        PluginValueSet pluginValueSet = this.u;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        return null;
    }
}
