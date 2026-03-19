package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vw extends c30 {
    private static final String b = uw.Z;
    private final uw a;

    @Override // com.qq.e.comm.plugin.c30
    public String a() {
        return "onReward";
    }

    public vw(uw uwVar) {
        this.a = uwVar;
    }

    @Override // com.qq.e.comm.plugin.c30
    public void a(jm jmVar, ug ugVar) {
        uw uwVar;
        ugVar.a();
        if (!ugVar.a().equals("onReward") || (uwVar = this.a) == null) {
            return;
        }
        uwVar.b(false);
    }
}
