package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class h50 extends e30 {
    private String a;
    private int b;
    private f5 c;

    public String a() {
        return "wx";
    }

    public h50(h4 h4Var) {
        if (h4Var != null) {
            if (h4Var.d1() != null) {
                this.a = h4Var.d1().a;
            }
            this.b = h4Var.I();
            this.c = f5.a(h4Var);
        }
    }

    @Override // com.qq.e.comm.plugin.e30
    public ih<String> a(jm jmVar, ug ugVar) {
        String strA = ugVar.a();
        strA.hashCode();
        strA.hashCode();
        switch (strA) {
            case "launchMiniProgram":
                new xn(this.a, this.b, this.c).a(jmVar, ugVar);
                break;
            case "preloadMiniProgram":
                new ou(this.a, this.b, this.c).a(jmVar, ugVar);
                break;
            case "updateTimelineShareData":
                new xy(this.a).a(jmVar, ugVar);
                break;
        }
        return new ih<>(null);
    }
}
