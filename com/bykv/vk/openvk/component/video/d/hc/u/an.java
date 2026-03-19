package com.bykv.vk.openvk.component.video.d.hc.u;

import com.bykv.vk.openvk.component.video.d.hc.tt;
import com.bytedance.sdk.component.hc.d.cb;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an extends d {
    private cb b;

    public an(cb cbVar, u uVar) {
        com.bytedance.sdk.component.hc.d.an anVarH;
        this.b = cbVar;
        this.d = new ArrayList();
        if (cbVar != null && (anVarH = cbVar.h()) != null) {
            for (int i = 0; i < anVarH.d(); i++) {
                this.d.add(new tt.hc(anVarH.d(i), anVarH.hc(i)));
            }
        }
        this.hc = uVar;
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.u.d
    public int d() {
        return this.b.b();
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.u.d
    public boolean hc() {
        return this.b.b() >= 200 && this.b.b() < 300;
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.u.d
    public String d(String str, String str2) {
        return d(str) != null ? d(str).hc : str2;
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.u.d
    public List<tt.hc> b() {
        return this.d;
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.u.d
    public InputStream c() {
        return this.b.an().b();
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.u.d
    public String u() {
        cb cbVar = this.b;
        return (cbVar == null || cbVar.gb() == null) ? "http/1.1" : this.b.gb().toString();
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.u.d
    public String an() {
        return d(this.b.b());
    }
}
