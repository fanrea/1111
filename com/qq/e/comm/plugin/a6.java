package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.fw;
import com.qq.e.comm.plugin.vg;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class a6 extends c30 {
    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "requestByCellularNetwork";
    }

    /* compiled from: A */
    class a implements fw.b {
        final /* synthetic */ bm a;
        final /* synthetic */ ug b;

        a(bm bmVar, ug ugVar) {
            this.a = bmVar;
            this.b = ugVar;
        }

        @Override // com.qq.e.comm.plugin.fw.b
        public void a(JSONObject jSONObject) {
            qm$h$$ExternalSyntheticBackport0.m(jSONObject);
            this.a.a(new vg(this.b, vg.a.OK, jSONObject));
        }
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) {
        a(jmVar.b(), ugVar);
    }

    private void a(bm bmVar, ug ugVar) {
        qg.b.submit(new fw(ugVar.d().optString("url"), new a(bmVar, ugVar)));
    }
}
