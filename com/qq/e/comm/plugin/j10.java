package com.qq.e.comm.plugin;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class j10 extends r0 {
    public j10(String str, e2 e2Var) {
        super(str, e2Var);
    }

    @Override // com.qq.e.comm.plugin.r0
    public JSONObject e() {
        JSONObject jSONObject = this.b;
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            this.b = null;
            if (d(jSONObject)) {
                return jSONObject;
            }
        }
        boolean zRemove = false;
        while (true) {
            if (this.a.isEmpty()) {
                break;
            }
            JSONObject jSONObject3 = this.a.get(b());
            if (d(jSONObject3)) {
                this.g++;
                jSONObject2 = jSONObject3;
                break;
            }
            zRemove |= this.a.remove(jSONObject3);
        }
        if (zRemove) {
            c();
        }
        return jSONObject2;
    }

    @Override // com.qq.e.comm.plugin.sk
    public int b() {
        int size = this.a.size();
        if (size <= 0) {
            return this.g;
        }
        return this.g % size;
    }

    @Override // com.qq.e.comm.plugin.r0
    protected boolean e(JSONObject jSONObject) {
        int iIndexOf = this.a.indexOf(jSONObject);
        int iB = b();
        boolean zRemove = this.a.remove(jSONObject);
        if (zRemove) {
            if (iIndexOf < iB) {
                this.g--;
            }
            if (this.a.isEmpty()) {
                this.g = 0;
            }
        }
        return zRemove;
    }

    @Override // com.qq.e.comm.plugin.sk
    public void b(JSONObject jSONObject) {
        this.a.add(b(), jSONObject);
    }
}
