package com.android.gdt.qone.ai;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class e implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ f d;

    public e(f fVar, c cVar, String str, String str2) {
        this.d = fVar;
        this.a = cVar;
        this.b = str;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.d) {
            f.a(this.d, this.a, this.b, this.c);
        }
    }
}
