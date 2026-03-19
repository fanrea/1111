package com.bytedance.adsdk.hc.hc.hc.d;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc implements com.bytedance.adsdk.hc.hc.hc.d {
    private com.bytedance.adsdk.hc.hc.d.d b;
    private com.bytedance.adsdk.hc.hc.hc.d[] d;
    private String hc;

    public tc(String str) {
        this.hc = str;
    }

    public void d(com.bytedance.adsdk.hc.hc.hc.d[] dVarArr) {
        this.d = dVarArr;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public Object d(Map<String, JSONObject> map) {
        com.bytedance.adsdk.hc.hc.d.d dVar = new com.bytedance.adsdk.hc.hc.d.d();
        this.b = dVar;
        dVar.d(this.hc);
        Object[] objArr = new Object[this.d.length];
        int i = 0;
        while (true) {
            com.bytedance.adsdk.hc.hc.hc.d[] dVarArr = this.d;
            if (i < dVarArr.length) {
                com.bytedance.adsdk.hc.hc.hc.d dVar2 = dVarArr[i];
                if (dVar2 != null) {
                    objArr[i] = dVar2.d(map);
                }
                i++;
            } else {
                this.b.d(objArr);
                return com.bytedance.adsdk.hc.mk.d(this.hc).d(map.get("default_key"), objArr);
            }
        }
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public com.bytedance.adsdk.hc.hc.c.u d() {
        return com.bytedance.adsdk.hc.hc.c.hc.METHOD;
    }

    @Override // com.bytedance.adsdk.hc.hc.hc.d
    public String hc() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hc).append("(");
        com.bytedance.adsdk.hc.hc.hc.d[] dVarArr = this.d;
        if (dVarArr != null && dVarArr.length > 0) {
            int i = 0;
            while (true) {
                com.bytedance.adsdk.hc.hc.hc.d[] dVarArr2 = this.d;
                if (i >= dVarArr2.length) {
                    break;
                }
                sb.append(dVarArr2[i].hc()).append(",");
                i++;
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
