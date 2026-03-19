package com.kuaishou.aegon.netcheck;

import java.util.EnumSet;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final /* synthetic */ class c implements Runnable {
    private final NetcheckTaskListenerWrapper a;
    private final EnumSet b;
    private final String c;

    private c(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        this.a = netcheckTaskListenerWrapper;
        this.b = enumSet;
        this.c = str;
    }

    public static Runnable a(NetcheckTaskListenerWrapper netcheckTaskListenerWrapper, EnumSet enumSet, String str) {
        return new c(netcheckTaskListenerWrapper, enumSet, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.a(this.b, this.c);
    }
}
