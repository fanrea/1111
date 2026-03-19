package com.bytedance.sdk.component.hc.d.d.d;

import com.bytedance.sdk.component.b.hc.s;
import com.bytedance.sdk.component.b.hc.sy;
import com.bytedance.sdk.component.hc.d.w;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tc extends w {
    s d;

    tc(s sVar) {
        this.d = sVar;
    }

    @Override // com.bytedance.sdk.component.hc.d.w
    public long d() {
        s sVar = this.d;
        if (sVar != null) {
            return sVar.hc();
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.hc.d.w
    public String hc() {
        try {
            return this.d.an();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.hc.d.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        s sVar = this.d;
        if (sVar != null) {
            sVar.close();
        }
    }

    @Override // com.bytedance.sdk.component.hc.d.w
    public InputStream b() {
        s sVar = this.d;
        if (sVar != null) {
            return sVar.c();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.hc.d.w
    public byte[] c() {
        try {
            return this.d.u();
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.bytedance.sdk.component.hc.d.w
    public com.bytedance.sdk.component.hc.d.tc u() {
        sy syVarD;
        s sVar = this.d;
        if (sVar == null || (syVarD = sVar.d()) == null) {
            return null;
        }
        return new com.bytedance.sdk.component.hc.d.tc(syVarD.toString(), syVarD.d(), syVarD.hc(), syVarD.b() != null ? syVarD.b().name() : null);
    }
}
