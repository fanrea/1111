package com.bytedance.msdk.api.d;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc implements b, c {
    private b b;
    private boolean c;
    private c d;
    private com.bytedance.msdk.core.tc.hc hc;

    public b uo() {
        return this.b;
    }

    public hc() {
    }

    public hc(int i, PluginValueSet pluginValueSet) {
        d(i, pluginValueSet, null);
    }

    public hc(hc hcVar) {
        if (hcVar != null) {
            d(hcVar.de(), com.bykv.d.d.d.d.d.d(hcVar.bc()).hc(), hcVar.uo());
        }
    }

    private void d(int i, PluginValueSet pluginValueSet, b bVar) {
        this.d = new u(i, pluginValueSet);
        d dVar = new d();
        this.b = dVar;
        if (bVar != null) {
            dVar.u(bVar.gb());
        }
    }

    @Override // com.bytedance.msdk.api.d.b
    public void an(int i) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.an(i);
        }
    }

    @Override // com.bytedance.msdk.api.d.b
    public int tt() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.tt();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.b
    public void d(JSONObject jSONObject) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.d(jSONObject);
        }
    }

    @Override // com.bytedance.msdk.api.d.b
    public JSONObject tc() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.tc();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.d.b
    public int mk() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.mk();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.b
    public void h(int i) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.h(i);
        }
    }

    @Override // com.bytedance.msdk.api.d.b
    public void b(String str) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.b(str);
        }
    }

    @Override // com.bytedance.msdk.api.d.b
    public String mq() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.mq();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.d.c
    public float k() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.k();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.d.c
    public float e() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.e();
        }
        return 0.0f;
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean cb() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.cb();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public void gb(int i) {
        c cVar = this.d;
        if (cVar != null) {
            cVar.gb(i);
        }
    }

    @Override // com.bytedance.msdk.api.d.c
    public int w() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.w();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean yo() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.yo();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public void tt(int i) {
        c cVar = this.d;
        if (cVar != null) {
            cVar.tt(i);
        }
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean rf() {
        c cVar = this.d;
        if (cVar == null) {
            return false;
        }
        cVar.rf();
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean jh() {
        c cVar = this.d;
        if (cVar == null) {
            return false;
        }
        cVar.jh();
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public com.bytedance.sdk.openadsdk.mediation.hc.hc.d sy() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.sy();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.d.c
    public int de() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.de();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.c
    public String v() {
        c cVar = this.d;
        return cVar != null ? cVar.v() : "";
    }

    @Override // com.bytedance.msdk.api.d.c
    public void c(String str) {
        c cVar = this.d;
        if (cVar != null) {
            cVar.c(str);
        }
    }

    @Override // com.bytedance.msdk.api.d.c
    public String np() {
        c cVar = this.d;
        return cVar != null ? cVar.np() : "";
    }

    @Override // com.bytedance.msdk.api.d.c
    public int yi() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.yi();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.c
    public int he() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.he();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.c
    public int vv() {
        c cVar;
        if (5 != de() && 9 != de()) {
            return 1;
        }
        com.bytedance.msdk.core.tc.hc hcVar = this.hc;
        int iW = hcVar != null ? hcVar.w() : 0;
        if (iW == 0 && (cVar = this.d) != null) {
            iW = cVar.vv();
        }
        if (iW <= 0) {
            return 1;
        }
        if (iW >= 3) {
            return 3;
        }
        return iW;
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean zw() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.zw();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public String j() {
        c cVar = this.d;
        return cVar != null ? cVar.j() : "";
    }

    @Override // com.bytedance.msdk.api.d.c
    public int s() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.s();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.c
    public String us() {
        c cVar = this.d;
        return cVar != null ? cVar.us() : "";
    }

    @Override // com.bytedance.msdk.api.d.c
    public String z() {
        c cVar = this.d;
        return cVar != null ? cVar.z() : "";
    }

    @Override // com.bytedance.msdk.api.d.c
    public int fs() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.fs();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean ba() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.ba();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public String mt() {
        c cVar = this.d;
        return cVar != null ? cVar.mt() : "";
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean r() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.r();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.c
    public Map<String, Object> hv() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.hv();
        }
        return new ConcurrentHashMap();
    }

    @Override // com.bytedance.msdk.api.d.c
    public SparseArray<Object> bc() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.bc();
        }
        return com.bykv.d.d.d.d.d.d.sparseArray();
    }

    public void d(com.bytedance.msdk.core.tc.hc hcVar) {
        this.hc = hcVar;
    }

    public com.bytedance.msdk.core.tc.hc dc() {
        return this.hc;
    }

    @Override // com.bytedance.msdk.api.d.c
    public String tr() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.tr();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.d.c
    public boolean nv() {
        c cVar = this.d;
        if (cVar != null) {
            return cVar.nv();
        }
        return false;
    }

    public long y() {
        com.bytedance.msdk.core.tc.hc hcVar = this.hc;
        if (hcVar != null) {
            return hcVar.he();
        }
        return 0L;
    }

    public String wl() {
        com.bytedance.msdk.core.tc.hc hcVar = this.hc;
        return hcVar != null ? hcVar.us() : "";
    }

    public double q() {
        com.bytedance.msdk.core.tc.hc hcVar = this.hc;
        if (hcVar != null) {
            return hcVar.yo();
        }
        return 0.0d;
    }

    public int ru() {
        com.bytedance.msdk.core.tc.hc hcVar = this.hc;
        if (hcVar != null) {
            return hcVar.q();
        }
        return 0;
    }

    public int yn() {
        com.bytedance.msdk.core.tc.hc hcVar = this.hc;
        if (hcVar != null) {
            return hcVar.ru();
        }
        return 0;
    }

    public String l() {
        com.bytedance.msdk.core.tc.hc hcVar = this.hc;
        return hcVar != null ? hcVar.wl() : "";
    }

    public int fu() {
        com.bytedance.msdk.core.tc.hc hcVar = this.hc;
        if (hcVar != null) {
            return hcVar.vv();
        }
        return 0;
    }

    public String xp() {
        com.bytedance.msdk.core.tc.hc hcVar = this.hc;
        return hcVar != null ? hcVar.zw() : "";
    }

    public String to() {
        com.bytedance.msdk.core.tc.hc hcVar = this.hc;
        return hcVar != null ? hcVar.rf() : "";
    }

    @Override // com.bytedance.msdk.api.d.b
    public String d() {
        b bVar = this.b;
        return bVar != null ? bVar.d() : "";
    }

    @Override // com.bytedance.msdk.api.d.b
    public void d(String str) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.d(str);
        }
    }

    @Override // com.bytedance.msdk.api.d.b
    public void d(int i) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.d(i);
        }
    }

    @Override // com.bytedance.msdk.api.d.b
    public int hc() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.hc();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.b
    public int b() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.b();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.b
    public void hc(int i) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.hc(i);
        }
    }

    @Override // com.bytedance.msdk.api.d.b
    public void b(int i) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    @Override // com.bytedance.msdk.api.d.b
    public int c() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.c();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.b
    public int u() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.u();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.d.b
    public void c(int i) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.c(i);
        }
    }

    @Override // com.bytedance.msdk.api.d.b
    public String an() {
        b bVar = this.b;
        return bVar != null ? bVar.an() : "";
    }

    @Override // com.bytedance.msdk.api.d.b
    public void hc(String str) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.hc(str);
        }
    }

    @Override // com.bytedance.msdk.api.d.b
    public boolean h() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.h();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.d.b
    public void u(int i) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.u(i);
        }
    }

    @Override // com.bytedance.msdk.api.d.b
    public int gb() {
        b bVar = this.b;
        if (bVar != null) {
            return bVar.gb();
        }
        return 0;
    }

    public boolean ra() {
        int iDe = de();
        Map<String, Object> mapHv = hv();
        if (mapHv == null) {
            return false;
        }
        Object obj = mapHv.get("use_share_cache");
        return (obj instanceof Boolean) && (iDe == 1 || iDe == 5 || iDe == 10 || iDe == 7) && ((Boolean) obj).booleanValue();
    }

    public void d(PluginValueSet pluginValueSet) {
        if (this.d == null || pluginValueSet == null) {
            return;
        }
        this.d = new u(de(), pluginValueSet);
    }

    public boolean rw() {
        return this.c;
    }

    public void d(boolean z) {
        this.c = z;
    }
}
