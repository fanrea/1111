package com.kuaishou.aegon.netcheck;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class b implements Runnable {
    private final NetcheckTaskListenerWrapper a;
    private final int b;

    private b(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        this.a = netcheckTaskListenerWrapper;
        this.b = i;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, int i) {
        return new b(netcheckTaskListenerWrapper, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.a(this.b);
    }
}
