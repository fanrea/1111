package com.qq.e.comm.plugin;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class pv {
    private static volatile pv c;
    private ArrayBlockingQueue<WeakReference<mk>> a;
    private int b = -1;

    private pv() {
        this.a = null;
        this.a = new ArrayBlockingQueue<>(16);
    }

    public void a(mk mkVar) {
        WeakReference<mk> weakReferencePoll;
        mk mkVar2;
        if (mkVar == null) {
            return;
        }
        if (b() == 0) {
            mkVar.d();
            return;
        }
        if (this.a.size() == b() && (weakReferencePoll = this.a.poll()) != null && (mkVar2 = weakReferencePoll.get()) != null) {
            mkVar2.hashCode();
            mkVar2.d();
        }
        this.a.offer(new WeakReference<>(mkVar));
        mkVar.hashCode();
        this.a.size();
    }

    public static pv a() {
        if (c == null) {
            synchronized (pv.class) {
                if (c == null) {
                    c = new pv();
                }
            }
        }
        return c;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b() throws java.lang.NumberFormatException {
        /*
            r3 = this;
            int r0 = r3.b
            if (r0 < 0) goto L5
            return r0
        L5:
            com.qq.e.comm.plugin.r1 r0 = com.qq.e.comm.plugin.r1.d()
            com.qq.e.comm.plugin.vx r0 = r0.f()
            r1 = 0
            if (r0 == 0) goto L25
            java.lang.String r2 = "maxCachedPlayerCount"
            java.lang.String r0 = r0.c(r2)
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L25
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L21
            goto L26
        L21:
            r0 = move-exception
            r0.getMessage()
        L25:
            r0 = 0
        L26:
            if (r0 >= 0) goto L29
            goto L2a
        L29:
            r1 = r0
        L2a:
            r3.b = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.pv.b():int");
    }

    public boolean b(mk mkVar) {
        WeakReference<mk> next;
        if (mkVar == null) {
            return false;
        }
        Iterator<WeakReference<mk>> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (mkVar == next.get()) {
                break;
            }
        }
        if (next != null) {
            boolean zRemove = this.a.remove(next);
            mkVar.hashCode();
            this.a.size();
            return zRemove;
        }
        mkVar.hashCode();
        return false;
    }
}
