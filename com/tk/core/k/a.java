package com.tk.core.k;

import android.os.Process;
import android.support.v4.d.j;
import com.tk.core.component.e;
import com.tk.core.o.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class a {
    private static Map<Class, b> aiC = new HashMap();
    private static Set<Class> aiD = new HashSet();
    private static Executor bh;

    public static void t(e eVar) {
        if (eVar == null || !eVar.mJ()) {
            return;
        }
        synchronized (aiD) {
            if (aiD.contains(eVar.getClass())) {
                return;
            }
            getExecutor().execute(new RunnableC0825a(0, eVar, new WeakReference(eVar)) { // from class: com.tk.core.k.a.1
                final /* synthetic */ e aiE;
                final /* synthetic */ WeakReference aiF;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.aiE = eVar;
                    this.aiF = weakReference;
                }

                @Override // com.tk.core.k.a.RunnableC0825a, java.lang.Runnable
                public final void run() throws SecurityException, IllegalArgumentException {
                    b bVar;
                    if (this.aiE.pN()) {
                        return;
                    }
                    super.run();
                    e eVar2 = (e) this.aiF.get();
                    if (eVar2 != null) {
                        Class<?> cls = eVar2.getClass();
                        synchronized (a.aiC) {
                            bVar = (b) a.aiC.get(cls);
                            if (bVar == null) {
                                bVar = new b(4);
                                a.aiC.put(cls, bVar);
                            }
                        }
                        a.a(bVar, eVar2, cls);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x003f A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.tk.core.bridge.b] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.tk.core.k.a.b r5, com.tk.core.component.e r6, java.lang.Class r7) {
        /*
        L0:
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r5.size()
            r1 = 4
            if (r0 >= r1) goto L3f
            r0 = 0
            android.view.View r0 = r6.qb()     // Catch: java.lang.Throwable -> L10
            goto L2b
        L10:
            r2 = move-exception
            java.util.Set<java.lang.Class> r3 = com.tk.core.k.a.aiD
            monitor-enter(r3)
            java.util.Set<java.lang.Class> r4 = com.tk.core.k.a.aiD     // Catch: java.lang.Throwable -> L3c
            r4.add(r7)     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3c
            boolean r3 = r6.qr()
            if (r3 == 0) goto L24
            com.tk.core.exception.a.a(r0, r2)
            goto L2b
        L24:
            java.lang.String r3 = "tachikoma_simpool"
            java.lang.String r4 = "schedule component error "
            com.tk.core.i.a.a(r3, r4, r2)
        L2b:
            if (r0 == 0) goto L3f
            monitor-enter(r7)
            r5.j(r0)     // Catch: java.lang.Throwable -> L39
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L39
            int r0 = r5.size()
            if (r0 >= r1) goto L3f
            goto L0
        L39:
            r5 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L39
            throw r5
        L3c:
            r5 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3c
            throw r5
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.k.a.a(com.tk.core.k.a$b, com.tk.core.component.e, java.lang.Class):void");
    }

    public static Object u(e eVar) {
        Object objG;
        Class<?> cls = eVar.getClass();
        synchronized (aiC) {
            b bVar = aiC.get(cls);
            if (bVar == null) {
                t(eVar);
                return null;
            }
            synchronized (cls) {
                try {
                    try {
                        objG = bVar.G();
                    } finally {
                        t(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return objG;
        }
    }

    private static Executor getExecutor() {
        if (bh == null) {
            synchronized (a.class) {
                if (bh == null) {
                    bh = p.p("tk-new-component-thread", 1);
                }
            }
        }
        return bh;
    }

    public static class b<T> implements j.a<T> {
        private final Object[] bW = new Object[4];
        private int bX;

        public b(int i) {
        }

        public final int size() {
            return this.bX;
        }

        @Override // android.support.v4.d.j.a
        public final T G() {
            int i = this.bX;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.bW;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.bX = i - 1;
            return t;
        }

        @Override // android.support.v4.d.j.a
        public final boolean j(T t) {
            if (k(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.bX;
            Object[] objArr = this.bW;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.bX = i + 1;
            return true;
        }

        private boolean k(T t) {
            for (int i = 0; i < this.bX; i++) {
                if (this.bW[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: com.tk.core.k.a$a, reason: collision with other inner class name */
    public static class RunnableC0825a implements Runnable {
        private final int aV;

        public RunnableC0825a(int i) {
            this.aV = i;
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(this.aV);
        }
    }
}
