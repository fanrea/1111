package com.fc.tjcpl.sdk.h;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class f implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ e b;

    public f(e eVar, Object obj) {
        this.b = eVar;
        this.a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        j jVar = this.b.b;
        if (jVar != null) {
            jVar.a(this.a);
        }
    }
}
