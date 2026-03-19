package com.bytedance.sdk.component.tt.hc;

import android.text.TextUtils;
import com.bytedance.sdk.component.hc.d.an;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.e;
import com.bytedance.sdk.component.hc.d.k;
import com.bytedance.sdk.component.hc.d.mq;
import com.bytedance.sdk.component.hc.d.tc;
import com.bytedance.sdk.component.hc.d.u;
import com.bytedance.sdk.component.hc.d.w;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends c {
    e d;

    public u(mq mqVar) {
        super(mqVar);
        this.d = null;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.d = e.d(tc.d(MediaTypeUtils.APPLICATION_JSON), str);
    }

    public void d(JSONObject jSONObject) {
        this.d = e.d(tc.d(MediaTypeUtils.APPLICATION_JSON), jSONObject != null ? jSONObject.toString() : "{}");
    }

    public void d(Map<String, String> map) {
        u.d dVar = new u.d();
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                dVar.d(str, map.get(str));
            }
        }
        this.d = dVar.d();
    }

    public void d(String str, byte[] bArr) {
        this.d = e.d(tc.d(str), bArr);
    }

    public void d(final com.bytedance.sdk.component.tt.d.d dVar) {
        try {
            k.d dVar2 = new k.d();
            if (TextUtils.isEmpty(this.an)) {
                dVar.d(this, new IOException("Url is Empty"));
                return;
            }
            dVar2.d(this.an);
            if (this.d == null) {
                if (dVar != null) {
                    dVar.d(this, new IOException("RequestBody is null, content type is not support!!"));
                }
            } else {
                d(dVar2);
                dVar2.d((Object) hc());
                this.b.d(dVar2.d(this.d).hc()).d(new com.bytedance.sdk.component.hc.d.b() { // from class: com.bytedance.sdk.component.tt.hc.u.1
                    @Override // com.bytedance.sdk.component.hc.d.b
                    public void onFailure(com.bytedance.sdk.component.hc.d.hc hcVar, IOException iOException) {
                        com.bytedance.sdk.component.tt.d.d dVar3 = dVar;
                        if (dVar3 != null) {
                            dVar3.d(u.this, iOException);
                        }
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb  */
                    /* JADX WARN: Removed duplicated region for block: B:42:0x00f3  */
                    @Override // com.bytedance.sdk.component.hc.d.b
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void onResponse(com.bytedance.sdk.component.hc.d.hc r13, com.bytedance.sdk.component.hc.d.cb r14) throws java.io.IOException {
                        /*
                            Method dump skipped, instructions count: 260
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.tt.hc.u.AnonymousClass1.onResponse(com.bytedance.sdk.component.hc.d.hc, com.bytedance.sdk.component.hc.d.cb):void");
                    }
                });
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.mq.d(th);
            dVar.d(this, new IOException(th.getMessage()));
        }
    }

    @Override // com.bytedance.sdk.component.tt.hc.c
    public com.bytedance.sdk.component.tt.hc d() {
        com.bytedance.sdk.component.tt.hc hcVar;
        try {
            k.d dVar = new k.d();
            if (TextUtils.isEmpty(this.an)) {
                com.bytedance.sdk.component.tt.c.u.d("PostExecutor", "execute: Url is Empty");
                return new com.bytedance.sdk.component.tt.hc(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            dVar.d(this.an);
            if (this.d == null) {
                com.bytedance.sdk.component.tt.c.u.d("PostExecutor", "RequestBody is null, content type is not support!!");
                return new com.bytedance.sdk.component.tt.hc(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            d(dVar);
            dVar.d((Object) hc());
            cb cbVarD = this.b.d(dVar.d(this.d).hc()).d();
            if (cbVarD == null) {
                return null;
            }
            HashMap map = new HashMap();
            an anVarH = cbVarD.h();
            if (anVarH != null) {
                for (int i = 0; i < anVarH.d(); i++) {
                    String strD = anVarH.d(i);
                    String strHc = anVarH.hc(i);
                    map.put(strD, strHc);
                    if (strD != null && strD.equalsIgnoreCase(com.alipay.sdk.m.p.e.f)) {
                        map.put(com.alipay.sdk.m.p.e.f, strHc == null ? "" : strHc.toLowerCase());
                    }
                }
            }
            if (com.bytedance.sdk.component.tt.c.d.d(map)) {
                byte[] bArrC = cbVarD.an().c();
                hcVar = new com.bytedance.sdk.component.tt.hc(cbVarD.c(), cbVarD.b(), cbVarD.u(), map, null, cbVarD.hc(), cbVarD.d());
                hcVar.d(bArrC);
            } else if (this.h) {
                byte[] bArrC2 = cbVarD.an().c();
                hcVar = new com.bytedance.sdk.component.tt.hc(cbVarD.c(), cbVarD.b(), cbVarD.u(), map, new String(bArrC2, d(d(cbVarD.an()))), cbVarD.hc(), cbVarD.d());
                hcVar.d(bArrC2);
            } else {
                hcVar = new com.bytedance.sdk.component.tt.hc(cbVarD.c(), cbVarD.b(), cbVarD.u(), map, cbVarD.an().hc(), cbVarD.hc(), cbVarD.d());
            }
            d(hcVar, cbVarD);
            return hcVar;
        } catch (Throwable th) {
            return new com.bytedance.sdk.component.tt.hc(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset d(tc tcVar) {
        try {
            return tcVar != null ? tcVar.d(com.bytedance.sdk.component.hc.d.hc.tc.d) : com.bytedance.sdk.component.hc.d.hc.tc.d;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.hc.d.hc.tc.d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public tc d(w wVar) {
        try {
            return wVar.u();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.bytedance.sdk.component.tt.hc hcVar, cb cbVar) {
        if (hcVar == null || cbVar == null) {
            return;
        }
        hcVar.d(cbVar.tt());
    }
}
