package com.baidu.mobads.container.bridge;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class j extends com.baidu.mobads.container.d.a {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;

    j(i iVar, String str, String str2) {
        this.c = iVar;
        this.a = str;
        this.b = str2;
    }

    @Override // com.baidu.mobads.container.d.a
    protected Object a() {
        try {
            this.c.b(this.a, this.b);
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
